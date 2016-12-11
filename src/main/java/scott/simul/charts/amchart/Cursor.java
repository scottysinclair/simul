package scott.simul.charts.amchart;

public class Cursor {

    private Boolean categoryBalloonEnabled;
    private Boolean zoomable;

    private String categoryBalloonDateFormat;
    private Integer cursorAlpha;
    private Boolean valueLineEnabled;
    private Boolean valueLineBalloonEnabled;
    private Double valueLineAlpha;
    private Boolean fullWidth;


    public boolean isCategoryBalloonEnabled() {
        return categoryBalloonEnabled;
    }
    public void setCategoryBalloonEnabled(boolean categoryBallonEnabled) {
        this.categoryBalloonEnabled = categoryBallonEnabled;
    }

    public boolean isZoomable() {
        return zoomable;
    }
    public void setZoomable(boolean zoomable) {
        this.zoomable = zoomable;
    }
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
