# Sistema de Gerenciamento de Alunos

**Aluno:** Guilherme dos Santos Silva

## 📌 Descrição

Este projeto implementa um sistema simples de gerenciamento de alunos utilizando dois padrões de projeto importantes:

* **Prototype (Protótipo):** permite a criação de novos objetos a partir de um modelo existente, evitando a repetição de código.
* **Singleton:** garante que exista apenas uma única instância do gerenciador de alunos durante toda a execução do sistema.

## ⚙️ Funcionamento

O sistema possui duas classes principais:

### 👨‍🎓 Classe Aluno

Representa um aluno com os atributos:

* Nome
* Idade
* Curso
* Unidade
* Período

Ela contém um método `clone()` que permite criar cópias de um aluno base (protótipo), facilitando a criação de novos alunos com características semelhantes.

### 🏫 Classe GerenciadorAlunos

Responsável por gerenciar a lista de alunos matriculados.

* Implementa o padrão **Singleton**, garantindo que todas as operações utilizem a mesma instância.
* Permite:

  * Adicionar alunos
  * Listar alunos matriculados

## 🔄 Fluxo do Sistema

1. Um aluno protótipo é criado com valores padrão.
2. Novos alunos são gerados a partir desse protótipo utilizando o método `clone()`.
3. Os dados específicos (nome e idade) são ajustados.
4. Os alunos são adicionados ao gerenciador.
5. A lista de alunos matriculados é exibida.
6. É feita uma verificação para garantir que o protótipo original não foi alterado.

## ✅ Objetivo

Demonstrar, de forma prática, a aplicação dos padrões de projeto **Prototype** e **Singleton** em diferentes linguagens de programação.
