import java.util.ArrayList;

public class Assessment {
    private String tipo;
    private double notaMaxima;
    private int peso;
    private Classroom turma;
    private ArrayList<Submission> submissoes = new ArrayList<>();


    // Uma avaliação está associada a uma turma (1:N).
    public void setTurma(Classroom turma) {
        this.turma = turma;
    }

    public int getTurma() {
        return turma.getCodigo();
    }
    // Cada avaliação possui múltiplas submissões de alunos (N:N).
    public void addSubmissao(Submission submissao) {
        submissoes.add(submissao);
    }

    public void removeSubmissao(Submission submissao) {
        submissoes.remove(submissao);
    }

    public ArrayList<Submission> getSubmissoes() {
        return submissoes;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setNotaMaxima(double notaMaxima) {
        this.notaMaxima = notaMaxima;
    }

    public double getNotaMaxima() {
        return this.notaMaxima;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getPeso() {
        return this.peso;
    }

}