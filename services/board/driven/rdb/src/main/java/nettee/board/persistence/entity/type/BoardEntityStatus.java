package nettee.board.persistence.entity.type;

import nettee.board.domain.type.BoardStatus;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static nettee.board.exception.BoardErrorCode.BOARD_DEFAULT;

public enum BoardEntityStatus {
    REMOVED(false, 0b0000, 0),
    PENDING(false, 0b0001, 0),
    ACTIVE(true, 0b0010, 0),
    SUSPENDED(true, 0b0100, 0),;

    /*
    R000 0000 0000 0000 0PPP PPPP PPPP PPPP
      R: generally readable status (1: readable, 0: unreadable)
      0: classifying bits (16 bits)
      P: detailed or padded bits (15 bits)
     */
    private static final int TLB_PADDING_SIZE = 31;
    private static final int CLASSIFYING_PADDING_SIZE = 15;

    private final int code;

    BoardEntityStatus(boolean canRead, int classifyingBits, int detailBits) {
        this.code = (canRead ? 1 << TLB_PADDING_SIZE : 0)
                | (classifyingBits << CLASSIFYING_PADDING_SIZE)
                | detailBits;
    }

    public int getCode() {
        return code;
    }

    public static BoardEntityStatus valueOf(BoardStatus boardStatus) {
        assert Set.of(BoardStatus.REMOVED, BoardStatus.PENDING, BoardStatus.ACTIVE, BoardStatus.SUSPENDED)
                .containsAll(Arrays.stream(BoardStatus.values()).collect(Collectors.toSet()))
                : "BoardStatus 중 일부가 BoardEntityStatus::valueOf 함수에서 매핑되지 않습니다.";

        return switch (boardStatus){
            case REMOVED -> REMOVED;
            case PENDING -> PENDING;
            case ACTIVE -> ACTIVE;
            case SUSPENDED -> SUSPENDED;
            default -> throw new Error("BoardStatus 중 일부가 BoardEntityStatus::valueOf 함수에서 매핑되지 않습니다.");
        };
    }

    public static BoardEntityStatus valueOf(int value) {
        return switch (value) {
            case 0b0__0000_0000_0000_0000__000_0000_0000_0000 -> REMOVED;
            case 0b0__0000_0000_0000_0001__000_0000_0000_0000 -> PENDING;
            case 0b1__0000_0000_0000_0010__000_0000_0000_0000 -> ACTIVE;
            case 0b1__0000_0000_0000_0100__000_0000_0000_0000 -> SUSPENDED;
            default -> throw BOARD_DEFAULT.exception();
        };
    }
}