package aplicacao;

public class Robo {
    private int linha;
    private int coluna;
    private int passo;

    public Robo(){
        this.linha = 0;
        this.coluna = 0;
    }

    public Robo(int passo){
        this.linha = 0;
        this.coluna = 0;
        this.passo = passo;
    }

    public int[] mostrarPosicaoAtual(){
        int posicao[] = {linha, coluna};
        return posicao;
    }

    public void setPasso(int passo) {
        this.passo = passo;
    }

    public void andarFrente(){
        if(linha+passo < 20) linha+=passo;
    }

    public void andarTras(){
        if((linha-passo) >= 0) linha-=passo;
    }

    public void andarDireita(){
        if(coluna+passo < 40) coluna+=passo;
    }

    public void andarEsquerda(){
        if(coluna-passo >= 0) coluna-=passo;
    }
}
