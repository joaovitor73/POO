package org.example.dominio;

public class Casa extends Imovel{
    private Porta porta1;
    private Porta porta2;
    private Porta porta3;

    public int quantasPortasEstaoAbertas(){
        int cont = 0;
        Porta[] portas =  {porta1,porta2, porta3};
        for(Porta p : portas)
            if(p!= null && p.estaAberta()) cont++;
        return cont;
    }

    public Porta getPorta1() {
        return porta1;
    }

    public void setPorta1(Porta porta1) {
        this.porta1 = porta1;
    }

    public Porta getPorta2() {
        return porta2;
    }

    public void setPorta2(Porta porta2) {
        this.porta2 = porta2;
    }

    public Porta getPorta3() {
        return porta3;
    }

    public void setPorta3(Porta porta3) {
        this.porta3 = porta3;
    }
}
