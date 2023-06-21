package com.wizeline.dsa;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Connect4Test {

  @Test
  void testPrintEmptyBoard() {
    Connect4 connect4 = new Connect4(3, 4, 2);
    String actualOutput = connect4.toString();

    String expectedOutput = "- - - -\n" + "- - - -\n" + "- - - -";

    assertThat(actualOutput, is(expectedOutput));
  }

  // happy path - jugada exitosa
  @Test
  void testMakePlay() {
    Connect4 connect4 = new Connect4(3, 4, 2);
    int row = connect4.makePlay(0, 0);

    assertThat(row, is(2));

    String actualOutput = connect4.toString();
    String expectedOutput = "- - - -\n" + "- - - -\n" + "A - - -";
    assertThat(expectedOutput, is(actualOutput));
  }

  // no existe jugador
  @Test
  void testMakePlay_invalidPlayer() {
    Connect4 connect4 = new Connect4(3, 4, 2);
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> {
          connect4.makePlay(3, 0);
        });
  }

  // columna inválida
  @Test
  void testMakePlay_invalidColumn() {
    Connect4 connect4 = new Connect4(3, 4, 2);
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> {
          connect4.makePlay(0, 5);
        });
  }

  // columna llena
  @Test
  void testMakePlay_fullColumn() {
    Connect4 connect4 = new Connect4(3, 4, 2);
    connect4.makePlay(0, 0);
    connect4.makePlay(1, 0);
    connect4.makePlay(0, 0);
    Assertions.assertThrows(
        FullColumnException.class,
        () -> {
          connect4.makePlay(1, 0);
        });
  }

  // happy path - alguien gana
  @Test
  void testPlayerWon_Vertically() {
    Connect4 connect4 = new Connect4(4, 4, 2);
    connect4.makePlay(0, 0);
    connect4.makePlay(1, 1);
    connect4.makePlay(0, 0);
    connect4.makePlay(1, 1);
    connect4.makePlay(0, 0);
    connect4.makePlay(1, 1);
    int row = connect4.makePlay(0, 0);
    // connect4.printBoard();
    assertThat(connect4.anyoneWon(row, 0), is(true));
  }

  // sin ganador
  @Test
  void testPlayerWon_NoOneWon_Vertically() {
    Connect4 connect4 = new Connect4(4, 4, 2);
    connect4.makePlay(0, 0);
    connect4.makePlay(1, 0);
    connect4.makePlay(1, 0);
    int row = connect4.makePlay(1, 0);
    connect4.printBoard();
    assertThat(connect4.anyoneWon(row, 0), is(false));
  }

  @Test
  void testPlayerWon_NoOneWon_Vertically_LessThanFour() {
    Connect4 connect4 = new Connect4(4, 4, 2);
    connect4.makePlay(0, 0);
    connect4.makePlay(1, 0);
    int row = connect4.makePlay(1, 0);
    connect4.printBoard();
    assertThat(connect4.anyoneWon(row, 0), is(false));
  }
}
