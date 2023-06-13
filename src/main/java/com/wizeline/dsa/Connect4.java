package com.wizeline.dsa;

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
