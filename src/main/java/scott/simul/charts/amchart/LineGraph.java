package scott.simul.charts.amchart;

public class LineGraph extends Graph {

    private String id;
    private Bullet bullet;
    private int bulletSize;
    private String lineColor;
    private int lineThickness;
    private String negativeLineColor;
    private LineType type;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Bullet getBullet() {
        return bullet;
    }
    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }
    public int getBulletSize() {
        return bulletSize;
    }
    public void setBulletSize(int bulletSize) {
        this.bulletSize = bulletSize;
    }
    public String getLineColor() {
        return lineColor;
    }
    public void setLineColor(String lineColor) {
        this.lineColor = lineColor;
    }
    public int getLineThickness() {
        return lineThickness;
    }
    public void setLineThickness(int lineThickness) {
        this.lineThickness = lineThickness;
    }
    public String getNegativeLineColor() {
        return negativeLineColor;
    }
    public void setNegativeLineColor(String negativeLineColor) {
        this.negativeLineColor = negativeLineColor;
    }
    public LineType getType() {
        return type;
    }
    public void setType(LineType type) {
        this.type = type;
    }
}
