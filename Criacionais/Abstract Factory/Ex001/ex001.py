# PRODUTOS ABSTRATOS
class VeiculoLeve:
    def exibir_detalhes(self): pass

class VeiculoPesado:
    def exibir_detalhes(self): pass

# PRODUTOS CONCRETOS - TERRESTRE
class Carro:
    def exibir_detalhes(self):
        return "Carro: Veículo leve de transporte terrestre."

class Onibus:
    def exibir_detalhes(self):
        return "Ônibus: Veículo pesado de transporte terrestre em massa."

# PRODUTOS CONCRETOS - AÉREO
class Helicoptero:
    def exibir_detalhes(self):
        return "Helicóptero: Veículo leve de transporte aéreo."

class Aviao:
    def exibir_detalhes(self):
        return "Avião: Veículo pesado de transporte aéreo em massa."

# FABRICA ABSTRATA
class FabricaTransporte:
    def criar_veiculo_leve(self): pass
    def criar_veiculo_pesado(self): pass

# FABRICAS CONCRETAS
class FabricaTerrestre:
    def criar_veiculo_leve(self):
        return Carro()
    
    def criar_veiculo_pesado(self):
        return Onibus()

class FabricaAerea:
    def criar_veiculo_leve(self):
        return Helicoptero()
    
    def criar_veiculo_pesado(self):
        return Aviao()

# CLIENTE
class Main:
    def solicitar_transporte(fabrica):
        leve = fabrica.criar_veiculo_leve()
        pesado = fabrica.criar_veiculo_pesado()

        print(leve.exibir_detalhes())
        print(pesado.exibir_detalhes())

if __name__ == "__main__":
    print("### MODALIDADE TERRESTRE ###")
    Main.solicitar_transporte(FabricaTerrestre())
    print()
    print("*************************")
    print()
    print("### MODALIDADE AÉREA ###")
    Main.solicitar_transporte(FabricaAerea())