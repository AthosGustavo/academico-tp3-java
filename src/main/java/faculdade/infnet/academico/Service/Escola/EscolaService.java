package faculdade.infnet.academico.Service.Escola;

import faculdade.infnet.academico.Model.Professor;
import faculdade.infnet.academico.DTOs.Escola.EscolaDTO;
import faculdade.infnet.academico.Model.Endereco;
import faculdade.infnet.academico.Model.Escola;
import faculdade.infnet.academico.Repository.Escola.EscolaRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscolaService {
    private final EscolaRepository escolaRepository;

    @Autowired
    public EscolaService(EscolaRepository escolaRepository) {
        this.escolaRepository = escolaRepository;
    }

//    public Escola saveEscola(Escola escola) {
//        return escolaRepository.save(escola);
//    }

    public void saveEscola(EscolaDTO escolaDTO){
        Escola escola = new Escola();

        escola.setNome(escolaDTO.nome());
        escola.setEmail(escolaDTO.email());

        String responseJson = ViaCepService.buscaCep(escolaDTO.endereco().getCep());
        String rua = "";
        String cidade = "";
        String estado = "";
        String bairro = "";

        try{
            JSONObject responseObject = new JSONObject(responseJson);
            rua = responseObject.getString("logradouro");
            bairro = responseObject.getString("bairro");
            cidade = responseObject.getString("localidade");
            estado = responseObject.getString("uf");
            Endereco endereco = new Endereco(rua, bairro, cidade, estado, escolaDTO.endereco().getCep());
            escola.setEndereco(endereco);
        }catch (JSONException ex){
            System.out.println(ex.getMessage());

        }


        List<Professor> professores = escolaDTO.professores();
        if(professores.isEmpty()){
            for (Professor professor : professores) {
                professor.setEscola(escola);
            }
            escola.setProfessores(professores);
        }

        escolaRepository.save(escola);
    }

    public List<Escola> getAllEscolas() {
        return escolaRepository.findAll();
    }

    public Escola getEscolaById(Long id) {
        return escolaRepository.findById(id).orElse(null);
    }

    public void deleteEscola(Long id) {
        escolaRepository.deleteById(id);
    }
}
