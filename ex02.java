import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return nome + " (R$ " + preco + ")";
    }
}

public class Exercicio2 {
    public static void main(String[] args) {
        List<Produto> produtos = Arrays.asList(
                new Produto("Notebook", 3500.00),
                new Produto("Mouse", 80.00),
                new Produto("Teclado", 150.00),
                new Produto("Monitor", 900.00),
                new Produto("Headset", 220.00),
                new Produto("Webcam", 180.00)
        );

        double total = produtos.stream()
                .mapToDouble(Produto::getPreco)
                .sum();
        System.out.println("Valor total: R$ " + total);

        OptionalDouble media = produtos.stream()
                .mapToDouble(Produto::getPreco)
                .average();
        System.out.println("Preco medio: R$ " + media.orElse(0.0));

        Optional<Produto> maisCaro = produtos.stream()
                .max(Comparator.comparingDouble(Produto::getPreco));
        if (maisCaro.isPresent()) {
            System.out.println("Produto mais caro: " + maisCaro.get());
        }

        double totalReduce = produtos.stream()
                .map(Produto::getPreco)
                .reduce(0.0, Double::sum);
        System.out.println("Valor total (com reduce): R$ " + totalReduce);
    }
}
