package elements;

import visitors.Visitor;

public interface Produto {
    void aceitar(Visitor visitor);
}
