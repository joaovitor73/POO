package org.example.Persistencia;

import org.example.dominio.Dependente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DependenteDAO {
    private Conexao connection;
    private final String SELECT = "SELECT * FROM \"Dependente\"";
    private final  String SELECT_ID = "SELECT * FROM \"Dependente\" WHERE pk_id = ? AND fk_cpf_s = ?";
    private final String INSERT = "INSERT INTO \"Dependente\" (pk_id, nome_d,idade, fk_cpf_s) VALUES (?,?,?,?)";
    private final String DELETE = "DELETE FROM \"Dependente\" WHERE pk_id = ? AND fk_cpf_s = ?";
    private final String UPDATE = "UPDATE \"Dependente\" SET pk_id = ? , nome_d = ? ,idade = ? , fk_cpf_s = ?  WHERE pk_id = ? AND fk_cpf_s = ?";

    public DependenteDAO(){
        connection = new Conexao("jdbc:postgresql://localhost:5432/BDSocio", "postgres", "1234");
    }

    public void alterar(int id_velho, int cpf_s, Dependente d){
        try{
            connection.conectar();
            PreparedStatement instrucao = connection.getCon().prepareStatement(UPDATE);
            instrucao.setInt(1,d.getId());
            instrucao.setString(2, d.getNome_d());
            instrucao.setInt(3, d.getIdade());
            instrucao.setInt(4, cpf_s);
            instrucao.setInt(5, id_velho);
            instrucao.setInt(6, cpf_s);
            instrucao.execute();
            connection.desconectar();
        }catch(Exception e){
            System.out.println("Erro na atualização: " + e.getMessage());
        }
    }
    public void excluir(int id, int cpf_s){
        try{
            connection.conectar();
            PreparedStatement instrucao = connection.getCon().prepareStatement(DELETE);
            instrucao.setInt(1,id);
            instrucao.setInt(2,cpf_s);
            instrucao.execute();
            connection.desconectar();
        }catch(Exception e){
            System.out.println("Erro na exclusão: " + e.getMessage());
        }
    }
    public void inserir(int cpf_s, Dependente d){
        try{
            connection.conectar();
            PreparedStatement instrucao = connection.getCon().prepareStatement(INSERT);
            instrucao.setInt(1,d.getId());
            instrucao.setString(2, d.getNome_d());
            instrucao.setInt(3,d.getIdade());
            instrucao.setInt(4,cpf_s);
            instrucao.execute();
            connection.desconectar();
        }catch(Exception e){
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }

    public Dependente relatorio_id(int id, int cpf_s){
        Dependente dependente = null;
        try{
            connection.conectar();
            PreparedStatement instrucao = connection.getCon().prepareStatement(SELECT_ID);
            instrucao.setInt(1, id);
            instrucao.setInt(2, cpf_s);
            ResultSet rs = instrucao.executeQuery();
            if(rs.next()) {
                dependente = new Dependente(rs.getInt("pk_id"), rs.getString("nome_d"), rs.getInt("idade"));
            }
            connection.desconectar();
        }catch(Exception e){
            System.out.println("Erro no reletório por id: " + e.getMessage());
        }

        return dependente;
    }

    public ArrayList<Dependente> relatorioGeral(int cpf_s){
        ArrayList<Dependente> dependentes = new ArrayList<>();
        Dependente dependente;
        try{
            connection.conectar();
            Statement instrucao = connection.getCon().createStatement();
            ResultSet rs = instrucao.executeQuery(SELECT);
            while(rs.next()){
                if(rs.getInt("fk_cpf_s") == cpf_s) {
                    dependente = new Dependente(rs.getInt("pk_id"), rs.getString("nome_d"), rs.getInt("idade"));
                    dependentes.add(dependente);
                }
            }
            connection.desconectar();
        }catch(Exception e){
            System.out.println("Erro no relatório geral: " + e.getMessage());
        }
        return dependentes;
    }


}
