package visitante;

import pessoas.CariocaLocal;
import pessoas.Gringo;
import pessoas.TuristaBrasileiro;

public interface VisitanteI {
    void visita (Gringo p);
    void visita (TuristaBrasileiro p);
    void visita (CariocaLocal p);
}
