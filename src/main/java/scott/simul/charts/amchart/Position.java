package scott.simul.charts.amchart;

public enum Position {
    LEFT("left");

    private final String name;
    private Position(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }

}
