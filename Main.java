import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Pagamento> pagamentos = new ArrayList<>();
        pagamentos.add(new Pix("TX001", 150.00, LocalDate.of(2026, 3, 10)));
        pagamentos.add(new CartaoCredito("TX002", 899.90, LocalDate.of(2026, 3, 12), 6));
        pagamentos.add(new Boleto("TX003", 320.00, LocalDate.of(2026, 3, 5)));

        System.out.println("=== Todos os pagamentos (ordem de cadastro) ===");
        for (Pagamento p : pagamentos) {
            System.out.println(p);
            p.enviarNotificacao();
        }

        // todo 5: ordene a lista pela ordem natural (compareTo, definido em Pagamento)
        // usando Collections.sort(pagamentos) e imprima o resultado.

        Collections.sort(pagamentos);
        System.out.println("\nPagamentos ordenados por Valor Total (crescente)");
        for (Pagamento p : pagamentos) {
            System.out.println(p);
        }    
        // todo 6: crie um Comparator<Pagamento> que ordene por DATA (mais antigo primeiro)
        // e ordene a lista com ele. Duas formas possíveis:
        //   Collections.sort(pagamentos, comparator);
        //   pagamentos.sort(Comparator.comparing(Pagamento::getData));

        pagamentos.sort(Comparator.comparing(Pagamento::getData));
        System.out.println("\nPagamentos ordenados por Data (mais antigo primeiro)");
        for (Pagamento p : pagamentos) {
            System.out.println(p);
        }

        // todo 7: percorra a lista e, para cada pagamento que também for Estornavel,
        // chame estornar() e imprima o resultado (use "if (p instanceof Estornavel e) { ... }").
        
        System.out.println("\nTentativas de Estorno");
        for (Pagamento p : pagamentos) {
            if (p instanceof Estornavel e) {
                boolean sucesso = e.estornar();
                System.out.println(p.getIdTransacao() + " estornado: " + sucesso);
            }
        }
    }
}

