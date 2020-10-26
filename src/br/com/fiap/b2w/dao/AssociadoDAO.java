package br.com.fiap.b2w.dao;

import br.com.fiap.b2w.models.Associado;

import java.sql.*;

public class AssociadoDAO {
    private Connection conn;

    public void conecta() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        this.conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM86433", "110701");
    }

    public void salvar(Associado associado) throws SQLException, ClassNotFoundException {
        conecta();
        String sql = "insert into T_B2W_ASSOCIADO (cd_cad_associado, cd_equipe, nm_nome, nm_email, nm_senha, nm_cargo, nr_cpf) " +
                "values (sq_associado.nextval, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pStmt = this.conn.prepareStatement(sql);

        pStmt.setInt(1, associado.getEquipe().getCdEquipe());
        pStmt.setString(2, associado.getNomeCompleto());
        pStmt.setString(3, associado.getEmail());
        pStmt.setString(4, associado.getSenha());
        pStmt.setString(5, associado.getCargo());
        pStmt.setLong(6, associado.getCpf());
        pStmt.executeUpdate();
        desconecta();
    }

    public Associado consultaPorCodigo(int codigo) throws SQLException, ClassNotFoundException {
        conecta();
        Associado associado = new Associado();
        Statement stmt = conn.createStatement();
        String sql = "select * from T_B2W_ASSOCIADO where cd_cad_associado = " + codigo;
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        if (rs != null) {
            associado.setNrCadastro(rs.getInt("cd_cad_associado"));
            associado.setNomeCompleto(rs.getString("nm_nome"));
            associado.setEmail(rs.getString("nm_email"));
            associado.setSenha(rs.getString("nm_senha"));
            associado.setEquipe(new EquipeDAO().consultaPorCodigo(rs.getInt("cd_equipe")));
            associado.setCargo(rs.getString("nm_cargo"));
            associado.setCpf(rs.getLong("nr_cpf"));

        } else {
            System.err.println("O Funcionário não existe!");
        }
        desconecta();
        return associado;

    }

    private void desconecta() throws SQLException {
        if (!this.conn.isClosed()) {
            this.conn.close();
        }
    }
}
