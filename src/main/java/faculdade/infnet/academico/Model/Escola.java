package faculdade.infnet.academico.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Escola {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String nome;

  @Column
  private String email;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name="endereco_id", nullable=false)
  private Endereco endereco;

  @OneToMany(mappedBy = "escola", cascade = CascadeType.ALL)
  @JsonManagedReference
  private List<Professor> professores;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

  public List<Professor> getProfessores() {
    return professores;
  }

  public void setProfessores(List<Professor> professores) {
    this.professores = professores;
  }
}