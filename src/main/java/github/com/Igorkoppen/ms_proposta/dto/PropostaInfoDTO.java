package github.com.Igorkoppen.ms_proposta.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class PropostaInfoDTO {

    private Long id;

    private BigDecimal valorSolicitado;

    private Integer prazoParaPagamento;

    private Boolean aprovado;

    private Long userId;

    public PropostaInfoDTO(Long id, BigDecimal valorSolicitado, Integer prazoParaPagamento, Boolean aprovado, Long userId) {
        this.id = id;
        this.valorSolicitado = valorSolicitado;
        this.prazoParaPagamento = prazoParaPagamento;
        this.aprovado = aprovado;
        this.userId = userId;
    }

    public PropostaInfoDTO() {}

    public Long getId() {
        return id;
    }

    public BigDecimal getValorSolicitado() {
        return valorSolicitado;
    }

    public Integer getPrazoParaPagamento() {
        return prazoParaPagamento;
    }

    public Boolean getAprovado() {
        return aprovado;
    }

    public Long getUserId() {
        return userId;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PropostaInfoDTO that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
