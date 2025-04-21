import java.util.ArrayList;

public class Student {
    private String nome;
    private int matricula;
    private String email;
    private ArrayList<Classroom> classrooms = new ArrayList<Classroom>();

    public Student(String nome, int matricula, String email) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
    }
    // Um aluno pode se matricular em múltiplas turmas (N:N).
    public void addClassroom(Classroom classroom) {
        for (Classroom c : classrooms) {
            if (c.getCodigo() == classroom.getCodigo()) {
                return;
            }
        }
        classrooms.add(classroom);
        System.out.println("Turma adicionada com sucesso!");


    }

    public ArrayList<Classroom> getClassrooms() {
        return classrooms;
    }

    public void removeClassroom(Classroom classroom) {
        if (classrooms.contains(classroom)) {
            classrooms.remove(classroom);
            System.out.println("Turma removida com sucesso!");
        }
    }

    // Cada aluno possui um histórico de desempenho por turma. (falta implementar)

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getMatricula() {
        return this.matricula;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

}