from typing import List

# Classe Base
class Nome:
    def __init__(self, nome, sobrenome):
        self.nome = nome
        self.sobrenome = sobrenome

    def imprimir(self):
        print(self.nome + " " + self.sobrenome)


# FÁBRICA
class FabricaDeNomes:
    def __init__(self):
        self.bancoDeNomes: List[Nome] = []

    def criarNome(self, entrada):
        pass

    def adicionarNome(self, entrada):
        novoNome = self.criarNome(entrada)
        self.bancoDeNomes.append(novoNome)

    def imprimirNomes(self):
        for n in self.bancoDeNomes:
            n.imprimir()


# Subclasse para formato: "nome sobrenome"
class FabricaFormatoSimples(FabricaDeNomes):
    def criarNome(self, entrada):
        partes = entrada.split(" ")
        return Nome(partes[0], partes[1])


# Subclasse para formato: "sobrenome, nome"
class FabricaFormatoInvertido(FabricaDeNomes):
    def criarNome(self, entrada):
        partes = entrada.split(", ")
        return Nome(partes[1], partes[0])


# USO DA FABRICA - CLIENTE:
class Main:
    @staticmethod
    def main():
        fabricaSimples = FabricaFormatoSimples()
        fabricaInvertida = FabricaFormatoInvertido()

        fabricaInvertida.adicionarNome("McNealy, Scott")
        fabricaSimples.adicionarNome("James Gosling")
        fabricaInvertida.adicionarNome("Naughton, Patrick")

        fabricaSimples.imprimirNomes()
        fabricaInvertida.imprimirNomes()


if __name__ == "__main__":
    Main.main()