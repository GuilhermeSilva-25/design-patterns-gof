// Classe Base
abstract class Pessoa {
    private String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract void mostrarPermissao();
}

// Subclasse Aluno
class Aluno extends Pessoa {
    public Aluno(String nome) {
        super(nome);
    }

    @Override
    public void mostrarPermissao() {
        System.out.printf("Nome: %s%nCargo: Aluno%nPermissão: Nível 0%n%n", getNome());
    }
}

// Subclasse Administrativo
class Administrativo extends Pessoa {
    public Administrativo(String nome) {
        super(nome);
    }

    @Override
    public void mostrarPermissao() {
        System.out.printf("Nome: %s%nCargo: Administrativo%nPermissão: Nível 1%n%n", getNome());
    }
}

// Subclasse Professor
class Professor extends Pessoa {
    public Professor(String nome) {
        super(nome);
    }

    @Override
    public void mostrarPermissao() {
        System.out.printf("Nome: %s%nCargo: Professor%nPermissão: Nível 2%n%n", getNome());
    }
}

// Subclasse Visitante
class Visitante extends Pessoa {
    public Visitante(String nome) {
        super(nome);
    }

    @Override
    public void mostrarPermissao() {
        System.out.printf("Nome: %s%nCargo: Visitante%nPermissão: Nível 3%n%n", getNome());
    }
}

// Fábricas
class FabricaDaFatec {
    public Pessoa criarPessoa(String nome, String cargo) {
        switch (cargo.toLowerCase()) {
            case "aluno":
                return new Aluno(nome);
            case "administrativo":
                return new Administrativo(nome);
            case "professor":
                return new Professor(nome);
            case "visitante":
                return new Visitante(nome);
            default:
                throw new IllegalArgumentException("Cargo desconhecido.");
        }
    }
}

// USO DA FABRICA - CLIENTE:
public class Main {
    public static void main(String[] args) {
        FabricaDaFatec fabrica = new FabricaDaFatec();

        Pessoa p1 = fabrica.criarPessoa("Carlos", "aluno");
        Pessoa p2 = fabrica.criarPessoa("Ana", "aluno");
        Pessoa p3 = fabrica.criarPessoa("Mariana", "administrativo");
        Pessoa p4 = fabrica.criarPessoa("João", "administrativo");
        Pessoa p5 = fabrica.criarPessoa("Roberto", "professor");
        Pessoa p6 = fabrica.criarPessoa("Patrícia", "professor");
        Pessoa p7 = fabrica.criarPessoa("Lucas", "visitante");
        Pessoa p8 = fabrica.criarPessoa("Fernanda", "visitante");

        p1.mostrarPermissao();
        p2.mostrarPermissao();
        p3.mostrarPermissao();
        p4.mostrarPermissao();
        p5.mostrarPermissao();
        p6.mostrarPermissao();
        p7.mostrarPermissao();
        p8.mostrarPermissao();
    }
}