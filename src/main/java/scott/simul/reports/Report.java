package scott.simul.reports;

import java.util.LinkedList;
import java.util.List;

import scott.simul.charts.amchart.Chart;

public class Report {

    private Long id;

    private String name;

    private String description;

    private final List<Column> columns = new LinkedList<>();

    private final List<List<Object>> data = new LinkedList<>();

    private Chart chart;

    private final List<Long> subReports = new LinkedList<>();

    private Long parentReport;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getParentReport() {
        return parentReport;
    }

    public void setParentReport(Long parentReport) {
        this.parentReport = parentReport;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public List<List<Object>> getData() {
        return data;
    }

    public List<Long> getSubReports() {
        return subReports;
    }

    public Chart getChart() {
        return chart;
    }

    public void setChart(Chart chart) {
        this.chart = chart;
    }
}
