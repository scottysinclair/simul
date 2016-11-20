package scott.simul.games.prisonersdilemma.strategy;

import scott.simul.games.prisonersdilemma.Card;
import scott.simul.games.prisonersdilemma.Player;
import scott.simul.games.prisonersdilemma.PrisonersDilemmaGame;
import scott.simul.games.prisonersdilemma.RoundResult.Move;

public class TitForTat implements Strategy {

    @Override
    public Card dealCard(Player player, PrisonersDilemmaGame game) {
        Move move = game.getOppenentsLastMove(player);
        /*
         * cooperate on first move
         */
        return move == null ? Card.COOPERATE : move.getCard();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
