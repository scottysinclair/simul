package scott.simul.games.prisonersdilemma;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

import scott.simul.games.Game;
import scott.simul.games.prisonersdilemma.RoundResult.Move;

/**
 * A Game of Prisoners Dilemma ends after a certain number of rounds
 * @author scott
 *
 */
public class PrisonersDilemmaGame implements Game {

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

    @Override
    public void run() {
        for (int round = 1; round<=numberOfRounds; round++) {
            Card cardA = playerA.dealCard(this);
            Card cardB = playerB.dealCard(this);
            results.add(new RoundResult(this, round, playerA, cardA, playerB, cardB));
        }
    }

    @Override
    public void printResults(PrintStream out) {
        out.println("Prisoner's Dilemma");
        out.println("# of rounds: " + numberOfRounds);
        out.println(playerA + " VS " + playerB);
        results.forEach(r -> r.printResult(out));
        RoundResult lastRound = getLastRound();
        if (lastRound.getBalanceAfterMoveOne() > lastRound.getBalanceAfterMoveTwo()) {
            out.println("Winner is " + lastRound.getMoveOne().getPlayer());
        }
        else if (lastRound.getBalanceAfterMoveTwo() > lastRound.getBalanceAfterMoveOne()) {
            out.println("Winner is " + lastRound.getMoveTwo().getPlayer());
        }
        else {
            out.println("The result is a draw");
        }

    }

    public RoundResult getLastRound() {
        return results.get( results.size() - 1);
    }

    public int calculateCostOrBenefit(Move ourMove, Move theirMove) {
        switch(ourMove.getCard()) {
        case COOPERATE:
            switch(theirMove.getCard()) {
            case COOPERATE: return 300;
            case DEFECT: return -100;
            default: throw new IllegalStateException("Unknown CARD " + theirMove.getCard());
            }
        case DEFECT:
            switch(theirMove.getCard()) {
            case COOPERATE: return 500;
            case DEFECT: return -10;
            }
        }
        return 0;
    }

    public Move getOppenentsLastMove(Player player) {
        if (results.isEmpty()) {
            return null;
        }
        RoundResult roundResult = results.get( results.size() - 1 );
        return roundResult.getOppenentsMove(player);
    }

    public Move getLastMove(Player player) {
        if (results.isEmpty()) {
            return null;
        }
        RoundResult roundResult = results.get( results.size() - 1 );
        return roundResult.getPlayersMove( player );
    }

    public Move getMoveBefore(Move move) {
        RoundResult roundBefore = getRoundBefore(move.getRound());
        return roundBefore != null ? roundBefore.getPlayersMove( move.getPlayer() ) : null;
    }

    public RoundResult getRoundBefore(RoundResult round) {
        if (round.getRoundNumber() < 2) {
            return null;
        }
        return results.get( round.getRoundNumber() - 2 );
    }


}
