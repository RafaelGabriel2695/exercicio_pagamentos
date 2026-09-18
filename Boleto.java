import java.time.LocalDate;

// Repare: Boleto NÃO implementa Estornavel — depois de compensado, não há como estornar.
// Isso é proposital: mostra que interfaces são contratos opcionais por subclasse,
// diferente de um método herdado da classe abstrata (que toda subclasse carrega).
public class Boleto extends Pagamento {

    public static final double TAXA_FIXA = 3.49;

    public Boleto(String idTransacao, double valor, LocalDate data) {
        super(idTransacao, valor, data);
    }

    // todo: taxa fixa de R$ 3,49
    @Override
    public double calcularTaxa() {
        return TAXA_FIXA;
    }

    // todo: imprima uma mensagem confirmando que o boleto foi gerado
    @Override
    public void enviarNotificacao() {
        System.out.println("O boleto foi gerado");
    }
}
