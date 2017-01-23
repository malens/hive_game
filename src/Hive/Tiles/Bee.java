package Hive.Tiles;

import Hive.HexTile;
import Hive.Player;
import javafx.scene.paint.Color;

import java.util.ArrayList;

import static Hive.Tiles.Tile.type.BEE;


/**
 * Created by malens on 2017-01-22.
 */
public class Bee extends Tile {

    public Bee(Player player) {
        this.player = player;
    }
    private Player player;
    private Color color = Color.GOLD;
    private Tile.type type = BEE;

    public int getAvailable() {
        return available;
    }

    private final int available = 1;

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
        getPossibleMovesBee(hex, possibleMoves, 1, null);
        return;
    }
    private void getPossibleMovesBee (HexTile hex, ArrayList<HexTile> possibleMoves, int moves, HexTile previous)
    {
        ArrayList<HexTile> neighbours = (ArrayList) hex.getNeighbours();
        ArrayList<HexTile> potentialMoves = new ArrayList<>();
        if (moves>=2) return;
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
            getPossibleMovesBee(x, possibleMoves, ++moves, hex);
        }
        potentialMoves.removeAll(potentialMoves);
        return;




    }
}

