package Hive.Tiles;

import Hive.HexTile;
import Hive.Player;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import static Hive.Tiles.Tile.type.GRASSHOPPER;


/**
 * Created by malens on 2017-01-22.
 */
public class Grasshopper extends Tile {

    public Grasshopper(Player player) {
        this.player = player;
    }
    private Player player;
    private Color color = Color.GREEN;
    private Tile.type type = GRASSHOPPER;

    public int getAvailable() {
        return available;
    }

    private final int available =3;

    public Tile.type getType() {
        return type;
    }

    public Player getPlayer(){
        return player;
    }

    public Color getColor(){
        return this.color;
    }

    public void getPossibleMoves (HexTile hex, ArrayList<HexTile> possibleMoves) {
        HexTile tmp = hex;

        if (!tmp.getTopLeftTile().getTiles().isEmpty()){
            while (tmp.getTopLeftTile()!=null&&!tmp.getTopLeftTile().getTiles().isEmpty()){
                tmp = tmp.getTopLeftTile();
            }
            tmp = tmp.getTopLeftTile();
            possibleMoves.add(tmp);

        }
        tmp = hex;
        if (!tmp.getTopRightTile().getTiles().isEmpty()){
            while (tmp.getTopRightTile()!=null&&!tmp.getTopRightTile().getTiles().isEmpty()){
                tmp = tmp.getTopRightTile();
            }
            tmp = tmp.getTopRightTile();
            possibleMoves.add(tmp);

        }
        tmp = hex;
        if (!tmp.getBotRightTile().getTiles().isEmpty()){
            while (tmp.getBotRightTile()!=null&&!tmp.getBotRightTile().getTiles().isEmpty()){
                tmp = tmp.getBotRightTile();
            }
            tmp = tmp.getBotRightTile();
            possibleMoves.add(tmp);

        }
        tmp = hex;
        if (!tmp.getBotLeftTile().getTiles().isEmpty()){
            while (tmp.getBotLeftTile()!=null&&!tmp.getBotLeftTile().getTiles().isEmpty()){
                tmp = tmp.getBotLeftTile();
            }
            tmp=tmp.getBotLeftTile();
            possibleMoves.add(tmp);

        }
        tmp = hex;
        if (!tmp.getLeftTile().getTiles().isEmpty()){
            while (tmp.getLeftTile()!=null&&!tmp.getLeftTile().getTiles().isEmpty()){
                tmp = tmp.getLeftTile();
            }
            tmp = tmp.getLeftTile();
            possibleMoves.add(tmp);

        }
        tmp = hex;
        if (!tmp.getRightTile().getTiles().isEmpty()){
            while (tmp.getRightTile()!=null&&!tmp.getRightTile().getTiles().isEmpty()){
                tmp = tmp.getRightTile();
            }
            tmp = tmp.getRightTile();
            possibleMoves.add(tmp);

        }

    }
}
