package github.com.Igorkoppen.ms_proposta.repository;

import github.com.Igorkoppen.ms_proposta.model.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long> { }
