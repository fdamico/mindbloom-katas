package kata.tictactoe;

import java.util.HashMap;
import java.util.Map;

public class TicTacToe {

  Player currentPlayer = Player.x;
  Map<Position, Player> grid = new HashMap<>();

  public Player getCurrentPlayer() {
    return currentPlayer;
  }

  public void move(final Position position) {
    grid.put(position, currentPlayer);
    currentPlayer = currentPlayer.alternate();
  }

  public Player getWinner() {
    if (grid.get(Position.TOP_LEFT) != null &&
        grid.get(Position.TOP_LEFT) == grid.get(Position.TOP_RIGHT)
        && grid.get(Position.TOP_RIGHT) == grid.get(Position.TOP_CENTER)) {
      return grid.get(Position.TOP_LEFT);
    }
    return Player.none;
  }
}
