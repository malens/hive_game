package Hive;

/**
 * Created by malens on 2017-01-04.
 */
import Hive.GameController.TurnManager;
import Hive.Tiles.Tile;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static Hive.GUI.SidePanel.*;
import static Hive.GameController.GameController.playing;
import static Hive.Tiles.Tile.type.BEETLE;


public class HexTile extends Polygon{


    /*
    *creates a HexTile in the place pointed to by where and with a scale of scale.
    *fills with a default color <- to be changed
    *adds a handler for clicks
     */
    public HexTile(Point2D where, double scale) {
        coords = where;
        this.scale = scale;
        hexagon = new Polygon();
        hexagon.getPoints().addAll(new Double[]{
                Math.sqrt(3) / 2 * scale + coords.getX(), 0.0* scale + coords.getY(),
                Math.sqrt(3)* scale + coords.getX(), 0.5* scale + coords.getY(),
                Math.sqrt(3)* scale + coords.getX(), 1.5* scale + coords.getY(),
                Math.sqrt(3)/2* scale + coords.getX(), 2.0* scale + coords.getY(),
                0.0* scale + coords.getX(), 1.5* scale + coords.getY(),
                0.0* scale + coords.getX(), 0.5* scale + coords.getY()});
        hexagon.setFill(Color.BLACK);
        playerMarker = new Polygon();
        playerMarker.getPoints().addAll(new Double[]{
                Math.sqrt(3) / 2 * scale + coords.getX(), 0.5* scale + coords.getY(),
                Math.sqrt(3)*3/4* scale + coords.getX(), 0.75* scale + coords.getY(),
                Math.sqrt(3)*3/4* scale + coords.getX(), 1.25* scale + coords.getY(),
                Math.sqrt(3)/2* scale + coords.getX(), 1.5* scale + coords.getY(),
                Math.sqrt(3)/4* scale + coords.getX(), 1.25* scale + coords.getY(),
                Math.sqrt(3)/4* scale + coords.getX(), 0.75* scale + coords.getY()});
        playerMarker.setFill(Color.BLACK);
        tiles = new Stack<Tile>();
    }

    public void highlight(Player player){
        this.getPoly().setFill(Color.MAGENTA);
        this.getPlayerMarker().setFill(player.getPlayerColor());
    }


    public HexBoard getBoard() {
        return parent;
    }

    // additionally enables the HexTile on creation
    public HexTile(Point2D where, double scale, Boolean enabled){
        this(where, scale);
        this.enabled = enabled;
    }

    // additionally adds a pointer to the HexBoard on which we put the HexTile
    public HexTile(Point2D where, double scale, Boolean enabled, HexBoard parent)
    {
        this(where, scale, enabled);
        this.parent = parent;
    }

    // additionally stores coords of the HexTile in the HexBoard array
    public HexTile(Point2D where, double scale, Boolean enabled, HexBoard parent, BoardCoords boardCoords)
    {
        this(where, scale, enabled, parent);
        this.boardCoords = boardCoords;
    }

    public boolean isNeighbourWithOtherThan (Player player){
        for (HexTile y:this.getNeighbours()){
            if (!y.getTiles().isEmpty()&&y.getTiles().peek().getPlayer()!=player)
                return true;
        }
        return false;
    }

    // canvas coords for drawing
    private Point2D coords;
    // what is actually drawn
    private Polygon hexagon;
    private Polygon playerMarker;
    // used for recognizing whether a tile can be put on HexTile
    private Boolean enabled = false;
    // scale of the HexTile
    private Double scale;
    // the HexBoard on which we put the HexTile
    private HexBoard parent;
    // position in the HexBoard's array
    private BoardCoords boardCoords;
    // what Tiles are currently in this place (some tiles can go on top of others, hence we use stack)
    private Stack<Tile> tiles;

    private Text text;

