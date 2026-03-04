// PRODUTOS ABSTRATOS
interface VeiculoLeve {
    String exibirDetalhes();
}

interface VeiculoPesado {
    String exibirDetalhes();
}

// PRODUTOS CONCRETOS - TERRESTRE
class Carro implements VeiculoLeve {
    public String exibirDetalhes() {
        return "Carro: Veículo leve de transporte terrestre.";
    }
}

class Onibus implements VeiculoPesado {
    public String exibirDetalhes() {
        return "Ônibus: Veículo pesado de transporte terrestre em massa.";
    }
}

// PRODUTOS CONCRETOS - AÉREO
class Helicoptero implements VeiculoLeve {
    public String exibirDetalhes() {
        return "Helicóptero: Veículo leve de transporte aéreo.";
    }
}

class Aviao implements VeiculoPesado {
    public String exibirDetalhes() {
        return "Avião: Veículo pesado de transporte aéreo em massa.";
    }
}

// FABRICA ABSTRATA
interface FabricaTransporte {
    VeiculoLeve criarVeiculoLeve();
    VeiculoPesado criarVeiculoPesado();
}

// FABRICAS CONCRETAS
class FabricaTerrestre implements FabricaTransporte {
    public VeiculoLeve criarVeiculoLeve() {
        return new Carro();
    }

    public VeiculoPesado criarVeiculoPesado() {
        return new Onibus();
    }
}

class FabricaAerea implements FabricaTransporte {
    public VeiculoLeve criarVeiculoLeve() {
        return new Helicoptero();
    }

    public VeiculoPesado criarVeiculoPesado() {
        return new Aviao();
    }
}

// CLIENTE
public class Main {
    public static void solicitarTransporte(FabricaTransporte fabrica) {
        VeiculoLeve leve = fabrica.criarVeiculoLeve();
        VeiculoPesado pesado = fabrica.criarVeiculoPesado();

        System.out.println(leve.exibirDetalhes());
        System.out.println(pesado.exibirDetalhes());
    }

    public static void main(String[] args) {
        System.out.println("### MODALIDADE TERRESTRE ###");
        solicitarTransporte(new FabricaTerrestre());
        System.out.println();
        System.out.println("*************************");
        System.out.println();
        System.out.println("### MODALIDADE AÉREA ###");
        solicitarTransporte(new FabricaAerea());
    }
}