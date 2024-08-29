package github.com.Igorkoppen.ms_proposta.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.Objects;

public class PropostaCadastroDTO {

    private Long id;
    @NotNull(message = "O campo 'User' é obrigatório. Por favor, forneça os dados do usuário.")
    private @Valid UserDTO user;

    @NotNull(message = "O campo 'Valor Solicitado' é obrigatório. Por favor, insira um valor.")
    @Positive(message = "O 'Valor Solicitado' deve ser positivo. Insira um valor maior que zero.")
    private BigDecimal valorSolicitado;

    @NotNull(message = "O campo 'Prazo para Pagamento' é obrigatório. Por favor, insira o prazo em meses.")
    @Positive(message = "O 'Prazo para Pagamento' deve ser positivo. Insira um prazo maior que zero.")
    private Integer prazoParaPagamento;

    public PropostaCadastroDTO(Long id, UserDTO user, BigDecimal valorSolicitado, Integer prazoParaPagamento) {
        this.id = id;
        this.user = user;
        this.valorSolicitado = valorSolicitado;
        this.prazoParaPagamento = prazoParaPagamento;
    }


    public PropostaCadastroDTO() {
    }

    public Long getId() {
        return id;
    }

    public UserDTO getUser() {
        return user;
    }

    public BigDecimal getValorSolicitado() {
        return valorSolicitado;
    }

    public Integer getPrazoParaPagamento() {
        return prazoParaPagamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PropostaCadastroDTO that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
