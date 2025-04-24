package repository;

import entity.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VendendorRepository extends JpaRepository<Vendedor, Long> {
    Optional<Vendedor> findById(long id);
}

