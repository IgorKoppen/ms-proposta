package github.com.Igorkoppen.ms_proposta.model;

import github.com.Igorkoppen.ms_proposta.dto.UserDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
 * Integrante:
 * Nome: Igor Koppen Pasqualino Pereira
 * Rm: 93507
 * */
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Column(nullable = false)
    private  String cpf;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private BigDecimal renda;

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "user")
    private List<Proposta> propostas = new ArrayList<>();


    public User(Long id, String nome, String sobrenome, String cpf, String telefone, BigDecimal renda, List<Proposta> propostas) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.renda = renda;
        this.propostas = propostas;
    }

    public User() {
    }

    public User(UserDTO dto) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.sobrenome = dto.getSobrenome();
        this.cpf = dto.getCpf();
        this.telefone = dto.getTelefone();
        this.renda = dto.getRenda();
    }

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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobreNome) {
        this.sobrenome = sobreNome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }

    public List<Proposta> getPropostas() {
        return propostas;
    }

    public void setPropostas(List<Proposta> propostas) {
        this.propostas = propostas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
