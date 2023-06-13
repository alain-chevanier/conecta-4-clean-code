package com.wizeline.dsa;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

class Connect4Test {

  @Test
  void testPrintEmptyBoard() {
    Connect4 connect4 = new Connect4(3, 4, 2);
    String actualOutput = connect4.toString();

    String expectedOutput = "- - - -\n" + "- - - -\n" + "- - - -";

    assertThat(actualOutput, is(expectedOutput));
  }
}
