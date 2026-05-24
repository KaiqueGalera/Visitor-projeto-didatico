package elements;

import visitors.VisitorI;

public interface ProdutoI {
    void aceitar(VisitorI visitor);
}
