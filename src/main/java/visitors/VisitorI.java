package visitors;

import elements.Alcoolico;
import elements.Alimento;
import elements.Eletronico;

public interface VisitorI {
    void visit (Alimento alimento);
    void visit (Alcoolico alcoolico);
    void visit (Eletronico eletronico);
}
