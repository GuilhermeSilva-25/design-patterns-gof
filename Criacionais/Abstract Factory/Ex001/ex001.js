// PRODUTOS CONCRETOS - TERRESTRE
class Carro {
    exibirDetalhes() {
        return "Carro: Veículo leve de transporte terrestre.";
    }
}

class Onibus {
    exibirDetalhes() {
        return "Ônibus: Veículo pesado de transporte terrestre em massa.";
    }
}

// PRODUTOS CONCRETOS - AÉREO
class Helicoptero {
    exibirDetalhes() {
        return "Helicóptero: Veículo leve de transporte aéreo.";
    }
}

class Aviao {
    exibirDetalhes() {
        return "Avião: Veículo pesado de transporte aéreo em massa.";
    }
}

// FABRICAS CONCRETAS
class FabricaTerrestre {
    criarVeiculoLeve() {
        return new Carro();
    }
    criarVeiculoPesado() {
        return new Onibus();
    }
}

class FabricaAerea {
    criarVeiculoLeve() {
        return new Helicoptero();
    }
    criarVeiculoPesado() {
        return new Aviao();
    }
}

// CLIENTE
class Main {
    static solicitarTransporte(fabrica) {
        const leve = fabrica.criarVeiculoLeve();
        const pesado = fabrica.criarVeiculoPesado();

        console.log(leve.exibirDetalhes());
        console.log(pesado.exibirDetalhes());
    }

    static rodar() {
        console.log("### MODALIDADE TERRESTRE ###");
        Main.solicitarTransporte(new FabricaTerrestre());
        console.log();
        console.log("*************************");
        console.log();
        console.log("### MODALIDADE AÉREA ###");
        Main.solicitarTransporte(new FabricaAerea());
    }
}

// Execução
Main.rodar();