# PRODUTOS ABSTRATOS (Em Python, apenas a lógica de contrato)
class GatewayPagamento:
    def autorizar(self, valor):
        pass

class Recibo:
    def gerar(self, valor):
        pass

# PRODUTOS CONCRETOS - PAYPAL
class GatewayPayPal:
    def autorizar(self, valor):
        return f"Paypal: Pagamento de R$ {valor:.2f} autorizado."

class ReciboPayPal:
    def gerar(self, valor):
        return f"PayPal: Recibo do pagamento de R$ {valor:.2f}."

# PRODUTOS CONCRETOS - MERCADOPAGO
class GatewayMercadoPago:
    def autorizar(self, valor):
        return f"Mercado Pago: Pagamento de R$ {valor:.2f} autorizado."

class ReciboMercadoPago:
    def gerar(self, valor):
        return f"Mercado Pago: Recibo do pagamento de R$ {valor:.2f}."

# FABRICA ABSTRATA
class FabricaPagamento:
    def criar_gateway(self):
        pass
    def criar_recibo(self):
        pass

# FABRICAS CONCRETAS
class FabricaPayPal:
    def criar_gateway(self):
        return GatewayPayPal()
    
    def criar_recibo(self):
        return ReciboPayPal()

class FabricaMercadoPago:
    def criar_gateway(self):
        return GatewayMercadoPago()
    
    def criar_recibo(self):
        return ReciboMercadoPago()

# CLIENTE
class Main:
    def finalizar_compra(fabrica, valor):
        gateway = fabrica.criar_gateway()
        recibo = fabrica.criar_recibo()

        print(gateway.autorizar(valor))
        print(recibo.gerar(valor))

if __name__ == "__main__":
    Main.finalizar_compra(FabricaPayPal(), 100.99)
    print("*************************")
    Main.finalizar_compra(FabricaMercadoPago(), 3100.99)
    print("*************************")
    Main.finalizar_compra(FabricaPayPal(), 180.99)
    print("*************************")
    Main.finalizar_compra(FabricaMercadoPago(), 1008.99)