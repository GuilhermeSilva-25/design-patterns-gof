# PRODUTOS ABSTRATOS
class CartaoCredito:
    def processar(self):
        pass

class Boleto:
    def emitir(self):
        pass

# PRODUTOS CONCRETOS - BANCO A
class CartaoCreditoBancoA:
    def processar(self):
        return "Banco A: Pagamento via Cartão de Crédito processado com sucesso."

class BoletoBancoA:
    def emitir(self):
        return "Banco A: Boleto emitido. Vencimento em 3 dias."

# PRODUTOS CONCRETOS - BANCO B
class CartaoCreditoBancoB:
    def processar(self):
        return "Banco B: Pagamento via Cartão de Crédito aprovado."

class BoletoBancoB:
    def emitir(self):
        return "Banco B: Boleto gerado. Vencimento em 5 dias úteis."

# FABRICA ABSTRATA
class FabricaPagamentoBanco:
    def criar_cartao_credito(self):
        pass
    def criar_boleto(self):
        pass

# FABRICAS CONCRETAS
class FabricaBancoA:
    def criar_cartao_credito(self):
        return CartaoCreditoBancoA()
    
    def criar_boleto(self):
        return BoletoBancoA()

class FabricaBancoB:
    def criar_cartao_credito(self):
        return CartaoCreditoBancoB()
    
    def criar_boleto(self):
        return BoletoBancoB()

# CLIENTE
class Main:
    def realizar_checkout(fabrica):
        cartao = fabrica.criar_cartao_credito()
        boleto = fabrica.criar_boleto()

        print(cartao.processar())
        print(boleto.emitir())

if __name__ == "__main__":
    print("### CHECKOUT COM BANCO A ###")
    Main.realizar_checkout(FabricaBancoA())
    print()
    print("*************************")
    print()
    print("### CHECKOUT COM BANCO B ###")
    Main.realizar_checkout(FabricaBancoB())