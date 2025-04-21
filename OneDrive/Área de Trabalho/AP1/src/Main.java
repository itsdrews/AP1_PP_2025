import java.util.Random;
public class Main {

    public static void main(String[] args) {

        //Implementando com pelo menos 2 professores com cursos distintos.
        Teacher prof1 = new Teacher ("Giorgian Daniel de Arrascaeta Benedetti"
                ,"Ciência de Dados",1);



        Teacher prof2 = new Teacher ("Filipe Luís Kamirski",
                "Arquitetura de Software",2);
        // 2 Cursos com pelo menos 1 turma
        Course curso1 = new Course();
        curso1.setNome("Projetos de Programa");
        curso1.setEmenta("Java & POO");
        curso1.setCargaHoraria(90);
        curso1.setTeacher(prof2);
        Classroom turma1 = new Classroom();
        turma1.setCodigo(1);
        // 1:N Course: Classrooms
        turma1.setCourse(curso1);
        curso1.addClassroom(turma1);
        //5 alunos (Students)
        Student aluno1 = new Student("Jorge Vercilo",123,"jorgevercilo@gmail.com");
        turma1.addStudent(aluno1);
        Student aluno2 = new Student("Joana D'Arc",122,"joana@gmail.com");
        turma1.addStudent(aluno2);
        Student aluno3 = new Student("Xi Ji Ping",2,"xi@gmail.com");
        turma1.addStudent(aluno3);
        Student aluno4 = new Student("Beatriz Araújo de Oliveira",1,"beatriz@gmail.com");
        turma1.addStudent(aluno4);
        Student aluno5 = new Student("Erick Roberto Pinheiro",3,"erick@gmail.com");
        turma1.addStudent(aluno5);

        /*
        System.out.println("Professor 2: " + prof1.getNome());
        System.out.println("Curso:" + curso1.getNome());
        System.out.println("Códigs de Turmas: ");

         */

        /*
        for (Classroom c: curso1.getTurmas() ){
            System.out.println("Código: "+c.getCodigo());
            System.out.println("Lista de alunos: ");
            for(Student s: c.getStudents()){
                System.out.println("Nome: "+s.getNome());
            }
        }
        */

        //3 Avaliações por turma



        Assessment ap1 = new Assessment("Prova",10,2,turma1);
        turma1.addAssessment(ap1);
        Assessment ap2 = new Assessment("Projeto Prático",10,3,turma1);
        turma1.addAssessment(ap2);
        Assessment ap3 = new Assessment("Apresentação",10,1,turma1);
        turma1.addAssessment(ap3);

        Random random = new Random();

        for (Student s :turma1.getStudents()){
            for (Assessment as: turma1.getAssessments()){
                Submission sub = new Submission(s,as);
                sub.setNota(random.nextDouble()*10);
                sub.setData("23/4/2025");
                sub.setObs("");
                sub.setAluno(s);
                as.addSubmissao(sub);



            }
        }


        for (Assessment as: turma1.getAssessments()){
            System.out.println("Avaliação: "+ as.getTipo()+ " Peso: "+ as.getPeso());
            for (Submission sub : as.getSubmissoes()){
                System.out.println("Aluno: "+ sub.getAluno().getNome());
                System.out.println("Nota: "+sub.getNota());
            }

        }













        Course curso2 = new Course();





    }
}
