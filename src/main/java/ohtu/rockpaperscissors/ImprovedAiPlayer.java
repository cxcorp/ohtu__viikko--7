
package ohtu.rockpaperscissors;

// "AI with memory"

public class ImprovedAiPlayer {
    private RPSMove[] memory;
    private int freeMemorySlotIndex;

    public ImprovedAiPlayer(int memorySize) {
        memory = new RPSMove[memorySize];
        freeMemorySlotIndex = 0;
    }

    public void addOpponentsMove(RPSMove move) {
        // if memory is full, forget the last element
        if (freeMemorySlotIndex == memory.length) {
            for (int i = 1; i < memory.length; i++) {
                memory[i - 1] = memory[i];
            }

            freeMemorySlotIndex--;
        }

        memory[freeMemorySlotIndex] = move;
        freeMemorySlotIndex++;
    }


    public RPSMove getNextMove() {
        if (freeMemorySlotIndex == 0 || freeMemorySlotIndex == 1) {
            return RPSMove.Rock;
        }

        RPSMove lastMove = memory[freeMemorySlotIndex - 1];

        int r = 0;
        int p = 0;
        int s = 0;

        for (int i = 0; i < freeMemorySlotIndex - 1; i++) {
            if (lastMove.equals(memory[i])) {
                RPSMove nextMove = memory[i + 1];

                if (nextMove == RPSMove.Rock) {
                    r++;
                } else if (nextMove == RPSMove.Paper) {
                    p++;
                } else {
                    s++;
                }
            }
        }

        // Choose the next move like so:
        // - if rock has been played the most, choose paper
        // - if paper has been played the most, choose scissors
        // otherwise choose rock
        if (r > p && r > s) {
            return RPSMove.Paper;
        } else if (p > r && p > s) {
            return RPSMove.Scissors;
        } else {
            return RPSMove.Rock;
        }
    }
}