package legacy.ddd.agenda.repositories;

import legacy.ddd.agenda.models.Agenda;
import legacy.ddd.agenda.models.Local;
import legacy.ddd.agenda.models.Orgao;
import legacy.ddd.agenda.models.Servico;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FakeRepo {

    private static final List<Orgao> ORGAO_LIST = new ArrayList<>();
    private static final List<Local> LOCAL_LIST = new ArrayList<>();
    private static final List<Servico> SERVICO_LIST = new ArrayList<>();
    private static final List<Agenda> AGENDA_LIST = new ArrayList<>();

    static {
        final Orgao iirgd = new Orgao(1, "IIRGD");
        ORGAO_LIST.add(iirgd);

        final Orgao detran = new Orgao(2, "DETRAN");
        ORGAO_LIST.add(detran);

        LOCAL_LIST.add(new Local(1, "Poupatempo Luz", "", iirgd));
        LOCAL_LIST.add(new Local(2, "Poupatempo Santo Amaro", "", iirgd));
        LOCAL_LIST.add(new Local(3, "Poupatempo Itaquera", "", iirgd));
        LOCAL_LIST.add(new Local(4, "Detran Armenia", "", detran));
        LOCAL_LIST.add(new Local(5, "Detran Villa Lobos", "", detran));

        SERVICO_LIST.add(new Servico(1, "Emissao RG", iirgd));
        SERVICO_LIST.add(new Servico(2, "Emissao de AAC", iirgd));
        SERVICO_LIST.add(new Servico(3, "Renovacao de CNH", detran));

        for (Local local : LOCAL_LIST) {
            criarGradeHorarios(local);
        }
    }

    private static void criarGradeHorarios(Local local) {
        for (int d = 0; d <= 3; d++) {
            int id = 1;
            LocalDate date = LocalDate.now().plusDays(d);

            for (int h = 8; h <= 18; h++) {
                LocalDateTime time = date.atTime(h, 0, 0);
                AGENDA_LIST.add(new Agenda(id++, time, false, local));
            }
        }
    }

    public List<Orgao> listAllOrgao() {
        return ORGAO_LIST;
    }

    public List<Local> listAllLocal() {
        return LOCAL_LIST;
    }

    public List<Local> listLocalByOrgao(final Integer idOrgao) {
        return LOCAL_LIST.stream()
                .filter(local -> local.getOrgao().getIdOrgao().equals(idOrgao))
                .collect(Collectors.toList());
    }

    public Local findLocalById(final Integer idLocal) {
        return LOCAL_LIST.stream()
                .filter(local -> local.getIdLocal().equals(idLocal))
                .findFirst().orElse(null);
    }

    public List<Servico> listAllServico() {
        return SERVICO_LIST;
    }

    public List<Servico> listServicoByOrgao(final Integer idOrgao) {
        return SERVICO_LIST.stream()
                .filter(servico -> servico.getOrgao().getIdOrgao().equals(idOrgao))
                .collect(Collectors.toList());
    }

    public Servico findServicoById(final Integer idServico) {
        return SERVICO_LIST.stream()
                .filter(servico -> servico.getIdServico().equals(idServico))
                .findFirst().orElse(null);
    }

    public List<Agenda> listAllAgenda() {
        return AGENDA_LIST;
    }

    public List<Agenda> listAgendaByLocal(final Integer idLocal) {
        return AGENDA_LIST.stream()
                .filter(agenda -> agenda.getOcupado().equals(false)
                        && agenda.getLocal().getIdLocal().equals(idLocal))
                .collect(Collectors.toList());
    }

    public Agenda findAgendaById(final Integer idAgenda) {
        return AGENDA_LIST.stream()
                .filter(agenda -> agenda.getIdAgenda().equals(idAgenda))
                .findFirst().orElse(null);
    }

    public Agenda updateAgenda(final Agenda agenda) {
        Agenda agendaToUpdate = findAgendaById(agenda.getIdAgenda());
        if (agendaToUpdate != null) {
            agendaToUpdate.setCidadao(agenda.getCidadao());
            agendaToUpdate.setServico(agenda.getServico());
            agendaToUpdate.setOcupado(true);
        }
        return agendaToUpdate;
    }

}
