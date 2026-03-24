// Classe Pessoa que será clonada:
class Pessoa {
    constructor(id, nome, idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    // Metodo clone para realizar uma copia superficial do objeto:
    clone() {
        return new Pessoa(this.id, this.nome, this.idade);
    }
}

// Classe GerenciaPessoa para gerenciar instancias de Pessoa:
class GerenciaPessoa {
    constructor() {
        this.pessoas = {};
    }

    // Add uma nova pessoa ao dicionario de pessoas:
    addPessoa(id, nome, idade) {
        const pessoa = new Pessoa(id, nome, idade);
        this.pessoas[id] = pessoa;
    }

    // Solicita uma pessoa pelo id e retorna uma copia dela:
    getPessoaById(id) {
        const pessoaOriginal = this.pessoas[id];

        if (pessoaOriginal) {
            return pessoaOriginal.clone();
        } else {
            return null;
        }
    }
}

// Criando uma instancia de GerenciaPessoa:
const gerencia = new GerenciaPessoa();

// Adicionando Pessoas:
gerencia.addPessoa(1, "João da Silva", 30);
gerencia.addPessoa(2, "Maria da Silva", 25);
gerencia.addPessoa(3, "Pedro da Silva", 45);

// Clonando a primeira pessoa e modificando o nome da copia
const pessoaClone = gerencia.getPessoaById(1);

if (pessoaClone) {
    pessoaClone.nome = "João Clonado";
    pessoaClone.idade = 99;
}

// Exibindo resultados
console.log("Pessoa original:", gerencia.pessoas[1]);
console.log("Pessoa clonada:", pessoaClone);