    public Polygon getPlayerMarker() {
        return playerMarker;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    // returns all the tiles currently on HexTile
    public Stack<Tile> getTiles() {
        return tiles;
    }



    // used for clearer code - position in HexBoards array
    static class BoardCoords {
        public int x;
        public int y;

        public BoardCoords(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // returns position on parents array

    public BoardCoords getBoardCoords(){
        return boardCoords;
    }


    public boolean hasFiveNeighbours (){
        int i=0;
        for(HexTile x:this.getNeighbours()){
            if (!x.getTiles().isEmpty()){
                i++;
            } else {
                int k=0;
                for (HexTile y:x.getNeighbours()){
                    if (!y.getTiles().isEmpty()){
                        k++;
                    }
                }
                if (k==5) return true;
            }
        }
        if (i==0) return true;
        return (i==5);
    }

    // adds a handler for onClick actions

    public void addClickHandler () {
        hexagon.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent t) {
                if (!playing) {
                    return;
                }
                if (!preview)
                {
                    if (HexTile.this.canMove()&&!tiles.isEmpty()&&tiles.peek().getPlayer().equals(parent.getTurn().getCurrentPlayer()))
                    {
                        Tile tmp = tiles.pop();
                        PossibleMoves = new ArrayList<HexTile>();
                        tmp.getPossibleMoves(HexTile.this, PossibleMoves);
                        PossibleMoves.remove(HexTile.this);
                        tiles.push(tmp);
                        if(!PossibleMoves.isEmpty())
                        {
                            for (HexTile x : PossibleMoves) {
                                x.getPoly().setFill(Color.MAGENTA);
                            }

                            tilePreview = parent.getTurn().getController().getCurrentPlayerPanel().setTilePreview(parent.getTurn().getCurrentPlayer(), HexTile.this.getTiles().peek().getType(), new Point2D(t.getX(), t.getY()), scale);
                            tilePreview.getPoly().setFill(tilePreview.getTiles().peek().getColor());
                            parent.getGroup().getChildren().add(tilePreview.getPoly());
                            moves = true;
                            tiles.pop();
                        }
/*
                        if(parent.getTurn().getCurrentPlayer().getPlayerID()==1)
                        {
                            tilePreview = parent.getTurn().getController().getPanelplayer1().setTilePreview(parent.getTurn().getCurrentPlayer(), HexTile.this.getTiles().peek().getType(), new Point2D(t.getX(), t.getY()), scale);
                            tilePreview.getPoly().setFill(tilePreview.getTiles().peek().getColor());
                            parent.getGroup().getChildren().add(tilePreview.getPoly());
                            PossibleMoves = new ArrayList<HexTile>();
                            tiles.peek().getPossibleMoves(HexTile.this, PossibleMoves);
                            for (HexTile x:PossibleMoves){
                                x.getPoly().setFill(Color.MAGENTA);
                            }
                            moves = true;
                            tiles.pop();
                        }
                        else if (parent.getTurn().getCurrentPlayer().getPlayerID()==2){
                            tilePreview = parent.getTurn().getController().getPanelplayer2().setTilePreview(parent.getTurn().getCurrentPlayer(), HexTile.this.getTiles().peek().getType(), new Point2D(t.getX(), t.getY()), scale);
                            tilePreview.getPoly().setFill(tilePreview.getTiles().peek().getColor());
                            parent.getGroup().getChildren().add(tilePreview.getPoly());
                            PossibleMoves = new ArrayList<HexTile>();
                            tiles.peek().getPossibleMoves(HexTile.this, PossibleMoves);
                            for (HexTile x:PossibleMoves){
                                x.getPoly().setFill(Color.MAGENTA);
                            }
                            moves = true;
                            tiles.pop();
                        }
   */                 }

                }
                else{
                    if (moves){
                        moveTile(tilePreview, parent.getGroup());
                    } else
                    placeTile(tilePreview, parent.getGroup());
                }}
        });
        playerMarker.setOnMouseClicked(hexagon.getOnMouseClicked());
    }



    // next 6 methods return coords of neighbouring HexTiles

