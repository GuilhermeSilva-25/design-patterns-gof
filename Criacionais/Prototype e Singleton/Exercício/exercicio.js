// Classe Aluno que será clonada
class Aluno {
    constructor(nome, idade, curso, unidade, periodo) {
        this.nome = nome;
        this.idade = idade;
        this.curso = curso;
        this.unidade = unidade;
        this.periodo = periodo;
    }

    // Método para clonar o objeto atual (Cópia Superficial)
    clone() {
        return new Aluno(
            this.nome, 
            this.idade, 
            this.curso, 
            this.unidade, 
            this.periodo
        );
    }
}

// SIGA
class GerenciadorAlunos {
    constructor() {
        if (GerenciadorAlunos.instance) {
            return GerenciadorAlunos.instance;
        }

        this.listaMatriculados = [];
        GerenciadorAlunos.instance = this;
    }

    adicionarAluno(aluno) {
        this.listaMatriculados.push(aluno);
        console.log(`> Sucesso: ${aluno.nome} matriculado em ${aluno.curso}.`);
    }

    listarMatriculados() {
        console.log("\nLISTA DE MATRÍCULAS");
        if (this.listaMatriculados.length === 0) {
            console.log("Nenhum aluno cadastrado.");
        } else {
            console.table(this.listaMatriculados);
        }
    }
}

// Client

const sigaA = new GerenciadorAlunos();
const sigaB = new GerenciadorAlunos();

console.log(`Os gerenciadores são a mesma instância? ${sigaA === sigaB ? "SIM" : "NÃO"}`);

const protoADS = new Aluno("Padrão", 0, "Análise de Sistemas", "Unidade Centro", "Noite");

const joao = protoADS.clone();
joao.nome = "João da Silva";
joao.idade = 20;

const maria = protoADS.clone();
maria.nome = "Maria Souza";
maria.idade = 22;

sigaA.adicionarAluno(joao);
sigaA.adicionarAluno(maria);

sigaB.listarMatriculados();

console.log("\nVerificação de Integridade do Protótipo:");
console.log(`Nome no Protótipo: ${protoADS.nome}`);
console.log(`Idade no Protótipo: ${protoADS.idade}`);
