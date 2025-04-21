
import java.util.ArrayList;

public class PerformanceReport {
    private double mediaPonderada;
    private ArrayList<Double> notas = new ArrayList<>();
    private ArrayList<Double> notasMaximas = new ArrayList<>();
    private ArrayList<Integer> pesos = new ArrayList<>();
    private double aproveitamento;


    //Notas individuais;
    public ArrayList<Double> getNotasIndividuais(){
        return notas;
    }

    public void setNotasIndividuais(Student aluno) {
        for(Classroom cr: aluno.getClassrooms()){
            for(Assessment as: cr.getAssessments()){
                for(Submission sub: as.getSubmissoes()){
                    if(sub.getAluno().getNome().equals(aluno.getNome())){
                        this.notas.add(sub.getNota());
                        this.pesos.add(as.getPeso());
                        this.notasMaximas.add(as.getNotaMaxima());
                    }
                }
            }
        }




    }
    //REFAZER
    public  void removeNotasIndividuais(Student aluno) {
        for(Classroom cr: aluno.getClassrooms()){
            for(Assessment as: cr.getAssessments()){
                for(Submission sub: as.getSubmissoes()){
                    if(sub.getAluno().getNome().equals(aluno.getNome())){
                        this.notas.remove(sub.getNota());
                        this.pesos.remove(as.getPeso());
                    }
                }
            }
        }

    }
    // Média ponderada;
    public void setMediaPonderada() {
        double acc = 0;
        double accPeso = 0;
        int i = 0;
        for (double nota : notas) {
            acc += nota *(pesos.get(i));
            accPeso += pesos.get(i);
            i++;

        }
        try{
            this.mediaPonderada = acc / accPeso;

        }catch (ArithmeticException e) {
            System.out.println(e.getMessage() + " Algo de errado não está certo!");
        }


    }

    public double getMediaPonderada() {
        return mediaPonderada;
    }
    //Aproveitamento;
    public void setAproveitamento() {
        double acc = 0;
        double accPeso = 0;
        int i = 0;
        for (double n:notasMaximas) {
            acc += n*(pesos.get(i));
            accPeso += pesos.get(i);
            i++;
        }

        try{
            double apMaximo = acc/accPeso;
            this.aproveitamento = (mediaPonderada/apMaximo)*100;
        }catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }


    }
    public double getAproveitamento() {
        return this.aproveitamento;
    }
}
