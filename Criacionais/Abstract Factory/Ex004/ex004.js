// PRODUTOS CONCRETOS - AUTOMOTIVA
class MontadorCarros {
    montar() {
        return "Montador Automotivo: Soldando chassi e montando portas.";
    }
}

class InspetorPecas {
    inspecionar() {
        return "Inspetor Automotivo: Verificando alinhamento e pintura.";
    }
}

// PRODUTOS CONCRETOS - ELETRÔNICOS
class MontadorCircuitos {
    montar() {
        return "Montador Eletrônico: Inserindo componentes na placa.";
    }
}

class InspetorChips {
    inspecionar() {
        return "Inspetor Eletrônico: Testando continuidade e circuitos.";
    }
}

// FABRICAS CONCRETAS
class FabricaAutomotiva {
    criarMontador() {
        return new MontadorCarros();
    }
    criarInspetor() {
        return new InspetorPecas();
    }
}

class FabricaEletronicos {
    criarMontador() {
        return new MontadorCircuitos();
    }
    criarInspetor() {
        return new InspetorChips();
    }
}

// CLIENTE
class Main {
    static produzir(fabrica) {
        const montador = fabrica.criarMontador();
        const inspetor = fabrica.criarInspetor();

        console.log(montador.montar());
        console.log(inspetor.inspecionar());
    }

    static rodar() {
        console.log("### LINHA AUTOMOTIVA ###");
        Main.produzir(new FabricaAutomotiva());
        console.log()
        console.log("*************************");
        console.log()
        console.log("### LINHA ELETRÔNICOS ###");
        Main.produzir(new FabricaEletronicos());
    }
}

// Execução
Main.rodar();