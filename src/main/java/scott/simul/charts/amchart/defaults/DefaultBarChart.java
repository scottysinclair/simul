package scott.simul.charts.amchart.defaults;

import scott.simul.charts.amchart.BarGraph;
import scott.simul.charts.amchart.CategoryAxis;
import scott.simul.charts.amchart.Chart;
import scott.simul.charts.amchart.Export;
import scott.simul.charts.amchart.ValueAxes;

public class DefaultBarChart extends Chart {

    private boolean gridAboveGraphs;
    private int startDuration;

    public DefaultBarChart() {
        setType(Type.SERIAL);
        setTheme(Theme.LIGHT);
        getValueAxes().add(new ValueAxes());
        getValueAxes().get(0).setGridColor("#FFFFFF");
        getValueAxes().get(0).setGridAlpha(0.2d);
        getValueAxes().get(0).setDashLength(0);
        gridAboveGraphs = true;
        startDuration = 1;
        getGraphs().add(new BarGraph());
        //getFirstGraph().setBallonText("[[category]]<br><b><span style=\'font-size:14px;\'>[[value]]</span></b>");
        getFirstGraph().setBalloonText("[[category]]<br><b><span style=\'font-size:14px;\'>[[value]]</span></b>");
        getFirstGraph().setFillAlphas(0.8);
        getFirstGraph().setLineAlpha(0.2);
        getFirstGraph().setType(BarGraph.Type.COLUMN);
        getFirstGraph().setValueField("value");

        getChartCursor().setCategoryBalloonEnabled(false);
        getChartCursor().setCursorAlpha(0);
        getChartCursor().setZoomable(false);

        setCategoryAxis(new CategoryAxis());
        getCategoryAxis().setGridPosition("start");
        getCategoryAxis().setGridAlpha(0);
        getCategoryAxis().setTickPosition("start");
        getCategoryAxis().setTickLength(20);

        setExport(new Export());
        getExport().setEnabled(true);
    }

    public int getStartDuration() {
        return startDuration;
    }

    public void setStartDuration(int startDuration) {
        this.startDuration = startDuration;
    }

    public boolean isGridAboveGraphs() {
        return gridAboveGraphs;
    }

    public void setGridAboveGraphs(boolean gridAboveGraphs) {
        this.gridAboveGraphs = gridAboveGraphs;
    }

    public BarGraph getFirstGraph() {
        return (BarGraph)getGraphs().get(0);
    }

}
