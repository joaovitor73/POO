package aplicacao;

public class Aluno {
    private String nome;
    private int matricula;
    private float nota1, nota2, nota3;
    private float media;
    private String situacao;

    public Aluno(){

    }

    public String getNome() {
        return nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public float getNota1() {
        return nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public float getNota3() {
        return nota3;
    }

    public float getMedia() {
        return media;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void setNota(float nota1, float nota2, float nota3) {
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public void calcularMedia(){
        this.media = ((this.nota1*4)+(this.nota2*5)+(this.nota3*6))/15;
        if(this.media < 3) this.situacao = "Reprovado";
        else if(media >= 7) this.situacao = "Aprovado";
        else this.situacao = "Recuperação";
    }

    public boolean buscarAluno(int matricula){
        if(matricula == this.matricula)
            return true;
        return false;
    }

    public String alterarNota(int codNota, float valorNota) {
        if (codNota == 1)
            this.nota1 = valorNota;
        else if (codNota == 2)
            this.nota2 = valorNota;
        else
            this.nota3 = valorNota;
        calcularMedia();
        return situacao;
    }

}
