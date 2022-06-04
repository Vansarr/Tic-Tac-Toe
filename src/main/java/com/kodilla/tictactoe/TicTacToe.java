package com.kodilla.tictactoe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import static com.kodilla.tictactoe.UI.GAME_HEIGHT;
import static com.kodilla.tictactoe.UI.GAME_WIDTH;


public class TicTacToe extends Application {
    private Menu menu;
    private Board board;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
            BorderPane grid = new BorderPane();
            Scene scene = new Scene(grid, GAME_WIDTH, GAME_HEIGHT);
            initLayout(grid);
            primaryStage.setTitle("Tic Tac Toe");
            primaryStage.setScene(scene);
            primaryStage.show();
    }

    private void initLayout(BorderPane grid) {
        initMenu(grid);
        initBoard(grid);
    }

    private void initMenu(BorderPane grid) {
        menu = new Menu();
        menu.setStartBtnOnAction(startNewGame());
        grid.getChildren().add(menu.getStackPane());
    }

    private EventHandler<ActionEvent> startNewGame() {
        return event -> {
            menu.updateTitle("Gra w toku");
            board.startNewGame();
            menu.hideStartButton();
        };
    }

    private void initBoard(BorderPane grid) {
        board = new Board(menu);
        grid.getChildren().add(board.getPane());
    }
}
