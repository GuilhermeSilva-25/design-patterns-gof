# Classe Aluno (Prototype)
class Aluno:
    def __init__(self, nome, idade, curso, unidade, periodo):
        self.nome = nome
        self.idade = idade
        self.curso = curso
        self.unidade = unidade
        self.periodo = periodo

    # Clone (cópia superficial)
    def clone(self):
        return Aluno(
            self.nome,
            self.idade,
            self.curso,
            self.unidade,
            self.periodo
        )


# Singleton - GerenciadorAlunos
class GerenciadorAlunos:
    _instance = None

    def __new__(cls):
        if cls._instance is None:
            cls._instance = super(GerenciadorAlunos, cls).__new__(cls)
            cls._instance.lista_matriculados = []
        return cls._instance

    def adicionar_aluno(self, aluno):
        self.lista_matriculados.append(aluno)
        print(f"> Sucesso: {aluno.nome} matriculado em {aluno.curso}.")

    def listar_matriculados(self):
        print("\nLISTA DE MATRÍCULAS")
        if not self.lista_matriculados:
            print("Nenhum aluno cadastrado.")
        else:
            for aluno in self.lista_matriculados:
                print(vars(aluno))


# Client
sigaA = GerenciadorAlunos()
sigaB = GerenciadorAlunos()

print(f"Os gerenciadores são a mesma instância? {'SIM' if sigaA is sigaB else 'NÃO'}")

protoADS = Aluno("Padrão", 0, "Análise de Sistemas", "Unidade Centro", "Noite")

joao = protoADS.clone()
joao.nome = "João da Silva"
joao.idade = 20

maria = protoADS.clone()
maria.nome = "Maria Souza"
maria.idade = 22

sigaA.adicionar_aluno(joao)
sigaA.adicionar_aluno(maria)

sigaB.listar_matriculados()

print("\nVerificação de Integridade do Protótipo:")
print(f"Nome no Protótipo: {protoADS.nome}")
print(f"Idade no Protótipo: {protoADS.idade}")