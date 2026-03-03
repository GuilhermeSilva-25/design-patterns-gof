// Classe Base
class Nome {
    constructor(nome, sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    imprimir() {
        console.log(this.nome + " " + this.sobrenome);
    }
}

// FÁBRICA
class FabricaDeNomes {
    constructor() {
        this.bancoDeNomes = [];
    }

    criarNome(entrada) {}

    adicionarNome(entrada) {
        const novoNome = this.criarNome(entrada);
        this.bancoDeNomes.push(novoNome);
    }

    imprimirNomes() {
        for (const n of this.bancoDeNomes) {
            n.imprimir();
        }
    }
}

// Subclasse para formato: "nome sobrenome"
class FabricaFormatoSimples extends FabricaDeNomes {
    criarNome(entrada) {
        const partes = entrada.split(" ");
        return new Nome(partes[0], partes[1]);
    }
}

// Subclasse para formato: "sobrenome, nome"
class FabricaFormatoInvertido extends FabricaDeNomes {
    criarNome(entrada) {
        const partes = entrada.split(", ");
        return new Nome(partes[1], partes[0]);
    }
}

// USO DA FABRICA - CLIENTE:
class Main {
    static main() {
        const fabricaSimples = new FabricaFormatoSimples();
        const fabricaInvertida = new FabricaFormatoInvertido();

        fabricaInvertida.adicionarNome("McNealy, Scott");
        fabricaSimples.adicionarNome("James Gosling");
        fabricaInvertida.adicionarNome("Naughton, Patrick");

        fabricaSimples.imprimirNomes();
        fabricaInvertida.imprimirNomes();
    }
}

Main.main();