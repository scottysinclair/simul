package scott.simul.charts.amchart.defaults;

import scott.simul.charts.amchart.Bullet;
import scott.simul.charts.amchart.CategoryAxis;
import scott.simul.charts.amchart.Chart;
import scott.simul.charts.amchart.Export;
import scott.simul.charts.amchart.LineGraph;
import scott.simul.charts.amchart.LineType;
import scott.simul.charts.amchart.Position;
import scott.simul.charts.amchart.ValueAxes;

public class DefaultLineChart extends Chart {

    public DefaultLineChart() {
        setType(Type.SERIAL);
        setTheme(Theme.LIGHT);
        setMarginTop(0);
        setMarginRight(80);
        getValueAxes().add(new ValueAxes());
        getValueAxes().get(0).setAxisAlpha(0);
        getValueAxes().get(0).setPosition(Position.LEFT);
        getGraphs().add(new LineGraph());
        getFirstGraph().setId("g1");
        getFirstGraph().setBalloonText("[[category]]<br><b><span style=\'font-size:14px;\'>[[value]]</span></b>");
        getFirstGraph().setBullet(Bullet.ROUND);
        getFirstGraph().setBulletSize(8);
        getFirstGraph().setLineColor("#d1655d");
        getFirstGraph().setLineThickness(2);
        getFirstGraph().setNegativeLineColor("#637bb6");
        getFirstGraph().setType(LineType.SMOOTHED);
        getFirstGraph().setValueField("value");
        getChartScrollbar().setGraph("g1");
        getChartScrollbar().setGridAlpha(0);
        getChartScrollbar().setColor("#888888");
        getChartScrollbar().setScrollbarHeight(55);
        getChartScrollbar().setBackgroundAlpha(0);
        getChartScrollbar().setSelectedBackgroundAlpha(0.1);
        getChartScrollbar().setSelectedBackgroundColor("#888888");
        getChartScrollbar().setGraphFillAlpha(0);
        getChartScrollbar().setAutoGridCount(true);
        getChartScrollbar().setSelectedGraphFillAlpha(0);
        getChartScrollbar().setGraphLineAlpha(0.2);
        getChartScrollbar().setGraphLineColor("#c2c2c2");
        getChartScrollbar().setSelectedGraphLineColor("#888888");
        getChartScrollbar().setSelectedGraphLineAlpha(1);
        getChartCursor().setCategoryBalloonDateFormat("YYYY");
        getChartCursor().setCursorAlpha(0);
        getChartCursor().setValueLineEnabled(true);
        getChartCursor().setValueLineBalloonEnabled(true);
        getChartCursor().setValueLineAlpha(0.5);
        getChartCursor().setFullWidth(true);
        setDataDateFormat("YYYY");
        setCategoryField("year");
        setCategoryAxis(new CategoryAxis());
        getCategoryAxis().setMinPeriod("YYYY");
        getCategoryAxis().setParseDates(true);
        getCategoryAxis().setMinorGridAlpha(0.1);
        getCategoryAxis().setMinorGridEnabled(true);
        setExport(new Export());
        getExport().setEnabled(true);
    }

    public LineGraph getFirstGraph() {
        return (LineGraph)getGraphs().get(0);
    }

}
