package com.kodilla.tictactoe;

import static com.kodilla.tictactoe.Board.*;

public class WinningConditions {

    private static int playerWins = 0;
    private static int computerWins = 0;

    private static void drawWinningLine(WinningTiles winningTiles) {
        winningLine.setStartX(winningTiles.getStart().getStackPane().getTranslateX());
        winningLine.setStartY(winningTiles.getStart().getStackPane().getTranslateY());
        winningLine.setEndX(winningTiles.getEnd().getStackPane().getTranslateX());
        winningLine.setEndY(winningTiles.getEnd().getStackPane().getTranslateY());
        winningLine.setTranslateX(winningTiles.getMiddle().getStackPane().getTranslateX());
        winningLine.setTranslateY(winningTiles.getMiddle().getStackPane().getTranslateY());
        winningLine.setVisible(true);
    }

    private static void resetScores() {
        playerWins = 0;
        computerWins = 0;
    }

    private static void gameOver(String winner, WinningTiles winningTiles) {
        isGameOver = true;
        drawWinningLine(winningTiles);
        winningLine.setVisible(true);
        menu.showStartButton();
        if (winner.equals("X")) {
            playerWins++;
            menu.updateTitle("Wygrywa gracz!");
        } else if (winner.equals("O")) {
            computerWins++;
            menu.updateTitle("Wygrywa komputer!");
        }

        if (playerWins == 3) {
            menu.updateTitle("Gracz wygrał serię!");
            resetScores();
        } else if (computerWins == 3) {
            menu.updateTitle("Komputer wygrał serię!");
            resetScores();
        }

        menu.updateScores("Gracz:" + playerWins + "    " + "Komputer:" + computerWins);
    }

    protected static void checkForWinner() {
        checkRowsForWinner();
        checkColsForWinner();
        checkDiagRightForWinner();
        checkDiagLeftForWinner();
        checkForStalemate();
    }

    private static void checkRowsForWinner() {
        if (!isGameOver) {
            for (int row = 0; row < 3; row++) {
                if (Tiles[row][0].getValue().equals(Tiles[row][1].getValue()) &&
                        Tiles[row][0].getValue().equals(Tiles[row][2].getValue()) &&
                        !Tiles[row][0].getValue().isEmpty()) {
                    String winner = Tiles[row][0].getValue();
                    gameOver(winner, new WinningTiles(Tiles[row][0], Tiles[row][1], Tiles[row][2]));
                }
            }
        }
    }

    private static void checkColsForWinner() {
        if (!isGameOver) {
            for (int col = 0; col < 3; col++) {
                if (Tiles[0][col].getValue().equals(Tiles[1][col].getValue()) &&
                        Tiles[0][col].getValue().equals(Tiles[2][col].getValue()) &&
                        !Tiles[0][col].getValue().isEmpty()) {
                    String winner = Tiles[0][col].getValue();
                    gameOver(winner, new WinningTiles(Tiles[0][col], Tiles[1][col], Tiles[2][col]));
                }
            }
        }
    }

    private static void checkDiagRightForWinner() {
        if (!isGameOver) {
            if (Tiles[0][0].getValue().equals(Tiles[1][1].getValue()) &&
                    Tiles[0][0].getValue().equals(Tiles[2][2].getValue()) &&
                    !Tiles[0][0].getValue().isEmpty()) {
                String winner = Tiles[0][0].getValue();
                gameOver(winner, new WinningTiles(Tiles[0][0], Tiles[1][1], Tiles[2][2]));
            }
        }
    }

    private static void checkDiagLeftForWinner() {
        if (!isGameOver) {
            if (Tiles[0][2].getValue().equals(Tiles[1][1].getValue()) &&
                    Tiles[0][2].getValue().equals(Tiles[2][0].getValue()) &&
                    !Tiles[0][2].getValue().isEmpty()) {
                String winner = Tiles[0][2].getValue();
                gameOver(winner, new WinningTiles(Tiles[0][2], Tiles[1][1], Tiles[2][0]));
            }
        }
    }

    private static void checkForStalemate() {
        if (!isGameOver) {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (Tiles[row][col].getValue().isEmpty()) {
                        return;
                    }
                }
            }
            isGameOver = true;
            menu.showStartButton();
            menu.updateTitle("Remis");
        }
    }
}
