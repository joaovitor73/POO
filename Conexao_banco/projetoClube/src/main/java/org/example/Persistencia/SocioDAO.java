package org.example.Persistencia;

import org.example.dominio.Socio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SocioDAO {
    private Conexao connection;
    private final String SELECT = "SELECT * FROM\"Socio\"";
    private final String SELECT_WHERE_ID = "SELECT * FROM \"Socio\" WHERE pk_cpf_s = ?";
    private final String INSERT = "INSERT INTO \"Socio\" (pk_cpf_s, nome_s, data_adm) values (?,?,TO_DATE(?, 'YYYY-MM-DD')) ";
    private final String DELETE_ID = "DELETE FROM \"Socio\" WHERE pk_cpf_s = ?";
    private final String UPDATE_ID = "UPDATE \"Socio\" SET pk_cpf_s = ?, nome_s = ? , data_adm = TO_DATE(?, 'YYYY-MM-DD') WHERE  pk_cpf_s = ?";

    public SocioDAO(){
        connection = new Conexao("jdbc:postgresql://localhost:5432/BDSocio", "postgres", "1234");
    }

    public void atualizar(int cpfAntigo, Socio s){
        try{
           connection.conectar();
           PreparedStatement instrucao = connection.getCon().prepareStatement(UPDATE_ID);
           instrucao.setInt(1, s.getCpf_s());
           instrucao.setString(2, s.getNome_s());
           instrucao.setString(3, s.getData_adm());
           instrucao.setInt(4,cpfAntigo);
           instrucao.execute();
           connection.desconectar();
        }catch(Exception e){
            System.out.println("Erro na atualização: " + e.getMessage());
        }
    }

    public void excluir(int cpf){
        try{
            connection.conectar();
            PreparedStatement instrucao = connection.getCon().prepareStatement(DELETE_ID);
            instrucao.setInt(1,cpf);
            instrucao.execute();
            connection.desconectar();
        }catch(Exception e){
            System.out.println("Erro na exclusão: " + e.getMessage());
        }
    }

    public void inserir(Socio s){
        try{
            connection.conectar();
            PreparedStatement instrucao = connection.getCon().prepareStatement(INSERT);
            instrucao.setInt(1, s.getCpf_s());
            instrucao.setString(2,s.getNome_s());
            instrucao.setString(3, s.getData_adm());
            instrucao.execute();
            connection.desconectar();
        }catch(Exception e){
            System.out.println("Erro na inclusão: " + e.getMessage());
        }
    }
    public Socio relatorio_id(int cpf){
        Socio socio = null;
        try{
            connection.conectar();
            PreparedStatement instrucao = connection.getCon().prepareStatement(SELECT_WHERE_ID);
            instrucao.setInt(1, cpf);
            ResultSet rs = instrucao.executeQuery();
            if(rs.next())
                socio = new Socio(rs.getInt("pk_cpf_s"), rs.getString("nome_s"), rs.getString("data_adm"));
            connection.desconectar();
        }catch(Exception e){
            System.out.println("Erro no relatório por CPF: " + e.getMessage());
        }
        return socio;
    }

    public ArrayList<Socio> relatorioGeral() {
        ArrayList<Socio> socios = new ArrayList<>();
        Socio socio;
        try {
            connection.conectar();
            Statement instrucao = connection.getCon().createStatement();
            ResultSet rs = instrucao.executeQuery(SELECT);
            while (rs.next()) {
                socio = new Socio(rs.getInt("pk_cpf_s"), rs.getString("nome_s"), rs.getString("data_adm"));
                socios.add(socio);
            }
            connection.desconectar();
        } catch (Exception e) {
            System.out.println("Erro na busca: " + e.getMessage());
        }
        return socios;
    }
}
