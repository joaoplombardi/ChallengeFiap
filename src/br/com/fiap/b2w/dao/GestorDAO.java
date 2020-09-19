package br.com.fiap.b2w.dao;

import br.com.fiap.b2w.models.Equipe;
import br.com.fiap.b2w.models.Gestor;

import java.sql.Connection;
import java.sql.*;


public class GestorDAO {
    private Connection conn;

    public void conecta() throws ClassNotFoundException, SQLException{
        this.conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM86433", "110701");
    }

    public Gestor consultaPorCodigo(int codigo) throws SQLException, ClassNotFoundException {
        conecta();
        Gestor gestor = new Gestor();
        Statement stmt = conn.createStatement();
        String sql = "select * from T_B2W_GERENTE where cd_cadastro_associado = " + codigo;
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        if(rs != null){
            gestor.setNrCadastro(rs.getInt("cd_cadastro_associado"));
            gestor.setNomeCompleto(rs.getString("nm_nome"));
            gestor.setEmail(rs.getString("nm_email"));
            gestor.setSenha(rs.getString("nm_senha"));
            gestor.setEquipe(new EquipeDAO().consultaPorCodigo(rs.getInt("cd_equipe")));
            gestor.setCargo(rs.getString("nm_cargo"));
            gestor.setCpf(rs.getLong("nr_cpf"));
            gestor.setPlanosCriados(new PlanoDesenvDAO().consultaTodosPorGestor(rs.getInt("cd_cadastro_associado")));
        }else {
            System.err.println("O gerente não existe!");
        }
        return gestor;
    }

}
