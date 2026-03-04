// PRODUTOS CONCRETOS - PAYPAL
class GatewayPayPal {
    autorizar(valor) {
        return `Paypal: Pagamento de R$ ${valor.toFixed(2)} autorizado.`;
    }
}

class ReciboPayPal {
    gerar(valor) {
        return `PayPal: Recibo do pagamento de R$ ${valor.toFixed(2)}.`;
    }
}

// PRODUTOS CONCRETOS - MERCADOPAGO
class GatewayMercadoPago {
    autorizar(valor) {
        return `Mercado Pago: Pagamento de R$ ${valor.toFixed(2)} autorizado.`;
    }
}

class ReciboMercadoPago {
    gerar(valor) {
        return `Mercado Pago: Recibo do pagamento de R$ ${valor.toFixed(2)}.`;
    }
}

// FABRICAS CONCRETAS
class FabricaPayPal {
    criarGateway() {
        return new GatewayPayPal();
    }
    criarRecibo() {
        return new ReciboPayPal();
    }
}

class FabricaMercadoPago {
    criarGateway() {
        return new GatewayMercadoPago();
    }
    criarRecibo() {
        return new ReciboMercadoPago();
    }
}

// CLIENTE
class Main {
    static finalizarCompra(fabrica, valor) {
        const gateway = fabrica.criarGateway();
        const recibo = fabrica.criarRecibo();

        console.log(gateway.autorizar(valor));
        console.log(recibo.gerar(valor));
    }

    static rodar() {
        Main.finalizarCompra(new FabricaPayPal(), 100.99);
        console.log("*************************");
        Main.finalizarCompra(new FabricaMercadoPago(), 3100.99);
        console.log("*************************");
        Main.finalizarCompra(new FabricaPayPal(), 180.99);
        console.log("*************************");
        Main.finalizarCompra(new FabricaMercadoPago(), 1008.99);
    }
}

// Execução
Main.rodar();