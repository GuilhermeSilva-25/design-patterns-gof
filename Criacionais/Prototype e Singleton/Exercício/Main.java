import java.util.ArrayList;
import java.util.List;

// Classe Aluno (Prototype)
class Aluno implements Cloneable {
    String nome;
    int idade;
    String curso;
    String unidade;
    String periodo;

    public Aluno(String nome, int idade, String curso, String unidade, String periodo) {
        this.nome = nome;
        this.idade = idade;
        this.curso = curso;
        this.unidade = unidade;
        this.periodo = periodo;
    }

    // Clone (cópia superficial)
    public Aluno clone() {
        return new Aluno(nome, idade, curso, unidade, periodo);
    }
}


// Singleton - GerenciadorAlunos
class GerenciadorAlunos {
    private static GerenciadorAlunos instance;
    private List<Aluno> listaMatriculados;

    private GerenciadorAlunos() {
        listaMatriculados = new ArrayList<>();
    }

    public static GerenciadorAlunos getInstance() {
        if (instance == null) {
            instance = new GerenciadorAlunos();
        }
        return instance;
    }

    public void adicionarAluno(Aluno aluno) {
        listaMatriculados.add(aluno);
        System.out.println("> Sucesso: " + aluno.nome + " matriculado em " + aluno.curso + ".");
    }

    public void listarMatriculados() {
        System.out.println("\nLISTA DE MATRÍCULAS");
        if (listaMatriculados.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (Aluno aluno : listaMatriculados) {
                System.out.println(
                    aluno.nome + " | " +
                    aluno.idade + " | " +
                    aluno.curso + " | " +
                    aluno.unidade + " | " +
                    aluno.periodo
                );
            }
        }
    }
}


// Client
public class Main {
    public static void main(String[] args) {

        GerenciadorAlunos sigaA = GerenciadorAlunos.getInstance();
        GerenciadorAlunos sigaB = GerenciadorAlunos.getInstance();

        System.out.println("Os gerenciadores são a mesma instância? " + 
            (sigaA == sigaB ? "SIM" : "NÃO"));

        Aluno protoADS = new Aluno(
            "Padrão", 0, "Análise de Sistemas", "Unidade Centro", "Noite"
        );

        Aluno joao = protoADS.clone();
        joao.nome = "João da Silva";
        joao.idade = 20;

        Aluno maria = protoADS.clone();
        maria.nome = "Maria Souza";
        maria.idade = 22;

        sigaA.adicionarAluno(joao);
        sigaA.adicionarAluno(maria);

        sigaB.listarMatriculados();

        System.out.println("\nVerificação de Integridade do Protótipo:");
        System.out.println("Nome no Protótipo: " + protoADS.nome);
        System.out.println("Idade no Protótipo: " + protoADS.idade);
    }
}