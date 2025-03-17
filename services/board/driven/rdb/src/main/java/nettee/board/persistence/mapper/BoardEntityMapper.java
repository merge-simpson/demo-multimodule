package nettee.board.persistence.mapper;

import nettee.board.persistence.entity.BoardEntity;
import nettee.board.domain.Board;
import nettee.board.readmodel.BoardReadModels.BoardDetail;
import nettee.board.readmodel.BoardReadModels.BoardSummary;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoardEntityMapper {

    Board toDomain(BoardEntity boardEntity);

    BoardEntity toEntity(Board board);

    BoardDetail toDetail(BoardEntity boardEntity);

    BoardSummary toSummary(BoardEntity boardEntity);

}
