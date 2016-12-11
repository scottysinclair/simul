package scott.simul.charts.amchart;

public class BarGraph extends Graph {

    public static enum Type {
        COLUMN("column");

        private String value;

        private Type(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    private double fillAlphas;
    private double lineAlpha;
    private Type type;

    public double getFillAlphas() {
        return fillAlphas;
    }
    public void setFillAlphas(double fillAlphas) {
        this.fillAlphas = fillAlphas;
    }
    public double getLineAlpha() {
        return lineAlpha;
    }
    public void setLineAlpha(double lineAlpha) {
        this.lineAlpha = lineAlpha;
    }
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }

}
