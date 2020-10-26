package br.com.fiap.b2w.dao;

import br.com.fiap.b2w.models.*;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EquipeDAO {
    private Connection conn;

    public void conecta() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        this.conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM86433", "110701");
    }

    public void salvar(Equipe equipe) throws SQLException, ClassNotFoundException {
        conecta();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String sql = "insert into T_B2W_EQUIPE (cd_equipe, cd_gerente, cd_rh, dt_inicio) values (sq_equipe.nextval, ?, ?, to_date(?, 'yyyy/MM/dd'))";
        PreparedStatement pStmt = this.conn.prepareStatement(sql);

        pStmt.setInt(1, equipe.getGerenteResponsavel().getNrCadastro());
        pStmt.setInt(2, equipe.getRhResponsavel().getNrCadastro());
        pStmt.setString(3, formatter.format(equipe.getDtInicio()));
        pStmt.executeUpdate();
        desconecta();
    }

    public Equipe consultaPorCodigo(Integer codigo) throws SQLException, ClassNotFoundException {
        conecta();
        Equipe equipe = new Equipe();
        Statement stmt = conn.createStatement();
        String sql = "select * from T_B2W_EQUIPE where cd_equipe = " + codigo;
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        if (rs != null) {
            equipe.setCdEquipe(rs.getInt("cd_equipe"));
            equipe.setGerenteResponsavel(new GestorDAO().consultaPorCodigo(rs.getInt("cd_gerente")));
            equipe.setRhResponsavel(new RHDAO().consultaPorCodigo(rs.getInt("cd_rh")));
            equipe.setDtInicio(rs.getDate("dt_inicio").toLocalDate());
        }
        return equipe;
    }


    public List<PlanodeDesenvolvimento> consultaTodosPorEquipe(Integer codigoEquipe) throws SQLException, ClassNotFoundException {
        conecta();
        Statement stmt = this.conn.createStatement();
        String sql = ("select * from T_B2W_PLANO_DES where cd_equipe = " + codigoEquipe + " order by cd_plano_desenvolvimento ASC");
        ResultSet rs = stmt.executeQuery(sql);
        List<PlanodeDesenvolvimento> consultaPorEquipe = new ArrayList<>();
        while (rs.next()) {
            Integer codigo = rs.getInt("cd_plano_desenvolvimento");
            Equipe equipe = new EquipeDAO().consultaPorCodigo(rs.getInt("cd_equipe"));
            Associado associado = new AssociadoDAO().consultaPorCodigo(rs.getInt("cd_cad_associado"));
            Gestor gestor = new GestorDAO().consultaPorCodigo(rs.getInt("cd_cad_associado"));
            LocalDate dtInicio = rs.getDate("dt_inicio") != null ? rs.getDate("dt_inicio").toLocalDate() : null;
            LocalDate dtTermino = rs.getDate("dt_termino") != null ? rs.getDate("dt_termino").toLocalDate() : null;
            Boolean ativo = rs.getString("st_ativo") == "A";
            List<Task> tasks = new TaskDAO().consultaTodosDentroDeUmPlano(rs.getInt("cd_plano_desenvolvimento"));
            consultaPorEquipe.add(new PlanodeDesenvolvimento(codigo, associado, gestor, equipe, dtInicio, dtTermino, tasks, ativo));
        }
        desconecta();
        return consultaPorEquipe;
    }


    private void desconecta() throws SQLException {
        if (!this.conn.isClosed()) {
            this.conn.close();
        }
    }
}
