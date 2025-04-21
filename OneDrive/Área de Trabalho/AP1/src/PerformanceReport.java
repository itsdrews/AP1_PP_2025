
import java.util.ArrayList;

public class PerformanceReport {
    private double mediaPonderada;
    private ArrayList<Double> notas = new ArrayList<>();
    private double aproveitamento;
    private ArrayList<Integer> pesos = new ArrayList<>();


    //Notas individuais;
    public ArrayList<Double> getNotasIndividuais(){
        return notas;
    }

    public void setNotasIndividuais(ArrayList<Assessment> assessments) {
        for(Assessment a : assessments){
            for(Submission sub: a.getSubmissoes()){
                this.notas.add(sub.getNota());
                this.pesos.add(a.getPeso());
            };
        }


    }

    public void removeNotasIndividuais(double nota,ArrayList<Assessment> assessments) {
        for(Assessment a : assessments){
            for(Submission sub: a.getSubmissoes()){
                this.notas.remove(sub.getNota());
                this.pesos.remove(a.getPeso());
            };
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
    public void setAproveitamento(ArrayList<Assessment> assessments) {
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
