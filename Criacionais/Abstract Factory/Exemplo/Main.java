// PRODUTOS ABSTRATOS
interface GatewayPagamento {
    String autorizar();
}

interface Recibo {
    String gerar();
}

// PRODUTOS CONCRETOS - PAYPAL
class GatewayPayPal implements GatewayPagamento {
    private double valor;

    public GatewayPayPal(double valor) {
        this.valor = valor;
    }

    public String autorizar() {
        return String.format("Paypal: Pagamento de R$ %.2f autorizado.", this.valor);
    }
}

class ReciboPayPal implements Recibo {
    private double valor;

    public ReciboPayPal(double valor) {
        this.valor = valor;
    }

    public String gerar() {
        return String.format("PayPal: Recibo do pagamento de R$ %.2f.", this.valor);
    }
}

// PRODUTOS CONCRETOS - MERCADOPAGO
class GatewayMercadoPago implements GatewayPagamento {
    private double valor;

    public GatewayMercadoPago(double valor) {
        this.valor = valor;
    }

    public String autorizar() {
        return String.format("Mercado Pago: Pagamento de R$ %.2f autorizado.", this.valor);
    }
}

class ReciboMercadoPago implements Recibo {
    private double valor;

    public ReciboMercadoPago(double valor) {
        this.valor = valor;
    }

    public String gerar() {
        return String.format("Mercado Pago: Recibo do pagamento de R$ %.2f.", this.valor);
    }
}

// FABRICA ABSTRATA
interface FabricaPagamento {
    GatewayPagamento criarGateway(double valor);

    Recibo criarRecibo(double valor);
}

// FABRICAS CONCRETAS
class FabricaPayPal implements FabricaPagamento {
    public GatewayPagamento criarGateway(double valor) {
        return new GatewayPayPal(valor);
    }

    public Recibo criarRecibo(double valor) {
        return new ReciboPayPal(valor);
    }
}

class FabricaMercadoPago implements FabricaPagamento {
    public GatewayPagamento criarGateway(double valor) {
        return new GatewayMercadoPago(valor);
    }

    public Recibo criarRecibo(double valor) {
        return new ReciboMercadoPago(valor);
    }
}

// CLIENTE
public class Main {
    public static void finalizarCompra(FabricaPagamento fabrica, double valor) {
        GatewayPagamento gateway = fabrica.criarGateway(valor);
        Recibo recibo = fabrica.criarRecibo(valor);

        System.out.println(gateway.autorizar());
        System.out.println(recibo.gerar());
    }

    public static void main(String[] args) {
        finalizarCompra(new FabricaPayPal(), 100.99);
        System.out.println("*************************");
        finalizarCompra(new FabricaMercadoPago(), 3100.99);
        System.out.println("*************************");
        finalizarCompra(new FabricaPayPal(), 180.99);
        System.out.println("*************************");
        finalizarCompra(new FabricaMercadoPago(), 1008.99);
    }
}