package repository;

import entity.Vendendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VendendorRepository extends JpaRepository<Vendendor, Long> {
    Optional<Vendendor> findById(long id);
}

