

public class Submission {
    private Student aluno;
    private Assessment avaliacao;
    private double nota;
    private String dataEntrega;
    private String obs;
    private double valor = -1;

    public Student getAluno() {
        return aluno;
    }

    public void setAluno(Student aluno) {
        this.aluno = aluno;
    }

    public Assessment getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Assessment avaliacao) {
        this.avaliacao = avaliacao;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {

        try {
            if (nota < 0 || nota > avaliacao.getNotaMaxima()) {
                throw new IllegalArgumentException("Nota inválida");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        this.nota = nota;
    }


    public String getData() {
        return this.dataEntrega;
    }

    public void setData(String data) {
        this.dataEntrega = data;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }


}


