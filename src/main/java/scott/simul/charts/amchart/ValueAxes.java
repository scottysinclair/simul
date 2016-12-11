package scott.simul.charts.amchart;

public class ValueAxes {

    private String gridColor;
    private Double gridAlpha;
    private Integer dashLength;

    private Integer axisAlpha;
    private Position position;

    public String getGridColor() {
        return gridColor;
    }
    public void setGridColor(String gridColor) {
        this.gridColor = gridColor;
    }
    public double getGridAlpha() {
        return gridAlpha;
    }
    public void setGridAlpha(double gridAlpha) {
        this.gridAlpha = gridAlpha;
    }
    public int getDashLength() {
        return dashLength;
    }
    public void setDashLength(int dashLength) {
        this.dashLength = dashLength;
    }
    public int getAxisAlpha() {
        return axisAlpha;
    }
    public void setAxisAlpha(int axisAlpha) {
        this.axisAlpha = axisAlpha;
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }

}
