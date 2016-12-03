package scott.simul.games.prisonersdilemma;

import scott.simul.games.prisonersdilemma.strategy.Strategy;

public class Player {

    private final Strategy strategy;
    private final int startingBalance;

    public Player(Strategy strategy, int startingBalance) {
        this.strategy = strategy;
        this.startingBalance = startingBalance;
    }

    @Override
    public String toString() {
        return "Player (" + strategy + ")";
    }

    public Card dealCard(PrisonersDilemmaGame game) {
        return strategy.dealCard(this, game);
    }

    public int getStartingBalance() {
        return startingBalance;
    }

    public boolean hasStrategy(Strategy stratgey) {
        return this.strategy == stratgey;
    }

}
