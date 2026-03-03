// Classe Base
class Pessoa {
    constructor(nome) {
        this.nome = nome;
    }

    getNome() {
        return this.nome;
    }

    mostrarPermissao() {
        throw new Error("Método deve ser sobrescrito.");
    }
}

// Subclasse Aluno
class Aluno extends Pessoa {
    constructor(nome) {
        super(nome);
    }

    mostrarPermissao() {
        console.log(`Nome: ${this.getNome()}\nCargo: Aluno\nPermissão: Nível 0\n`);
    }
}

// Subclasse Administrativo
class Administrativo extends Pessoa {
    constructor(nome) {
        super(nome);
    }

    mostrarPermissao() {
        console.log(`Nome: ${this.getNome()}\nCargo: Administrativo\nPermissão: Nível 1\n`);
    }
}

// Subclasse Professor
class Professor extends Pessoa {
    constructor(nome) {
        super(nome);
    }

    mostrarPermissao() {
        console.log(`Nome: ${this.getNome()}\nCargo: Professor\nPermissão: Nível 2\n`);
    }
}

// Subclasse Visitante
class Visitante extends Pessoa {
    constructor(nome) {
        super(nome);
    }

    mostrarPermissao() {
        console.log(`Nome: ${this.getNome()}\nCargo: Visitante\nPermissão: Nível 3\n`);
    }
}

// Fábricas
class FabricaDaFatec {
    criarPessoa(nome, cargo) {
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
                throw new Error("Cargo desconhecido.");
        }
    }
}

// USO DA FABRICA - CLIENTE:
class Main {
    static main() {
        const fabrica = new FabricaDaFatec();

        const p1 = fabrica.criarPessoa("Carlos", "aluno");
        const p2 = fabrica.criarPessoa("Ana", "aluno");
        const p3 = fabrica.criarPessoa("Mariana", "administrativo");
        const p4 = fabrica.criarPessoa("João", "administrativo");
        const p5 = fabrica.criarPessoa("Roberto", "professor");
        const p6 = fabrica.criarPessoa("Patrícia", "professor");
        const p7 = fabrica.criarPessoa("Lucas", "visitante");
        const p8 = fabrica.criarPessoa("Fernanda", "visitante");

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

Main.main();