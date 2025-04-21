import java.util.ArrayList;
import java.util.Iterator;

public class Classroom {
    private int codigo;
    private int periodo;
    private Course course;
    private ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<Assessment> assessments = new ArrayList<Assessment>();
    // Cada turma está ligada a um curso específico (1:1).

    // Cada turma possui múltiplas avaliações (1:N).
    public void addAssessment(Assessment a) {
        assessments.add(a);
    }

    public void removeAssessment(Assessment a) {
        assessments.remove(a);
    }

    public ArrayList<Assessment> getAssessments() {
        return assessments;
    }

    // Cada turma possui vários alunos (N:N).
    public void addStudent(Student student) {
        for (Student s : students) {
            if (s.getNome().equals(student.getNome())) {
                System.out.println("Adicionado: "+student.getNome());
                return;
            }
        }
        students.add(student);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void removeStudent(Student student) {
        if (students.contains(student)) {
            System.out.println("Removido: " + student.getNome());
            student = null;
            students.remove(student);
        }
    }


    public void setCourse(Course course) {
        this.course = course;
    }

    public String getCourse() {
        return course.getNome();
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public int getPeriodo() {
        return this.periodo;
    }

}