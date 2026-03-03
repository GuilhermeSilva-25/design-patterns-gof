# Classe Base
class Pessoa:
    def __init__(self, nome):
        self._nome = nome

    def getNome(self):
        return self._nome

    def mostrarPermissao(self):
        raise NotImplementedError("Método deve ser sobrescrito.")


# Subclasse Aluno
class Aluno(Pessoa):
    def __init__(self, nome):
        super().__init__(nome)

    def mostrarPermissao(self):
        print(f"Nome: {self.getNome()}\nCargo: Aluno\nPermissão: Nível 0\n")


# Subclasse Administrativo
class Administrativo(Pessoa):
    def __init__(self, nome):
        super().__init__(nome)

    def mostrarPermissao(self):
        print(f"Nome: {self.getNome()}\nCargo: Administrativo\nPermissão: Nível 1\n")


# Subclasse Professor
class Professor(Pessoa):
    def __init__(self, nome):
        super().__init__(nome)

    def mostrarPermissao(self):
        print(f"Nome: {self.getNome()}\nCargo: Professor\nPermissão: Nível 2\n")


# Subclasse Visitante
class Visitante(Pessoa):
    def __init__(self, nome):
        super().__init__(nome)

    def mostrarPermissao(self):
        print(f"Nome: {self.getNome()}\nCargo: Visitante\nPermissão: Nível 3\n")


# Fábricas
class FabricaDaFatec:
    def criarPessoa(self, nome, cargo):
        cargo = cargo.lower()
        if cargo == "aluno":
            return Aluno(nome)
        elif cargo == "administrativo":
            return Administrativo(nome)
        elif cargo == "professor":
            return Professor(nome)
        elif cargo == "visitante":
            return Visitante(nome)
        else:
            raise ValueError("Cargo desconhecido.")


# USO DA FABRICA - CLIENTE:
class Main:
    @staticmethod
    def main():
        fabrica = FabricaDaFatec()

        p1 = fabrica.criarPessoa("Carlos", "aluno")
        p2 = fabrica.criarPessoa("Ana", "aluno")
        p3 = fabrica.criarPessoa("Mariana", "administrativo")
        p4 = fabrica.criarPessoa("João", "administrativo")
        p5 = fabrica.criarPessoa("Roberto", "professor")
        p6 = fabrica.criarPessoa("Patrícia", "professor")
        p7 = fabrica.criarPessoa("Lucas", "visitante")
        p8 = fabrica.criarPessoa("Fernanda", "visitante")

        p1.mostrarPermissao()
        p2.mostrarPermissao()
        p3.mostrarPermissao()
        p4.mostrarPermissao()
        p5.mostrarPermissao()
        p6.mostrarPermissao()
        p7.mostrarPermissao()
        p8.mostrarPermissao()


if __name__ == "__main__":
    Main.main()