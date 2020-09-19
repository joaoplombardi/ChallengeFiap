package br.com.fiap.b2w.dao;

import br.com.fiap.b2w.models.Equipe;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EquipeDAO {
    private Connection conn;

    public void conecta() throws ClassNotFoundException, SQLException {
        this.conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM86433", "110701");
    }

    public void salvar(Equipe equipe) throws SQLException, ClassNotFoundException {
        conecta();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String sql = "insert into T_B2W_EQUIPE (cd_equipe, cd_gerente, cd_rh, dt_inicio) values (?, ?, ?, to_date(?, 'yyyy/MM/dd'))";
        PreparedStatement pStmt = this.conn.prepareStatement(sql);
        pStmt.setInt(1, equipe.getCdEquipe());
        pStmt.setInt(2, equipe.getGerenteResponsavel().getNrCadastro());
        pStmt.setInt(3, equipe.getRhResponsavel().getNrCadastro());
        pStmt.setString(4, formatter.format(equipe.getDtInicio()));
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
            equipe.setMembros(new AssociadoDAO().consultaTodosPorEquipe(rs.getInt("cd_equipe")));
        }
        return equipe;
     }
















    private void desconecta() throws SQLException {
        if(!this.conn.isClosed()){
            this.conn.close();
        }
    }
}
