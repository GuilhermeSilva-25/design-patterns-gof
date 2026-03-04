# PRODUTOS ABSTRATOS
class RoboMontador:
    def montar(self):
        pass

class RoboInspetor:
    def inspecionar(self):
        pass

# PRODUTOS CONCRETOS - AUTOMOTIVA
class MontadorCarros:
    def montar(self):
        return "Montador Automotivo: Soldando chassi e montando portas."

class InspetorPecas:
    def inspecionar(self):
        return "Inspetor Automotivo: Verificando alinhamento e pintura."

# PRODUTOS CONCRETOS - ELETRÔNICOS
class MontadorCircuitos:
    def montar(self):
        return "Montador Eletrônico: Inserindo componentes na placa."

class InspetorChips:
    def inspecionar(self):
        return "Inspetor Eletrônico: Testando continuidade e circuitos."

# FABRICA ABSTRATA
class FabricaRobos:
    def criar_montador(self):
        pass
    def criar_inspetor(self):
        pass

# FABRICAS CONCRETAS
class FabricaAutomotiva:
    def criar_montador(self):
        return MontadorCarros()
    
    def criar_inspetor(self):
        return InspetorPecas()

class FabricaEletronicos:
    def criar_montador(self):
        return MontadorCircuitos()
    
    def criar_inspetor(self):
        return InspetorChips()

# CLIENTE
class Main:
    def produzir(fabrica):
        montador = fabrica.criar_montador()
        inspetor = fabrica.criar_inspetor()

        print(montador.montar())
        print(inspetor.inspecionar())

if __name__ == "__main__":
    print("### LINHA AUTOMOTIVA ###")
    Main.produzir(FabricaAutomotiva())
    print()
    print("*************************")
    print()
    print("### LINHA ELETRÔNICOS ###")
    Main.produzir(FabricaEletronicos())