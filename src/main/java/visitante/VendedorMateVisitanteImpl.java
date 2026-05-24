package visitante;
                    
import pessoas.CariocaLocalImpl;
import pessoas.GringoImpl;
import pessoas.TuristaBrasileiroImpl;

public class VendedorMateVisitanteImpl implements VisitanteI {
    @Override
    public void visita(GringoImpl p) {
        System.out.println("Pra você consigo fazer por 30, chefe");
    }

    @Override
    public void visita(TuristaBrasileiroImpl p) {
        System.out.println("Não é daqui, cuidado pra não ficar de rolé a noite, o mate aqui é 20");
    }

    @Override
    public void visita(CariocaLocalImpl p) {
        System.out.println("Salve chará, hoje o movimento ta fraco, o mate ta saindo por 15");
    }
}
