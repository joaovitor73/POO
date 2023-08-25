package aplicacao;

public class Cachorro {

    private String nome;
    private String raca;
    private int idade;

    public Cachorro(String nome, String raca, int idade) {
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
    }

    public String informarEstado(){
        return "Cachorro{nome="  + this.nome +
                ", raca=" +this.raca +
                ", idade=" + this.idade +  "}\n";
    }

    public Cachorro clonarCachorro(){
        Cachorro c2 = new Cachorro(this.nome, this.raca, this.idade);
        return c2;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
