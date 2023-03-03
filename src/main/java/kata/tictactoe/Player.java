package kata.tictactoe;

public enum Player {
  o {
    @Override
    Player alternate() {
      return x;
    }
  }, x {
    @Override
    Player alternate() {
      return o;
    }
  }, none {
    @Override
    Player alternate() {
      return null;
    }
  };

  abstract Player alternate();
}
