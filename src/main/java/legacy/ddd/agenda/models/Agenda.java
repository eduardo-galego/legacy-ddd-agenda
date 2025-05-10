package legacy.ddd.agenda.models;

import java.time.LocalDateTime;

public class Agenda {

    private Integer idAgenda;
    private LocalDateTime horario;
    private Boolean ocupado;
    private Local local;
    private Servico servico;
    private Cidadao cidadao;

    public Agenda() {
    }

    public Agenda(Integer idAgenda, LocalDateTime horario, Boolean ocupado, Local local) {
        this.idAgenda = idAgenda;
        this.horario = horario;
        this.ocupado = ocupado;
        this.local = local;
    }

    public Integer getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(Integer idAgenda) {
        this.idAgenda = idAgenda;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public Boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(Boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Cidadao getCidadao() {
        return cidadao;
    }

    public void setCidadao(Cidadao cidadao) {
        this.cidadao = cidadao;
    }
}
