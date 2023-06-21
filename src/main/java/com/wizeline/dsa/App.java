package com.wizeline.dsa;

public class App {

  public static void main(String[] arguments) {
    System.out.println("Hello World");
    Connect4 connect4 = new Connect4(6, 7, 2);
    connect4.makePlay(0, 3);
    connect4.makePlay(1, 4);
    connect4.makePlay(0, 3);
    connect4.makePlay(1, 4);
    connect4.makePlay(0, 3);
    connect4.makePlay(1, 4);
    connect4.makePlay(0, 3);
    connect4.printBoard();
  }
}
