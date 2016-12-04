package scott.simul.charts.amchart;

public enum Bullet {
    ROUND("round");

    private final String name;
    private Bullet(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
}
