package Hive.Tiles;

import Hive.HexTile;
import Hive.Player;
import javafx.scene.paint.Color;


import java.util.ArrayList;

import static Hive.Tiles.Tile.type.BEETLE;


/**
 * Created by malens on 2017-01-22.
 */
public class Beetle extends Tile {

    public Beetle(Player player) {
        this.player = player;
    }
    private Player player;
    private Color color = Color.VIOLET;
    private Tile.type type = BEETLE;
    private final int available =2;

    public int getAvailable() {
        return available;
    }



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
        if (hex.getTiles().size()>1){
            for (HexTile x:hex.getNeighbours())
                possibleMoves.add(x);
            return;
        }
        ArrayList<HexTile> neighbours = (ArrayList) hex.getNeighbours();
        for (int i = 0; i <= 5; i++) {
            if ((neighbours.get(i).getTiles().isEmpty())
                    && (neighbours.get((i + 1) % 6).getTiles().isEmpty())
                    && (!neighbours.get((i + 2) % 6).getTiles().isEmpty())
                    && (!neighbours.get((i + 3) % 6).getTiles().isEmpty())
                    && (!neighbours.get((i + 4) % 6).getTiles().isEmpty())
                    && (!neighbours.get((i + 5) % 6).getTiles().isEmpty())) {
                possibleMoves.addAll(neighbours);
                return;
            }
            if ((!neighbours.get(i).getTiles().isEmpty())
                    && (neighbours.get((i + 1) % 6).getTiles().isEmpty())
                    && (!neighbours.get((i + 2) % 6).getTiles().isEmpty())
                    && (!neighbours.get((i + 3) % 6).getTiles().isEmpty())
                    && (neighbours.get((i + 4) % 6).getTiles().isEmpty())
                    && (!neighbours.get((i + 5) % 6).getTiles().isEmpty())) {
                possibleMoves.addAll(neighbours);
                return;
            }
            if ((!neighbours.get(i).getTiles().isEmpty())
                    && (neighbours.get((i + 1) % 6).getTiles().isEmpty())
                    && (!neighbours.get((i + 2) % 6).getTiles().isEmpty())
                    && (!neighbours.get((i + 3) % 6).getTiles().isEmpty())
                    && (!neighbours.get((i + 4) % 6).getTiles().isEmpty())
                    && (neighbours.get((i + 5) % 6).getTiles().isEmpty())) {
                possibleMoves.addAll(neighbours);
                return;
            }
            if ((neighbours.get(i).getTiles().isEmpty())
                    && (!neighbours.get((i + 1) % 6).getTiles().isEmpty())
                    && (!neighbours.get((i + 2) % 6).getTiles().isEmpty())
                    && (!neighbours.get((i + 3) % 6).getTiles().isEmpty())
                    && (!neighbours.get((i + 4) % 6).getTiles().isEmpty())
                    && (!neighbours.get((i + 5) % 6).getTiles().isEmpty())) {
                possibleMoves.add(neighbours.get((i + 2) % 6));
                possibleMoves.add(neighbours.get((i + 3) % 6));
                possibleMoves.add(neighbours.get((i + 4) % 6));
                possibleMoves.add(neighbours.get((i + 5) % 6));
                possibleMoves.add(neighbours.get((i + 1) % 6));
                return;
            }
            if ((!neighbours.get(i).getTiles().isEmpty())
                    && (neighbours.get((i + 1) % 6).getTiles().isEmpty())
                    && (neighbours.get((i + 2) % 6).getTiles().isEmpty())
                    && (neighbours.get((i + 3) % 6).getTiles().isEmpty())
                    && (neighbours.get((i + 4) % 6).getTiles().isEmpty())
                    && (neighbours.get((i + 5) % 6).getTiles().isEmpty())) {
                possibleMoves.add(neighbours.get((i + 1) % 6));
                possibleMoves.add(neighbours.get((i + 5) % 6));
                possibleMoves.add(neighbours.get((i) % 6));
                return;
            }
            if ((!neighbours.get(i).getTiles().isEmpty())
                    && (neighbours.get((i + 1) % 6).getTiles().isEmpty())
                    && (neighbours.get((i + 2) % 6).getTiles().isEmpty())
                    && (!neighbours.get((i + 3) % 6).getTiles().isEmpty())
                    && (neighbours.get((i + 4) % 6).getTiles().isEmpty())
                    && (neighbours.get((i + 5) % 6).getTiles().isEmpty())) {
                possibleMoves.addAll(neighbours);
                return;
            }
            if ((!neighbours.get(i).getTiles().isEmpty())
                    && (neighbours.get((i + 1) % 6).getTiles().isEmpty())
                    && (neighbours.get((i + 2) % 6).getTiles().isEmpty())
                    && (neighbours.get((i + 3) % 6).getTiles().isEmpty())
                    && (!neighbours.get((i + 4) % 6).getTiles().isEmpty())
                    && (neighbours.get((i + 5) % 6).getTiles().isEmpty())) {
                possibleMoves.add(neighbours.get((i + 1) % 6));
                possibleMoves.add(neighbours.get((i + 3) % 6));
                possibleMoves.add(neighbours.get((i + 4) % 6));
                possibleMoves.add(neighbours.get((i + 5) % 6));
                possibleMoves.add(neighbours.get((i) % 6));
                return;
            }
            if ((!neighbours.get(i).getTiles().isEmpty())
                    && (!neighbours.get((i + 1) % 6).getTiles().isEmpty())
                    && (neighbours.get((i + 2) % 6).getTiles().isEmpty())
                    && (neighbours.get((i + 3) % 6).getTiles().isEmpty())
                    && (neighbours.get((i + 4) % 6).getTiles().isEmpty())
                    && (neighbours.get((i + 5) % 6).getTiles().isEmpty())) {
                possibleMoves.add(neighbours.get((i + 2) % 6));
                possibleMoves.add(neighbours.get((i + 5) % 6));
                possibleMoves.add(neighbours.get((i + 1) % 6));
                possibleMoves.add(neighbours.get((i) % 6));
                return;
            }
            if ((!neighbours.get(i).getTiles().isEmpty())
                    && (neighbours.get((i + 1) % 6).getTiles().isEmpty())
                    && (!neighbours.get((i + 2) % 6).getTiles().isEmpty())
                    && (neighbours.get((i + 3) % 6).getTiles().isEmpty())
                    && (!neighbours.get((i + 4) % 6).getTiles().isEmpty())
                    && (neighbours.get((i + 5) % 6).getTiles().isEmpty())) {
                possibleMoves.addAll(neighbours);
                return;
            }
            if ((!neighbours.get(i).getTiles().isEmpty())
                    && (neighbours.get((i + 1) % 6).getTiles().isEmpty())
                    && (!neighbours.get((i + 2) % 6).getTiles().isEmpty())
                    && (!neighbours.get((i + 3) % 6).getTiles().isEmpty())
                    && (neighbours.get((i + 4) % 6).getTiles().isEmpty())
                    && (neighbours.get((i + 5) % 6).getTiles().isEmpty())) {
                possibleMoves.addAll(neighbours);
                return;
            }
            if ((!neighbours.get(i).getTiles().isEmpty())
                    && (neighbours.get((i + 1) % 6).getTiles().isEmpty())
                    && (neighbours.get((i + 2) % 6).getTiles().isEmpty())
                    && (!neighbours.get((i + 3) % 6).getTiles().isEmpty())
                    && (!neighbours.get((i + 4) % 6).getTiles().isEmpty())
                    && (neighbours.get((i + 5) % 6).getTiles().isEmpty())) {
                possibleMoves.addAll(neighbours);
                return;
            }
            if ((!neighbours.get(i).getTiles().isEmpty())
                    && (!neighbours.get((i + 1) % 6).getTiles().isEmpty())
                    && (!neighbours.get((i + 2) % 6).getTiles().isEmpty())
                    && (neighbours.get((i + 3) % 6).getTiles().isEmpty())
                    && (neighbours.get((i + 4) % 6).getTiles().isEmpty())
                    && (neighbours.get((i + 5) % 6).getTiles().isEmpty())) {
                possibleMoves.add(neighbours.get((i + 3) % 6));
                possibleMoves.add(neighbours.get((i + 5) % 6));
                possibleMoves.add(neighbours.get((i + 1) % 6));
                possibleMoves.add(neighbours.get((i + 2) % 6));
                possibleMoves.add(neighbours.get((i) % 6));
                return;
            }


        }
    }


}
