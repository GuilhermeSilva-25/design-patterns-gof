# Define as Partes de um Carro:
class Motor:
    def __init__(self, tipo):
        self.tipo = tipo
 
 
class Carroceria:
    def __init__(self, estilo):
        self.estilo = estilo
 
 
class Rodas:
    def __init__(self, tamanho):
        self.tamanho = tamanho
 
 
class Interior:
    def __init__(self, cor):
        self.cor = cor
 
 
# Builder
class CarroBuilder:
    def __init__(self):
        self.motor = None
        self.carroceria = None
        self.rodas = None
        self.interior = None
 
    def addMotor(self, tipo):
        self.motor = Motor(tipo)
        return self
 
    def addCarroceria(self, estilo):
        self.carroceria = Carroceria(estilo)
        return self
 
    def addRodas(self, tamanho):
        self.rodas = Rodas(tamanho)
        return self
 
    def addInterior(self, cor):
        self.interior = Interior(cor)
        return self
 
    def construir(self):
        return Carro(
            self.motor,
            self.carroceria,
            self.rodas,
            self.interior
        )
 
 
# Construir Carro
class Carro:
    def __init__(self, motor, carroceria, rodas, interior):
        self.motor = motor
        self.carroceria = carroceria
        self.rodas = rodas
        self.interior = interior
 
    def mostrarDetalhes(self):
        print("Carro composto por:")
        print("Motor:", self.motor.tipo)
        print("Carroceria:", self.carroceria.estilo)
        print("Rodas:", self.rodas.tamanho)
        print("Interior:", self.interior.cor)
 
 
# Cliente - Usando o Builder para construir o carro
builder = CarroBuilder()
carro1 = builder \
    .addMotor("1.4") \
    .addCarroceria("Esportiva") \
    .addRodas(18) \
    .addInterior("Preto") \
    .construir()
 
carro1.mostrarDetalhes()