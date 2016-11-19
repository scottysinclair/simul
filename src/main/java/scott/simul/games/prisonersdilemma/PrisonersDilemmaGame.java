package scott.simul.games.prisonersdilemma;

import java.util.LinkedList;
import java.util.List;

/**
 * A Game of Prisoners Dilemma ends after a certain number of rounds
 * @author scott
 *
 */
public class PrisonersDilemmaGame {

    private final Player playerA, playerB;
    private final Banker banker;
    private final int numberOfRounds;
    private final List<RoundResult> results;

    public PrisonersDilemmaGame(Player playerA, Player playerB, Banker banker, int numberOfRounds) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.banker = banker;
        this.numberOfRounds = numberOfRounds;
        this.results = new LinkedList<>();
    }

    public void start() {
        for (int round = 0; round<numberOfRounds; round++) {
            Card cardA = playerA.dealCard(this);
            Card cardB = playerB.dealCard(this);
            results.add(new RoundResult(this, new Move(playerA, cardA), new Move(playerB, cardB)));
        }
    }

    public int calculateCostOrBenefit(Move ourMove, Move theirMove) {
        return 0;
    }

    public Move getOppenentsLastMove(Player player) {
        RoundResult roundResult = results.get( results.size() - 1 );
        return player == roundResult.getMoveOne().getPlayer() ?
                roundResult.getMoveTwo() : roundResult.getMoveOne();
    }

}
