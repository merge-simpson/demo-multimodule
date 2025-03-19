package nettee.board.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import nettee.board.domain.Board;

import static nettee.board.exception.BoardErrorCode.BOARD_CONTENT_LENGTH_MIN;
import static nettee.board.exception.BoardErrorCode.BOARD_TITLE_LENGTH_MIN;

public final class BoardCommandDto {

    private BoardCommandDto() {
    }

    @Builder
    public record BoardCreateCommand(
            @NotBlank(message = "{validation.board.title.notBlank}")
            @Size(min = 3, message = "{validation.board.title.size.min}")
            String title,

            @NotBlank(message = "{validation.board.content.notBlank}")
            @Size(min = 3, message = "{validation.board.content.size.min}")
            String content
    ) {
        // compact constructor
        public BoardCreateCommand { // 소괄호가 없는 생성자
            // 생성자 파라미터에 대한 검증, 전처리
            title = title.strip(); // trim()의 개선판
            content = content.strip(); // trim() 개선판

            if (title.length() < 3) {
                throw BOARD_TITLE_LENGTH_MIN.exception();
            }

            if (content.length() < 3) {
                throw BOARD_CONTENT_LENGTH_MIN.exception();
            }
        }
    }

    @Builder
    public record BoardCreateResponse(
            Board board
    ) {
    }
}
