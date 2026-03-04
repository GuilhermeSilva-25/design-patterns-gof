// PRODUTOS ABSTRATOS
interface Botao {
    String renderizar();
}

interface Janela {
    String desenhar();
}

// PRODUTOS CONCRETOS - WINDOWS
class BotaoWindows implements Botao {
    public String renderizar() {
        return "Windows: Renderizando botão retangular padrão.";
    }
}

class JanelaWindows implements Janela {
    public String desenhar() {
        return "Windows: Desenhando janela com barra de título clássica.";
    }
}

// PRODUTOS CONCRETOS - MAC
class BotaoMac implements Botao {
    public String renderizar() {
        return "Mac: Renderizando botão arredondado estilo Aqua.";
    }
}

class JanelaMac implements Janela {
    public String desenhar() {
        return "Mac: Desenhando janela com botões de controle à esquerda.";
    }
}

// PRODUTOS CONCRETOS - LINUX
class BotaoLinux implements Botao {
    public String renderizar() {
        return "Linux: Renderizando botão customizável estilo GTK.";
    }
}

class JanelaLinux implements Janela {
    public String desenhar() {
        return "Linux: Desenhando janela baseada no gerenciador de janelas atual.";
    }
}

// FABRICA ABSTRATA
interface FabricaGUI {
    Botao criarBotao();
    Janela criarJanela();
}

// FABRICAS CONCRETAS
class FabricaWindows implements FabricaGUI {
    public Botao criarBotao() {
        return new BotaoWindows();
    }

    public Janela criarJanela() {
        return new JanelaWindows();
    }
}

class FabricaMac implements FabricaGUI {
    public Botao criarBotao() {
        return new BotaoMac();
    }

    public Janela criarJanela() {
        return new JanelaMac();
    }
}

class FabricaLinux implements FabricaGUI {
    public Botao criarBotao() {
        return new BotaoLinux();
    }

    public Janela criarJanela() {
        return new JanelaLinux();
    }
}

// CLIENTE
public class Main {
    public static void renderizarInterface(FabricaGUI fabrica) {
        Botao botao = fabrica.criarBotao();
        Janela janela = fabrica.criarJanela();

        System.out.println(janela.desenhar());
        System.out.println(botao.renderizar());
    }

    public static void main(String[] args) {
        System.out.println("### SISTEMA OPERACIONAL: WINDOWS ###");
        renderizarInterface(new FabricaWindows());
        System.out.println();
        System.out.println("*************************");
        System.out.println();
        System.out.println("### SISTEMA OPERACIONAL: MAC ###");
        renderizarInterface(new FabricaMac());
        System.out.println();
        System.out.println("*************************");
        System.out.println();
        System.out.println("### SISTEMA OPERACIONAL: LINUX ###");
        renderizarInterface(new FabricaLinux());
    }
}