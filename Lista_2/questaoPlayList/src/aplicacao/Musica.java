package aplicacao;

public class Musica {
    private int duracaoTot;
    private String nome;
    private String cantor;
    public Musica(int duracaoTot, String nome, String cantor){
        this.duracaoTot = duracaoTot;
        this.nome = nome;
        this.cantor = cantor;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCantor() {
        return cantor;
    }

    public void setCantor(String cantor) {
        this.cantor = cantor;
    }

    public int getDuracaoTot() {return duracaoTot;}
}
