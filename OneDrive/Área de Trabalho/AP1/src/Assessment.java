import java.util.ArrayList;

public class Assessment {
    private String tipo;
    private double notaMaxima;
    private int peso;
    private Classroom turma;
    final private ArrayList<Submission> submissoes = new ArrayList<>();

    public Assessment(String tipo, double notaMaxima, int peso, Classroom turma) {
        this.tipo = tipo;
        this.notaMaxima = notaMaxima;
        this.peso = peso;
        this.turma = turma;

    }
    // Uma avaliação está associada a uma turma (1:N).
    public void setTurma(Classroom turma) {
        this.turma = turma;
    }

    public int getTurma() {
        return turma.getCodigo();
    }
    // Cada avaliação possui múltiplas submissões de alunos (N:N).
    public void addSubmissao(Submission submissao) {
        this.submissoes.add(submissao);
    }

    public void removeSubmissao(Submission submissao) {
        if (this.submissoes.contains(submissao)) {
            this.submissoes.remove(submissao);
            System.out.println("Submissao removida com sucesso!");
        }
    }

    public ArrayList<Submission> getSubmissoes() {
        return this.submissoes;
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