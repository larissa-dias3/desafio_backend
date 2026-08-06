import java.text.Normalizer;
import java.util.Scanner;

public class DetectorGolpe {
    // remove acentos e converte para minúsculas
    private static String normalizarTexto(String texto) {
        if (texto == null) return "";
        String semAcentos = Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
        return semAcentos.toLowerCase();
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        // Criando a lista de regras
        Regra[] regras = {
                new Regra(
                        "Senso de Urgência",
                        new String[]{"urgente", "bloquead", "suspens", "agora", "imediatamente", "expira"},
                        20,
                        "Golpistas usam pressão para impedir que a vítima pense antes de agir.",
                        "Algumas empresas realmente enviam avisos urgentes sobre problemas na conta."
                ),
                new Regra(
                        "Links Desconhecidos ou Encurtados",
                        new String[]{"http://", "https://", "www.", "bit.ly", "tinyurl"},
                        20,
                        "O link pode direcionar para sites falsos ou instalar programas maliciosos.",
                        "O link pode ser legítimo, mas deve ser verificado antes de clicar."
                ),
                new Regra(
                        "Promessa de Prêmios ou Dinheiro",
                        new String[]{"premio", "prêmio", "brinde", "sorteio", "ganhou", "resgate"},
                        15,
                        "Ofertas muito vantajosas são comuns em golpes para atrair vítimas.",
                        "Promoções reais existem; confirme sempre no site oficial."
                ),
                new Regra(
                        "Solicitação de Dados Pessoais",
                        new String[]{"cpf", "cartao", "cartão", "senha", "cvv", "confirmar dados"},
                        25,
                        "Essas informações podem ser usadas para fraude ou roubo de identidade.",
                        "Bancos ou empresas podem solicitar alguns dados apenas em canais oficiais."
                ),
                new Regra(
                        "Pedido de PIX ou Transferência",
                        new String[]{"pix", "transferencia", "transferência", "deposito", "depósito", "pagamento"},
                        20,
                        "É uma estratégia muito comum em golpes financeiros diretos.",
                        "O pedido pode ser verdadeiro, mas deve ser confirmado por outro meio."
                ),
                new Regra(
                        "Arquivos ou Aplicativos para Baixar",
                        new String[]{"baixar", "download", ".apk", ".exe", "arquivo", "anexo"},
                        25,
                        "O arquivo pode conter vírus ou programas maliciosos.",
                        "Verifique a fonte antes de abrir qualquer arquivo recebido."
                )
        };

        System.out.println("=======================================");
        System.out.println("DETECTOR DE GOLPES");
        System.out.println("=======================================");
        System.out.println("Digite 'sair' para encerrar o programa.");

        while (true) {
            System.out.print("\nCole a mensagem para análise: ");
            String mensagem = leitor.nextLine();

            if (mensagem.equalsIgnoreCase("sair")) {
                System.out.println("Programa encerrado.");
                break;
            }

            String textoTratado = normalizarTexto(mensagem);
            int nivelDeRisco = 0;
            boolean encontrouAlgumaRegra = false;

            System.out.println("\n----------------- RELATÓRIO DE ANÁLISE -----------------");

            // Avalia a mensagem contra cada uma das regras
            for (Regra regra : regras) {
                boolean regraViolada = false;

                for (String palavra : regra.getPalavrasChave()) {
                    if (textoTratado.contains(palavra)) {
                        regraViolada = true;
                        break;
                    }
                }

                if (regraViolada) {
                    encontrouAlgumaRegra = true;
                    nivelDeRisco += regra.getPontos();

                    System.out.println("\nALERTA: " + regra.getNome());
                    System.out.println("Por que atenção? " + regra.getPorQueAtencao());
                    System.out.println("Atenção à exceção: " + regra.getFalsoPositivo());
                }
            }

            // Limita o nível de risco a 100%
            if (nivelDeRisco > 100) nivelDeRisco = 100;

            System.out.println("\n--------------------------------------------------------");
            System.out.println("Pontuação de Risco Calculada: " + nivelDeRisco + "%");

            if (!encontrouAlgumaRegra) {
                System.out.println("Veredito: BAIXO RISCO - Nenhum padrão clássico de golpe detectado.");
            } else if (nivelDeRisco >= 50) {
                System.out.println("Veredito: ALTO RISCO - Fortes indícios de mensagem fraudulenta!");
            } else {
                System.out.println("Veredito: RISCO MÉDIO - Mensagem suspeita. Proceda com cautela.");
            }
            System.out.println("--------------------------------------------------------\n");
        }

        leitor.close();
    }
}