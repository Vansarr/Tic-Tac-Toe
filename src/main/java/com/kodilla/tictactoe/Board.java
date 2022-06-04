package com.kodilla.tictactoe;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;

import static com.kodilla.tictactoe.UI.*;


public class Board {

    private final StackPane pane;
    protected static Menu menu;
    protected static Tile[][] Tiles = new Tile[3][3];
    protected static Line winningLine;

    protected static char playerTurn = 'X';
    protected static boolean isGameOver = true;

    public Board(Menu menu) {
        Board.menu = menu;
        pane = new StackPane();
        pane.setMinSize(GAME_WIDTH, BOARD_HEIGHT);
        pane.setTranslateX(GAME_WIDTH / 2);
        pane.setTranslateY((BOARD_HEIGHT / 2) + MENU_HEIGHT);

        addAllTiles();

        winningLine = new Line();
        pane.getChildren().add(winningLine);
    }

    private void addAllTiles() {
        for (int row=0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                Tile tile = new Tile();
                tile.getStackPane().setTranslateX((col * TILE_WIDTH) - 100);
                tile.getStackPane().setTranslateY((row * TILE_HEIGHT) - 100);
                pane.getChildren().add(tile.getStackPane());
                Tiles[row][col] = tile;
            }
        }
    }

    protected void startNewGame() {
        isGameOver = false;
        playerTurn = 'X';
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Tiles[row][col].setValue("");
            }
        }
        winningLine.setVisible(false);
    }

    public StackPane getPane() {
        return pane;
    }
}
