package Hive.GameController;

import Hive.GUI.SidePanel;
import Hive.HexBoard;
import Hive.HexTile;
import Hive.Player;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by malens on 2017-01-04.
 */
public class GameController extends Application {

    // the width of game window
    public static boolean playing=true;
    private int scrw;
    // the height of game window
    private int scrh;
    // the vertical (h) and horizontal (w) amount of tile rows we draw
    private int w, h;
    // scale of each hextile
    private double scale;
    private TurnManager turns;
    private Group group;

    public static void endgame(){
        playing = false;
    }

    public Group getGroup() {
        return group;
    }
    private SidePanel panelplayer1;
    private SidePanel panelplayer2;

    public SidePanel getCurrentPlayerPanel(){
        if (this.turns.getCurrentPlayer()==this.getPanelplayer1().getOwner()) return getPanelplayer1();
        else return getPanelplayer2();
    }

    public SidePanel getPanelplayer1() {
        return panelplayer1;
    }

    public SidePanel getPanelplayer2() {
        return panelplayer2;
    }

    // sets up the game window
    public void setUp (int scrw, int scrh, int w, int h)
    {
        this.scrw = scrw;
        this.scrh = scrh;
        this.w = w;
        this.h = h;
        scale = (double)scrh/(double)h/1.5;
    }

    public void addOnMouseMoveHandler (Group scene, SidePanel panel)
    {
        scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (panel.preview)
                {
                    panel.getTilePreview().getPoly().relocate(event.getSceneX(), event.getSceneY());
                }
            }
        });
    }


    // creates the game window
    @Override
    public void start(Stage primaryStage) throws Exception {

        setUp(1000, 900, 20, 20);
        Group gameBoardGroup = new Group();
        //stub, need to change it to sth sensible and scalable
        Scene gameBoard = new Scene (gameBoardGroup, scrw-20, scrh-30);
        primaryStage.setResizable(false);

        this.turns = new TurnManager(this);
        HexBoard hex = new HexBoard(w,h, scale, gameBoardGroup, turns);
        turns.setBoard(hex);
        for (HexTile[] hexrow : hex.getBoard())
        {
            for (HexTile hextile : hexrow)
            {
                gameBoardGroup.getChildren().add(hextile.getPoly());
                gameBoardGroup.getChildren().add(hextile.getPlayerMarker());
            }
        }
        hex.getBoard()[(w-1)/2][(h-1)/2].enable();
        hex.getBoard()[(w-1)/2][(h-1)/2].getPoly().setFill(Color.PINK);
        hex.getBoard()[(w-1)/2][(h-1)/2].getPlayerMarker().setFill(Color.PINK);

        Player player1 = new Player(2, "player1", Color.BLACK);
        Player player2 = new Player (1, "player2", Color.WHITE);
        turns.addPlayer(player1);
        turns.addPlayer(player2);
        this.group = gameBoardGroup;
        this.panelplayer1 = new SidePanel (new GridPane(), player1, scale, new Point2D(0,0), gameBoardGroup, hex);
        this.panelplayer2 = new SidePanel (new GridPane(), player2, scale, new Point2D(0, 0), gameBoardGroup, hex);
        turns.setUp();
        //turns.nextTurn();



        addOnMouseMoveHandler(gameBoardGroup, this.panelplayer1);
        addOnMouseMoveHandler(gameBoardGroup, this.panelplayer2);
        primaryStage.setTitle("Hive Game");
        primaryStage.setScene(gameBoard);
        primaryStage.show();

    }

    public static void main(String[] args){
        launch(args);
    }
}
