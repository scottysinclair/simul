package scott.simul.games.prisonersdilemma.reports;

import static java.util.Collections.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import scott.simul.charts.amchart.Chart;
import scott.simul.charts.amchart.defaults.DefaultBarChart;
import scott.simul.games.prisonersdilemma.PrisonersDilemmaSimRunner;
import scott.simul.reports.Column;
import scott.simul.reports.Report;

public class RootReport extends Report {

    public RootReport(PrisonersDilemmaSimRunner runner) {
           setId(1L);
           setName("Prisoner's Dilemma Report");
           setDescription("The total score of each strategy across all games.");
           getColumns().add(new Column("Stratgey", "string"));
           getColumns().add(new Column("Total score", "number"));

            Arrays.stream(runner.getStrategies()).forEach(stratgey -> {
                int totalScore = runner.getGames().stream()
                    .mapToInt(game -> game.getEndBalance(stratgey))
                    .sum();
                getData().add(Arrays.asList(stratgey.getClass().getSimpleName(), totalScore));
            });

            sort(getData(), (row1, row2) ->  {
                return getScore(row2) - getScore(row1) ;
            });
    }

    public Chart makeChart() {
        DefaultBarChart barChart = new DefaultBarChart();
        for (List<Object> row: getData()) {
            addData(barChart, "strategy", row.get(0), row.get(1));
        }
        barChart.setCategoryField("strategy");
        barChart.getFirstGraph().setValueField("value");
        return barChart;
    }

    private void addData(Chart chart, String categoryName, Object category, Object value) {
        Map<String,Object> data = new HashMap<>();
        data.put(categoryName, category);
        data.put("value", value);
        chart.getDataProvider().add(data);
    }

    private static int getScore(List<Object> row) {
        return (Integer)row.get(1);
    }

}
