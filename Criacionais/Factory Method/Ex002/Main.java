import java.util.ArrayList;
import java.util.List;

// Classe Base
class Nome {
    private String nome;
    private String sobrenome;

    public Nome(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public void imprimir() {
        System.out.println(nome + " " + sobrenome);
    }
}

// FÁBRICA
abstract class FabricaDeNomes {
    private List<Nome> bancoDeNomes = new ArrayList<>();

    public abstract Nome criarNome(String entrada);

    public void adicionarNome(String entrada) {
        Nome novoNome = criarNome(entrada);
        bancoDeNomes.add(novoNome);
    }

    public void imprimirNomes() {
        for (Nome n : bancoDeNomes) {
            n.imprimir();
        }
    }
}

// Subclasse para formato: "nome sobrenome"
class FabricaFormatoSimples extends FabricaDeNomes {
    @Override
    public Nome criarNome(String entrada) {
        String[] partes = entrada.split(" ");
        return new Nome(partes[0], partes[1]);
    }
}

// Subclasse para formato: "sobrenome, nome"
class FabricaFormatoInvertido extends FabricaDeNomes {
    @Override
    public Nome criarNome(String entrada) {
        String[] partes = entrada.split(", ");
        return new Nome(partes[1], partes[0]);
    }
}

// USO DA FABRICA - CLIENTE:
public class Main {
    public static void main(String[] args) {
        
        FabricaDeNomes fabricaSimples = new FabricaFormatoSimples();
        FabricaDeNomes fabricaInvertida = new FabricaFormatoInvertido();

        fabricaInvertida.adicionarNome("McNealy, Scott");
        fabricaSimples.adicionarNome("James Gosling");
        fabricaInvertida.adicionarNome("Naughton, Patrick");

        fabricaSimples.imprimirNomes();
        fabricaInvertida.imprimirNomes();
    }
}