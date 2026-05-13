// PROJETO PIZZARIA - RESOLUÇÃO

// PARTE 1: PADRÃO BRIDGE (Montagem da Pizza)

// 1. IMPLEMENTAÇÕES - Interface de Sabores
interface Sabor {
    String obterSabor();
}

// Implementações Concretas de Sabor
class SaborCalabresa implements Sabor {
    @Override
    public String obterSabor() {
        return "Calabresa";
    }
}

class SaborMussarela implements Sabor {
    @Override
    public String obterSabor() {
        return "Mussarela";
    }
}

class SaborFrango implements Sabor {
    @Override
    public String obterSabor() {
        return "Frango";
    }
}

// 2. IMPLEMENTAÇÕES - Interface de Bordas
interface Borda {
    String obterBorda();
}

// Implementações Concretas de Borda
class BordaTradicional implements Borda {
    @Override
    public String obterBorda() {
        return "com Borda Tradicional";
    }
}

class BordaCatupiry implements Borda {
    @Override
    public String obterBorda() {
        return "com Borda de Catupiry";
    }
}

class SemBorda implements Borda {
    @Override
    public String obterBorda() {
        return "Sem Borda";
    }
}

// 3. ABSTRAÇÃO - Interface da Pizza (Tamanho)
abstract class Pizza {

    protected Sabor sabor;
    protected Borda borda;

    public Pizza(Sabor sabor, Borda borda) {
        this.sabor = sabor;
        this.borda = borda;
    }

    public abstract String montar();
}

// 4. ABSTRAÇÕES REFINADAS - Tamanhos
class PizzaBrotinho extends Pizza {

    public PizzaBrotinho(Sabor sabor, Borda borda) {
        super(sabor, borda);
    }

    @Override
    public String montar() {
        return "Pizza Brotinho de "
                + sabor.obterSabor()
                + " ("
                + borda.obterBorda()
                + ").";
    }
}

class PizzaTradicional extends Pizza {

    public PizzaTradicional(Sabor sabor, Borda borda) {
        super(sabor, borda);
    }

    @Override
    public String montar() {
        return "Pizza Tradicional de "
                + sabor.obterSabor()
                + " ("
                + borda.obterBorda()
                + ").";
    }
}

class PizzaGrande extends Pizza {

    public PizzaGrande(Sabor sabor, Borda borda) {
        super(sabor, borda);
    }

    @Override
    public String montar() {
        return "Pizza Grande de "
                + sabor.obterSabor()
                + " ("
                + borda.obterBorda()
                + ").";
    }
}

// PARTE 2: PADRÃO ADAPTER (Assando a Pizza)

// 1. INTERFACE DO CLIENTE
class FornoTarget {

    public void assar(Pizza pizza) {
        System.out.println("Target: Assando pedido...");
    }
}

// 2. SERVIÇO EXISTENTE - Interface incompatível
class FornoLenhaAntigo {

    public void assarNoFogo(String instrucaoEmTexto) {
        System.out.println(
                "Adaptee (Forno Antigo): Colocando no fogo -> "
                        + instrucaoEmTexto);
    }
}

// 3. ADAPTADOR (ADAPTER)
class FornoAdapter extends FornoTarget {

    private FornoLenhaAntigo fornoAntigo;

    public FornoAdapter(FornoLenhaAntigo fornoAntigo) {
        this.fornoAntigo = fornoAntigo;
    }

    @Override
    public void assar(Pizza pizza) {

        System.out.println(
                "Adapter: Convertendo o objeto Pizza para o forno antigo...");

        String instrucaoParaForno = pizza.montar();

        fornoAntigo.assarNoFogo(instrucaoParaForno);
    }
}

// 4. CLIENTE (A Pizzaria)
class SistemaPizzaria {

    private FornoTarget forno;

    public SistemaPizzaria(FornoTarget fornoTarget) {
        this.forno = fornoTarget;
    }

    public void fazerPedido(Pizza pizza) {

        System.out.println("\n--- Novo Pedido Recebido ---");

        forno.assar(pizza);

        System.out.println("Pedido Finalizado!");
    }
}

// Classe Principal
public class Main {

    public static void main(String[] args) {

        // Instanciando o maquinário (Adapter)
        FornoLenhaAntigo fornoLegado = new FornoLenhaAntigo();

        FornoAdapter fornoAdaptado = new FornoAdapter(fornoLegado);

        SistemaPizzaria pizzaria = new SistemaPizzaria(fornoAdaptado);

        // Criando os ingredientes (Bridge)
        Sabor saborCalabresa = new SaborCalabresa();

        Sabor saborFrango = new SaborFrango();

        Borda bordaCatupiry = new BordaCatupiry();

        Borda semBorda = new SemBorda();

        // Montando as pizzas combinando as abstrações e implementações (Bridge)
        Pizza pedido1 = new PizzaGrande(
                saborCalabresa,
                bordaCatupiry);

        Pizza pedido2 = new PizzaBrotinho(
                saborFrango,
                semBorda);

        // Enviando os pedidos (Cliente usando o Adapter)
        pizzaria.fazerPedido(pedido1);

        pizzaria.fazerPedido(pedido2);
    }
}