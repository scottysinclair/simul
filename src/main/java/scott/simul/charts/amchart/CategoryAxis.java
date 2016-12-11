package scott.simul.charts.amchart;

public class CategoryAxis {

    private String gridPosition;
    private Double gridAlpha;
    private String tickPosition;
    private Integer tickLength;

    private String minPeriod;
    private Boolean parseDates;
    private Double minorGridAlpha;
    private Boolean minorGridEnabled;

    public String getGridPosition() {
        return gridPosition;
    }
    public void setGridPosition(String gridPosition) {
        this.gridPosition = gridPosition;
    }
    public double getGridAlpha() {
        return gridAlpha;
    }
    public void setGridAlpha(double gridAlpha) {
        this.gridAlpha = gridAlpha;
    }
    public String getTickPosition() {
        return tickPosition;
    }
    public void setTickPosition(String tickPosition) {
        this.tickPosition = tickPosition;
    }
    public int getTickLength() {
        return tickLength;
    }
    public void setTickLength(int tickLength) {
        this.tickLength = tickLength;
    }
    public String getMinPeriod() {
        return minPeriod;
    }
    public void setMinPeriod(String minPeriod) {
        this.minPeriod = minPeriod;
    }
    public boolean isParseDates() {
        return parseDates;
    }
    public void setParseDates(boolean parseDates) {
        this.parseDates = parseDates;
    }
    public double getMinorGridAlpha() {
        return minorGridAlpha;
    }
    public void setMinorGridAlpha(double minorGridAlpha) {
        this.minorGridAlpha = minorGridAlpha;
    }
    public boolean isMinorGridEnabled() {
        return minorGridEnabled;
    }
    public void setMinorGridEnabled(boolean minorGridEnabled) {
        this.minorGridEnabled = minorGridEnabled;
    }
}
