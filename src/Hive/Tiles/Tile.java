package Hive.Tiles;

import Hive.HexTile;
import Hive.Player;
import javafx.scene.paint.Color;
import java.util.ArrayList;

/**
 * Created by malens on 2017-01-05.
 */
public class Tile {

    // the owner of this tile
    private Player player;
    // the type of this tile
    public int getAvailable() {
        return available;
    }
    private int available;
    //list of all available tile types
    public enum type {ANT, SPIDER, BEE, BEETLE, GRASSHOPPER, MOSQUITO;}
    private Color color;
    private type type;

    public Tile.type getType() {
        return type;
    }

    public Color getColor()
    {
        return color;
    }
    // creates a new tile owned by player of type

    public Tile newTile(Player player, type type) {
        switch (type) {
            case ANT:
                return new Ant(player);
            case SPIDER:
                return new Spider(player);
            case BEE:
                return new Bee(player);
            case BEETLE:
                return new Beetle(player);
            case GRASSHOPPER:
                return new Grasshopper(player);
            case MOSQUITO:
                return new Mosquito(player);
        }
        return null;
    }

    public void getPossibleMoves(HexTile hex,ArrayList<HexTile> possibleMoves)
    {}

    //returns this tiles owner
    public Player getPlayer() {
        return player;
    }
}
