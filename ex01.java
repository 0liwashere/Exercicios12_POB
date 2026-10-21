import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercicio1 {
    public static void main(String[] args) {
        List<String> nomes = Arrays.asList("ana", "carlos", "beatriz", "antonio", "amanda", "bernardo");

        List<String> resultado = nomes.stream()
                .filter(n -> n.toLowerCase().startsWith("a")) 
                .map(n -> n.toUpperCase())                    
                .sorted()                                     
                .collect(Collectors.toList());                

        System.out.println("Nomes originais: " + nomes);
        System.out.println("Resultado: " + resultado);
    }
}
