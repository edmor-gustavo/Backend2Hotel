package eg.com.hottelbackend2.repository;

import eg.com.hottelbackend2.entity.Pacote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacoteRepository extends JpaRepository<Pacote, Long> {
}

