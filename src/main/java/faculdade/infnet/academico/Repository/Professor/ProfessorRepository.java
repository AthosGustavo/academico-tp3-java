package faculdade.infnet.academico.Repository.Professor;

import faculdade.infnet.academico.Model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}