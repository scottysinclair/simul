package scott.simul.charts.amchart;

public class Cursor {
    private String categoryBalloonDateFormat;
    private int cursorAlpha;
    private boolean valueLineEnabled;
    private boolean valueLineBalloonEnabled;
    private double valueLineAlpha;
    private boolean fullWidth;
    public String getCategoryBalloonDateFormat() {
        return categoryBalloonDateFormat;
    }
    public void setCategoryBalloonDateFormat(String categoryBalloonDateFormat) {
        this.categoryBalloonDateFormat = categoryBalloonDateFormat;
    }
    public int getCursorAlpha() {
        return cursorAlpha;
    }
    public void setCursorAlpha(int cursorAlpha) {
        this.cursorAlpha = cursorAlpha;
    }
    public boolean isValueLineEnabled() {
        return valueLineEnabled;
    }
    public void setValueLineEnabled(boolean valueLineEnabled) {
        this.valueLineEnabled = valueLineEnabled;
    }
    public boolean isValueLineBalloonEnabled() {
        return valueLineBalloonEnabled;
    }
    public void setValueLineBalloonEnabled(boolean valueLineBalloonEnabled) {
        this.valueLineBalloonEnabled = valueLineBalloonEnabled;
    }
    public double getValueLineAlpha() {
        return valueLineAlpha;
    }
    public void setValueLineAlpha(double valueLineAlpha) {
        this.valueLineAlpha = valueLineAlpha;
    }
    public boolean isFullWidth() {
        return fullWidth;
    }
    public void setFullWidth(boolean fullWidth) {
        this.fullWidth = fullWidth;
    }

}
