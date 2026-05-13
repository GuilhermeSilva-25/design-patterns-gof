# PROJETO PIZZARIA - RESOLUÇÃO

# PARTE 1: PADRÃO BRIDGE (Montagem da Pizza)


# 1. IMPLEMENTAÇÕES - Interface de Sabores
class Sabor:
    def obter_sabor(self):
        raise NotImplementedError("Método abstrato: obter_sabor()")


# Implementações Concretas de Sabor
class SaborCalabresa(Sabor):
    def obter_sabor(self):
        return "Calabresa"


class SaborMussarela(Sabor):
    def obter_sabor(self):
        return "Mussarela"


class SaborFrango(Sabor):
    def obter_sabor(self):
        return "Frango"


# 2. IMPLEMENTAÇÕES - Interface de Bordas
class Borda:
    def obter_borda(self):
        raise NotImplementedError("Método abstrato: obter_borda()")


# Implementações Concretas de Borda
class BordaTradicional(Borda):
    def obter_borda(self):
        return "com Borda Tradicional"


class BordaCatupiry(Borda):
    def obter_borda(self):
        return "com Borda de Catupiry"


class SemBorda(Borda):
    def obter_borda(self):
        return "Sem Borda"


# 3. ABSTRAÇÃO - Interface da Pizza (Tamanho)
class Pizza:
    def __init__(self, sabor, borda):
        self.sabor = sabor
        self.borda = borda

    def montar(self):
        raise NotImplementedError("Método abstrato: montar()")


# 4. ABSTRAÇÕES REFINADAS - Tamanhos
class PizzaBrotinho(Pizza):
    def montar(self):
        return f"Pizza Brotinho de {self.sabor.obter_sabor()} ({self.borda.obter_borda()})."


class PizzaTradicional(Pizza):
    def montar(self):
        return f"Pizza Tradicional de {self.sabor.obter_sabor()} ({self.borda.obter_borda()})."


class PizzaGrande(Pizza):
    def montar(self):
        return (
            f"Pizza Grande de {self.sabor.obter_sabor()} ({self.borda.obter_borda()})."
        )


# PARTE 2: PADRÃO ADAPTER (Assando a Pizza)


# 1. INTERFACE DO CLIENTE
class FornoTarget:
    def assar(self, pizza):
        print("Target: Assando pedido...")


# 2. SERVIÇO EXISTENTE - Interface incompatível
class FornoLenhaAntigo:
    def assar_no_fogo(self, instrucao_em_texto):
        print(f"Adaptee (Forno Antigo): Colocando no fogo -> {instrucao_em_texto}")


# 3. ADAPTADOR (ADAPTER)
class FornoAdapter(FornoTarget):
    def __init__(self, forno_antigo):
        self.forno_antigo = forno_antigo

    def assar(self, pizza):
        print("Adapter: Convertendo o objeto Pizza para o forno antigo...")

        instrucao_para_forno = pizza.montar()

        self.forno_antigo.assar_no_fogo(instrucao_para_forno)


# 4. CLIENTE (A Pizzaria)
class SistemaPizzaria:
    def __init__(self, forno_target):
        self.forno = forno_target

    def fazer_pedido(self, pizza):
        print("\n--- Novo Pedido Recebido ---")

        self.forno.assar(pizza)

        print("Pedido Finalizado!")


# Instanciando o maquinário (Adapter)
forno_legado = FornoLenhaAntigo()

forno_adaptado = FornoAdapter(forno_legado)

pizzaria = SistemaPizzaria(forno_adaptado)


# Criando os ingredientes (Bridge)
sabor_calabresa = SaborCalabresa()

sabor_frango = SaborFrango()

borda_catupiry = BordaCatupiry()

sem_borda = SemBorda()


# Montando as pizzas combinando as abstrações e implementações (Bridge)
pedido1 = PizzaGrande(sabor_calabresa, borda_catupiry)

pedido2 = PizzaBrotinho(sabor_frango, sem_borda)


# Enviando os pedidos (Cliente usando o Adapter)
pizzaria.fazer_pedido(pedido1)

pizzaria.fazer_pedido(pedido2)
