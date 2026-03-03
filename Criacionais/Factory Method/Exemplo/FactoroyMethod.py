# Classe Base de Veiculo
class Veiculo:
    def __init__(self, modelo):
        self.modelo = modelo

    def mostrar_detalhes(self):
        print(f"Modelo: {self.modelo}")


# Subclasse de Veiculo
class Carro(Veiculo):
    def __init__(self, modelo):
        super().__init__(modelo)


class Moto(Veiculo):
    def __init__(self, modelo):
        super().__init__(modelo)


class Barco(Veiculo):
    def __init__(self, modelo):
        super().__init__(modelo)


# Fabrica Abstrata de Veiculo
class FabricaDeVeiculos:
    def criar_veiculo(self, modelo):
        raise Exception("O metodo criarVeiculo deve ser implementado")


# Fabrica Concreta de Carros
class FabricaDeCarros(FabricaDeVeiculos):
    def criar_veiculo(self, modelo):
        return Carro(modelo)


# fabrica Concreta de Motos
class FabricaDemotos(FabricaDeVeiculos):
    def criar_veiculo(self, modelo):
        return Moto(modelo)


# Fabrica Concreta de Barcos
class FabricaDeBarcos(FabricaDeVeiculos):
    def criar_veiculo(self, modelo):
        return Barco(modelo)


# USO DA FABRICA - CLIENTE:
FabricaDeCarro = FabricaDeCarros()
FabricaDemoto = FabricaDemotos()
FabricaDeBarco = FabricaDeBarcos()

veiculo1 = FabricaDeCarro.criar_veiculo("Sedan")
veiculo2 = FabricaDeCarro.criar_veiculo("Hatch")
veiculo3 = FabricaDemoto.criar_veiculo("esportiva")
veiculo4 = FabricaDemoto.criar_veiculo("Hudson")
veiculo5 = FabricaDeBarco.criar_veiculo("Lancha")
veiculo6 = FabricaDeBarco.criar_veiculo("Iate")

veiculo1.mostrar_detalhes()
veiculo2.mostrar_detalhes()
veiculo3.mostrar_detalhes()
veiculo4.mostrar_detalhes()
veiculo5.mostrar_detalhes()
veiculo6.mostrar_detalhes()
