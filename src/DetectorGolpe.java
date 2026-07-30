import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
public class DetectorGolpe {
        public static void main(String[] args) {
            List<String> listaSuspeitas = new ArrayList<>();
            listaSuspeitas.add("hack");
            listaSuspeitas.add("virus");
            listaSuspeitas.add("senha");
            listaSuspeitas.add("cartao");
            listaSuspeitas.add("fraude");
            listaSuspeitas.add("phishing");
            listaSuspeitas.add("pix");

            // busca  rápida
            Set<String> conjuntoSuspeito = new HashSet<>(listaSuspeitas);

            Scanner scanner = new Scanner(System.in);
            System.out.println("=== SISTEMA DE DETECÇÃO DE CONTEÚDO SUSPEITO ===");
            System.out.println("Digite seu texto para análise (ou 'sair' para encerrar):\n");

            while (true) {
                System.out.print("> ");
                String entradaUsuario = scanner.nextLine();

                // encerrar o programa
                if (entradaUsuario.equalsIgnoreCase("sair")) {
                    System.out.println("Sistema encerrado.");
                    break;
                }
                // Analisa a entrada do usuário
                Set<String> encontradas = analisarTexto(entradaUsuario, conjuntoSuspeito);

                // Retorna o resultado
                if (!encontradas.isEmpty()) {
                    System.out.println("ALERTA: Conteúdo SUSPEITO detectado!");
                    System.out.println("Palavras identificadas: " + encontradas + "\n");
                } else {
                    System.out.println("Conteúdo SEGURO (nenhum termo suspeito encontrado).\n");
                }
            }

            scanner.close();
        }

        /* Limpa a frase digitada, divide em palavras e compara com a lista suspeita.
         */
        private static Set<String> analisarTexto(String texto, Set<String> listaSuspeita) {
            Set<String> detectadas = new HashSet<>();

            // 1. Remove acentos/pontuações e passa tudo para minúsculo
            String textoLimpo = texto.toLowerCase()
                    .replaceAll("[^a-zA-Záàâãéèêíïóôõöúçñ0-9\\s]", "");

            // 2. Separa a frase palavra por palavra
            String[] palavras = textoLimpo.split("\\s+");

            // 3. Verifica cada palavra digitada contra a lista suspeita
            for (String palavra : palavras) {
                if (listaSuspeita.contains(palavra)) {
                    detectadas.add(palavra);
                }
            }

            return detectadas;
        }
    }
//metodo para ignorar acentos:
/*Collator comparador inteligente = Collator.getInstance(new Locale("pt", "BR"));
        // PRIMARY ignora acentos (ex: 'á' vira 'a') e ignora maiúsculas/minúsculas
        comparadorInteligente.setStrength(Collator.PRIMARY);

boolean encontrada = false;
String palavraOriginal = "";

// 4. Varredura da lista usando o comparador
        for (String palavraLista : listaDePalavras) {
        // compare() retorna 0 se as palavras forem equivalentes
        if (comparadorInteligente.compare(palavraLista, entradaUsuario) == 0) {
encontrada = true;
palavraOriginal = palavraLista;
                break;
                        }
                        }

                        // 5. Resultado
                        if (encontrada) {
        System.out.println("Palavra identificada: " + palavraOriginal);
        } else {
                System.out.println("Palavra não encontrada.");
        }

                scanner.close();
    }
}*/
