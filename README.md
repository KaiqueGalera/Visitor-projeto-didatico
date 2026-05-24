# Visitor-projeto-didatico

Repositório didático utilizado na disciplina de **Análise e Projeto Orientado a Objetos (APOO)**
do IFSP Câmpus São Carlos, como material de apoio ao seminário sobre o padrão de projeto **Visitor**.

---

## Sobre este repositório

Este repositório possui **quatro branches**:

| Branch | Descrição |
|---|---|
| `produto_ex_errado` | Código **incompleto e problemático**, ponto de partida da refatoração em sala |
| `produto_ex_completo_correto` | Código **corrigido e completo** com o padrão Visitor aplicado corretamente |
| `produto_ex_incompleto` | Código **incompleto** com o padrão Visitor não aplicado |
| `projeto_didatico_visitor_vendedor_mate` | Código **corrigido e completo** do exemplo do Vendedor de Mate apresentado no seminário |

O objetivo é que, durante a aula, a turma refatore o código da `produto_ex_errado` **passo a passo** até chegar
na estrutura presente na branch `produto_ex_completo_correto`.

---

## O Problema: o que há de errado no código atual?

O código da branch `produto_ex_errado` possui uma interface `ProdutoI` com um método `calculateImposto()`.
Cada classe concreta (`Alcoolico`, `Alimento`, `Eletronico`) implementa esse método com sua própria lógica fiscal.

**Essa abordagem viola dois princípios fundamentais:**

- **SRP (Single Responsibility Principle):** as classes de produto acumulam responsabilidade
  de dados e de cálculo de negócio ao mesmo tempo.
- **OCP (Open/Closed Principle):** para adicionar uma nova operação (ex: calcular frete ou desconto),
  é necessário **abrir e modificar todas as classes** da hierarquia.

---

## A Solução: Padrão Visitor

O padrão **Visitor** resolve o problema separando as operações das estruturas de dados.

As classes de produto passam a ser apenas **Elements**: elas conhecem seus próprios dados
e sabem aceitar um visitante. Toda a lógica de negócio (imposto, frete, desconto) é movida
para classes **Visitor**, que são criadas de forma independente.

---

## Passo a Passo da Refatoração

### Passo 1 — Criar o pacote `elements`

Crie um novo pacote chamado `elements`. Todas as classes de produto serão movidas para ele.

```
src/main/java/
├── app/
├── elements/       ← criar aqui
└── visitors/       ← criar depois
```

---

### Passo 2 — Criar a interface `ProdutoI` no pacote `elements`

Remova o método `calculateImposto()` da interface antiga. A nova `ProdutoI` deve declarar
apenas o contrato do padrão Visitor: o método `aceitar`.

```java
// elements/ProdutoI.java
package elements;

import visitors.VisitorI;

public interface ProdutoI {
    void aceitar(VisitorI visitor);
}
```

> O método `aceitar` é o ponto de entrada do Double Dispatch. É por ele que o Visitor
> descobre o tipo concreto do Element em tempo de execução.

---

### Passo 3 — Refatorar as classes de produto

Para cada classe (`Alcoolico`, `Alimento`, `Eletronico`), faça o seguinte:

- Mova a classe para o pacote `elements`
- Atualize a declaração para implementar a nova interface `ProdutoI`
- **Remova** o método `calculateImposto()`
- **Adicione** o método `aceitar(VisitorI visitor)` chamando `visitor.visit(this)`

Exemplo completo para `Alimento`:

```java
// elements/Alimento.java
package elements;

import visitors.VisitorI;

public class Alimento implements ProdutoI {

    private final double price;
    private final String name;

    public Alimento(double price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public void aceitar(VisitorI visitor) {
        visitor.visit(this); // Double Dispatch: resolve visit(Alimento)
    }

    public double getPrice() { return price; }
    public String getName()  { return name;  }
}
```

Repita o mesmo processo para `Alcoolico` e `Eletronico`, alterando apenas o nome da classe.

---

### Passo 4 — Criar o pacote `visitors` e a interface `VisitorI`

A interface `VisitorI` declara um método `visit` sobrecarregado para cada tipo concreto de Element.
Esse é o contrato que todo Visitor concreto deve implementar.

```java
// visitors/VisitorI.java
package visitors;

import elements.Alcoolico;
import elements.Alimento;
import elements.Eletronico;

public interface VisitorI {
    void visit(Alimento  alimento);
    void visit(Alcoolico alcoolico);
    void visit(Eletronico eletronico);
}
```

---

### Passo 5 — Criar os Visitors concretos

Cada operação de negócio vira uma classe Visitor separada. Crie as três abaixo no pacote `visitors`.

**CalculadoraImpostoVisitor** — calcula o imposto por tipo de produto:

