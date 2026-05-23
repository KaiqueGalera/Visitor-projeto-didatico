package visitors;

import elements.Alcoolicos;
import elements.Alimento;
import elements.Eletronico;
import elements.Livro;

public interface Visitor {
    void visit (Livro livro);
    void visit (Alimento alimento);
    void visit (Alcoolicos alcoolicos);
    void visit (Eletronico eletronico);
}
