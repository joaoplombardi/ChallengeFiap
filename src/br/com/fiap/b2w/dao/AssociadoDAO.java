package br.com.fiap.b2w.dao;

import br.com.fiap.b2w.models.Associado;
import br.com.fiap.b2w.models.Gestor;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.List;

public class AssociadoDAO {
    private Connection conn;

    public void conecta() throws ClassNotFoundException, SQLException{
        this.conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM86433", "110701");
    }

    public void salvar(Associado associado) throws SQLException, ClassNotFoundException {
        conecta();
        String sql = "insert into T_B2W_ASSOCIADO (cd_cadastro_associado, cd_equipe, nm_nome, nm_email, nm_senha, nm_cargo, nr_cpf) " +
                "values (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pStmt = this.conn.prepareStatement(sql);
        pStmt.setInt(1, associado.getNrCadastro());
        pStmt.setInt(2, associado.getEquipe().getCdEquipe());
        pStmt.setString(3, associado.getNomeCompleto());
        pStmt.setString(4, associado.getEmail());
        pStmt.setString(5, associado.getSenha());
        pStmt.setString(6, associado.getCargo());
        pStmt.setLong(7, associado.getCpf());
        pStmt.executeUpdate();

    }

    public List<Associado> consultaTodosPorEquipe(int codigo) {
        return null;
    }

    public Associado consultaPorCodigo(int codigo) throws SQLException, ClassNotFoundException {
        conecta();
        Associado associado = new Associado();
        Statement stmt = conn.createStatement();
        String sql = "select * from T_B2W_ASSOCIADO where cd_cadastro_associado = " + codigo;
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        if(rs != null){
            associado.setNrCadastro(rs.getInt("cd_cadastro_associado"));
            associado.setNomeCompleto(rs.getString("nm_nome"));
            associado.setEmail(rs.getString("nm_email"));
            associado.setSenha(rs.getString("nm_senha"));
            associado.setEquipe(new EquipeDAO().consultaPorCodigo(rs.getInt("cd_equipe")));
            associado.setCargo(rs.getString("nm_cargo"));
            associado.setCpf(rs.getLong("nr_cpf"));

        }else {
            System.err.println("O Funcionário não existe!");
        }
        return associado;
    }

    private void desconecta() throws SQLException {
        if(!this.conn.isClosed()){
            this.conn.close();
        }
    }
}
