package Hive;

import javafx.scene.paint.Color;

/**
 * Created by malens on 2017-01-07.
 */
public class Player {

    // identifier for the player entity
    private int playerID;
    // name for the player
    private String playerName;

    private Color playerColor;
    //returns players identifier
    public int getPlayerID() {
        return playerID;
    }

    // returns players name
    public String getPlayerName() {
        return playerName;
    }

    // sets players name
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }


    // sets players id
    public void setPlayerID(int playerID) {
        this.playerID = playerID;

    }



    //creates a new Player object with a designated playerID
    public Player(int playerID) {
        this.playerID = playerID;
    }

    public Color getPlayerColor() {
        return playerColor;
    }

    public Player(int playerID, String playerName, Color color) {

        this.playerID = playerID;
        this.playerName = playerName;
        this.playerColor = color;

    }
}
