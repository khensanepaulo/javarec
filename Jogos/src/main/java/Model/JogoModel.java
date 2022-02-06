package Model;

public class JogoModel {
    private int idJogo;
    private int idCategoria;
    private int idEmpresa;
    private String nomeJogo;


    public JogoModel() {
    }

    public JogoModel(int idJogo, int idCategoria, int idEmpresa, String nomeJogo) {
        this.idJogo = idJogo;
        this.idCategoria = idCategoria;
        this.idEmpresa = idEmpresa;
        this.nomeJogo = nomeJogo;
    }

    public int getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNomeJogo() {
        return nomeJogo;
    }

    public void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }
}

