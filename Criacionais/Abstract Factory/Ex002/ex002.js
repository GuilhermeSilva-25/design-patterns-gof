// PRODUTOS CONCRETOS - BANCO A
class CartaoCreditoBancoA {
    processar() {
        return "Banco A: Pagamento via Cartão de Crédito processado com sucesso.";
    }
}

class BoletoBancoA {
    emitir() {
        return "Banco A: Boleto emitido. Vencimento em 3 dias.";
    }
}

// PRODUTOS CONCRETOS - BANCO B
class CartaoCreditoBancoB {
    processar() {
        return "Banco B: Pagamento via Cartão de Crédito aprovado.";
    }
}

class BoletoBancoB {
    emitir() {
        return "Banco B: Boleto gerado. Vencimento em 5 dias úteis.";
    }
}

// FABRICAS CONCRETAS
class FabricaBancoA {
    criarCartaoCredito() {
        return new CartaoCreditoBancoA();
    }
    criarBoleto() {
        return new BoletoBancoA();
    }
}

class FabricaBancoB {
    criarCartaoCredito() {
        return new CartaoCreditoBancoB();
    }
    criarBoleto() {
        return new BoletoBancoB();
    }
}

// CLIENTE
class Main {
    static realizarCheckout(fabrica) {
        const cartao = fabrica.criarCartaoCredito();
        const boleto = fabrica.criarBoleto();

        console.log(cartao.processar());
        console.log(boleto.emitir());
    }

    static rodar() {
        console.log("### CHECKOUT COM BANCO A ###");
        Main.realizarCheckout(new FabricaBancoA());
        console.log();
        console.log("*************************");
        console.log();
        console.log("### CHECKOUT COM BANCO B ###");
        Main.realizarCheckout(new FabricaBancoB());
    }
}

// Execução
Main.rodar();