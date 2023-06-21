package com.wizeline.dsa;

import java.util.Objects;

public class Connect4 {
  /* Player
   * 0 - 'a'
   * 1 - 'b'
   * ...
   * */
  private final Integer[][] gameBoard;
  private final Integer players;
  private final Integer rows;
  private final Integer columns;

  public Connect4(int rows, int columns, int players) {
    this.rows = rows;
    this.columns = columns;
    this.players = players;
    this.gameBoard = new Integer[rows][columns];
  }

  public int makePlay(int player, int column) {
    // 0. 0 <= player < this.players y 0 <= column < columns
    // si alguna de las dos no se cumple lanzar una excepción "IllegalArgumentException"
    if (player < 0 || player >= this.players) {
      throw new IllegalArgumentException(); //
    }
    if (column < 0 || column >= this.columns) {
      throw new IllegalArgumentException(); //
    }
    // 1. buscar si en esta column hay un espacio libre (renglón)
    // si lo tengo pasar 2.
    // si no lo tengo lanzo una excepción de "FullColumnException"
    int availableRow = -1;
    for (int row = this.rows - 1; row >= 0; row--) {
      if (Objects.isNull(gameBoard[row][column])) {
        availableRow = row;
        break;
      }
    }
    if (availableRow < 0) {
      throw new FullColumnException();
    }
    // 2. marcar la casilla como ocupada con el playerId dado.
    gameBoard[availableRow][column] = player;

    // 3. regresar el renglón donde cayó la pelotita
    return availableRow;
  }

  public boolean anyoneWon(int row, int column) {
    // si gana verticalmente :checked:
    // si gana horizontalmente :checked:
    // si gana diagonal ascendente :checked:
    // si gana diagonal descendente :checked:
    // si no gama em ninguna de las anteriores regresa false
    return anyoneWonVertically(row, column); // || ... || ... || ...;
  }

  private boolean anyoneWonVertically(int row, int column) {
    int consecutiveTokens = 0;
    for (int currentRow = row; currentRow < this.rows; currentRow++) {
      int currentPlayer = gameBoard[currentRow][column];
      if (currentPlayer == gameBoard[currentRow + 1][column]) {
        consecutiveTokens++;
        if (consecutiveTokens == 3) {
          return true;
        }
      } else {
        break;
      }
    }
    return false;
  }

  public void printBoard() {
    System.out.print(this);
  }

  @Override
  public String toString() {
    StringBuilder partialGameBoard = new StringBuilder();
    for (int row = 0; row < this.rows; row++) {
      partialGameBoard.append(this.getFormattedRow(row));
      partialGameBoard.append(this.getRowSeparator(row));
    }
    return partialGameBoard.toString();
  }

  private String getFormattedRow(int row) {
    StringBuilder formattedRow = new StringBuilder();
    for (int column = 0; column < this.columns; column++) {
      Integer cellValue = this.gameBoard[row][column];
      formattedRow.append(this.getFormattedCell(cellValue));
      formattedRow.append(this.getCellSeparator(column));
    }
    return formattedRow.toString();
  }

  private String getFormattedCell(Integer cellValue) {
    return String.format("%c", cellValue == null ? '-' : ('A' + cellValue));
  }

  private String getRowSeparator(int row) {
    return this.isLastRow(row) ? "" : "\n";
  }

  private String getCellSeparator(int column) {
    return this.isLastColumn(column) ? "" : " ";
  }

  boolean isLastRow(int row) {
    return (row == this.gameBoard.length - 1);
  }

  boolean isLastColumn(int column) {
    return (column == this.gameBoard[0].length - 1);
  }
}
