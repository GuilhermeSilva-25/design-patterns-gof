// Classe Base de Veiculo
class Veiculo {
  constructor(modelo) {
    this.modelo = modelo;
  }

  mostrarDetalhes() {
    console.log(`Modelo: ${this.modelo}`);
  }
}
// Subclasse de Veiculo
class Carro extends Veiculo {
  constructor(modelo) {
    super(modelo);
  }
}

class Moto extends Veiculo {
  constructor(modelo) {
    super(modelo);
  }
}

class Barco extends Veiculo {
  constructor(modelo) {
    super(modelo);
  }
}

// Fabrica Abstrata de Veiculo
class FabricaDeVeiculos {
  criarVeiculo(modelo) {
    throw new Error(`O metodo criarVeiculo deve ser implementado`);
  }
}

// Fabrica Concreta de Carros
class FabricaDeCarros extends FabricaDeVeiculos {
  criarVeiculo(modelo) {
    return new Carro(modelo);
  }
}

// fabrica Concreta de Motos
class FabricaDemotos extends FabricaDeVeiculos {
  criarVeiculo(modelo) {
    return new Moto(modelo);
  }
}

// Fabrica Concreta de Barcos
class FabricaDeBarcos extends FabricaDeVeiculos {
  criarVeiculo(modelo) {
    return new Barco(modelo);
  }
}

// USO DA FABRICA - CLIENTE:
const FabricaDeCarro = new FabricaDeCarros();
const FabricaDemoto = new FabricaDemotos();
const FabricaDeBarco = new FabricaDeBarcos();

const veiculo1 = FabricaDeCarro.criarVeiculo("Sedan");
const veiculo2 = FabricaDeCarro.criarVeiculo("Hatch");
const veiculo3 = FabricaDemoto.criarVeiculo("esportiva");
const veiculo4 = FabricaDemoto.criarVeiculo("Hudson");
const veiculo5 = FabricaDeBarco.criarVeiculo("Lancha");
const veiculo6 = FabricaDeBarco.criarVeiculo("Iate");

veiculo1.mostrarDetalhes();
veiculo2.mostrarDetalhes();
veiculo3.mostrarDetalhes();
veiculo4.mostrarDetalhes();
veiculo5.mostrarDetalhes();
veiculo6.mostrarDetalhes();
