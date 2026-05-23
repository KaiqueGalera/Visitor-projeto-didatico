package visitors;

import elements.Alcoolico;
import elements.Alimento;
import elements.Eletronico;
import elements.Livro;

public interface Visitor {
    void visit (Livro livro);
    void visit (Alimento alimento);
    void visit (Alcoolico alcoolico);
    void visit (Eletronico eletronico);
}
