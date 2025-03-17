package nettee.board.readmodel;

import lombok.Builder;
import nettee.board.domain.type.BoardStatus;

import java.time.Instant;

public final class BoardReadModels {

    private BoardReadModels() {}

    @Builder
    public record BoardDetail(
            String id,
            String title,
            String content,
            BoardStatus status,
            Instant createdAt,
            Instant updatedAt
    ) {
    }

    @Builder
    public record BoardSummary(
            String id,
            String title,
            BoardStatus status,
            Instant createdAt,
            Instant updatedAt
    ) {
    }
}
