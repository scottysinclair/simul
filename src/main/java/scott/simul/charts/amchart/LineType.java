package scott.simul.charts.amchart;

public enum LineType {
    SMOOTHED("smoothedLine");

    private final String name;
    private LineType(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
}
