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
            @NotBlank(message = "제목을 입력하세요.")
            @Size(min = 3, message = "제목은 세 글자 이상 입력하십시오.")
            String title,

            @NotBlank(message = "본문을 입력하세요.")
            @Size(min = 3, message = "본문은 세 글자 이상 입력하십시오.")
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
