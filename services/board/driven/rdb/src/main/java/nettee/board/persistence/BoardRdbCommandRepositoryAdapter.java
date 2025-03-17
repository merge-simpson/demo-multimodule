package nettee.board.persistence;

import lombok.RequiredArgsConstructor;
import nettee.board.application.port.BoardCommandRepositoryPort;
import nettee.board.domain.Board;
import nettee.board.persistence.mapper.BoardEntityMapper;
import nettee.board.persistence.repository.BoardJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BoardRdbCommandRepositoryAdapter implements BoardCommandRepositoryPort {

    private final BoardJpaRepository boardJpaRepository;
    private final BoardEntityMapper mapper;

    @Override
    public Board save(Board board) {
        var entity = mapper.toEntity(board);
        return mapper.toDomain(boardJpaRepository.save(entity));
    }
}
