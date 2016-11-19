package scott.simul.games.prisonersdilemma;

public class RoundResult {

    private final Move moveOne;
    private final int costOfMoveOne;
    private final Move moveTwo;
    private final int costOfMoveTwo;

    public RoundResult(PrisonersDilemmaGame game, Move moveOne, Move moveTwo) {
        this.moveOne = moveOne;
        this.moveTwo = moveTwo;
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

}
