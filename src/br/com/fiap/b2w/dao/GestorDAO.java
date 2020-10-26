package br.com.fiap.b2w.dao;

import br.com.fiap.b2w.models.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class GestorDAO {
    private Connection conn;

    public void conecta() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        this.conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM86433", "110701");
    }

//    public void salvar(Gestor gestor) throws SQLException, ClassNotFoundException {
//        conecta();
//        String sql = "insert into T_B2W_GESTOR (cd_cadastro_associado, cd_equipe, nm_nome, nm_email, nm_senha, nm_cargo, nr_cpf) " +
//                "values (?, ?, ?, ?, ?, ?, ?)";
//        PreparedStatement pStmt = this.conn.prepareStatement(sql);
//
//        pStmt.executeUpdate();
//
//    }

    public List<PlanodeDesenvolvimento> consultaTodosPorGestor(Integer codigoGestor) throws SQLException, ClassNotFoundException {
        conecta();
        Statement stmt = this.conn.createStatement();
        String sql = ("select * from T_B2W_PLANO_DES where cd_gerente = " + codigoGestor + " order by cd_plano_desenvolvimento ASC");
        ResultSet rs = stmt.executeQuery(sql);
        List<PlanodeDesenvolvimento> consultaPorGestor = new ArrayList<>();
        while (rs.next()) {
            Integer codigo = rs.getInt("cd_plano_desenvolvimento");
            Equipe equipe = new EquipeDAO().consultaPorCodigo(rs.getInt("cd_equipe"));
            Associado associado = new AssociadoDAO().consultaPorCodigo(rs.getInt("cd_cad_associado"));
            Gestor gestor = new GestorDAO().consultaPorCodigo(rs.getInt("cd_cadastro_gerente"));
            LocalDate dtInicio = rs.getDate("dt_inicio") != null ? rs.getDate("dt_inicio").toLocalDate() : null;
            LocalDate dtTermino = rs.getDate("dt_termino") != null ? rs.getDate("dt_termino").toLocalDate() : null;
            Boolean ativo = rs.getString("st_ativo") == "A";
            List<Task> tasks = new TaskDAO().consultaTodosDentroDeUmPlano(rs.getInt("cd_plano_desenvolvimento"));
            consultaPorGestor.add(new PlanodeDesenvolvimento(codigo, associado, gestor, equipe, dtInicio, dtTermino, tasks, ativo));
        }
        desconecta();
        return consultaPorGestor;
    }

    public Gestor consultaPorCodigo(int codigo) throws SQLException, ClassNotFoundException {
        conecta();
        Gestor gestor = new Gestor();
        Statement stmt = conn.createStatement();
        String sql = "select * from T_B2W_GERENTE where cd_cad_associado = " + codigo;
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        if (rs != null) {
            gestor.setNrCadastro(rs.getInt("cd_cadastro_associado"));
            gestor.setNomeCompleto(rs.getString("nm_nome"));
            gestor.setEmail(rs.getString("nm_email"));
            gestor.setSenha(rs.getString("nm_senha"));
            gestor.setEquipe(new EquipeDAO().consultaPorCodigo(rs.getInt("cd_equipe")));
            gestor.setCargo(rs.getString("nm_cargo"));
            gestor.setCpf(rs.getLong("nr_cpf"));
            gestor.setPlanosCriados(consultaTodosPorGestor(rs.getInt("cd_cadastro_associado")));
        } else {
            System.err.println("O gerente não existe!");
        }
        return gestor;
    }

    private void desconecta() throws SQLException {
        if (!this.conn.isClosed()) {
            this.conn.close();
        }
    }

}
