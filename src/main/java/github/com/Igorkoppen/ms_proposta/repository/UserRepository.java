package github.com.Igorkoppen.ms_proposta.repository;

import github.com.Igorkoppen.ms_proposta.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { }
