package github.com.Igorkoppen.ms_proposta.service;

import github.com.Igorkoppen.ms_proposta.dto.PropostaInfoDTO;
import github.com.Igorkoppen.ms_proposta.dto.PropostaCadastroDTO;
import github.com.Igorkoppen.ms_proposta.dto.UserDTO;
import github.com.Igorkoppen.ms_proposta.exception.ResourceNotFoundException;
import github.com.Igorkoppen.ms_proposta.model.Proposta;
import github.com.Igorkoppen.ms_proposta.model.User;
import github.com.Igorkoppen.ms_proposta.repository.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PropostaService {

    @Autowired
    private PropostaRepository propostaRepository;


    @Transactional(readOnly = true)
    public List<PropostaInfoDTO> findAll() {
          List<Proposta> propostas = propostaRepository.findAll();
          return propostas.stream().map(this::toDTOInfo).toList();
    }

    @Transactional(readOnly = true)
    public PropostaInfoDTO findById(Long id) {
       Proposta proposta = propostaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
       return toDTOInfo(proposta);
    }

    @Transactional
    public PropostaCadastroDTO insert(PropostaCadastroDTO dto) {
        Proposta proposta = new Proposta();
        User user = new User(dto.getUser());
        proposta.setAprovado(false);
        proposta.setValorSolicitado(dto.getValorSolicitado());
        proposta.setPrazoParaPagamento(dto.getPrazoParaPagamento());
        proposta.setUser(user);
        Proposta propostaSalva = propostaRepository.save(proposta);
        return toDTOCadastro(propostaSalva);

    }

    private PropostaCadastroDTO toDTOCadastro(Proposta proposta){
        User userOfProposta = proposta.getUser();
        UserDTO userDTO = new UserDTO(
                userOfProposta.getId(),
                userOfProposta.getNome(),
                userOfProposta.getSobrenome(),
                userOfProposta.getCpf(),
                userOfProposta.getTelefone(),
                userOfProposta.getRenda()
        );
        return new PropostaCadastroDTO(
                proposta.getId(),
                userDTO,
                proposta.getValorSolicitado(),
                proposta.getPrazoParaPagamento()
        );
    }

    private PropostaInfoDTO toDTOInfo(Proposta proposta) {
        return new PropostaInfoDTO(
                proposta.getId(),
                proposta.getValorSolicitado(),
                proposta.getPrazoParaPagamento(),
                proposta.getAprovado(),
                proposta.getUser().getId()
        );
    }
}
