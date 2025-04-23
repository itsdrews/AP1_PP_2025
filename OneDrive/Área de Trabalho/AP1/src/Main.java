import java.util.Random;
public class Main {
    public static void main(String[] args) {

        //Implementando com pelo menos 2 professores com cursos distintos.
        Teacher prof1 = new Teacher("Giorgian Daniel de Arrascaeta Benedetti"
                , "Ciência de Dados", 1);


        Teacher prof2 = new Teacher("Filipe Luís Kamirski",
                "Arquitetura de Software", 2);

        // 2 Cursos com pelo menos 1 turma
        Course curso1 = new Course();
        curso1.setNome("Projetos de Programa");
        curso1.setEmenta("Java & POO");
        curso1.setCargaHoraria(90);
        curso1.setTeacher(prof1);
        Classroom turma1 = new Classroom();
        turma1.setCodigo(1);

        Course curso2 = new Course();
        curso2.setNome("Estruturas de Dados");
        curso2.setEmenta("Python & R");
        curso2.setCargaHoraria(90);
        curso2.setTeacher(prof2);
        Classroom turma2 = new Classroom();
        turma2.setCodigo(2);

        // 1:N Course: Classrooms

        turma1.setCourse(curso1);
        curso1.addClassroom(turma1);
        turma2.setCourse(curso2);
        curso2.addClassroom(turma2);


        //6 alunos(Students)
        Student aluno1 = new Student("Jorge Vercilo",
                123, "jorgevercilo@gmail.com");
        turma2.addStudent(aluno1);
        turma1.addStudent(aluno1);
        aluno1.addClassroom(turma1);
        aluno1.addClassroom(turma2);
        Student aluno2 = new Student("Joana D'Arc",
                122, "joana@gmail.com");
        turma2.addStudent(aluno2);
        aluno2.addClassroom(turma2);
        Student aluno3 = new Student("Xi Ji Ping",
                2, "xi@gmail.com");
        turma1.addStudent(aluno3);
        aluno3.addClassroom(turma1);
        Student aluno4 = new Student("Beatriz Araújo de Oliveira",
                1, "beatriz@gmail.com");
        turma1.addStudent(aluno4);
        aluno4.addClassroom(turma1);
        Student aluno5 = new Student("Erick Roberto Pinheiro",
                3, "erick@gmail.com");
        turma1.addStudent(aluno5);
        aluno5.addClassroom(turma1);
        Student aluno6 = new Student("Michelle Daniel",
                4, "michelle@gmail.com");
        turma1.addStudent(aluno6);
        aluno6.addClassroom(turma1);

        //Printando as turmas associadas e a lista de alunos por curso → turma → alunos
        mostrarAlunosPorTurma(curso1);
        mostrarAlunosPorTurma(curso2);

        //3 Avaliações por turma

        Assessment ap1 = new Assessment("Prova", 10, 2, turma1);
        turma1.addAssessment(ap1);
        turma2.addAssessment(ap1);
        Assessment ap2 = new Assessment("Projeto Prático", 10, 3, turma1);
        turma1.addAssessment(ap2);
        turma2.addAssessment(ap2);
        Assessment ap3 = new Assessment("Apresentação", 10, 1, turma1);
        turma1.addAssessment(ap3);
        turma2.addAssessment(ap3);

        //Setando as notas e médias ponderadas por turma → avaliacao → submissao e utilizando PerformanceReport

        //mostrarMediasPorAluno(turma1);
        //mostrarMediasPorAluno(turma2);

        //Mostrando médias por aluno → turmas → avaliacao → submissao
        mostrarMediasPorAlunoTurma(aluno1);

        //Printando todas as notas de avaliações por turma → avaliacao → submissao
        //mostrarNotas(turma1);
        //mostrarNotas(turma2);

        //Removendo aluno e derrubando submissões
        mostrarSubmissoes(turma1);
        aluno1.killAluno();
        mostrarSubmissoes(turma1);

    }

    public static void mostrarSubmissoes(Classroom turma) {
        System.out.println("-".repeat(20));
        int i = 0;
        for (Assessment as : turma.getAssessments()) {
            for (Submission sub : as.getSubmissoes()) {
                i++;
            }
        }
        System.out.println("Submissoes: " + i);

    }

    public static void mostrarNotas(Classroom turma) {
        System.out.println("-".repeat(20));
        for (Assessment as : turma.getAssessments()) {
            System.out.println("-".repeat(20));
            System.out.println("Avaliação: " + as.getTipo() + " Peso: " + as.getPeso());
            for (Submission sub : as.getSubmissoes()) {
                System.out.println("Aluno: " + sub.getAluno().getNome());
                System.out.println("Nota: " + String.format("%.2f", sub.getNota()));


            }


        }
    }

    public static void mostrarMediasPorAluno(Classroom turma) {
        Random random = new Random();
        for (Student s : turma.getStudents()) {

            for (Assessment as : turma.getAssessments()) {
                Submission sub = new Submission(s, as);
                sub.setNota(random.nextDouble() * 10);
                sub.setData("23/4/2025");
                sub.setObs("Observação");
                sub.setAluno(s);
                as.addSubmissao(sub);


            }
            PerformanceReport pR = new PerformanceReport();
            pR.setNotasIndividuais(turma, s);
            pR.setMediaPonderada();
            System.out.println("Média ponderada de " + s.getNome()
                    + " na disciplina  " + pR.getNomeCurso() + " : "
                    + String.format("%.2f", pR.getMediaPonderada()));
            pR.setAproveitamento();
            System.out.println("Aproveitamento: "
                    + String.format("%.2f", pR.getAproveitamento()) + "%");
            System.out.println("-".repeat(20));
        }


    }

    public static void mostrarAlunosPorTurma(Course curso) {
        System.out.println("-".repeat(20));
        System.out.println("Professor: " + curso.getTeacher());
        System.out.println("Curso:" + curso.getNome());
        System.out.println("Códigs de Turmas: ");
        for (Classroom c : curso.getTurmas()) {
            System.out.println("Código: " + c.getCodigo());
            System.out.println("Lista de alunos: ");
            for (Student s : c.getStudents()) {
                System.out.println("Nome: " + s.getNome());
            }
        }
    }

    public static void mostrarMediasPorAlunoTurma(Student aluno) {
        Random random = new Random();
        for (Classroom c: aluno.getClassrooms()) {
            System.out.println(aluno.getClassrooms().size());
            for (Assessment as : c.getAssessments()) {
                Submission sub = new Submission(aluno, as);
                sub.setNota(random.nextDouble() * 10);
                sub.setData("23/4/2025");
                sub.setObs("Observação");
                sub.setAluno(aluno);
                as.addSubmissao(sub);


            }
            PerformanceReport pR = new PerformanceReport();
            pR.setNotasIndividuais(c, aluno);
            pR.setMediaPonderada();
            System.out.println("Média ponderada de " + aluno.getNome()
                    + " na disciplina  " + pR.getNomeCurso() + " : "
                    + String.format("%.2f", pR.getMediaPonderada()));
            pR.setAproveitamento();
            System.out.println("Aproveitamento: "
                    + String.format("%.2f", pR.getAproveitamento()) + "%");
            System.out.println("-".repeat(20));
        }


    }
}



