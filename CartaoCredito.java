import java.time.LocalDate;

public class CartaoCredito extends Pagamento implements Estornavel {

    private final int parcelas;

    public CartaoCredito(String idTransacao, double valor, LocalDate data, int parcelas) {
        super(idTransacao, valor, data);
        this.parcelas = parcelas;
    }

    public int getParcelas() {
        return parcelas;
    }

    // todo: taxa de 3,5% sobre o valor, mais R$ 0,50 por parcela além da 1ª
    @Override
    public double calcularTaxa() {
        double calculoTaxa = (getValor() * 0.035) + 0.50 * (parcelas-1);
        return calculoTaxa;
    }

    // todo: imprima uma mensagem informando o número de parcelas
    @Override
    public void enviarNotificacao() {
        System.out.println("Número de parcelas: " + getParcelas());
    }

    // todo: cartão de crédito sempre pode ser estornado — retorne true
    @Override
    public boolean estornar() {
        return true;
    }
}
