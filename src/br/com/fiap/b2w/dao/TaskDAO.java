package br.com.fiap.b2w.dao;

import br.com.fiap.b2w.models.PlanodeDesenvolvimento;
import br.com.fiap.b2w.models.Status;
import br.com.fiap.b2w.models.Task;
import jdk.jshell.Snippet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
    private Connection conn;

    public void conecta() throws ClassNotFoundException, SQLException {
        this.conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM86433", "110701");
    }

    public List<Task> consultaTodosDentroDeUmPlano(int cd_plano_desenvolvimento) throws SQLException, ClassNotFoundException {
        conecta();
        List<Task> tasksPlano = new ArrayList<>();
        Statement stmt = this.conn.createStatement();
        String sql = "select * from T_B2W_TASK where cd_plano_desenvolvimento = " + cd_plano_desenvolvimento;
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
            Integer codigo = rs.getInt("cd_task");
            Status status = Status.valueOf(rs.getString("st_status"));
            String objetivo = rs.getString("nm_nome");
            PlanodeDesenvolvimento plano = new PlanoDesenvDAO().consultaPorCodigo(rs.getInt("cd_plano_desenvolvimento"));
            tasksPlano.add(new Task(codigo, status, objetivo, plano));
        }
        return tasksPlano;
    }
}
