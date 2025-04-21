import java.util.ArrayList;

public class Teacher {
    private String nome;
    private String especialidade;
    private int id;

    final private ArrayList<Course> courses = new ArrayList<Course>();
    // Um professor pode ministrar vários cursos (1:N).
    public Teacher(String nome, String especialidade, int id) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.id = id;
    }
    public void addCourse(Course course) {

        for (Course c : courses) {
            if (c.getNome().equals(course.getNome())) {
                return; // sai do loop se já existir um curso com nome igual.
            }
        }
            courses.add(course);
            System.out.println("Curso: " + course.getNome()+ " adicionado!");
    }
    public void removeCourse(Course course) {
        if (courses.contains(course)) {
            courses.remove(course);
            System.out.println("Curso: " + course.getNome()+ " removido com sucesso!");
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return this.especialidade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInt() {
        return this.id;
    }

}