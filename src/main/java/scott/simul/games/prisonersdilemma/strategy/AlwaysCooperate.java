package scott.simul.games.prisonersdilemma.strategy;

import scott.simul.games.prisonersdilemma.Card;
import scott.simul.games.prisonersdilemma.Player;
import scott.simul.games.prisonersdilemma.PrisonersDilemmaGame;

public class AlwaysCooperate implements Strategy {

    @Override
    public Card dealCard(Player player, PrisonersDilemmaGame game) {
        return Card.COOPERATE;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }


}
