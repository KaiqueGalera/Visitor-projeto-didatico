package visitors;

import elements.AlcoolicoImpl;
import elements.AlimentoImpl;
import elements.EletronicoImpl;

public interface VisitorI {
    void visit (AlimentoImpl alimento);
    void visit (AlcoolicoImpl alcoolico);
    void visit (EletronicoImpl eletronico);
}
