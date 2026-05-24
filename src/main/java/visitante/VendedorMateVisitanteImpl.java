package visitante;
                    
import pessoas.CariocaLocal;
import pessoas.Gringo;
import pessoas.TuristaBrasileiro;

public class VendedorMateVisitanteImpl implements VisitanteI {
    @Override
    public void visita(Gringo p) {
        System.out.println("Pra você consigo fazer por 30, chefe");
    }

    @Override
    public void visita(TuristaBrasileiro p) {
        System.out.println("Não é daqui, cuidado pra não ficar de rolé a noite, o mate aqui é 20");
    }

    @Override
    public void visita(CariocaLocal p) {
        System.out.println("Salve chará, hoje o movimento ta fraco, o mate ta saindo por 15");
    }
}
