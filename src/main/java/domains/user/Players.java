package domains.user;

import domains.card.Deck;

import java.util.*;
import java.util.stream.Collectors;

public class Players implements Iterable<Player>{
    public static final String DELIMITER = ",";
    private static final int MAXIMUM_NUMBER_OF_PLAYERS = 5;

    private List<Player> players;

    public Players(String playerNames, Deck deck) {
        players = new ArrayList<>();
        checkNull(playerNames);
        List<String> names = splitNames(playerNames);
        checkNumberOfPlayers(names);
        checkDuplication(names);
        for (String name : names) {
            players.add(new Player(name, deck));
        }
    }

    private void checkNumberOfPlayers(List<String> names) {
        if (names.size() > MAXIMUM_NUMBER_OF_PLAYERS) {
            throw new InvalidPlayersException(InvalidPlayersException.OVER_NUMBER_OF_PLAYERS);
        }
    }

    public Players(List<Player> players) {
        this.players = players;
    }

    private void checkNull(String playerNames) {
        if (Objects.isNull(playerNames)) {
            throw new InvalidPlayersException(InvalidPlayersException.NULL);
        }
    }

    private List<String> splitNames(String playerNames) {
        List<String> names = Arrays.asList(playerNames.split(DELIMITER));
        names = names.stream().map(String::trim).collect(Collectors.toList());
        return names;
    }

    private void checkDuplication(List<String> names) {
        int distinctNameCount = (int) names.stream()
                .distinct()
                .count();

        if (names.size() != distinctNameCount) {
            throw new InvalidPlayersException(InvalidPlayersException.DUPLICATION);
        }
    }

    @Override
    public Iterator<Player> iterator() {
        return players.iterator();
    }
}