```java
// visitors/CalculadoraImpostoVisitor.java
package visitors;

import elements.Alcoolico;
import elements.Alimento;
import elements.Eletronico;

public class CalculadoraImpostoVisitor implements VisitorI {

    @Override
    public void visit(Alimento alimento) {
        double imposto = alimento.getPrice() * 0.2;
        System.out.println("Imposto (alimento) = " + imposto);
    }

    @Override
    public void visit(Eletronico eletronico) {
        double imposto = eletronico.getPrice() * 0.35;
        System.out.println("Imposto (eletronico) = " + imposto);
    }

    @Override
    public void visit(Alcoolico alcoolico) {
        double imposto = alcoolico.getPrice() * 0.5;
        System.out.println("Imposto (alcoolico) = " + imposto);
    }
}
```

**CalculadoraFreteVisitor** — calcula o frete por tipo de produto:

```java
// visitors/CalculadoraFreteVisitor.java
package visitors;

import elements.Alcoolico;
import elements.Alimento;
import elements.Eletronico;

public class CalculadoraFreteVisitor implements VisitorI {

    @Override
    public void visit(Alimento alimento) {
        System.out.println("Frete (alimento) = R$ 20,00");
    }

    @Override
    public void visit(Eletronico eletronico) {
        System.out.println("Frete (eletronico) = R$ 50,00");
    }

    @Override
    public void visit(Alcoolico alcoolico) {
        System.out.println("Frete (alcoolico) = R$ 15,00");
    }
}
```

**DescontoVisitor** — calcula o desconto por tipo de produto:

```java
// visitors/DescontoVisitor.java
package visitors;

import elements.Alcoolico;
import elements.Alimento;
import elements.Eletronico;

public class DescontoVisitor implements VisitorI {

    @Override
    public void visit(Alimento alimento) {
        double desconto = alimento.getPrice() * 0.35;
        System.out.println("Desconto (alimento) = " + desconto);
    }

    @Override
    public void visit(Alcoolico alcoolico) {
        double desconto = alcoolico.getPrice() * 0.1;
        System.out.println("Desconto (alcoolico) = " + desconto);
    }

    @Override
    public void visit(Eletronico eletronico) {
        double desconto = eletronico.getPrice() * 0.1;
        System.out.println("Desconto (eletronico) = " + desconto);
    }
}
```

---

### Passo 6 — Atualizar a classe `Main`

A classe `Main` agora instancia os Elements e aplica qualquer Visitor sobre eles.
Observe que a mesma lista de produtos recebe três Visitors distintos sem nenhuma modificação.

```java
// app/Main.java
package app;

import elements.Alcoolico;
import elements.Alimento;
import elements.Eletronico;
import elements.ProdutoI;
import visitors.CalculadoraFreteVisitor;
import visitors.CalculadoraImpostoVisitor;
import visitors.DescontoVisitor;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<ProdutoI> produtos = List.of(
            new Alimento(50.0, "Arroz"),
            new Eletronico(299.0, "Smartwatch"),
            new Alcoolico(35.0, "Cerveja")
        );

        System.out.println("=== Impostos ===");
        produtos.forEach(p -> p.aceitar(new CalculadoraImpostoVisitor()));

        System.out.println("\n=== Fretes ===");
        produtos.forEach(p -> p.aceitar(new CalculadoraFreteVisitor()));

        System.out.println("\n=== Descontos ===");
        produtos.forEach(p -> p.aceitar(new DescontoVisitor()));
    }
}
```

---

### Passo 7 — Deletar o código antigo

Remova as classes do pacote `produtos` (o pacote original com `calculateImposto()`).
Após a refatoração, elas não são mais utilizadas e não devem permanecer no projeto.

---

## Estrutura final esperada

```
src/main/java/
├── app/
│   └── Main.java
├── elements/
│   ├── ProdutoI.java
│   ├── Alimento.java
│   ├── Alcoolico.java
│   └── Eletronico.java
└── visitors/
    ├── VisitorI.java
    ├── CalculadoraImpostoVisitor.java
    ├── CalculadoraFreteVisitor.java
    └── DescontoVisitor.java
```

---

## O que mudou e por quê

| Antes | Depois |
|---|---|
| `calculateImposto()` dentro de cada produto | Lógica fiscal isolada em `CalculadoraImpostoVisitor` |
| Adicionar frete exigia modificar todas as classes | Basta criar `CalculadoraFreteVisitor` |
| Interface `ProdutoI` misturava dados e operação | Interface `ProdutoI` declara apenas `aceitar` |
| Violação de SRP e OCP | SRP e OCP satisfeitos |

---

## Referências

- GAMMA, E. et al. **Design Patterns: Elements of Reusable Object-Oriented Software**. Addison-Wesley, 1994.
- Material didático da disciplina APOO — Prof. Dr. Lucas Bueno R. Oliveira — IFSP Câmpus São Carlos.
