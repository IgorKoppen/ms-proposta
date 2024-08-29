package github.com.Igorkoppen.ms_proposta.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.Objects;

public class UserDTO {

    private Long id;
    @NotBlank(message = "O campo 'Nome' é obrigatório. Por favor, preencha o nome.")
    private String nome;

    @NotBlank(message = "O campo 'Sobrenome' é obrigatório. Por favor, preencha o sobrenome.")
    private String sobrenome;

    @NotBlank(message = "O campo 'CPF' é obrigatório. Por favor, preencha o CPF.")
    private String cpf;

    @NotBlank(message = "O campo 'Telefone' é obrigatório. Por favor, preencha o número de telefone.")
    private String telefone;

    @NotNull(message = "O campo 'Renda' é obrigatório. Por favor, informe a renda.")
    @Positive(message = "O valor da 'Renda' deve ser positivo. Insira um valor maior que zero.")
    private BigDecimal renda;

    public UserDTO(Long id, String nome, String sobrenome, String cpf, String telefone, BigDecimal renda) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.renda = renda;
    }

    public UserDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDTO userDTO)) return false;
        return Objects.equals(id, userDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
