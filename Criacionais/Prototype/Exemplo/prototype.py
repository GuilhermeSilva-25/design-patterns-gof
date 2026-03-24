# Classe Pessoa que será clonada:
class Pessoa:
    def __init__(self, id, nome, idade):
        self.id = id
        self.nome = nome
        self.idade = idade

    # Método clone para realizar uma cópia superficial:
    def clone(self):
        return Pessoa(self.id, self.nome, self.idade)

    def __repr__(self):
        return f"Pessoa(id={self.id}, nome='{self.nome}', idade={self.idade})"


# Classe GerenciaPessoa para gerenciar instâncias de Pessoa:
class GerenciaPessoa:
    def __init__(self):
        self.pessoas = {}

    # Adiciona uma nova pessoa ao dicionário:
    def add_pessoa(self, id, nome, idade):
        pessoa = Pessoa(id, nome, idade)
        self.pessoas[id] = pessoa

    # Retorna uma cópia da pessoa:
    def get_pessoa_by_id(self, id):
        pessoa_original = self.pessoas.get(id)
        if pessoa_original:
            return pessoa_original.clone()
        return None


# Uso:
gerencia = GerenciaPessoa()

gerencia.add_pessoa(1, "João da Silva", 30)
gerencia.add_pessoa(2, "Maria da Silva", 25)
gerencia.add_pessoa(3, "Pedro da Silva", 45)

pessoa_clone = gerencia.get_pessoa_by_id(1)

if pessoa_clone:
    pessoa_clone.nome = "João Clonado"
    pessoa_clone.idade = 99

print("Pessoa original:", gerencia.pessoas[1])
print("Pessoa clonada:", pessoa_clone)