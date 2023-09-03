package aplicacao;

public class Ingresso {
    private int codigo;
    private String cpf;
    private String nomeFilme;
    private int numeroPoltrona;
    private float preco;

    public Ingresso() {

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public int getNumeroPoltrona() {
        return numeroPoltrona;
    }

    public void setNumeroPoltrona(int numeroPoltrona) {
        this.numeroPoltrona = numeroPoltrona;
    }

    public float getPreco() {
        return preco;
    }

    public void Preco(int op) {
        if(op == 1) this.preco = 8;
        else this.preco = 16;
    }
}
