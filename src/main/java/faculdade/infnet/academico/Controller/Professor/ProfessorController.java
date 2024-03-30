package faculdade.infnet.academico.Controller.Professor;

import faculdade.infnet.academico.Model.Professor;
import faculdade.infnet.academico.Service.Escola.EscolaService;
import faculdade.infnet.academico.Service.Professor.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

  @Autowired
  private ProfessorService professorService;

  @Autowired
  private EscolaService escolaService;

  @GetMapping("/escola/{id}")
  public List<Professor> getProfessoresByEscolaId(@PathVariable Long id) {
    return professorService.getProfessoresByEscolaId(id);
  }

  @DeleteMapping("/{escolaId}/professores/{professorId}")
  public ResponseEntity<Void> deleteProfessor(@PathVariable Long escolaId, @PathVariable Long professorId) {
    professorService.deleteProfessor(escolaId, professorId);
    return ResponseEntity.noContent().build();
  }

}