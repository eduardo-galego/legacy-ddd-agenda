package legacy.ddd.agenda.models;

import java.util.Objects;

public class Orgao {

    private Integer idOrgao;
    private String descricao;

    public Orgao() {
    }

    public Orgao(Integer idOrgao, String descricao) {
        this.idOrgao = idOrgao;
        this.descricao = descricao;
    }

    public Integer getIdOrgao() {
        return idOrgao;
    }

    public void setIdOrgao(Integer idOrgao) {
        this.idOrgao = idOrgao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
