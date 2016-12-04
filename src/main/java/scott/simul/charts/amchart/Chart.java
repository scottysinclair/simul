package scott.simul.charts.amchart;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Chart {

    public static enum Type {
        SERIAL("serial");
        private final String name;
        private Type(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return name;
        }
    }

    public static enum Theme {
        LIGHT("light");
        private final String name;
        private Theme(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return name;
        }
    }

    private Type type;
    private Theme theme;
    private int marginTop;
    private int marginRight;
    private List<Map<String,Object>> dataProvider = new LinkedList<>();
    private ValueAxes valueAxes;
    private final List<Graph> graphs = new LinkedList<>();
    private final Scrollbar chartScrollbar = new Scrollbar();
    private final Cursor chartCursor = new Cursor();
    private String dataDateFormat;
    private String categoryField;
    private CategoryAxis categoryAxis;
    private Export export;

    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public Theme getTheme() {
        return theme;
    }
    public void setTheme(Theme theme) {
        this.theme = theme;
    }
    public int getMarginTop() {
        return marginTop;
    }
    public void setMarginTop(int marginTop) {
        this.marginTop = marginTop;
    }
    public int getMarginRight() {
        return marginRight;
    }
    public void setMarginRight(int marginRight) {
        this.marginRight = marginRight;
    }
    public List<Map<String, Object>> getDataProvider() {
        return dataProvider;
    }
    public void setDataProvider(List<Map<String, Object>> dataProvider) {
        this.dataProvider = dataProvider;
    }
    public ValueAxes getValueAxes() {
        return valueAxes;
    }
    public void setValueAxes(ValueAxes valueAxes) {
        this.valueAxes = valueAxes;
    }
    public List<Graph> getGraphs() {
        return graphs;
    }
    public String getDataDateFormat() {
        return dataDateFormat;
    }
    public void setDataDateFormat(String dataDateFormat) {
        this.dataDateFormat = dataDateFormat;
    }
    public String getCategoryField() {
        return categoryField;
    }
    public void setCategoryField(String categoryField) {
        this.categoryField = categoryField;
    }
    public CategoryAxis getCategoryAxis() {
        return categoryAxis;
    }
    public void setCategoryAxis(CategoryAxis categoryAxis) {
        this.categoryAxis = categoryAxis;
    }
    public Export getExport() {
        return export;
    }
    public void setExport(Export export) {
        this.export = export;
    }
    public Scrollbar getChartScrollbar() {
        return chartScrollbar;
    }
    public Cursor getChartCursor() {
        return chartCursor;
    }

}
