package repository;

import entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CarroRepository extends JpaRepository<Carro, Long> {
    Optional<Carro> findById(long id);
}
