package nettee.board.exception;

import letsdev.common.exception.support.ErrorCode;
import org.springframework.http.HttpStatus;

import java.util.Map;
import java.util.function.Supplier;

import static org.springframework.http.HttpStatus.*;

public enum BoardErrorCode implements ErrorCode {
    BOARD_ALREADY_EXISTS(HttpStatus.CONFLICT),
    BOARD_NOT_FOUND(HttpStatus.NOT_FOUND),
    BOARD_GONE(HttpStatus.GONE),
    BOARD_FORBIDDEN(HttpStatus.FORBIDDEN),
    BOARD_TITLE_LENGTH_MIN(HttpStatus.BAD_REQUEST),
    BOARD_CONTENT_LENGTH_MIN(HttpStatus.BAD_REQUEST),
    BOARD_DEFAULT(HttpStatus.INTERNAL_SERVER_ERROR);

    private static final String NAMESPACE = "board.error";

    private final String messageKey;
    private final HttpStatus status;

    BoardErrorCode(HttpStatus status) {
        this.messageKey = NAMESPACE + "." + this.name();
        this.status = status;
    }

    @Override
    public HttpStatus httpStatus() {
        return status;
    }

    @Override
    public String message() {
        return messageKey;
    }

    @Override
    public RuntimeException exception() {
        return new BoardException(this);
    }

    @Override
    public RuntimeException exception(Throwable cause) {
        return new BoardException(this, cause);
    }

    @Override
    public RuntimeException exception(Runnable action) {
        return new BoardException(this, action);
    }

    @Override
    public RuntimeException exception(Runnable action, Throwable cause) {
        return new BoardException(this, action, cause);
    }

    @Override
    public RuntimeException exception(Supplier<Map<String, Object>> payloadSupplier) {
        return new BoardException(this, payloadSupplier);
    }

    @Override
    public RuntimeException exception(Supplier<Map<String, Object>> payloadSupplier, Throwable cause) {
        return new BoardException(this, payloadSupplier, cause);
    }
}
