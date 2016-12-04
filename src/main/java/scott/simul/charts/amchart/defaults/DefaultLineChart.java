package scott.simul.charts.amchart.defaults;

import scott.simul.charts.amchart.Bullet;
import scott.simul.charts.amchart.CategoryAxis;
import scott.simul.charts.amchart.Chart;
import scott.simul.charts.amchart.Export;
import scott.simul.charts.amchart.Graph;
import scott.simul.charts.amchart.LineType;
import scott.simul.charts.amchart.Position;
import scott.simul.charts.amchart.ValueAxes;

public class DefaultLineChart extends Chart {

    public DefaultLineChart() {
        setType(Type.SERIAL);
        setTheme(Theme.LIGHT);
        setMarginTop(0);
        setMarginRight(80);
        setValueAxes(new ValueAxes());
        getValueAxes().setAxisAlpha(0);
        getValueAxes().setPosition(Position.LEFT);
        getGraphs().add(new Graph());
        getGraphs().get(0).setId("g1");
        getGraphs().get(0).setBallonText("[[category]]<br><b><span style=\'font-size:14px;\'>[[value]]</span></b>");
        getGraphs().get(0).setBullet(Bullet.ROUND);
        getGraphs().get(0).setBulletSize(8);
        getGraphs().get(0).setLineColor("#d1655d");
        getGraphs().get(0).setLineThickness(2);
        getGraphs().get(0).setNegativeLineColor("#637bb6");
        getGraphs().get(0).setType(LineType.SMOOTHED);
        getGraphs().get(0).setValueField("value");
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
        getChartScrollbar().setGraphLineAlpha(0.3);
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

}
