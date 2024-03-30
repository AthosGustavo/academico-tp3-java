package faculdade.infnet.academico.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private Double salario;

    @Column
    private String titulo;

    @ManyToOne
    @JoinColumn(name="escola_id", nullable=false)
    @JsonBackReference
    private Escola escola;
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

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }
}