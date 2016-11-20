package scott.simul.games.prisonersdilemma.strategy;

import scott.simul.games.prisonersdilemma.Card;
import scott.simul.games.prisonersdilemma.Player;
import scott.simul.games.prisonersdilemma.PrisonersDilemmaGame;
import scott.simul.games.prisonersdilemma.RoundResult.Move;

public class TitFor2Tats implements Strategy {

    @Override
    public Card dealCard(Player player, PrisonersDilemmaGame game) {
        Move lastMove = game.getOppenentsLastMove(player);
        if (lastMove == null) {
            /*
             * cooperate on first move
             */
            return Card.COOPERATE;
        }
        switch (lastMove.getCard()) {
            case COOPERATE: {
                return Card.COOPERATE;
            }
            case DEFECT: {
                /*
                 * so the last move was defect so
                 * if the opponents second last move was cooporate, then we give them the benefit of the doubt
                 * otherwise we defect.
                 */
                Move secondLastMove = lastMove.getPreviousMove();
                return secondLastMove == null ? Card.COOPERATE : secondLastMove.getCard();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

}
