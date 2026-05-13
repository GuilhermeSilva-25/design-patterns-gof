// PROJETO PIZZARIA - RESOLUÇÃO

// PARTE 1: PADRÃO BRIDGE (Montagem da Pizza)

// 1. IMPLEMENTAÇÕES - Interface de Sabores
class Sabor {
  obterSabor() {
    throw new Error("Método abstrato: obterSabor()");
  }
}

// Implementações Concretas de Sabor
class SaborCalabresa extends Sabor {
  obterSabor() {
    return "Calabresa";
  }
}

class SaborMussarela extends Sabor {
  obterSabor() {
    return "Mussarela";
  }
}

class SaborFrango extends Sabor {
  obterSabor() {
    return "Frango";
  }
}

// 2. IMPLEMENTAÇÕES - Interface de Bordas
class Borda {
  obterBorda() {
    throw new Error("Método abstrato: obterBorda()");
  }
}

// Implementações Concretas de Borda
class BordaTradicional extends Borda {
  obterBorda() {
    return "com Borda Tradicional";
  }
}

class BordaCatupiry extends Borda {
  obterBorda() {
    return "com Borda de Catupiry";
  }
}

class SemBorda extends Borda {
  obterBorda() {
    return "Sem Borda";
  }
}

// 3. ABSTRAÇÃO - Interface da Pizza (Tamanho)
class Pizza {
  constructor(sabor, borda) {
    this.sabor = sabor;
    this.borda = borda;
  }

  montar() {
    throw new Error("Método abstrato: montar()");
  }
}

// 4. ABSTRAÇÕES REFINADAS - Tamanhos
class PizzaBrotinho extends Pizza {
  montar() {
    return `Pizza Brotinho de ${this.sabor.obterSabor()} (${this.borda.obterBorda()}).`;
  }
}

class PizzaTradicional extends Pizza {
  montar() {
    return `Pizza Tradicional de ${this.sabor.obterSabor()} (${this.borda.obterBorda()}).`;
  }
}

class PizzaGrande extends Pizza {
  montar() {
    return `Pizza Grande de ${this.sabor.obterSabor()} (${this.borda.obterBorda()}).`;
  }
}

// PARTE 2: PADRÃO ADAPTER (Assando a Pizza)

// 1. INTERFACE DO CLIENTE
class FornoTarget {
  assar(pizza) {
    console.log("Target: Assando pedido...");
  }
}

// 2. SERVIÇO EXISTENTE - Interface incompatível
class FornoLenhaAntigo {
  assarNoFogo(instrucaoEmTexto) {
    console.log(
      `Adaptee (Forno Antigo): Colocando no fogo -> ${instrucaoEmTexto}`,
    );
  }
}

// 3. ADAPTADOR (ADAPTER)
class FornoAdapter extends FornoTarget {
  constructor(fornoAntigo) {
    super();
    this.fornoAntigo = fornoAntigo;
  }

  assar(pizza) {
    console.log("Adapter: Convertendo o objeto Pizza para o forno antigo...");

    const instrucaoParaForno = pizza.montar();

    this.fornoAntigo.assarNoFogo(instrucaoParaForno);
  }
}

// 4. CLIENTE (A Pizzaria)
class SistemaPizzaria {
  constructor(fornoTarget) {
    this.forno = fornoTarget;
  }

  fazerPedido(pizza) {
    console.log("\n--- Novo Pedido Recebido ---");

    this.forno.assar(pizza);

    console.log("Pedido Finalizado!");
  }
}

// Instanciando o maquinário (Adapter)
const fornoLegado = new FornoLenhaAntigo();

const fornoAdaptado = new FornoAdapter(fornoLegado);

const pizzaria = new SistemaPizzaria(fornoAdaptado);

// Criando os ingredientes (Bridge)
const saborCalabresa = new SaborCalabresa();
const saborFrango = new SaborFrango();

const bordaCatupiry = new BordaCatupiry();
const semBorda = new SemBorda();

// Montando as pizzas combinando as abstrações e implementações (Bridge)
const pedido1 = new PizzaGrande(saborCalabresa, bordaCatupiry);

const pedido2 = new PizzaBrotinho(saborFrango, semBorda);

// Enviando os pedidos (Cliente usando o Adapter)
pizzaria.fazerPedido(pedido1);

pizzaria.fazerPedido(pedido2);
