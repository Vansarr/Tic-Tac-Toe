package com.kodilla.tictactoe;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import static com.kodilla.tictactoe.Board.*;
import static com.kodilla.tictactoe.Computer.computerMove;
import static com.kodilla.tictactoe.UI.TILE_HEIGHT;
import static com.kodilla.tictactoe.UI.TILE_WIDTH;
import static com.kodilla.tictactoe.WinningConditions.checkForWinner;

public class Tile {

    private final StackPane pane;
    private final Label label;


    protected Tile() {
        pane = new StackPane();
        pane.setMinSize(TILE_WIDTH, TILE_HEIGHT);

        Rectangle border = new Rectangle();
        border.setHeight(TILE_HEIGHT);
        border.setWidth(TILE_WIDTH);
        border.setFill(Color.TRANSPARENT);
        border.setStroke(Color.BLACK);
        pane.getChildren().add(border);

        label = new Label("");
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font(35));
        pane.getChildren().add(label);

        pane.setOnMouseClicked( event -> {
            if (getValue().isEmpty() && !isGameOver) {
                setValue(getPlayerTurn());
                checkForWinner();
                changePlayerTurn();
                computerMove();
                checkForWinner();
                changePlayerTurn();
            }
        });
    }

    private static void changePlayerTurn() {
        if (Board.playerTurn == 'X') {
            Board.playerTurn = 'O';
        } else {
            Board.playerTurn = 'X';
        }
    }

    protected static String getPlayerTurn() {
        return String.valueOf(playerTurn);
    }

    protected StackPane getStackPane() {
        return pane;
    }

    protected String getValue() {
        return label.getText();
    }

    protected void setValue(String value) {
        label.setText(value);
    }
}
