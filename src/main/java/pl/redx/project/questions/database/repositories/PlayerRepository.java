package pl.redx.project.questions.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.redx.project.questions.database.entities.PlayerEntity;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
}
