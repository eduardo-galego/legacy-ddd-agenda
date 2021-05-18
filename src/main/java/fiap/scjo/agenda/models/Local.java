package fiap.scjo.agenda.models;

public class Local {

    private Integer idLocal;
    private String descricao;
    private String endereço;
    private Orgao orgao;

    public Local() {
    }

    public Local(Integer idLocal, String descricao, String endereço, Orgao orgao) {
        this.idLocal = idLocal;
        this.descricao = descricao;
        this.endereço = endereço;
        this.orgao = orgao;
    }

    public Integer getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public Orgao getOrgao() {
        return orgao;
    }

    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
    }


}
