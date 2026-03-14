// Define as Partes de um Carro:
class Motor {
    String tipo;
 
    Motor(String tipo) {
        this.tipo = tipo;
    }
}
 
class Carroceria {
    String estilo;
 
    Carroceria(String estilo) {
        this.estilo = estilo;
    }
}
 
class Rodas {
    int tamanho;
 
    Rodas(int tamanho) {
        this.tamanho = tamanho;
    }
}
 
class Interior {
    String cor;
 
    Interior(String cor) {
        this.cor = cor;
    }
}
 
 
// Builder
class CarroBuilder {
    Motor motor;
    Carroceria carroceria;
    Rodas rodas;
    Interior interior;
 
    CarroBuilder() {
        this.motor = null;
        this.carroceria = null;
        this.rodas = null;
        this.interior = null;
    }
 
    CarroBuilder addMotor(String tipo) {
        this.motor = new Motor(tipo);
        return this;
    }
 
    CarroBuilder addCarroceria(String estilo) {
        this.carroceria = new Carroceria(estilo);
        return this;
    }
 
    CarroBuilder addRodas(int tamanho) {
        this.rodas = new Rodas(tamanho);
        return this;
    }
 
    CarroBuilder addInterior(String cor) {
        this.interior = new Interior(cor);
        return this;
    }
 
    Carro construir() {
        return new Carro(
            this.motor,
            this.carroceria,
            this.rodas,
            this.interior
        );
    }
}
 
// Construir Carro
class Carro {
    Motor motor;
    Carroceria carroceria;
    Rodas rodas;
    Interior interior;
 
    Carro(Motor motor, Carroceria carroceria, Rodas rodas, Interior interior) {
        this.motor = motor;
        this.carroceria = carroceria;
        this.rodas = rodas;
        this.interior = interior;
    }
 
    void mostrarDetalhes() {
        System.out.println("Carro composto por:");
        System.out.println("Motor: " + this.motor.tipo);
        System.out.println("Carroceria: " + this.carroceria.estilo);
        System.out.println("Rodas: " + this.rodas.tamanho);
        System.out.println("Interior: " + this.interior.cor);
    }
}
 
// Cliente - Usando o Builder para construir o carro
public class Main {
    public static void main(String[] args) {
 
        CarroBuilder builder = new CarroBuilder();
        Carro carro1 = builder
            .addMotor("1.4")
            .addCarroceria("Esportiva")
            .addRodas(18)
            .addInterior("Preto")
            .construir();
 
        carro1.mostrarDetalhes();
    }
}