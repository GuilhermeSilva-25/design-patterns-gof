// PRODUTOS ABSTRATOS
interface RoboMontador {
    String montar();
}

interface RoboInspetor {
    String inspecionar();
}

// PRODUTOS CONCRETOS - AUTOMOTIVA
class MontadorCarros implements RoboMontador {
    public String montar() {
        return "Montador Automotivo: Soldando chassi e montando portas.";
    }
}

class InspetorPecas implements RoboInspetor {
    public String inspecionar() {
        return "Inspetor Automotivo: Verificando alinhamento e pintura.";
    }
}

// PRODUTOS CONCRETOS - ELETRÔNICOS
class MontadorCircuitos implements RoboMontador {
    public String montar() {
        return "Montador Eletrônico: Inserindo componentes na placa.";
    }
}

class InspetorChips implements RoboInspetor {
    public String inspecionar() {
        return "Inspetor Eletrônico: Testando continuidade e circuitos.";
    }
}

// FABRICA ABSTRATA
interface FabricaRobos {
    RoboMontador criarMontador();
    RoboInspetor criarInspetor();
}

// FABRICAS CONCRETAS
class FabricaAutomotiva implements FabricaRobos {
    public RoboMontador criarMontador() {
        return new MontadorCarros();
    }

    public RoboInspetor criarInspetor() {
        return new InspetorPecas();
    }
}

class FabricaEletronicos implements FabricaRobos {
    public RoboMontador criarMontador() {
        return new MontadorCircuitos();
    }

    public RoboInspetor criarInspetor() {
        return new InspetorChips();
    }
}

// CLIENTE
public class Main {
    public static void produzir(FabricaRobos fabrica) {
        RoboMontador montador = fabrica.criarMontador();
        RoboInspetor inspetor = fabrica.criarInspetor();

        System.out.println(montador.montar());
        System.out.println(inspetor.inspecionar());
    }

    public static void main(String[] args) {
        System.out.println("### LINHA AUTOMOTIVA ###");
        produzir(new FabricaAutomotiva());
        System.out.println();
        System.out.println("*************************");
        System.out.println();
        System.out.println("### LINHA ELETRÔNICOS ###");
        produzir(new FabricaEletronicos());
    }
}