package visitante;

import pessoas.CariocaLocalImpl;
import pessoas.GringoImpl;
import pessoas.TuristaBrasileiroImpl;

public interface VisitanteI {
    void visita (GringoImpl p);
    void visita (TuristaBrasileiroImpl p);
    void visita (CariocaLocalImpl p);
}
