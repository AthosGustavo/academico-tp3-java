package faculdade.infnet.academico.DTOs.Endereco;




import faculdade.infnet.academico.Model.Endereco;

public record EnderecoDTO(String rua, String bairro, String cidade, String estado, String cep) {
  public EnderecoDTO(Endereco endereco) {
    this(endereco.getRua(), endereco.getBairro(), endereco.getCidade(), endereco.getEstado(), endereco.getCep());
  }
}