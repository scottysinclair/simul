package scott.simul.charts.amchart;

public class Graph {

    private String id;
    private String ballonText;
    private Bullet bullet;
    private int bulletSize;
    private String lineColor;
    private int lineThickness;
    private String negativeLineColor;
    private LineType type;
    private String valueField;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getBallonText() {
        return ballonText;
    }
    public void setBallonText(String ballonText) {
        this.ballonText = ballonText;
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
    public String getValueField() {
        return valueField;
    }
    public void setValueField(String valueField) {
        this.valueField = valueField;
    }

}
