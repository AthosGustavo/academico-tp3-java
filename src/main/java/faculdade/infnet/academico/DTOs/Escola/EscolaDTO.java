package faculdade.infnet.academico.DTOs.Escola;

import faculdade.infnet.academico.Model.Endereco;
import faculdade.infnet.academico.Model.Professor;

import java.util.List;

public record EscolaDTO(String nome, String email, Endereco endereco, List<Professor> professores) {
}