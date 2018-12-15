package ohtu.rockpaperscissors;

import java.util.HashMap;
import java.util.Map;

public enum RPSMove {
    Rock {
        @Override
        public String toString() {
            return "k";
        }
    },
    Paper {
        @Override
        public String toString() {
            return "p";
        }
    },
    Scissors {
        @Override
        public String toString() {
            return "s";
        }
    };

    private static final Map<String, RPSMove> stringToMove;

    static {
        stringToMove = new HashMap<>();
        stringToMove.put("k", RPSMove.Rock);
        stringToMove.put("p", RPSMove.Paper);
        stringToMove.put("s", RPSMove.Scissors);
    }

    public static RPSMove fromString(String str) {
        return stringToMove.getOrDefault(str, null);
    }
}
