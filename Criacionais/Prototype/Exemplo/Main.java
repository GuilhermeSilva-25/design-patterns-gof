import java.util.HashMap;
import java.util.Map;

// Classe Pessoa que será clonada:
class Pessoa {
    int id;
    String nome;
    int idade;

    public Pessoa(int id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    // Método clone (cópia superficial):
    public Pessoa clone() {
        return new Pessoa(this.id, this.nome, this.idade);
    }

    @Override
    public String toString() {
        return "Pessoa{id=" + id + ", nome='" + nome + "', idade=" + idade + "}";
    }
}

// Classe GerenciaPessoa:
class GerenciaPessoa {
    private Map<Integer, Pessoa> pessoas = new HashMap<>();

    public void addPessoa(int id, String nome, int idade) {
        Pessoa pessoa = new Pessoa(id, nome, idade);
        pessoas.put(id, pessoa);
    }

    public Pessoa getPessoaById(int id) {
        Pessoa pessoaOriginal = pessoas.get(id);
        if (pessoaOriginal != null) {
            return pessoaOriginal.clone();
        }
        return null;
    }

    public Pessoa getOriginal(int id) {
        return pessoas.get(id);
    }
}

// Classe principal:
public class Main {
    public static void main(String[] args) {
        GerenciaPessoa gerencia = new GerenciaPessoa();

        gerencia.addPessoa(1, "João da Silva", 30);
        gerencia.addPessoa(2, "Maria da Silva", 25);
        gerencia.addPessoa(3, "Pedro da Silva", 45);

        Pessoa pessoaClone = gerencia.getPessoaById(1);

        if (pessoaClone != null) {
            pessoaClone.nome = "João Clonado";
            pessoaClone.idade = 99;
        }

        System.out.println("Pessoa original: " + gerencia.getOriginal(1));
        System.out.println("Pessoa clonada: " + pessoaClone);
    }
}