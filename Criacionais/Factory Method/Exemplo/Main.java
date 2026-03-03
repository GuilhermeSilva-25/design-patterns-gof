// Classe Base de Veiculo
abstract class Veiculo {
    String modelo;

    public Veiculo(String modelo) {
        this.modelo = modelo;
    }

    public void mostrarDetalhes() {
        System.out.println("Modelo: " + this.modelo);
    }
}

// Subclasse de Veiculo
class Carro extends Veiculo {
    public Carro(String modelo) {
        super(modelo);
    }
}

class Moto extends Veiculo {
    public Moto(String modelo) {
        super(modelo);
    }
}

class Barco extends Veiculo {
    public Barco(String modelo) {
        super(modelo);
    }
}

// Fabrica Abstrata de Veiculo
interface FabricaDeVeiculos {
    Veiculo criarVeiculo(String modelo);
}

// Fabrica Concreta de Carros
class FabricaDeCarros implements FabricaDeVeiculos {
    @Override
    public Veiculo criarVeiculo(String modelo) {
        return new Carro(modelo);
    }
}

// Fabrica Concreta de Motos
class FabricaDeMotos implements FabricaDeVeiculos {
    @Override
    public Veiculo criarVeiculo(String modelo) {
        return new Moto(modelo);
    }
}

// Fabrica Concreta de Barcos
class FabricaDeBarcos implements FabricaDeVeiculos {
    @Override
    public Veiculo criarVeiculo(String modelo) {
        return new Barco(modelo);
    }
}

// USO DA FABRICA - CLIENTE:
public class Main {
    public static void main(String[] args) {
        FabricaDeVeiculos fabricaDeCarro = new FabricaDeCarros();
        FabricaDeVeiculos fabricaDeMoto = new FabricaDeMotos();
        FabricaDeVeiculos fabricaDeBarco = new FabricaDeBarcos();

        Veiculo veiculo1 = fabricaDeCarro.criarVeiculo("Sedan");
        Veiculo veiculo2 = fabricaDeCarro.criarVeiculo("Hatch");
        Veiculo veiculo3 = fabricaDeMoto.criarVeiculo("Esportiva");
        Veiculo veiculo4 = fabricaDeMoto.criarVeiculo("Hudson");
        Veiculo veiculo5 = fabricaDeBarco.criarVeiculo("Lancha");
        Veiculo veiculo6 = fabricaDeBarco.criarVeiculo("Iate");

        veiculo1.mostrarDetalhes();
        veiculo2.mostrarDetalhes();
        veiculo3.mostrarDetalhes();
        veiculo4.mostrarDetalhes();
        veiculo5.mostrarDetalhes();
        veiculo6.mostrarDetalhes();
    }
}