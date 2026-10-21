import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Aluno {
    private String nome;
    private String curso;
    private double notaFinal;

    public Aluno(String nome, String curso, double notaFinal) {
        this.nome = nome;
        this.curso = curso;
        this.notaFinal = notaFinal;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    @Override
    public String toString() {
        return nome + " (" + notaFinal + ")";
    }
}

public class Exercicio3 {
    public static void main(String[] args) {
        List<Aluno> alunos = Arrays.asList(
                new Aluno("Pedro", "ADS", 8.5),
                new Aluno("Maria", "ADS", 6.0),
                new Aluno("Joao", "Redes", 7.0),
                new Aluno("Ana", "Redes", 9.2),
                new Aluno("Lucas", "Engenharia", 5.5),
                new Aluno("Julia", "Engenharia", 7.8),
                new Aluno("Carla", "ADS", 7.1)
        );

        Map<String, List<Aluno>> porCurso = alunos.stream()
                .collect(Collectors.groupingBy(Aluno::getCurso));

        System.out.println("=== Alunos por curso ===");
        for (Map.Entry<String, List<Aluno>> entrada : porCurso.entrySet()) {
            System.out.println(entrada.getKey() + ": " + entrada.getValue());
        }

        Map<Boolean, List<Aluno>> aprovacao = alunos.stream()
                .collect(Collectors.partitioningBy(a -> a.getNotaFinal() > 7.0));

        System.out.println("\n=== Aprovados (nota > 7.0) ===");
        System.out.println(aprovacao.get(true));
        System.out.println("=== Reprovados (nota <= 7.0) ===");
        System.out.println(aprovacao.get(false));
    }
}
