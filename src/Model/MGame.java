package Model;

public class MGame {
    private static final int N = 8;

    private int roundCat;
    private final Dice[] dice;
    private final Board board;
    private Player[] players;

    public MGame(String[] playerNames, int playerCount) {
        roundCat = 0;

        dice = new Dice[2];
        dice[0] = new Dice();
        dice[1] = new Dice();

        board = new Board();

        Player[] players = createPlayers(playerNames, playerCount);
        initializePlayers(players);
    }

    private Player[] createPlayers(String[] playerNames, int playerCount) {
        Player[] players = new Player[playerCount];
        for (int i = 0; i < playerCount; ++i) {
            players[i] = new Player(playerNames[i]);
        }
        return players;
    }

    private void initializePlayers(Player[] players) {
        this.players = players;
        for (Player player : players) {
            player.setBoard(this.board);
            player.setDice(this.dice);
            player.setLocation(board.getStartingSquare());
        }
    }

    public void playGame() {
        System.out.println("Starting a game...");
        while (roundCat < N) {
            playRound();
            ++roundCat;
        }

        System.out.println("Model.MGame Over");
    }

    private void playRound() {
        System.out.println("Round " + (roundCat + 1));
        for (Player player : players) {
            player.takeTurn();
        }
    }

}
