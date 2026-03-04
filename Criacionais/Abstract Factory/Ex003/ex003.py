# PRODUTOS ABSTRATOS
class Botao:
    def renderizar(self):
        pass

class Janela:
    def desenhar(self):
        pass

# PRODUTOS CONCRETOS - WINDOWS
class BotaoWindows:
    def renderizar(self):
        return "Windows: Renderizando botão retangular padrão."

class JanelaWindows:
    def desenhar(self):
        return "Windows: Desenhando janela com barra de título clássica."

# PRODUTOS CONCRETOS - MAC
class BotaoMac:
    def renderizar(self):
        return "Mac: Renderizando botão arredondado estilo Aqua."

class JanelaMac:
    def desenhar(self):
        return "Mac: Desenhando janela com botões de controle à esquerda."

# PRODUTOS CONCRETOS - LINUX
class BotaoLinux:
    def renderizar(self):
        return "Linux: Renderizando botão customizável estilo GTK."

class JanelaLinux:
    def desenhar(self):
        return "Linux: Desenhando janela baseada no gerenciador de janelas atual."

# FABRICA ABSTRATA
class FabricaGUI:
    def criar_botao(self):
        pass
    def criar_janela(self):
        pass

# FABRICAS CONCRETAS
class FabricaWindows:
    def criar_botao(self):
        return BotaoWindows()
    
    def criar_janela(self):
        return JanelaWindows()

class FabricaMac:
    def criar_botao(self):
        return BotaoMac()
    
    def criar_janela(self):
        return JanelaMac()

class FabricaLinux:
    def criar_botao(self):
        return BotaoLinux()
    
    def criar_janela(self):
        return JanelaLinux()

# CLIENTE
class Main:
    def renderizar_interface(fabrica):
        botao = fabrica.criar_botao()
        janela = fabrica.criar_janela()

        print(janela.desenhar())
        print(botao.renderizar())

if __name__ == "__main__":
    print("### SISTEMA OPERACIONAL: WINDOWS ###")
    Main.renderizar_interface(FabricaWindows())
    print("\n*************************\n")
    print("### SISTEMA OPERACIONAL: MAC ###")
    Main.renderizar_interface(FabricaMac())
    print("\n*************************\n")
    print("### SISTEMA OPERACIONAL: LINUX ###")
    Main.renderizar_interface(FabricaLinux())