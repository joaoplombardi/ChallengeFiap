package br.com.fiap.b2w.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class PlanoDesenvDAO {
    private Connection conn;

    public void conecta() throws ClassNotFoundException, SQLException {
        this.conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM86433", "110701");
    }
}
