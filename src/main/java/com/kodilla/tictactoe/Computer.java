package com.kodilla.tictactoe;

import java.util.Random;

import static com.kodilla.tictactoe.Board.Tiles;
import static com.kodilla.tictactoe.Board.isGameOver;
import static com.kodilla.tictactoe.Tile.getPlayerTurn;

public class Computer {

    protected static void computerMove() {
        if(!isGameOver) {
            Random random = new Random();
            int move = random.nextInt(9) + 1;
            if (possibleMove(move) == null) {
                computerMove();
            } else {
                possibleMove(move).setValue(getPlayerTurn());
            }
        }
    }

    private static Tile possibleMove(int move) {
        switch (move) {
            case 1:
                if (Tiles[0][0].getValue().equals("")) return Tiles[0][0];
            case 2:
                if (Tiles[0][1].getValue().equals("")) return Tiles[0][1];
            case 3:
                if (Tiles[0][2].getValue().equals("")) return Tiles[0][2];
            case 4:
                if (Tiles[1][0].getValue().equals("")) return Tiles[1][0];
            case 5:
                if (Tiles[1][1].getValue().equals("")) return Tiles[1][1];
            case 6:
                if (Tiles[1][2].getValue().equals("")) return Tiles[1][2];
            case 7:
                if (Tiles[2][0].getValue().equals("")) return Tiles[2][0];
            case 8:
                if (Tiles[2][1].getValue().equals("")) return Tiles[2][1];
            case 9:
                if (Tiles[2][2].getValue().equals("")) return Tiles[2][2];
            default:
                return null;
        }
    }

}
