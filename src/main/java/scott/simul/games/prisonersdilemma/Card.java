package scott.simul.games.prisonersdilemma;

public enum Card {
    COOPERATE,
    DEFECT;

    public Card getOppositeCard() {
        return this == COOPERATE ? DEFECT : COOPERATE;
    }

}
