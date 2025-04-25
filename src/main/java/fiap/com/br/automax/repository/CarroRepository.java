package fiap.com.br.automax.repository;

import fiap.com.br.automax.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarroRepository extends JpaRepository<Carro, Long> {
    Optional<Carro> findById(long id);
}
