import java.util.ArrayList;
public class Course {
    private String nome;
    private int cargaHoraria;
    private String ementa;
    private Teacher teacher;
    private ArrayList<Classroom> turmas = new ArrayList<Classroom>();
    // Cada curso pode ter N turmas associadas (1:N)
    // Cada curso deve ter exatamente um professor (1:1).
    public void addClassroom(Classroom classroom) {
        for (Classroom c : turmas) {
            if (c.getCodigo()==(classroom.getCodigo())){
                return;
            }

        }
        turmas.add(classroom);
        System.out.println("Turma: " +classroom.getCodigo() +" adicionado com sucesso!");
    }

    public ArrayList<Classroom> getTurmas() {
        return turmas;
    }
    public void removeClassroom(Classroom classroom) {
        for (Classroom c : turmas) {
            if (c.getCodigo()==(classroom.getCodigo())){
                System.out.println("Turma: " +classroom.getCodigo() +" removido!");
                turmas.remove(classroom);
                return;
            }
        }
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getTeacher() {
        return teacher.getNome();
    }

    public void setNome(String nome ){
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getCargaHoraria() {
        return this.cargaHoraria;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public String getEmenta() {
        return this.ementa;
    }

}