import java.util.Set;

public class RegraUrgencia implements RegraSuspeita {
    private Set<String> palavraChave = Set.of(
            "urgente",
            "agora",
            "imediatamente",
            "bloqueada",
            "bloqueado"
    );

    public static void main(String[] args) {
        RegraUrgencia regra = new RegraUrgencia();

        String mensagem1 = "responda agora";
        String mensagem2 = "bom dia, tudo bem?";

        System.out.println(mensagem1 + " -> suspeita? " + regra.verificar(mensagem1));
        System.out.println(mensagem2 + " -> suspeita? " + regra.verificar(mensagem2));
    }
    @Override
    public boolean verificar(String mensagemLimpa) {

        String[] palavras = mensagemLimpa.split("\\s+");

        for (String palavra : palavras) {
            if (palavraChave.contains(palavra)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String getNomeRegra() {
        return "Urgência";
    }
}