package kata.tictactoe;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TicTacToeShould {

  @Test
  void make_x_the_first_player() {
    //ARRANGE
    final TicTacToe ticTacToe = new TicTacToe();
    //ACT
    final Player currentPlayer = ticTacToe.getCurrentPlayer();
    //ASSERT
    assertThat(currentPlayer).isEqualTo(Player.x);
  }

  @Test
  void make_o_the_second_player() {
    //ARRANGE
    final TicTacToe ticTacToe = new TicTacToe();
    ticTacToe.move(Position.TOP_LEFT);
    //ACT
    final Player currentPlayer = ticTacToe.getCurrentPlayer();
    //ASSERT
    assertThat(currentPlayer).isEqualTo(Player.o);
  }

  @Test
  void alternate_players() {
    //ARRANGE
    final TicTacToe ticTacToe = new TicTacToe();
    ticTacToe.move(Position.TOP_LEFT);
    ticTacToe.move(Position.TOP_LEFT);
    //ACT
    final Player currentPlayer = ticTacToe.getCurrentPlayer();
    //ASSERT
    assertThat(currentPlayer).isEqualTo(Player.x);
  }

  @Test
  void win_when_top_row_is_taken_by_x() {
    //ARRANGE
    final TicTacToe ticTacToe = new TicTacToe();
    ticTacToe.move(Position.TOP_LEFT);
    ticTacToe.move(Position.BOTTOM_LEFT);
    ticTacToe.move(Position.TOP_CENTER);
    ticTacToe.move(Position.BOTTOM_RIGHT);
    ticTacToe.move(Position.TOP_RIGHT);
    //ACT
    final Player winner = ticTacToe.getWinner();
    //ASSERT
    assertThat(winner).isEqualTo(Player.x);
  }

  @Test
  void win_when_top_row_is_taken_by_o() {
    //ARRANGE
    final TicTacToe ticTacToe = new TicTacToe();
    ticTacToe.move(Position.MIDDLE_CENTER);
    ticTacToe.move(Position.TOP_LEFT);
    ticTacToe.move(Position.BOTTOM_LEFT);
    ticTacToe.move(Position.TOP_CENTER);
    ticTacToe.move(Position.BOTTOM_RIGHT);
    ticTacToe.move(Position.TOP_RIGHT);
    //ACT
    final Player winner = ticTacToe.getWinner();
    //ASSERT
    assertThat(winner).isEqualTo(Player.o);
  }

  @Test
  void has_no_winner_when_game_start() {
    //ARRANGE
    final TicTacToe ticTacToe = new TicTacToe();
    //ACT
    final Player winner = ticTacToe.getWinner();
    //ASSERT
    assertThat(winner).isEqualTo(Player.none);
  }
}
