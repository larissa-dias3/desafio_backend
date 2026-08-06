public class Regra {
    private String nome;
    private String[] palavrasChave;
    private int pontos;
    private String porQueAtencao;
    private String falsoPositivo;

    public Regra(String nome, String[] palavrasChave, int pontos, String porQueAtencao, String falsoPositivo) {
        this.nome = nome;
        this.palavrasChave = palavrasChave;
        this.pontos = pontos;
        this.porQueAtencao = porQueAtencao;
        this.falsoPositivo = falsoPositivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String[] getPalavrasChave() {
        return palavrasChave;
    }

    public void setPalavrasChave(String[] palavrasChave) {
        this.palavrasChave = palavrasChave;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public String getPorQueAtencao() {
        return porQueAtencao;
    }

    public void setPorQueAtencao(String porQueAtencao) {
        this.porQueAtencao = porQueAtencao;
    }

    public String getFalsoPositivo() {
        return falsoPositivo;
    }

    public void setFalsoPositivo(String falsoPositivo) {
        this.falsoPositivo = falsoPositivo;
    }
}
