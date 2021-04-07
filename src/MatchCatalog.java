import java.util.ArrayList;
import java.util.List;

public class MatchCatalog {
    private List<Match> matches;
    private List<Place> stadiumMap;

    public MatchCatalog(List<Place> stadiumMap) {
        this.stadiumMap = new ArrayList<>(stadiumMap);
        this.matches = new ArrayList<>();
    }

    public void addMatch(String matchName) {
        matches.add(new Match(matches.size(), matchName, stadiumMap));
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void writeMatches() {
        for (Match match: matches) {
            match.writeMatch();
        }
    }
}
