package Exercício;

// Define os Tipos de Pessoas
class Pessoa {
    protected String nome;
    protected String horaEntrada;
    protected String horaSaida;

    public Pessoa(String nome, String horaEntrada, String horaSaida) {
        this.nome = nome;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
    }

    public String getNome() {
        return nome;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void mostrarPermissao() {
        throw new RuntimeException("Método deve ser sobrescrito.");
    }
}

// Subclasse Aluno
class Aluno extends Pessoa {
    public Aluno(String nome, String horaEntrada, String horaSaida) {
        super(nome, horaEntrada, horaSaida);
    }

    public void mostrarPermissao() {
        System.out.println("Nome: " + getNome() +
                "\nCargo: Aluno" +
                "\nHora de Entrada: " + getHoraEntrada() +
                "\nHora de Saída: " + getHoraSaida() +
                "\nPermissão: Nível 0\n");
    }
}

// Subclasse Administrativo
class Administrativo extends Pessoa {
    public Administrativo(String nome, String horaEntrada, String horaSaida) {
        super(nome, horaEntrada, horaSaida);
    }

    public void mostrarPermissao() {
        System.out.println("Nome: " + getNome() +
                "\nCargo: Administrativo" +
                "\nHora de Entrada: " + getHoraEntrada() +
                "\nHora de Saída: " + getHoraSaida() +
                "\nPermissão: Nível 1\n");
    }
}

// Subclasse Professor
class Professor extends Pessoa {
    public Professor(String nome, String horaEntrada, String horaSaida) {
        super(nome, horaEntrada, horaSaida);
    }

    public void mostrarPermissao() {
        System.out.println("Nome: " + getNome() +
                "\nCargo: Professor" +
                "\nHora de Entrada: " + getHoraEntrada() +
                "\nHora de Saída: " + getHoraSaida() +
                "\nPermissão: Nível 2\n");
    }
}

// Subclasse Visitante
class Visitante extends Pessoa {
    public Visitante(String nome, String horaEntrada, String horaSaida) {
        super(nome, horaEntrada, horaSaida);
    }

    public void mostrarPermissao() {
        System.out.println("Nome: " + getNome() +
                "\nCargo: Visitante" +
                "\nHora de Entrada: " + getHoraEntrada() +
                "\nHora de Saída: " + getHoraSaida() +
                "\nPermissão: Nível 3\n");
    }
}

// Builder
class PessoaBuilder {
    private String nome;
    private String cargo;
    private String horaEntrada;
    private String horaSaida;

    public PessoaBuilder addNome(String nome) {
        this.nome = nome;
        return this;
    }

    public PessoaBuilder addCargo(String cargo) {
        this.cargo = cargo.toLowerCase();
        return this;
    }

    public PessoaBuilder addHoraEntrada(String hora) {
        this.horaEntrada = hora;
        return this;
    }

    public PessoaBuilder addHoraSaida(String hora) {
        this.horaSaida = hora;
        return this;
    }

    public Pessoa construir() {
        switch (cargo) {
            case "aluno":
                return new Aluno(nome, horaEntrada, horaSaida);

            case "administrativo":
                return new Administrativo(nome, horaEntrada, horaSaida);

            case "professor":
                return new Professor(nome, horaEntrada, horaSaida);

            case "visitante":
                return new Visitante(nome, horaEntrada, horaSaida);

            default:
                throw new RuntimeException("Cargo desconhecido.");
        }
    }
}

// Cliente - Usando o Builder para construir as pessoas
public class Main {
    public static void main(String[] args) {

        PessoaBuilder builder = new PessoaBuilder();

        Pessoa p1 = builder
                .addNome("Carlos")
                .addCargo("aluno")
                .addHoraEntrada("08:00")
                .addHoraSaida("12:00")
                .construir();

        Pessoa p2 = builder
                .addNome("Mariana")
                .addCargo("administrativo")
                .addHoraEntrada("09:00")
                .addHoraSaida("17:00")
                .construir();

        Pessoa p3 = builder
                .addNome("Roberto")
                .addCargo("professor")
                .addHoraEntrada("07:30")
                .addHoraSaida("13:00")
                .construir();

        Pessoa p4 = builder
                .addNome("Lucas")
                .addCargo("visitante")
                .addHoraEntrada("10:00")
                .addHoraSaida("11:00")
                .construir();

        p1.mostrarPermissao();
        p2.mostrarPermissao();
        p3.mostrarPermissao();
        p4.mostrarPermissao();
    }
}