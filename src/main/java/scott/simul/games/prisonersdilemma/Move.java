package scott.simul.games.prisonersdilemma;

public class Move {
    private final Player player;
    private final Card cardDealt;

    public Move(Player player, Card cardDealt) {
        this.player = player;
        this.cardDealt = cardDealt;
    }

    public Player getPlayer() {
        return player;
    }

    public Card getCard() {
        return cardDealt;
    }

}
