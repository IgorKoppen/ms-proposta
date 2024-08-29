package github.com.Igorkoppen.ms_proposta.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

/*
* Integrante:
* Nome: Igor Koppen Pasqualino Pereira
* Rm: 93507
* */
@Entity
@Table(name = "tb_proposta")
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal valorSolicitado;

    @Column(nullable = false)
    private Integer prazoParaPagamento;

    private Boolean aprovado;


    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public Proposta(Long id, BigDecimal valorSolicitado, Integer prazoParaPagamento, Boolean aprovado, User user) {
        this.id = id;
        this.valorSolicitado = valorSolicitado;
        this.prazoParaPagamento = prazoParaPagamento;
        this.aprovado = aprovado;
        this.user = user;
    }

    public Proposta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValorSolicitado() {
        return valorSolicitado;
    }

    public void setValorSolicitado(BigDecimal valorSolicitado) {
        this.valorSolicitado = valorSolicitado;
    }

    public Integer getPrazoParaPagamento() {
        return prazoParaPagamento;
    }

    public void setPrazoParaPagamento(Integer prazoParaPagamento) {
        this.prazoParaPagamento = prazoParaPagamento;
    }

    public Boolean getAprovado() {
        return aprovado;
    }

    public void setAprovado(Boolean aprovado) {
        this.aprovado = aprovado;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Proposta proposta)) return false;
        return Objects.equals(id, proposta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
