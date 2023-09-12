package aplicacao;

public class Aluno {
    private int matricula;
    private String nome;
    private float ntProvas[];
    private float ntTrabalho;
    private float media;

    public Aluno(int matricula, String nome, float[] ntProvas, float ntTrabalho) {
        this.ntProvas = new float[2];
        this.matricula = matricula;
        this.nome = nome;
        this.ntProvas = ntProvas;
        this.ntTrabalho = ntTrabalho;
    }

    public int getMatricula(){
        return matricula;
    }

    public void media(){
        media =  (float) ((ntTrabalho*2)+(ntProvas[0]*2.5)+(ntProvas[1]*2.5))/7;
    }

    public String getNome(){
        return nome;
    }

    public float getMedia(){
        this.media();
        return media;
    }

    public float pvFinal(){
        if(this.media < 5){
            return 5-this.media;
        }
        return 0;
    }

    public String estado(){
        return "Aluno{[Nome: " + this.nome + "],\n[Matricula: " +
                this.matricula + "]\n[Notas provas: 1a. " + this.ntProvas[0] +
                " 2a. " + this.ntProvas[1]  + "]\n[Nota trabalho: " + this.ntTrabalho +
                "]\n[Media: " + this.media + "]\n[Pontuação para passae na prova final: "
                + pvFinal() + "]}";
    }
}
