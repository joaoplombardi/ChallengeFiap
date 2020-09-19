package br.com.fiap.b2w.dao;
import br.com.fiap.b2w.models.*;

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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String sql = "insert into T_B2W_PLANO_DESENVOLVIMENTO (cd_plano_desenvolvimento, cd_equipe, cd_cadastro_associado, cd_cadastro_gerente, st_ativo)" +
                "values(?, ?, ?, ?, ?)";
        PreparedStatement pStmt = this.conn.prepareStatement(sql);
        pStmt.setInt(1, planodeDesenvolvimento.getCdPlanodeDesenvolvimento());
        pStmt.setInt(2, planodeDesenvolvimento.getEquipe().getCdEquipe());
        pStmt.setInt(3, planodeDesenvolvimento.getAssociado().getNrCadastro());
        pStmt.setInt(4, planodeDesenvolvimento.getGestor().getNrCadastro());
        pStmt.setString(5, planodeDesenvolvimento.getAtivo() == true ? "A" : "I");
        desconecta();
    }

    public List<PlanodeDesenvolvimento> consultaTodos() throws SQLException, ClassNotFoundException {
        conecta();
        List<PlanodeDesenvolvimento> todosPlanos = new ArrayList<>();
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
            Boolean ativo = (rs.getString("st_ativo") == "A");
            Gestor gestor = new GestorDAO().consultaPorCodigo(rs.getInt("cd_cadastro_gerente"));
            Associado associado = new AssociadoDAO().consultaPorCodigo(rs.getInt("cd_cadastro_associado"));
            Equipe equipe = new EquipeDAO().consultaPorCodigo(rs.getInt("cd_equipe"));
            List<Task> tasks = new TaskDAO().consultaTodosDentroDeUmPlano(rs.getInt("cd_plano_desenvolvimento"));
            planosInativos.add(new PlanodeDesenvolvimento(codigo, associado, gestor, equipe, tasks, ativo));
        }
        return planosInativos;
    }

    public List<PlanodeDesenvolvimento> consultaAtivos(int cd_equipe) throws SQLException, ClassNotFoundException {
        conecta();
        Statement stmt = this.conn.createStatement();
        List<PlanodeDesenvolvimento> planosAtivos = new ArrayList<>();
        String sql = "select * from T_B2W_PLANO_DESENVOLVIMENTO where cd_equipe = "+cd_equipe+" and ativo = 'A'";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            Integer codigo = rs.getInt("cd_plano_desenvolvimento");
            Boolean ativo = (rs.getString("st_ativo") == "A");
            LocalDate dtInicio = rs.getDate("dt_inicio").toLocalDate();
            Gestor gestor = new GestorDAO().consultaPorCodigo(rs.getInt("cd_cadastro_gerente"));
            Associado associado = new AssociadoDAO().consultaPorCodigo(rs.getInt("cd_cadastro_associado"));
            Equipe equipe = new EquipeDAO().consultaPorCodigo(rs.getInt("cd_equipe"));
            List<Task> tasks = new TaskDAO().consultaTodosDentroDeUmPlano(rs.getInt("cd_plano_desenvolvimento"));
            planosAtivos.add(new PlanodeDesenvolvimento(codigo, associado, gestor, equipe, dtInicio, tasks, ativo));
        }
        return planosAtivos;
    }

    public PlanodeDesenvolvimento consultaPorCodigo(int cd_plano_desenvolvimento) throws SQLException, ClassNotFoundException {
        conecta();
        PlanodeDesenvolvimento plano = new PlanodeDesenvolvimento();
        String sql = "select * from T_B2W_PLANO_DESENVOLVIMENTO where cd_plano_desenvolvimento = " + cd_plano_desenvolvimento;
        Statement stmt = this.conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        if (rs != null){
            Integer codigo = rs.getInt("cd_plano_desenvolvimento");
            Boolean ativo = (rs.getString("st_ativo") == "A");
            LocalDate dtInicio = rs.getDate("dt_inicio").toLocalDate();
            if (rs.getDate("dt_termino") != null){plano.setDtTermino(rs.getDate("dt_termino").toLocalDate());}
            plano.setCdPlanodeDesenvolvimento(codigo);
            plano.setGestor(new GestorDAO().consultaPorCodigo(rs.getInt("cd_cadastro_gerente")));
            plano.setDtInicio(dtInicio);
            plano.setAssociado(new AssociadoDAO().consultaPorCodigo(rs.getInt("cd_cadastro_associado")));
            plano.setAtivo(ativo);
            plano.setEquipe(new EquipeDAO().consultaPorCodigo(rs.getInt("cd_equipe")));
            plano.setTasks(new TaskDAO().consultaTodosDentroDeUmPlano(rs.getInt("cd_plano_desenvolvimento")));
        }else System.err.println("Plano de desenvolviemnto não encontrado");
        return plano;
    }
}
