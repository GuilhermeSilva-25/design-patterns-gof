# Define os Tipos de Pessoas
class Pessoa:
    def __init__(self, nome, horaEntrada, horaSaida):
        self.nome = nome
        self.horaEntrada = horaEntrada
        self.horaSaida = horaSaida

    def getNome(self):
        return self.nome

    def getHoraEntrada(self):
        return self.horaEntrada

    def getHoraSaida(self):
        return self.horaSaida

    def mostrarPermissao(self):
        raise Exception("Método deve ser sobrescrito.")


# Subclasse Aluno
class Aluno(Pessoa):
    def mostrarPermissao(self):
        print(
            f"""Nome: {self.getNome()}
Cargo: Aluno
Hora de Entrada: {self.getHoraEntrada()}
Hora de Saída: {self.getHoraSaida()}
Permissão: Nível 0
"""
        )


# Subclasse Administrativo
class Administrativo(Pessoa):
    def mostrarPermissao(self):
        print(
            f"""Nome: {self.getNome()}
Cargo: Administrativo
Hora de Entrada: {self.getHoraEntrada()}
Hora de Saída: {self.getHoraSaida()}
Permissão: Nível 1
"""
        )


# Subclasse Professor
class Professor(Pessoa):
    def mostrarPermissao(self):
        print(
            f"""Nome: {self.getNome()}
Cargo: Professor
Hora de Entrada: {self.getHoraEntrada()}
Hora de Saída: {self.getHoraSaida()}
Permissão: Nível 2
"""
        )


# Subclasse Visitante
class Visitante(Pessoa):
    def mostrarPermissao(self):
        print(
            f"""Nome: {self.getNome()}
Cargo: Visitante
Hora de Entrada: {self.getHoraEntrada()}
Hora de Saída: {self.getHoraSaida()}
Permissão: Nível 3
"""
        )


# Builder
class PessoaBuilder:
    def __init__(self):
        self.nome = None
        self.cargo = None
        self.horaEntrada = None
        self.horaSaida = None

    def addNome(self, nome):
        self.nome = nome
        return self

    def addCargo(self, cargo):
        self.cargo = cargo.lower()
        return self

    def addHoraEntrada(self, hora):
        self.horaEntrada = hora
        return self

    def addHoraSaida(self, hora):
        self.horaSaida = hora
        return self

    def construir(self):
        if self.cargo == "aluno":
            return Aluno(self.nome, self.horaEntrada, self.horaSaida)

        elif self.cargo == "administrativo":
            return Administrativo(self.nome, self.horaEntrada, self.horaSaida)

        elif self.cargo == "professor":
            return Professor(self.nome, self.horaEntrada, self.horaSaida)

        elif self.cargo == "visitante":
            return Visitante(self.nome, self.horaEntrada, self.horaSaida)

        else:
            raise Exception("Cargo desconhecido.")


# Cliente - Usando o Builder para construir as pessoas
builder = PessoaBuilder()

p1 = (
    builder.addNome("Carlos")
    .addCargo("aluno")
    .addHoraEntrada("08:00")
    .addHoraSaida("12:00")
    .construir()
)

p2 = (
    builder.addNome("Mariana")
    .addCargo("administrativo")
    .addHoraEntrada("09:00")
    .addHoraSaida("17:00")
    .construir()
)

p3 = (
    builder.addNome("Roberto")
    .addCargo("professor")
    .addHoraEntrada("07:30")
    .addHoraSaida("13:00")
    .construir()
)

p4 = (
    builder.addNome("Lucas")
    .addCargo("visitante")
    .addHoraEntrada("10:00")
    .addHoraSaida("11:00")
    .construir()
)

p1.mostrarPermissao()
p2.mostrarPermissao()
p3.mostrarPermissao()
p4.mostrarPermissao()
