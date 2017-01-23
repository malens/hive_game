package Hive.Tiles;

import Hive.HexTile;
import Hive.Player;
import javafx.scene.paint.Color;
import java.util.ArrayList;

import static Hive.Tiles.Tile.type.ANT;

/**
 * Created by malens on 2017-01-10.
 */
public class Ant extends Tile {

    public Ant(Player player) {
        this.player = player;
    }

    public int getAvailable() {
        return available;
    }

    private final int available = 3;
    private Player player;
    private Color color = Color.BLUE;
    private Tile.type type = ANT;

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
        getPossibleMovesAntAlt(hex, possibleMoves);
    }



    private void getPossibleMovesAntAlt (HexTile hex, ArrayList<HexTile> possibleMoves){
        for (HexTile[] rows:hex.getBoard().getBoard()){
            for (HexTile x:rows){
                if (x.isEnabled()&&!x.hasFiveNeighbours()){
                    possibleMoves.add(x);
                }
            }
        }
    }


    private void getPossibleMovesAnt (HexTile hex, ArrayList<HexTile> possibleMoves, HexTile previous)
    {
        ArrayList<HexTile> neighbours = (ArrayList) hex.getNeighbours();
        ArrayList<HexTile> potentialMoves = new ArrayList<>();
        for (int i = 0; i<=5; i++)
        {
            if ((neighbours.get(i).getTiles().isEmpty())
                    &&(neighbours.get((i+1)%6).getTiles().isEmpty())
                    &&(!neighbours.get((i+2)%6).getTiles().isEmpty())
                    &&(!neighbours.get((i+3)%6).getTiles().isEmpty())
                    &&(!neighbours.get((i+4)%6).getTiles().isEmpty())
                    &&(!neighbours.get((i+5)%6).getTiles().isEmpty()))
            {
                if (!possibleMoves.contains(neighbours.get((i)%6))&&(previous == null ||!previous.getNeighbours().contains(neighbours.get((i)%6))))
                {
                    possibleMoves.add(neighbours.get(i));
                    potentialMoves.add(neighbours.get(i));

                }
                if (!possibleMoves.contains(neighbours.get((i+1)%6))&&(previous == null ||!previous.getNeighbours().contains(neighbours.get((i+1)%6))))
                {
                    possibleMoves.add(neighbours.get((i+1)%6));
                    potentialMoves.add(neighbours.get((i+1)%6));
                }
                break;
            }
            if ((!neighbours.get(i).getTiles().isEmpty())
                    &&(neighbours.get((i+1)%6).getTiles().isEmpty())
                    &&(!neighbours.get((i+2)%6).getTiles().isEmpty())
                    &&(!neighbours.get((i+3)%6).getTiles().isEmpty())
                    &&(neighbours.get((i+4)%6).getTiles().isEmpty())
                    &&(!neighbours.get((i+5)%6).getTiles().isEmpty()))
            {
                break;
            }
            if ((!neighbours.get(i).getTiles().isEmpty())
                    &&(neighbours.get((i+1)%6).getTiles().isEmpty())
                    &&(!neighbours.get((i+2)%6).getTiles().isEmpty())
                    &&(!neighbours.get((i+3)%6).getTiles().isEmpty())
                    &&(!neighbours.get((i+4)%6).getTiles().isEmpty())
                    &&(neighbours.get((i+5)%6).getTiles().isEmpty()))
            {
                break;
            }
            if ((neighbours.get(i).getTiles().isEmpty())
                    &&(!neighbours.get((i+1)%6).getTiles().isEmpty())
                    &&(!neighbours.get((i+2)%6).getTiles().isEmpty())
                    &&(!neighbours.get((i+3)%6).getTiles().isEmpty())
                    &&(!neighbours.get((i+4)%6).getTiles().isEmpty())
                    &&(!neighbours.get((i+5)%6).getTiles().isEmpty()))
            {
                break;
            }
            if ((!neighbours.get(i).getTiles().isEmpty())
                    &&(neighbours.get((i+1)%6).getTiles().isEmpty())
                    &&(neighbours.get((i+2)%6).getTiles().isEmpty())
                    &&(neighbours.get((i+3)%6).getTiles().isEmpty())
                    &&(neighbours.get((i+4)%6).getTiles().isEmpty())
                    &&(neighbours.get((i+5)%6).getTiles().isEmpty()))
            {
                if (!possibleMoves.contains(neighbours.get((i+1)%6))&&(previous == null ||!previous.getNeighbours().contains(neighbours.get((i+1)%6))))
                {
                    possibleMoves.add(neighbours.get((i+1)%6));
                    potentialMoves.add(neighbours.get((i+1)%6));
                }

                if (!possibleMoves.contains(neighbours.get((i+5)%6))&&(previous == null ||!previous.getNeighbours().contains(neighbours.get((i+5)%6))))
                {
                    possibleMoves.add(neighbours.get((i+5)%6));
                    potentialMoves.add(neighbours.get((i+5)%6));
                }

                break;
            }
            if ((!neighbours.get(i).getTiles().isEmpty())
                    &&(neighbours.get((i+1)%6).getTiles().isEmpty())
                    &&(neighbours.get((i+2)%6).getTiles().isEmpty())
                    &&(!neighbours.get((i+3)%6).getTiles().isEmpty())
                    &&(neighbours.get((i+4)%6).getTiles().isEmpty())
                    &&(neighbours.get((i+5)%6).getTiles().isEmpty()))
            {
                if (!possibleMoves.contains(neighbours.get((i+1)%6))&&(previous == null ||!previous.getNeighbours().contains(neighbours.get((i+1)%6))))
                {
                    possibleMoves.add(neighbours.get((i+1)%6));
                    potentialMoves.add(neighbours.get((i+1)%6));
                }
                if (!possibleMoves.contains(neighbours.get((i+2)%6))&&(previous == null ||!previous.getNeighbours().contains(neighbours.get((i+2)%6))))
                {
                    possibleMoves.add(neighbours.get((i+2)%6));
                    potentialMoves.add(neighbours.get((i+2)%6));
                }
                if (!possibleMoves.contains(neighbours.get((i+4)%6))&&(previous == null ||!previous.getNeighbours().contains(neighbours.get((i+4)%6))))
                {
                    possibleMoves.add(neighbours.get((i+4)%6));
                    potentialMoves.add(neighbours.get((i+4)%6));
                }
                if (!possibleMoves.contains(neighbours.get((i+5)%6))&&(previous == null ||!previous.getNeighbours().contains(neighbours.get((i+5)%6))))
                {
                    possibleMoves.add(neighbours.get((i+5)%6));
                    potentialMoves.add(neighbours.get((i+5)%6));
                }

                break;
            }
            if ((!neighbours.get(i).getTiles().isEmpty())
                    &&(neighbours.get((i+1)%6).getTiles().isEmpty())
                    &&(neighbours.get((i+2)%6).getTiles().isEmpty())
                    &&(neighbours.get((i+3)%6).getTiles().isEmpty())
                    &&(!neighbours.get((i+4)%6).getTiles().isEmpty())
                    &&(neighbours.get((i+5)%6).getTiles().isEmpty()))
            {
                if (!possibleMoves.contains(neighbours.get((i+1)%6))&&(previous == null ||!previous.getNeighbours().contains(neighbours.get((i+1)%6))))
                {
                    possibleMoves.add(neighbours.get((i+1)%6));
                    potentialMoves.add(neighbours.get((i+1)%6));
                }
                if (!possibleMoves.contains(neighbours.get((i+3)%6))&&(previous == null ||!previous.getNeighbours().contains(neighbours.get((i+3)%6))))
                {
                    possibleMoves.add(neighbours.get((i+3)%6));
                    potentialMoves.add(neighbours.get((i+3)%6));
                }
                break;
            }
            if ((!neighbours.get(i).getTiles().isEmpty())
                    &&(!neighbours.get((i+1)%6).getTiles().isEmpty())
                    &&(neighbours.get((i+2)%6).getTiles().isEmpty())
                    &&(neighbours.get((i+3)%6).getTiles().isEmpty())
                    &&(neighbours.get((i+4)%6).getTiles().isEmpty())
                    &&(neighbours.get((i+5)%6).getTiles().isEmpty()))
            {
                if (!possibleMoves.contains(neighbours.get((i+2)%6))&&(previous == null ||!previous.getNeighbours().contains(neighbours.get((i+2)%6))))
                {
                    possibleMoves.add(neighbours.get((i+2)%6));
                    potentialMoves.add(neighbours.get((i+2)%6));
                }
                if (!possibleMoves.contains(neighbours.get((i+5)%6))&&(previous == null ||!previous.getNeighbours().contains(neighbours.get((i+5)%6))))
                {
                    possibleMoves.add(neighbours.get((i+5)%6));
                    potentialMoves.add(neighbours.get((i+5)%6));
                }


                break;
            }
            if ((!neighbours.get(i).getTiles().isEmpty())
                    &&(neighbours.get((i+1)%6).getTiles().isEmpty())
                    &&(!neighbours.get((i+2)%6).getTiles().isEmpty())
                    &&(neighbours.get((i+3)%6).getTiles().isEmpty())
                    &&(!neighbours.get((i+4)%6).getTiles().isEmpty())
                    &&(neighbours.get((i+5)%6).getTiles().isEmpty()))
            {
                break;
            }
            if ((!neighbours.get(i).getTiles().isEmpty())
                    &&(neighbours.get((i+1)%6).getTiles().isEmpty())
                    &&(!neighbours.get((i+2)%6).getTiles().isEmpty())
                    &&(!neighbours.get((i+3)%6).getTiles().isEmpty())
                    &&(neighbours.get((i+4)%6).getTiles().isEmpty())
                    &&(neighbours.get((i+5)%6).getTiles().isEmpty()))
            {
                if (!possibleMoves.contains(neighbours.get((i+4)%6))&&(previous == null ||!previous.getNeighbours().contains(neighbours.get((i+4)%6))))
                {
                    possibleMoves.add(neighbours.get((i+4)%6));
                    potentialMoves.add(neighbours.get((i+4)%6));
                }

                if (!possibleMoves.contains(neighbours.get((i+5)%6))&&(previous == null ||!previous.getNeighbours().contains(neighbours.get((i+5)%6))))
                {
                    possibleMoves.add(neighbours.get((i+5)%6));
                    potentialMoves.add(neighbours.get((i+5)%6));
                }

                break;
            }
            if ((!neighbours.get(i).getTiles().isEmpty())
                    &&(neighbours.get((i+1)%6).getTiles().isEmpty())
                    &&(neighbours.get((i+2)%6).getTiles().isEmpty())
                    &&(!neighbours.get((i+3)%6).getTiles().isEmpty())
                    &&(!neighbours.get((i+4)%6).getTiles().isEmpty())
                    &&(neighbours.get((i+5)%6).getTiles().isEmpty()))
            {
                if (!possibleMoves.contains(neighbours.get((i+1)%6))&&(previous == null ||!previous.getNeighbours().contains(neighbours.get((i+1)%6))))
                {
                    possibleMoves.add(neighbours.get((i + 1) % 6));
                    potentialMoves.add(neighbours.get((i + 1) % 6));
                }
                if (!possibleMoves.contains(neighbours.get((i+2)%6))&&(previous == null ||!previous.getNeighbours().contains(neighbours.get((i+2)%6))))
                {
                    possibleMoves.add(neighbours.get((i+2)%6));
                    potentialMoves.add(neighbours.get((i+2)%6));
                }

                break;
            }
            if ((!neighbours.get(i).getTiles().isEmpty())
                    &&(!neighbours.get((i+1)%6).getTiles().isEmpty())
                    &&(!neighbours.get((i+2)%6).getTiles().isEmpty())
                    &&(neighbours.get((i+3)%6).getTiles().isEmpty())
                    &&(neighbours.get((i+4)%6).getTiles().isEmpty())
                    &&(neighbours.get((i+5)%6).getTiles().isEmpty()))
            {
                if (!possibleMoves.contains(neighbours.get((i+3)%6))&&(previous == null ||!previous.getNeighbours().contains(neighbours.get((i+3)%6))))
                {
                    possibleMoves.add(neighbours.get((i + 3) % 6));
                    potentialMoves.add(neighbours.get((i + 3) % 6));
                }
                if (!possibleMoves.contains(neighbours.get((i+5)%6))&&(previous == null ||!previous.getNeighbours().contains(neighbours.get((i+5)%6))))
                {
                    possibleMoves.add(neighbours.get((i+5)%6));
                    potentialMoves.add(neighbours.get((i+5)%6));
                }


                break;
            }

            
        }
        for (HexTile x:potentialMoves)
        {
            getPossibleMovesAnt(x, possibleMoves, hex);
        }
        potentialMoves.removeAll(potentialMoves);
        return;

        


    }
}
