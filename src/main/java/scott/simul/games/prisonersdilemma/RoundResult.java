package scott.simul.games.prisonersdilemma;

import java.io.PrintStream;

public class RoundResult {

    private final PrisonersDilemmaGame game;
    private final int roundNumber;
    private final Move moveOne;
    private final int costOfMoveOne;
    private final Move moveTwo;
    private final int costOfMoveTwo;

    public RoundResult(PrisonersDilemmaGame game, int roundNumber, Player playerOne, Card cardOne, Player playerTwo, Card cardTwo) {
        this.game = game;
        this.roundNumber = roundNumber;
        this.moveOne = new Move(playerOne, cardOne);
        this.moveTwo = new Move(playerTwo, cardTwo);
        this.costOfMoveOne = game.calculateCostOrBenefit(moveOne, moveTwo);
        this.costOfMoveTwo = game.calculateCostOrBenefit(moveTwo, moveOne);
    }

    public Move getMoveOne() {
        return moveOne;
    }

    public Move getMoveTwo() {
        return moveTwo;
    }

    public int getCostOfMoveOne() {
        return costOfMoveOne;
    }

    public int getCostOfMoveTwo() {
        return costOfMoveTwo;
    }

    public int getBalanceBeforeMoveOne() {
        RoundResult prev = getPreviousRound();
        return prev != null ? prev.getBalanceAfterMoveOne() : moveOne.getPlayer().getStartingBalance();
    }

    public int getBalanceBeforeMoveTwo() {
        RoundResult prev = getPreviousRound();
        return prev != null ? prev.getBalanceAfterMoveTwo() : moveTwo.getPlayer().getStartingBalance();
    }

    public int getBalanceAfterMoveOne() {
        return getBalanceBeforeMoveOne() + costOfMoveOne;
    }

    public int getBalanceAfterMoveTwo() {
        return getBalanceBeforeMoveTwo() + costOfMoveTwo;
    }

    public RoundResult getPreviousRound() {
        return game.getRoundBefore(this);
    }

    public Move getPlayersMove(Player player) {
        if (player == moveOne.getPlayer()) {
            return moveOne;
        }
        else if (player == moveTwo.getPlayer()) {
            return moveTwo;
        }
        return null;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public Move getOppenentsMove(Player player) {
        return player == moveOne.getPlayer() ?
                moveTwo : moveOne;
    }

    public class Move {
        private final Player player;
        private final Card cardDealt;

        public Move(Player player, Card cardDealt) {
            this.player = player;
            this.cardDealt = cardDealt;
        }

        public Move getPreviousMove() {
            return game.getMoveBefore(this);
        }

        public Player getPlayer() {
            return player;
        }

        public Card getCard() {
            return cardDealt;
        }

        public RoundResult getRound() {
            return RoundResult.this;
        }
    }

    public void printResult(PrintStream out) {
        out.println(moveOne.getPlayer() + " " + moveOne.getCard() + " " + getBalanceAfterMoveOne() + " "+ moveTwo.getPlayer() + " " + moveTwo.getCard() + " " + getBalanceAfterMoveTwo());
    }
}
