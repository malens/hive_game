package Hive.Tiles;

import Hive.HexTile;
import Hive.Player;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import static Hive.Tiles.Tile.type.MOSQUITO;

/**
 * Created by malens on 2017-01-23.
 */
public class Mosquito extends Tile {
    public Mosquito(Player player) {
        this.player = player;
    }

    public int getAvailable() {
        return available;
    }

    private final int available = 1;
    private Player player;
    private Color color = Color.GREY;
    private Tile.type type = MOSQUITO;

    public Tile.type getType() {
        return type;
    }
    public Player getPlayer(){
        return player;
    }
    public Color getColor(){
        return this.color;
    }

    public void getPossibleMoves (HexTile hex, ArrayList<HexTile> possibleMoves){
        for (HexTile x:hex.getNeighbours()){
            if (!x.getTiles().isEmpty()){
                x.getTiles().peek().getPossibleMoves(hex, possibleMoves);
            }
        }

    }

}
