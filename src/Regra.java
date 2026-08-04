public class Regra {
    String nome;
    String[] palavrasChave;
    int pontos;
    String porQueAtencao;
    String falsoPositivo;

    public Regra(String nome, String[] palavrasChave, int pontos, String porQueAtencao, String falsoPositivo) {
        this.nome = nome;
        this.palavrasChave = palavrasChave;
        this.pontos = pontos;
        this.porQueAtencao = porQueAtencao;
        this.falsoPositivo = falsoPositivo;
    }
}
