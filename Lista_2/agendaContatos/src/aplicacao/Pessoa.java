package aplicacao;

import java.util.ArrayList;

public class Pessoa {
    private String nome;
    private String email;
    private ArrayList<String> telefone = new ArrayList<String>();

    public Pessoa() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<String> getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone.add(telefone);
    }
}
