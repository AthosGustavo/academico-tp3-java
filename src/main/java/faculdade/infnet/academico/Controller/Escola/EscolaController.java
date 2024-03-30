package faculdade.infnet.academico.Controller.Escola;

import faculdade.infnet.academico.DTOs.Escola.EscolaDTO;
import faculdade.infnet.academico.Model.Escola;
import faculdade.infnet.academico.Service.Escola.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escola")
public class EscolaController {
    private final EscolaService escolaService;

    @Autowired
    public EscolaController(EscolaService escolaService) {
        this.escolaService = escolaService;
    }

    @GetMapping
    public List<Escola> getAllEscolas() {
        return escolaService.getAllEscolas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Escola> getEscolaById(@PathVariable Long id) {
        Escola escola = escolaService.getEscolaById(id);
        if (escola == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(escola);
    }
    @PostMapping
    public void createEscola(@RequestBody EscolaDTO escolaDTO) {
        escolaService.saveEscola(escolaDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteEscola(@PathVariable Long id) {
        escolaService.deleteEscola(id);
    }


}


