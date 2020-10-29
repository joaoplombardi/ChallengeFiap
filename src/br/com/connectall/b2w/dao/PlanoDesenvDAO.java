package br.com.connectall.b2w.dao;

import br.com.connectall.b2w.models.*;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PlanoDesenvDAO {
    private Connection conn;

    public void conecta() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        this.conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM86433", "110701");
    }

    public void salvar(PlanoDeDesenvolvimento planodeDesenvolvimento) throws SQLException, ClassNotFoundException {
        conecta();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String sql = "insert into T_B2W_PLANO_DES (cd_plano_desenvolvimento, cd_equipe, cd_cadastro_associado, cd_cadastro_gerente, st_ativo)" +
                "values(sq_plano_desenvolvimento.nextval, ?, ?, ?, ?)";
        PreparedStatement pStmt = this.conn.prepareStatement(sql);

        pStmt.setInt(1, planodeDesenvolvimento.getEquipe().getId());
        pStmt.setInt(2, planodeDesenvolvimento.getAssociado().getId());
        pStmt.setInt(3, planodeDesenvolvimento.getGestor().getId());
        pStmt.setString(4, planodeDesenvolvimento.getAtivo() == true ? "A" : "I");
        desconecta();
    }


    public void iniciarPlanoDesenvolvimento(PlanoDeDesenvolvimento planodeDesenvolvimento) throws SQLException, ClassNotFoundException {
        conecta();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        Statement stmt = this.conn.createStatement();
        String dtInicio = formatter.format(planodeDesenvolvimento.getDtInicio());
        String sql = String.format("update T_B2W_PLANO_DES set dt_inicio = to_date('%s', 'yyyy/MM/dd') where cd_plano_desenvolvimento = %s",
                dtInicio, planodeDesenvolvimento.getId());
        stmt.executeUpdate(sql);
        desconecta();
    }

    public void terminarPlanoDesenvolvimento(PlanoDeDesenvolvimento planodeDesenvolvimento) throws SQLException, ClassNotFoundException {
        conecta();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        Statement stmt = this.conn.createStatement();
        String dtTermino = formatter.format(planodeDesenvolvimento.getDtTermino());
        String sql = String.format("update T_B2W_PLANO_DES set dt_termino = to_date('%s', 'yyyy/MM/dd') where cd_plano_desenvolvimento = %s",
                dtTermino, planodeDesenvolvimento.getId());
        stmt.executeUpdate(sql);
        desconecta();
    }

    public List<PlanoDeDesenvolvimento> consultaInativos(int cd_equipe) throws SQLException, ClassNotFoundException, IOException {
        conecta();
        Statement stmt = this.conn.createStatement();
        List<PlanoDeDesenvolvimento> planosInativos = new ArrayList<>();
        String sql = "select * from T_B2W_PLANO_DES where cd_equipe = " + cd_equipe + " and ativo = 'I'";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Integer codigo = rs.getInt("cd_plano_desenvolvimento");
            Boolean ativo = (rs.getString("st_ativo") == "A");
            Gestor gestor = new GestorDAO().consultaPorCodigo(rs.getInt("cd_cadastro_gerente"));
            LocalDate dtInicio = rs.getDate("dt_inicio") != null ? rs.getDate("dt_inicio").toLocalDate() : null;
            LocalDate dtTermino = rs.getDate("dt_termino") != null ? rs.getDate("dt_termino").toLocalDate() : null;
            Associado associado = new AssociadoDAO().consultaPorId(rs.getInt("cd_cad_associado"));
            Equipe equipe = new EquipeDAO().consultaPorCodigo(rs.getInt("cd_equipe"));
            List<Task> tasks = new TaskDAO().consultaTodosDentroDeUmPlano(rs.getInt("cd_plano_desenvolvimento"));
            planosInativos.add(new PlanoDeDesenvolvimento(codigo, associado, gestor, equipe, dtInicio, dtTermino, tasks, ativo));
        }
        desconecta();
        return planosInativos;
    }

    public List<PlanoDeDesenvolvimento> consultaAtivos(int cd_equipe) throws SQLException, ClassNotFoundException, IOException {
        conecta();
        Statement stmt = this.conn.createStatement();
        List<PlanoDeDesenvolvimento> planosAtivos = new ArrayList<>();
        String sql = "select * from T_B2W_PLANO_DES where cd_equipe = " + cd_equipe + " and ativo = 'A'";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Integer codigo = rs.getInt("cd_plano_desenvolvimento");
            Boolean ativo = (rs.getString("st_ativo") == "A");
            Gestor gestor = new GestorDAO().consultaPorCodigo(rs.getInt("cd_cadastro_gerente"));
            LocalDate dtInicio = rs.getDate("dt_inicio") != null ? rs.getDate("dt_inicio").toLocalDate() : null;
            LocalDate dtTermino = rs.getDate("dt_termino") != null ? rs.getDate("dt_termino").toLocalDate() : null;
            Associado associado = new AssociadoDAO().consultaPorId(rs.getInt("cd_cadastro_associado"));
            Equipe equipe = new EquipeDAO().consultaPorCodigo(rs.getInt("cd_equipe"));
            List<Task> tasks = new TaskDAO().consultaTodosDentroDeUmPlano(rs.getInt("cd_plano_desenvolvimento"));
            planosAtivos.add(new PlanoDeDesenvolvimento(codigo, associado, gestor, equipe, dtInicio, dtTermino, tasks, ativo));
        }
        desconecta();
        return planosAtivos;
    }

    public PlanoDeDesenvolvimento consultaPorCodigo(int cd_plano_desenvolvimento) throws SQLException, ClassNotFoundException, IOException {
        conecta();
        PlanoDeDesenvolvimento plano = new PlanoDeDesenvolvimento();
        String sql = "select * from T_B2W_PLANO_DES where cd_plano_desenvolvimento = " + cd_plano_desenvolvimento;
        Statement stmt = this.conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        if (rs != null) {
            Integer codigo = rs.getInt("cd_plano_desenvolvimento");
            Boolean ativo = (rs.getString("st_ativo") == "A");
            LocalDate dtInicio = rs.getDate("dt_inicio").toLocalDate();
            if (rs.getDate("dt_termino") != null) {
                plano.setDtTermino(rs.getDate("dt_termino").toLocalDate());
            }
            plano.setId(codigo);
            plano.setGestor(new GestorDAO().consultaPorCodigo(rs.getInt("cd_cadastro_gerente")));
            plano.setDtInicio(dtInicio);
            plano.setAssociado(new AssociadoDAO().consultaPorId(rs.getInt("cd_cad_associado")));
            plano.setAtivo(ativo);
            plano.setEquipe(new EquipeDAO().consultaPorCodigo(rs.getInt("cd_equipe")));
            plano.setTasks(new TaskDAO().consultaTodosDentroDeUmPlano(rs.getInt("cd_plano_desenvolvimento")));
        } else System.err.println("Plano de desenvolvimento não encontrado");
        desconecta();
        return plano;
    }

    private void desconecta() throws SQLException {
        if (!this.conn.isClosed()) {
            this.conn.close();
        }
    }
}
