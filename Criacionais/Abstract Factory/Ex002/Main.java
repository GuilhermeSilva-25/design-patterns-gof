// PRODUTOS ABSTRATOS
interface CartaoCredito {
    String processar();
}

interface Boleto {
    String emitir();
}

// PRODUTOS CONCRETOS - BANCO A
class CartaoCreditoBancoA implements CartaoCredito {
    public String processar() {
        return "Banco A: Pagamento via Cartão de Crédito processado com sucesso.";
    }
}

class BoletoBancoA implements Boleto {
    public String emitir() {
        return "Banco A: Boleto emitido. Vencimento em 3 dias.";
    }
}

// PRODUTOS CONCRETOS - BANCO B
class CartaoCreditoBancoB implements CartaoCredito {
    public String processar() {
        return "Banco B: Pagamento via Cartão de Crédito aprovado.";
    }
}

class BoletoBancoB implements Boleto {
    public String emitir() {
        return "Banco B: Boleto gerado. Vencimento em 5 dias úteis.";
    }
}

// FABRICA ABSTRATA
interface FabricaPagamentoBanco {
    CartaoCredito criarCartaoCredito();
    Boleto criarBoleto();
}

// FABRICAS CONCRETAS
class FabricaBancoA implements FabricaPagamentoBanco {
    public CartaoCredito criarCartaoCredito() {
        return new CartaoCreditoBancoA();
    }

    public Boleto criarBoleto() {
        return new BoletoBancoA();
    }
}

class FabricaBancoB implements FabricaPagamentoBanco {
    public CartaoCredito criarCartaoCredito() {
        return new CartaoCreditoBancoB();
    }

    public Boleto criarBoleto() {
        return new BoletoBancoB();
    }
}

// CLIENTE
public class Main {
    public static void realizarCheckout(FabricaPagamentoBanco fabrica) {
        CartaoCredito cartao = fabrica.criarCartaoCredito();
        Boleto boleto = fabrica.criarBoleto();

        System.out.println(cartao.processar());
        System.out.println(boleto.emitir());
    }

    public static void main(String[] args) {
        System.out.println("### CHECKOUT COM BANCO A ###");
        realizarCheckout(new FabricaBancoA());
        System.out.println();
        System.out.println("*************************");
        System.out.println();
        System.out.println("### CHECKOUT COM BANCO B ###");
        realizarCheckout(new FabricaBancoB());
    }
}