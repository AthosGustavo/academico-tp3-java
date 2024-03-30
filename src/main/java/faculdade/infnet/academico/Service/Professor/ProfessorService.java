package faculdade.infnet.academico.Service.Professor;

import faculdade.infnet.academico.Exceptions.ResourceNotFoundException;
import faculdade.infnet.academico.Model.Escola;
import faculdade.infnet.academico.Model.Professor;
import faculdade.infnet.academico.Repository.Escola.EscolaRepository;
import faculdade.infnet.academico.Repository.Professor.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

  @Autowired
  private EscolaRepository escolaRepository;

  @Autowired
  private ProfessorRepository professorRepository;

  public List<Professor> getProfessoresByEscolaId(Long id) {
    Escola escola = escolaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Escola", "id", id));
    return escola.getProfessores();
  }

  public void deleteProfessor(Long escolaId, Long professorId) {
    Escola escola = escolaRepository.findById(escolaId).orElse(null);
    if (escola != null) {
      escola.getProfessores().removeIf(professor -> professor.getId().equals(professorId));
      escolaRepository.save(escola);
      professorRepository.deleteById(professorId);
    }
  }
}