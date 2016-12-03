package scott.simul.games;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import scott.simul.games.prisonersdilemma.Player;
import scott.simul.games.prisonersdilemma.PrisonersDilemmaGame;
import scott.simul.games.prisonersdilemma.strategy.AlternateCooperateAndDefect;
import scott.simul.games.prisonersdilemma.strategy.AlwaysCooperate;
import scott.simul.games.prisonersdilemma.strategy.AlwaysDefect;
import scott.simul.games.prisonersdilemma.strategy.Strategy;
import scott.simul.games.prisonersdilemma.strategy.TitFor2Tats;
import scott.simul.games.prisonersdilemma.strategy.TitForTat;
import scott.simul.reports.Column;
import scott.simul.reports.Report;

import java.util.Arrays;

public class GameRunner {

    private List<PrisonersDilemmaGame> games = new LinkedList<>();
    private Strategy strategies[] = {
            new TitForTat(),
            new TitFor2Tats(),
            new AlwaysCooperate(),
            new AlwaysDefect(),
            new AlternateCooperateAndDefect()
    };

    public void runGame() {

        List<StrategyPairing> pairings = calculateStrategyPairings(strategies);

        pairings.forEach(sp -> System.out.println(sp));

        games = pairings.stream()
                                    .map(strategyPair -> createGame(strategyPair))
                                    .collect(Collectors.toList());

        games.forEach(g -> g.run());
        games.forEach(g -> g.printResults(System.out));
    }

    public Report getReport(Long reportId) {
      if (reportId == 1) {
          return getRootReport();
      }
      return null;
    }

    public Report getRootReport() {
        Report root = new Report();
        root.setId(1L);
        root.setName("Prisoner's Dilemma Report");
        root.getColumns().add(new Column("Stratgey", "string"));
        root.getColumns().add(new Column("Total score", "number"));

        Arrays.stream(strategies).forEach(stratgey -> {
            int totalScore = games.stream()
                .mapToInt(game -> game.getEndBalance(stratgey))
                .sum();
            root.getData().add(Arrays.asList(stratgey.getClass().getSimpleName(), totalScore));
        });
        return root;
    }

    public List<PrisonersDilemmaGame> getGames() {
        return games;
    }

    private PrisonersDilemmaGame createGame(StrategyPairing strategyPair) {
        final int numberOfRounds = 20;
        Player playerA = new Player(strategyPair.getFirst(), 0);
        Player playerB = new Player(strategyPair.getSecond(), 0);
        return new PrisonersDilemmaGame(playerA, playerB, null, numberOfRounds);
    }


    private List<StrategyPairing> calculateStrategyPairings(Strategy ...strategies) {
        LinkedHashSet<StrategyPairing> result = new LinkedHashSet<>();
        for (int i=0; i<strategies.length; i++) {
            for (int j=0; j<strategies.length; j++) {
                result.add(new StrategyPairing(strategies[i], strategies[j]));
            }
        }
        return new LinkedList<>(result);
    }

    /**
     * A pair of strategies
     * @author scott
     *
     */
    private static class StrategyPairing {
        private final Strategy first;
        private final Strategy second;
        public StrategyPairing(Strategy first, Strategy second) {
            this.first = first;
            this.second = second;
        }
        public Strategy getFirst() {
            return first;
        }
        public Strategy getSecond() {
            return second;
        }
        @Override
        public String toString() {
            return "StrategyPairing [ " + first + " vs " + second + " ]";
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime + ((first == null) ? 0 : first.hashCode());
            result = prime + ((second == null) ? 0 : second.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            StrategyPairing other = (StrategyPairing) obj;
            return (other.first == first || other.first == second) && (other.second == first || other.second == second);
        }

    }

}


