package github.com.Igorkoppen.ms_proposta.service;

import github.com.Igorkoppen.ms_proposta.dto.UserDTO;
import github.com.Igorkoppen.ms_proposta.exception.DatabaseException;
import github.com.Igorkoppen.ms_proposta.exception.ResourceNotFoundException;
import github.com.Igorkoppen.ms_proposta.model.User;
import github.com.Igorkoppen.ms_proposta.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @Transactional(readOnly = true)
    public UserDTO findById(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return toDTO(user);
    }

    @Transactional(readOnly = true)
    public List<UserDTO> findAll(){
          List<User> users = userRepository.findAll();
          return users.stream().map(this::toDTO).toList();
    }

    @Transactional
    public UserDTO insert(UserDTO dto){
           User user = new User(dto);
           userRepository.save(user);
           return toDTO(user);
    }

    @Transactional
    public UserDTO update(Long id, UserDTO dto){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        user.setNome(dto.getNome());
        user.setSobrenome(dto.getSobrenome());
        user.setCpf(dto.getCpf());
        user.setTelefone(dto.getTelefone());
        user.setRenda(dto.getRenda());
        User savedUser = userRepository.save(user);
        return toDTO(savedUser);
    }

    @Transactional
    public void delete(Long id){
        if(!userRepository.existsById(id)){
            throw new ResourceNotFoundException(id);
        }
        try {
            userRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }

    }
    private UserDTO toDTO(User user){
        return new UserDTO(
                user.getId(),
                user.getNome(),
                user.getSobrenome(),
                user.getCpf(),
                user.getTelefone(),
                user.getRenda()
        );
    }
}