    public BoardCoords getLeftCoords ()
    {
        if (this.boardCoords.x==0) return null;
        return new BoardCoords(boardCoords.x-1, boardCoords.y);
    }
    public BoardCoords getRightCoords ()
    {
        if (this.boardCoords.x==this.parent.getWidth()-1) return null;
        return new BoardCoords(boardCoords.x+1, boardCoords.y);
    }
    public BoardCoords getTopLeftCoords()
    {
        if (this.boardCoords.x==0||this.boardCoords.y==0) return null;
        if (this.boardCoords.y%2==0){
            return new BoardCoords(boardCoords.x, boardCoords.y-1);
        }
        else{
            if (this.boardCoords.x==0) return null;
            return new BoardCoords(boardCoords.x-1, boardCoords.y-1);
        }

    }
    public BoardCoords getTopRightCoords()
    {
        if (this.boardCoords.x==this.parent.getWidth()-1||this.boardCoords.y==0) return null;
        if (this.boardCoords.y%2==0)
        {
            return new BoardCoords(boardCoords.x+1, boardCoords.y-1);
        }

        else
            return new BoardCoords(boardCoords.x, boardCoords.y-1);
    }
    public BoardCoords getBotLeftCoords()
    {
        if (this.boardCoords.x==0||this.boardCoords.y==this.parent.getHeight()-1) return null;
        if (this.boardCoords.y%2==0)
            return new BoardCoords(boardCoords.x, boardCoords.y+1);
        else
            return new BoardCoords(boardCoords.x-1, boardCoords.y+1);
    }
    public BoardCoords getBotRightCoords()
    {

        if (this.boardCoords.x==this.parent.getWidth()-1||this.boardCoords.y==this.parent.getHeight()-1) return null;
        if (this.boardCoords.y%2==0)
            return new BoardCoords(boardCoords.x+1, boardCoords.y+1);
        else
        {
            return new BoardCoords (boardCoords.x, boardCoords.y+1);
        }

    }

    // next 6 methods return current HexTiles neighbours

    public HexTile getLeftTile (){
        if (this.getLeftCoords()==null) return null;
        return parent.getBoard()[this.getLeftCoords().x][this.getLeftCoords().y];
    }
    public HexTile getRightTile (){
        if (this.getRightCoords()==null) return null;
        return parent.getBoard()[this.getRightCoords().x][this.getRightCoords().y];
    }
    public HexTile getTopLeftTile (){
        if (this.getTopLeftCoords()==null) return null;
        return parent.getBoard()[this.getTopLeftCoords().x][this.getTopLeftCoords().y];
    }
    public HexTile getBotLeftTile (){
        if (this.getBotLeftCoords()==null) return null;
        return parent.getBoard()[this.getBotLeftCoords().x][this.getBotLeftCoords().y];
    }
    public HexTile getTopRightTile (){
        if (this.getTopRightCoords()==null) return null;
        return parent.getBoard()[this.getTopRightCoords().x][this.getTopRightCoords().y];
    }
    public HexTile getBotRightTile (){
        if (this.getBotRightCoords()==null) return null;
        return parent.getBoard()[this.getBotRightCoords().x][this.getBotRightCoords().y];

    }


    // enables the HexTile
    public void enable (){
        this.enabled = true;
    }
    //disables the HexTile
    public void disable () {this.enabled = false;}

    // returns the state of HexTile (enabled/disabled)
    public boolean isEnabled () {return this.enabled;}

    //returns the polygon that is drawn
    public Polygon getPoly () {
        return this.hexagon;
    }

    // returns a list of all existing neighbouring HexTiles
    public List<HexTile> getNeighbours ()
    {
        List<HexTile> hex = new ArrayList<HexTile>();
        if (this.getLeftTile()!=null)
            hex.add(this.getLeftTile());
        if (this.getTopLeftTile()!=null)
            hex.add(this.getTopLeftTile());
        if (this.getTopRightTile()!=null)
            hex.add(this.getTopRightTile());
        if (this.getRightTile()!=null)
            hex.add(this.getRightTile());
        if (this.getBotRightTile()!=null)
            hex.add(this.getBotRightTile());
        if (this.getBotLeftTile()!=null)
            hex.add(this.getBotLeftTile());
        return hex;
    }

