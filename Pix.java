import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pix extends Pagamento implements Estornavel {

    public Pix(String idTransacao, double valor, LocalDate data) {
        super(idTransacao, valor, data);
    }

    // todo: Pix não tem taxa de processamento — retorne 0.0
    @Override
    public double calcularTaxa() {
        return 0.0;
    }

    // todo: imprima uma mensagem confirmando que o Pix foi recebido/confirmado
    @Override
    public void enviarNotificacao() {
        System.out.println("Pix Confirmado");
    }

    // todo: Pix só pode ser estornado em até 90 dias após a data do pagamento.
    // Compare getData() com LocalDate.now() usando ChronoUnit.DAYS ou Period.
    @Override
    public boolean estornar() {
        long dias = ChronoUnit.DAYS.between(getData(), LocalDate.now());
        if (dias >= 0 && dias <= 90)
            return true;
        else 
            return false;
    }
}
