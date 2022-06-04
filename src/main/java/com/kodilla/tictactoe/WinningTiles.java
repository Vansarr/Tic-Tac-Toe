package com.kodilla.tictactoe;

public class WinningTiles {
    private Tile start;
    private Tile middle;
    public Tile end;

    public Tile getStart() {
        return start;
    }

    public Tile getMiddle() {
        return middle;
    }

    public Tile getEnd() {
        return end;
    }

    public WinningTiles(Tile start, Tile middle, Tile end) {
        this.start = start;
        this.middle = middle;
        this.end = end;
    }
}
