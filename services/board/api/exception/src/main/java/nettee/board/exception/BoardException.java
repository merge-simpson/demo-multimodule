package nettee.board.exception;

import letsdev.common.exception.support.CustomException;
import letsdev.common.exception.support.ErrorCode;

import java.util.Map;
import java.util.function.Supplier;

public class BoardException extends CustomException {
    public BoardException(String message) {
        super(message);
    }

    public BoardException(String message, Throwable cause) {
        super(message, cause);
    }

    public BoardException(ErrorCode errorCode) {
        super(errorCode);
    }

    public BoardException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public BoardException(ErrorCode errorCode, Runnable action) {
        super(errorCode, action);
    }

    public BoardException(ErrorCode errorCode, Runnable action, Throwable cause) {
        super(errorCode, action, cause);
    }

    public BoardException(ErrorCode errorCode, Supplier<Map<String, Object>> payloadSupplier) {
        super(errorCode, payloadSupplier);
    }

    public BoardException(ErrorCode errorCode, Supplier<Map<String, Object>> payloadSupplier, Throwable cause) {
        super(errorCode, payloadSupplier, cause);
    }
}
