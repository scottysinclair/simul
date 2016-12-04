package scott.simul.charts.amchart;

public class CategoryAxis {

    private String minPeriod;
    private boolean parseDates;
    private double minorGridAlpha;
    private boolean minorGridEnabled;
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
