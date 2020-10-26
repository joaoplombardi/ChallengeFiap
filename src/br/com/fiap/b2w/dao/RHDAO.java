package br.com.fiap.b2w.dao;

import br.com.fiap.b2w.models.PlanodeDesenvolvimento;
import br.com.fiap.b2w.models.RH;

import java.sql.*;
import java.time.format.DateTimeFormatter;

public class RHDAO {
    private Connection conn;

    public void conecta() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        this.conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM86433", "110701");
    }


    public void aprovarPlano(PlanodeDesenvolvimento plano) throws SQLException, ClassNotFoundException {
        conecta();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        Statement stmt = this.conn.createStatement();
        String sql = String.format("update T_B2W_PLANO_DES set st_ativo = 'A', dt_inicio = to_date('%s', 'yyyy/MM/dd') where cd_plano_desenvolvimento = %s",
                formatter.format(plano.getDtInicio()), plano.getCdPlanodeDesenvolvimento());
        stmt.executeUpdate(sql);
        desconecta();
    }


    public RH consultaPorCodigo(int codigo) throws SQLException, ClassNotFoundException {
        conecta();
        RH rh = new RH();
        Statement stmt = conn.createStatement();
        String sql = "select * from T_B2W_RH where cd_cad_associado = " + codigo;
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        if (rs != null) {
            rh.setNrCadastro(rs.getInt("cd_cad_associado"));
            rh.setNomeCompleto(rs.getString("nm_nome"));
            rh.setEmail(rs.getString("nm_email"));
            rh.setSenha(rs.getString("nm_senha"));
            rh.setEquipe(new EquipeDAO().consultaPorCodigo(rs.getInt("cd_equipe")));
            rh.setCargo(rs.getString("nm_cargo"));
            rh.setCpf(rs.getLong("nr_cpf"));
            rh.setPlanosParaAprovacao(new PlanoDesenvDAO().consultaInativos(rs.getInt("cd_equipe")));

        } else {
            System.err.println("O responsável do RH não existe!");
        }
        desconecta();
        return rh;
    }

    private void desconecta() throws SQLException {
        if (!this.conn.isClosed()) {
            this.conn.close();
        }
    }
}
