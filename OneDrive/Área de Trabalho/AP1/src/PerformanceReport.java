import java.lang.reflect.Array;
import java.util.ArrayList;

public class PerformanceReport {
    private double mediaPonderada;
    private ArrayList<Double> notas = new ArrayList<>();
    private double aproveitamento;
    private Student aluno;
    private ArrayList<Assessment> assessments = new ArrayList<>();

    //Notas individuais;
    public ArrayList<Double> getNotasIndividuais(){
        return notas;
    }

    public void setNotasIndividuais(double nota) {
        notas.add(nota);

    }
    public void removeNotasIndividuais(double nota){
        notas.remove(nota);
    }

    // Média ponderada;
}
