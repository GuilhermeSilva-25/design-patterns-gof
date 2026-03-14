// Define as Partes de um Carro:
class Motor {
    constructor(tipo) {
        this.tipo = tipo
    }
}
 
class Carroceria {
    constructor(estilo) {
        this.estilo = estilo
    }
}
 
class Rodas {
    constructor(tamanho) {
        this.tamanho = tamanho
    }
}
 
class Interior {
    constructor(cor) {
        this.cor = cor
    }
}
 
 
 
// Builder
class CarroBuilder {
    constructor() {
        this.motor = null
        this.carroceria = null
        this.rodas = null
        this.interior = null
    }
 
    addMotor(tipo) {
        this.motor = new Motor(tipo)
        return this
    }
 
    addCarroceria(estilo) {
        this.carroceria = new Carroceria(estilo)
        return this
    }
 
    addRodas(tamanho) {
        this.rodas = new Rodas(tamanho)
        return this
    }
 
    addInterior(cor) {
        this.interior = new Interior(cor)
        return this
    }
 
    construir() {
        return new Carro(
            this.motor,
            this.carroceria,
            this.rodas,
            this.interior
        )
    }
}
 
// Construir Carro
class Carro {
    constructor(motor, carroceria, rodas, interior) {
        this.motor = motor
        this.carroceria = carroceria
        this.rodas = rodas
        this.interior = interior
    }
 
    mostrarDetalhes() {
        console.log("Carro composto por:")
        console.log("Motor:", this.motor.tipo)
        console.log("Carroceria:", this.carroceria.estilo)
        console.log("Rodas:", this.rodas.tamanho)
        console.log("Interior:", this.interior.cor)
    }
}
 
// Cliente - Usando o Builder para construir o carro
const builder = new CarroBuilder();
const carro1 = builder
    .addMotor("1.4")
    .addCarroceria("Esportiva")
    .addRodas(18)
    .addInterior("Preto")
    .construir();
 
carro1.mostrarDetalhes();