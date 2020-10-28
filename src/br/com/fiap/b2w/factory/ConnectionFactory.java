package br.com.fiap.b2w.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private Properties props;

    public ConnectionFactory() throws IOException {
        this.props = new Properties();
        this.props.load(new FileInputStream("application.properties"));
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(
                this.props.getProperty("database.url"),
                this.props.getProperty("database.user"),
                this.props.getProperty("database.password"));
    }


}
