package br.com.fiap.b2w.dao;

import br.com.fiap.b2w.models.Status;
import br.com.fiap.b2w.models.Task;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
    private Connection conn;

    public void conecta() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        this.conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM86433", "110701");
    }

    public void salvar(Task task) throws SQLException, ClassNotFoundException {
        conecta();
        String sql = "inserto into T_B2W_TASK (cd_plano_desenvolvimento, cd_equipe, cd_task, nm_nome, ds_task, st_status)" +
                "values (sq_task.nextval, ?, ?, ?, ?, ?)";
        PreparedStatement pStmt = this.conn.prepareStatement(sql);

        pStmt.setInt(1, task.getPlanoPertencente());
        pStmt.setInt(2, task.getCdTask());
        pStmt.setString(3, task.getNome());
        pStmt.setString(4, task.getObjetivo());
        pStmt.setString(5, task.getStatus().getStatus());
        pStmt.executeUpdate();
        desconecta();
    }

    public List<Task> consultaTodosDentroDeUmPlano(int cd_plano_desenvolvimento) throws SQLException, ClassNotFoundException {
        conecta();
        List<Task> tasksPlano = new ArrayList<>();
        Statement stmt = this.conn.createStatement();
        String sql = "select * from T_B2W_TASK where cd_plano_desenvolvimento = " + cd_plano_desenvolvimento;
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Integer codigo = rs.getInt("cd_task");
            String nome = rs.getString("nm_nome");
            Status status = Status.valueOf(rs.getString("st_status"));
            String objetivo = rs.getString("ds_task");
            Integer plano = rs.getInt("cd_plano_desenvolvimento");
            tasksPlano.add(new Task(nome, codigo, status, objetivo, plano));
        }
        return tasksPlano;
    }

    public void iniciaTask(Task task) throws SQLException, ClassNotFoundException {
        conecta();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        Statement stmt = this.conn.createStatement();
        String sql = "update T_B2W_TASK set st_status = 'Em andamento' where cd_task = " + task.getCdTask();
        stmt.executeUpdate(sql);
    }

    public void encerraTask(Task task) throws SQLException, ClassNotFoundException {
        conecta();
        Statement stmt = this.conn.createStatement();
        String sql = "update T_B2W_TASK set st_status = 'Concluída' where cd_task = " + task.getCdTask();
        stmt.executeUpdate(sql);
    }

    private void desconecta() throws SQLException {
        if (!this.conn.isClosed()) {
            this.conn.close();
        }
    }
}
