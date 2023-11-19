package org.example.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    private String path;
    private String user;
    private String password;
    private Connection con;

    public Conexao(String path, String user, String password){
        this.path = path;
        this.user = user;
        this.password = password;
    }

    public void conectar(){
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(path, user, password);
        }catch(Exception e){
            System.out.println("Erro na conexão: " + e.getMessage());
        }
    }

    public void desconectar(){
        try{
            con.close();
        }catch(Exception e){
            System.out.println("Erro na desconexão: " + e.getMessage());
        }
    }

    public Connection getCon(){
        return this.con;
    }

}
