package aplicacao;

public class Elevador {
    private int andarAtual;
    private int totAndares;
    private int capacidade;
    private int totPessoas;

    public void inicializa(int capacidade, int totAndares){
        this.capacidade = capacidade;
        this.totAndares = totAndares;
        andarAtual = 0;
        totPessoas = 0;
    }

   public boolean entra(){
        if(totPessoas < capacidade) {
            totPessoas++;
            return true;
        }
        return false;
    }

    public boolean sair(){
        if(totPessoas > 0) {
            totPessoas--;
            return true;
        }
        return false;
    }

    public boolean sobe(){
        if(andarAtual < (totAndares-1)) {
            andarAtual++;
            return true;
        }
        return false;
    }

    public boolean desce(){
        if(andarAtual> 0) {
            andarAtual--;
            return true;
        }
        return false;
    }

}
