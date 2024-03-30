package faculdade.infnet.academico.Model;

import jakarta.persistence.*;


@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String rua;

    private String bairro;
    @Column
    private String cidade;

    @Column
    private String estado;

    @Column
    private String cep;

  public Endereco(String rua, String bairro, String cidade, String estado, String cep) {
    this.rua = rua;
    this.cidade = cidade;
    this.estado = estado;
    this.cep = cep;
  }

  public Endereco(){}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRua() {
    return rua;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return estado;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }
}
