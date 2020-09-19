package br.com.fiap.b2w.dao;
import br.com.fiap.b2w.models.PlanodeDesenvolvimento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PlanoDesenvDAO {
    private Connection conn;

    public void conecta() throws ClassNotFoundException, SQLException {
        this.conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM86433", "110701");
    }

    public void salvar(PlanodeDesenvolvimento planodeDesenvolvimento) throws SQLException, ClassNotFoundException {
        conecta();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Statement stmt = this.conn.createStatement();
        String sql = String.format("insert into T_B2W_PLANO_DESENVOLVIMENTO (cd_plano_desenvolvimento, cd_colaborador, cd_gerente, cd_equipe) " +
        "values (sq_plano_desenvolvimento.nextval, %s, %s, %s)", planodeDesenvolvimento.getAssociado().getNrCadastro(),
                planodeDesenvolvimento.getGestor().getNrCadastro(), planodeDesenvolvimento.getGestor().getCodigoSetorGerencia());
        stmt.executeUpdate(sql);
        desconecta();
    }

    public List<PlanodeDesenvolvimento> consultaTodos() throws SQLException, ClassNotFoundException {
        conecta();
        Statement stmt = this.conn.createStatement();
        String sql = ("select * from T_B2W_PLANO_DESENVOLVIMENTO order by cd_plano_desenvolvimento ASC");
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){

            Integer cdPlanoDesenvolvimento = rs.getInt("cd_plano_desenvolvimento");




            LocalDate dtInicio = rs.getDate("dt_inicio").toLocalDate();

        }
        return null;
    }

    public List<PlanodeDesenvolvimento> consultaTodosPorGestor(Integer codigoGestor) throws SQLException, ClassNotFoundException {
        conecta();
        Statement stmt = this.conn.createStatement();
        String sql = ("select * from T_B2W_PLANO_DESENVOLVIMENTO where cd_gerente = " + codigoGestor + " order by cd_plano_desenvolvimento ASC");
        ResultSet rs = stmt.executeQuery(sql);
        List<PlanodeDesenvolvimento> consultaPorGestor = new ArrayList<>();
        while(rs.next()){

            Integer cdPlanoDesenvolvimento = rs.getInt("cd_plano_desenvolvimento");




            LocalDate dtInicio = rs.getDate("dt_inicio").toLocalDate();
            consultaPorGestor.add(new PlanodeDesenvolvimento());
        }
        desconecta();
        return null;
    }

    public void iniciarPlanoDesenvolvimento(PlanodeDesenvolvimento planodeDesenvolvimento) throws SQLException, ClassNotFoundException {
        conecta();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        Statement stmt = this.conn.createStatement();
        String dtInicio = formatter.format(planodeDesenvolvimento.getDtInicio());
        String sql = String.format("update T_B2W_PLANO_DESENVOLVIMENTO set dt_inicio = to_date('%s', 'yyyy/MM/dd') where cd_plano_desenvolvimento = %s",
                dtInicio, planodeDesenvolvimento.getCdPlanodeDesenvolvimento());
        stmt.executeUpdate(sql);
        desconecta();
    }

    public void terminarPlanoDesenvolvimento(PlanodeDesenvolvimento planodeDesenvolvimento) throws SQLException, ClassNotFoundException {
        conecta();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Statement stmt = this.conn.createStatement();
        String dtTermino = formatter.format(planodeDesenvolvimento.getDtTermino());
        String sql = String.format("update T_B2W_PLANO_DESENVOLVIMENTO set dt_termino = to_date('%s', 'yyyy/MM/dd') where cd_plano_desenvolvimento = %s",
                dtTermino, planodeDesenvolvimento.getCdPlanodeDesenvolvimento());
        stmt.executeUpdate(sql);
        desconecta();
    }


    private void desconecta() throws SQLException {
        if(!this.conn.isClosed()){
            this.conn.close();
        }
    }

    public List<PlanodeDesenvolvimento> consultaInativos(int cd_equipe) throws SQLException, ClassNotFoundException {
        conecta();
        Statement stmt = this.conn.createStatement();
        List<PlanodeDesenvolvimento> planosInativos = new ArrayList<>();
        String sql = "select * from T_B2W_PLANO_DESENVOLVIMENTO where cd_equipe = "+cd_equipe+" and ativo = 'I'";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            Integer codigo = rs.getInt("cd_plano_desenvolvimento");
            Integer codEquipe = rs.getInt("cd_equipe");


        }
        return planosInativos;
    }
}
