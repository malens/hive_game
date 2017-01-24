package Hive.Tiles;

import Hive.HexTile;
import Hive.Player;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import static Hive.Tiles.Tile.type.SPIDER;

/**
 * Created by malens on 2017-01-22.
 */
public class Spider extends Tile {

    public Spider(Player player) {
        this.player = player;
    }
    private Player player;
    private Color color = Color.BROWN;
    private Tile.type type = SPIDER;
    private final int available = 2;

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

    public void getPossibleMoves (HexTile hex, ArrayList<HexTile> possibleMoves){
        getPossibleMovesSpider(hex, possibleMoves, 0, null);
        return;
    }
    private void getPossibleMovesSpider (HexTile hex, ArrayList<HexTile> possibleMoves, int moves, HexTile previous)
    {
        ArrayList<HexTile> neighbours = (ArrayList) hex.getNeighbours();
        ArrayList<HexTile> potentialMoves = new ArrayList<>();
        if (moves>=3) return;
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


                if (!possibleMoves.contains(neighbours.get((i+5)%6))&&(previous == null ||!previous.getNeighbours().contains(neighbours.get((i+5)%6))))
                {
                    possibleMoves.add(neighbours.get((i+5)%6));
                    potentialMoves.add(neighbours.get((i+5)%6));
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
            getPossibleMovesSpider(x, possibleMoves, moves+1, hex);
        }
        potentialMoves.removeAll(potentialMoves);
        return;




    }
    }



