
import java.util.ArrayList;

public class PerformanceReport {
    private double mediaPonderada;
    private ArrayList<Double> notas = new ArrayList<>();
    private double aproveitamento;
    private ArrayList<Assessment> assessments = new ArrayList<>();

    //Notas individuais;
    public ArrayList<Double> getNotasIndividuais(){
        return notas;
    }

    public void setNotasIndividuais(double nota,Assessment assessment) {
        notas.add(nota);
        assessments.add(assessment);

    }

    public void addAssessment(Assessment assessment) {
        assessments.add(assessment);
    }

    public void removeAssessment(Assessment assessment) {
        assessments.remove(assessment);
    }

    public void removeNotasIndividuais(double nota){
        notas.remove(nota);
    }
    // Média ponderada;
    public void setMediaPonderada() {
        double acc = 0;
        double accPeso = 0;
        int i = 0;
        for (double nota : notas) {
            acc += nota *(assessments.get(i).getPeso());
            accPeso += assessments.get(i).getPeso();


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
        for (Assessment assessment : assessments) {
            acc += assessment.getPeso()*assessment.getNotaMaxima();
            accPeso += assessment.getPeso();

        }
        try{
            double aproveitamentoMaximo = acc/accPeso;
            this.aproveitamento = this.mediaPonderada/aproveitamentoMaximo;
        }catch (ArithmeticException e) {
            System.out.println(e.getMessage() + " Opa!");
        }

    }
    public double getAproveitamento() {
        return this.aproveitamento;
    }
}
