package com.kodilla.tictactoe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

import static com.kodilla.tictactoe.UI.*;

public class Menu {

    private StackPane pane;
    private Label title;
    private Label scoreboard;
    private Button startGameBtn;

    protected Menu() {
        pane = new StackPane();
        pane.setMinSize(GAME_WIDTH, MENU_HEIGHT);
        pane.setTranslateX(GAME_WIDTH / 2);
        pane.setTranslateY(MENU_HEIGHT / 2);

        title = new Label("Kółko i Krzyżyk");
        title.setMinSize(GAME_WIDTH, MENU_HEIGHT / 2);
        title.setFont(Font.font(20));
        title.setAlignment(Pos.CENTER);
        title.setTranslateY(-40);
        pane.getChildren().add(title);

        scoreboard = new Label("Gracz:0    Komputer:0");
        scoreboard.setMinSize(GAME_WIDTH, MENU_HEIGHT / 2);
        scoreboard.setFont(Font.font(15));
        scoreboard.setAlignment(Pos.CENTER);
        scoreboard.setTranslateY(-15);
        pane.getChildren().add(scoreboard);

        startGameBtn = new Button ("Rozpocznij nową grę");
        startGameBtn.setMinSize(150, 40);
        startGameBtn.setTranslateY(20);
        pane.getChildren().add(startGameBtn);
    }

    protected StackPane getStackPane() {
        return pane;
    }

    protected void updateTitle(String message) {
        title.setText(message);
    }

    protected void updateScores(String scores) {
        scoreboard.setText(scores);
    }

    protected void setStartBtnOnAction(EventHandler<ActionEvent> onAction ) {
        startGameBtn.setOnAction(onAction);
    }

    protected void showStartButton() {
        startGameBtn.setVisible(true);
    }

    protected void hideStartButton() {
        startGameBtn.setVisible(false);
    }
}
