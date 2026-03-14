// Define os Tipos de Pessoas
class Pessoa {
  constructor(nome, horaEntrada, horaSaida) {
    this.nome = nome;
    this.horaEntrada = horaEntrada;
    this.horaSaida = horaSaida;
  }

  getNome() {
    return this.nome;
  }

  getHoraEntrada() {
    return this.horaEntrada;
  }

  getHoraSaida() {
    return this.horaSaida;
  }

  mostrarPermissao() {
    throw new Error("Método deve ser sobrescrito.");
  }
}

// Subclasse Aluno
class Aluno extends Pessoa {
  mostrarPermissao() {
    console.log(`Nome: ${this.getNome()}
Cargo: Aluno
Hora de Entrada: ${this.getHoraEntrada()}
Hora de Saída: ${this.getHoraSaida()}
Permissão: Nível 0\n`);
  }
}

// Subclasse Administrativo
class Administrativo extends Pessoa {
  mostrarPermissao() {
    console.log(`Nome: ${this.getNome()}
Cargo: Administrativo
Hora de Entrada: ${this.getHoraEntrada()}
Hora de Saída: ${this.getHoraSaida()}
Permissão: Nível 1\n`);
  }
}

// Subclasse Professor
class Professor extends Pessoa {
  mostrarPermissao() {
    console.log(`Nome: ${this.getNome()}
Cargo: Professor
Hora de Entrada: ${this.getHoraEntrada()}
Hora de Saída: ${this.getHoraSaida()}
Permissão: Nível 2\n`);
  }
}

// Subclasse Visitante
class Visitante extends Pessoa {
  mostrarPermissao() {
    console.log(`Nome: ${this.getNome()}
Cargo: Visitante
Hora de Entrada: ${this.getHoraEntrada()}
Hora de Saída: ${this.getHoraSaida()}
Permissão: Nível 3\n`);
  }
}

// Builder
class PessoaBuilder {
  constructor() {
    this.nome = null;
    this.cargo = null;
    this.horaEntrada = null;
    this.horaSaida = null;
  }

  addNome(nome) {
    this.nome = nome;
    return this;
  }

  addCargo(cargo) {
    this.cargo = cargo.toLowerCase();
    return this;
  }

  addHoraEntrada(hora) {
    this.horaEntrada = hora;
    return this;
  }

  addHoraSaida(hora) {
    this.horaSaida = hora;
    return this;
  }

  construir() {
    switch (this.cargo) {
      case "aluno":
        return new Aluno(this.nome, this.horaEntrada, this.horaSaida);

      case "administrativo":
        return new Administrativo(this.nome, this.horaEntrada, this.horaSaida);

      case "professor":
        return new Professor(this.nome, this.horaEntrada, this.horaSaida);

      case "visitante":
        return new Visitante(this.nome, this.horaEntrada, this.horaSaida);

      default:
        throw new Error("Cargo desconhecido.");
    }
  }
}

// Cliente - Usando o Builder para construir as pessoas
const builder = new PessoaBuilder();

const p1 = builder
  .addNome("Carlos")
  .addCargo("aluno")
  .addHoraEntrada("08:00")
  .addHoraSaida("12:00")
  .construir();

const p2 = builder
  .addNome("Mariana")
  .addCargo("administrativo")
  .addHoraEntrada("09:00")
  .addHoraSaida("17:00")
  .construir();

const p3 = builder
  .addNome("Roberto")
  .addCargo("professor")
  .addHoraEntrada("07:30")
  .addHoraSaida("13:00")
  .construir();

const p4 = builder
  .addNome("Lucas")
  .addCargo("visitante")
  .addHoraEntrada("10:00")
  .addHoraSaida("11:00")
  .construir();

p1.mostrarPermissao();
p2.mostrarPermissao();
p3.mostrarPermissao();
p4.mostrarPermissao();
