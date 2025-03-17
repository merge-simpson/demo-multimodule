package nettee.board.persistence.repository;

import nettee.board.persistence.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardCommandJpaRepository extends JpaRepository<BoardEntity, Long> {

}