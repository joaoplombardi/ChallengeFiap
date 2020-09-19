package br.com.fiap.b2w.dao;

import br.com.fiap.b2w.models.Associado;

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
        Statement stmt = this.conn.createStatement();
        String sql = String.format("insert into ");

    }

    public List<Associado> consultaTodosPorEquipe(int codigo) {
        return null;
    }
}
