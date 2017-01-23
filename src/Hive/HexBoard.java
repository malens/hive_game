package Hive;

import Hive.GameController.TurnManager;
import Hive.Tiles.Tile;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import static Hive.GameController.GameController.endgame;
import static Hive.GameController.GameController.playing;

/**
 * Created by malens on 2017-01-04.
 */
public class HexBoard {

    //returns the width (amount of HexTiles) of this HexBoard
    public int getWidth() {
        return width;
    }
    //returns the height (amount of HexTiles) of this HexBoard
    public int getHeight() {
        return height;
    }

    private Group group;

    private TurnManager turn;

    public Group getGroup() {
        return group;
    }

    //represents our board
    private HexTile[][] board;
    //width, in number of Tiles, of board
    private int width;
    //height, in number of Tiles, of board
    private int height;
    //scale of all drawn HexTiles
    private double scale;
    //list of colours for all applicable states of HexTiles
    public final static Color enabledColor = Color.PINK;
    public final static Color disabledColor = Color.BLACK;


    public TurnManager getTurn() {
        return turn;
    }

    //creates a new HexBoard of width w, height h and scale s
    //also initializes all HexTiles in the HexBoard to disabled, children to this HexBoard, and in appropriate coords of the board
    public HexBoard(int w, int h, double s, Group group, TurnManager turn) {

        this.turn = turn;
        this.group = group;
        width = w;
        height = h;
        scale = s;
        board = new HexTile[w][h];
        for (int i = 0; i<height; i++)
        {
            for (int j = 0; j<width; j++)
            {
                if (i%2==0)
                {
                    board[j][i] = new HexTile(new Point2D(Math.sqrt(3)*scale*j,1.5*scale*i-0.5*scale), scale, false, this, new HexTile.BoardCoords(j, i));
                    board[j][i].addClickHandler();
                }
                else
                {
                    board[j][i] = new HexTile(new Point2D(Math.sqrt(3)*scale*j-Math.sqrt(3)/2*scale,1.5*scale*i-0.5*scale), scale, false, this, new HexTile.BoardCoords(j,i));
                    board[j][i].addClickHandler();
                }
            }
        }
    }

    // returns the board of this HexBoard
    public HexTile[][] getBoard()
    {
        return this.board;
    }

    public void Highlight (Player player){
        for (HexTile[] row:this.getBoard()){
            for (HexTile hex:row){
                if (!hex.getTiles().isEmpty()&&hex.getTiles().peek().getPlayer()==player){
                    for (HexTile x:hex.getNeighbours())
                    {
                        if (x.isEnabled()&&!x.isNeighbourWithOtherThan(player))
                            x.highlight(player);
                    }

                }
            }
        }
    }


    private boolean checkWinState(HexTile hextile){
        if (hextile.getTiles().isEmpty()) return false;
        if (hextile.getTiles().peek().getType()== Tile.type.BEE){
            for(HexTile x:hextile.getNeighbours()){
                if(x.getTiles().isEmpty()) return false;
            }
            return true;
        }
        return false;

    }

    // updates all HexTiles on this board to reflect their current state
    public void update ()
    {
        if (!playing) return;
        for (HexTile[] hexrow : this.board)
        {
            for (HexTile hextile : hexrow)
            {
                hextile.disable();
                if (checkWinState(hextile)){
                    Text text = new Text();
                    text.setText(hextile.getTiles().peek().getPlayer().getPlayerName().concat(" has lost!"));
                    text.setFill(Color.MAGENTA);
                    text.setFont(Font.font(30));
                    text.setX(400);
                    text.setY(300);
                    this.group.getChildren().add(text);
                    endgame();
                }
            }
        }
        for (HexTile[] hexrow : this.board)
        {
            for (HexTile hextile : hexrow)
            {

                if (!hextile.getTiles().isEmpty()){
                    hextile.disable();
                    for (HexTile x:hextile.getNeighbours()){
                        if (x.getTiles().isEmpty()){
                            x.enable();
                        }
                    }
                }




            }
        }
        for (HexTile[] hexrow : this.board)
        {
            for (HexTile hextile : hexrow)
            {

                if (hextile.isEnabled()){
                    hextile.getPoly().setFill(enabledColor);
                    hextile.getPlayerMarker().setFill(enabledColor);
                }

                else
                if (hextile.getTiles().empty()){
                    hextile.getPoly().setFill(disabledColor);
                    hextile.getPlayerMarker().setFill(disabledColor);
                }
                else {
                    hextile.getPoly().setFill(hextile.getTiles().peek().getColor());
                    hextile.getPlayerMarker().setFill(hextile.getTiles().peek().getPlayer().getPlayerColor());
                }



            }
        }



    }

}
