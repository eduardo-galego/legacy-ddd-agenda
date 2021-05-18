package fiap.scjo.agenda.models;

public class Servico {

    private Integer idServico;
    private String descricao;
    private Orgao orgao;

    public Servico() {
    }

    public Servico(Integer idServico, String descricao, Orgao orgao) {
        this.idServico = idServico;
        this.descricao = descricao;
        this.orgao = orgao;
    }

    public Integer getIdServico() {
        return idServico;
    }

    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Orgao getOrgao() {
        return orgao;
    }

    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
    }
}
