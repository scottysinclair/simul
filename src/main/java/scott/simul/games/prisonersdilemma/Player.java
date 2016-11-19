package scott.simul.games.prisonersdilemma;

import scott.simul.games.prisonersdilemma.strategy.Strategy;

public class Player {

    private final Strategy strategy;

    public Player(Strategy strategy) {
        this.strategy = strategy;
    }

    public Card dealCard(PrisonersDilemmaGame game) {
        return strategy.dealCard(this, game);
    }

}
