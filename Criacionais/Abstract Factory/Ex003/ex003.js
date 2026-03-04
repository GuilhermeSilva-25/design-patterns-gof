// PRODUTOS CONCRETOS - WINDOWS
class BotaoWindows {
    renderizar() {
        return "Windows: Renderizando botão retangular padrão.";
    }
}

class JanelaWindows {
    desenhar() {
        return "Windows: Desenhando janela com barra de título clássica.";
    }
}

// PRODUTOS CONCRETOS - MAC
class BotaoMac {
    renderizar() {
        return "Mac: Renderizando botão arredondado estilo Aqua.";
    }
}

class JanelaMac {
    desenhar() {
        return "Mac: Desenhando janela com botões de controle à esquerda.";
    }
}

// PRODUTOS CONCRETOS - LINUX
class BotaoLinux {
    renderizar() {
        return "Linux: Renderizando botão customizável estilo GTK.";
    }
}

class JanelaLinux {
    desenhar() {
        return "Linux: Desenhando janela baseada no gerenciador de janelas atual.";
    }
}

// FABRICAS CONCRETAS
class FabricaWindows {
    criarBotao() {
        return new BotaoWindows();
    }
    criarJanela() {
        return new JanelaWindows();
    }
}

class FabricaMac {
    criarBotao() {
        return new BotaoMac();
    }
    criarJanela() {
        return new JanelaMac();
    }
}

class FabricaLinux {
    criarBotao() {
        return new BotaoLinux();
    }
    criarJanela() {
        return new JanelaLinux();
    }
}

// CLIENTE
class Main {
    static renderizarInterface(fabrica) {
        const botao = fabrica.criarBotao();
        const janela = fabrica.criarJanela();

        console.log(janela.desenhar());
        console.log(botao.renderizar());
    }

    static rodar() {
        console.log("### SISTEMA OPERACIONAL: WINDOWS ###");
        Main.renderizarInterface(new FabricaWindows());
        console.log("\n*************************\n");
        console.log("### SISTEMA OPERACIONAL: MAC ###");
        Main.renderizarInterface(new FabricaMac());
        console.log("\n*************************\n");
        console.log("### SISTEMA OPERACIONAL: LINUX ###");
        Main.renderizarInterface(new FabricaLinux());
    }
}

// Execução
Main.rodar();