package ohtu.rockpaperscissors.logic.ai;

import java.util.HashMap;
import java.util.Map;

class Counter<T> {
    private final Map<T, Integer> stats = new HashMap<>();

    public void increment(T keyToIncrement) {
        stats.compute(
            keyToIncrement,
            (key, count) -> count == null ? 1 : count + 1
        );
    }

    public int getCount(T key) {
        return stats.getOrDefault(key, 0);
    }
}
