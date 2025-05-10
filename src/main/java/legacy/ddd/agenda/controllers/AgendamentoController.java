package legacy.ddd.agenda.controllers;

import legacy.ddd.agenda.models.Agenda;
import legacy.ddd.agenda.models.Local;
import legacy.ddd.agenda.models.Orgao;
import legacy.ddd.agenda.repositories.FakeRepo;
import legacy.ddd.agenda.models.Cidadao;
import legacy.ddd.agenda.models.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class AgendamentoController {

    private final FakeRepo repo;

    @Autowired
    public AgendamentoController(FakeRepo repo) {
        this.repo = repo;
    }

    // Listar todos os orgaos
    @GetMapping("/orgaos")
    public List<Orgao> getAllOrgao() {
        return repo.listAllOrgao();
    }

    @GetMapping("/orgaos/{idOrgao}/locais")
    public List<Local> getLocalByOrgao(@PathVariable("idOrgao") Integer idOrgao) {
        return repo.listLocalByOrgao(idOrgao);
    }

    @GetMapping("/orgaos/{idOrgao}/locais/{idLocal}/servicos")
    public List<Servico> getServicoByOrgaoLocal(@PathVariable("idOrgao") Integer idOrgao,
                                                @PathVariable("idLocal") Integer idLocal) {
        return repo.listServicoByOrgao(idOrgao);
    }

    @GetMapping("/orgaos/{idOrgao}/locais/{idLocal}/servicos/{idServico}/horarios")
    public List<String> getHorariosByOrgaoLocalServico(@PathVariable("idOrgao") Integer idOrgao,
                                                       @PathVariable("idLocal") Integer idLocal,
                                                       @PathVariable("idServico") Integer idServico) {
        List<Agenda> agendas = repo.listAgendaByLocal(idLocal);
        return agendas.stream()
                .flatMap(agenda -> Stream.of(agenda.getHorario()
                        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))))
                .collect(Collectors.toList());
    }

    @PostMapping("/orgaos/{idOrgao}/locais/{idLocal}/servicos/{idServico}/horarios/{idAgenda}/agendar")
    public ResponseEntity<Agenda> getHorariosByOrgaoLocalServico(@PathVariable("idOrgao") Integer idOrgao,
                                                                 @PathVariable("idLocal") Integer idLocal,
                                                                 @PathVariable("idServico") Integer idServico,
                                                                 @PathVariable("idAgenda") Integer idAgenda,
                                                                 @RequestBody Cidadao cidadao) {
        Agenda agenda = repo.findAgendaById(idAgenda);
        if (agenda == null) {
            return ResponseEntity.notFound().build();
        }

        if (agenda.getOcupado()) {
            return ResponseEntity.badRequest().build();
        }

        Local local = repo.findLocalById(idLocal);
        if (local == null) {
            return ResponseEntity.notFound().build();
        }

        Servico servico = repo.findServicoById(idServico);
        if (servico == null) {
            return ResponseEntity.notFound().build();
        }

        agenda.setLocal(local);
        agenda.setCidadao(cidadao);
        agenda.setServico(servico);
        Agenda agendaUpdated = repo.updateAgenda(agenda);
        if (agendaUpdated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(agendaUpdated);
    }


    // Listar locais por orgao

    // Listar servicos por orgao

    // Listar horarios por local

    // Listar todos os Locais

    // Listar serviços por local

    // Listar todos os servicos

    // Listar data por serviço

    // Listar local por data

}