    public List<HexTile> getEnabledNeighbours ()
    {
        List<HexTile> hex = new ArrayList<HexTile>();
        if (this.getLeftTile()!=null&&this.getLeftTile().isEnabled())
            hex.add(this.getLeftTile());
        if (this.getTopLeftTile()!=null&&this.getTopLeftTile().isEnabled())
            hex.add(this.getTopLeftTile());
        if (this.getTopRightTile()!=null&&this.getTopRightTile().isEnabled())
            hex.add(this.getTopRightTile());
        if (this.getRightTile()!=null&&this.getRightTile().isEnabled())
            hex.add(this.getRightTile());
        if (this.getBotRightTile()!=null&&this.getBotRightTile().isEnabled())
            hex.add(this.getBotRightTile());
        if (this.getBotLeftTile()!=null&&this.getBotLeftTile().isEnabled())
            hex.add(this.getBotLeftTile());
        return hex;
    }



    //checks whether a new Tile owned by player can be placed on this HexTile
    public boolean canPlace (Player player)
    {
        if (!this.isEnabled()) return false;
        if (this.parent.getTurn().getTurnCounter()==1) return true;
        List<HexTile> hex = this.getNeighbours();
        for (HexTile h:hex)
        {
            if ((!h.tiles.empty())&&!h.tiles.peek().getPlayer().equals(player))
                return false;
        }

        return true;
    }

    public boolean canMove (){
        if (TurnManager.turnCounter<5) return false;

        if (this.getTiles().isEmpty())return false;
        if (this.getTiles().peek().getType()==BEETLE&&this.getTiles().size()>1) return true;
        int i=0;
        for (HexTile[] hexrow:this.parent.getBoard()){
            for (HexTile hex:hexrow){
                if (!hex.getTiles().isEmpty()){
                    i++;
                }
            }
        }
        Tile tmp = this.getTiles().pop();
        ArrayList<HexTile> neighbours = (ArrayList<HexTile>) this.getNeighbours();
        HexTile base = null;

        for (int k=0; k<6;k++){
            if (!neighbours.get(k).getTiles().isEmpty()) base = neighbours.get(k);
        }

        if (base==null) return false;

        Stack<HexTile> toVisit = new Stack<>();
        neighbours = (ArrayList<HexTile>) base.getNeighbours();
        ArrayList<HexTile> visited = new ArrayList<>();
        visited.add(base);
        i--;

        for (int k=0; k<6; k++){
            if(!neighbours.get(k).getTiles().isEmpty()) toVisit.add(neighbours.get(k));
        }

        while (!toVisit.isEmpty()){
            HexTile x = toVisit.pop();

            if (!visited.contains(x)) {
                visited.add(x);
                toVisit.remove(x);
                i--;
                for (HexTile k:x.getNeighbours()){
                    if (!visited.contains(k)&&!toVisit.contains(k)&&!k.getTiles().isEmpty()) toVisit.add(k);
                }
            }
        }
        this.getTiles().push(tmp);
        return (i==1);

    }

    // places a new Tile on this HexTile if it is possible
    public void placeTile (HexTile previewed, Group group)
    {
        if(this.canPlace(previewed.getTiles().peek().getPlayer())) {
            this.tiles.push(previewed.getTiles().peek());
            this.getPoly().setFill(previewed.getPoly().getFill());
            this.getPlayerMarker().setFill(previewed.getTiles().peek().getPlayer().getPlayerColor());
            group.getChildren().remove(previewed.getPoly());
            preview = false;
            for (HexTile x : this.getNeighbours()) {
                if (x.getTiles().empty())
                    x.enable();

            }
            this.disable();
            previewed = null;
            this.parent.update();
            this.parent.getTurn().nextTurn();

        }
    }

    public void moveTile (HexTile previewed, Group group)
    {
        if (PossibleMoves.contains(this))
        {
            this.tiles.push(previewed.getTiles().peek());
            this.getPoly().setFill(previewed.getPoly().getFill());
            this.getPlayerMarker().setFill(previewed.getTiles().peek().getPlayer().getPlayerColor());
            group.getChildren().remove(previewed.getPoly());
            preview = false;
            for (HexTile x : this.getNeighbours()) {
                if (x.getTiles().empty())
                    x.enable();

            }
            this.disable();
            previewed = null;
            moves = false;
            this.parent.update();
            this.parent.getTurn().nextTurn();
            for (HexTile x:PossibleMoves){
                if (!x.getTiles().isEmpty())
                    x.getPoly().setFill(x.getTiles().peek().getColor());
            }
            PossibleMoves.removeAll(PossibleMoves);
            parent.update();
        }
    }




}
