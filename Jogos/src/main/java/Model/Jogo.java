package Model;

public class Jogo {
    private int idJogo;
    private String nomeJogo;
    private String categoriaJogo;
    private String empresaPertencente;

    public Jogo() {
    }

    public Jogo(int idJogo, String nomeJogo, String categoriaJogo, String empresaPertencente) {
        this.idJogo = idJogo;
        this.nomeJogo = nomeJogo;
        this.categoriaJogo = categoriaJogo;
        this.empresaPertencente = empresaPertencente;
    }

    public int getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public String getNomeJogo() {
        return nomeJogo;
    }

    public void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }

    public String getCategoriaJogo() {
        return categoriaJogo;
    }

    public void setCategoriaJogo(String categoriaJogo) {
        this.categoriaJogo = categoriaJogo;
    }

    public String getEmpresaPertencente() {
        return empresaPertencente;
    }

    public void setEmpresaPertencente(String empresaPertencente) {
        this.empresaPertencente = empresaPertencente;
    }
}

