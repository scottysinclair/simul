package scott.simul.reports;

import java.util.LinkedList;
import java.util.List;

public class Report {

    private Long id;

    private String name;

    private final List<Column> columns = new LinkedList<>();

    private final List<List<Object>> data = new LinkedList<>();

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

}
