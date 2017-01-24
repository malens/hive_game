package Hive.GameController;

import Hive.GUI.SidePanel;
import Hive.HexBoard;
import Hive.HexTile;
import Hive.Player;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    private String player1name="player1";
    private String player2name="player2";
    private TextField txt1;
    private TextField txt2;
    // scale of each hextile
    private double scale;
    private TurnManager turns;
    private Group group;
    private Stage mainStage;

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

    private void addOnMouseMoveHandler (Group scene, SidePanel panel)
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


        mainStage = primaryStage;
        mainStage.setResizable(false);
        setMenu();
        mainStage.show();
    }

    private void setMenu (){

        GridPane panel = new GridPane ();
        Button but1 = new Button("Set player 1 name");
        Button but2 = new Button("Set player 2 name");
        Button but3 = new Button("Start");
        TextField txt1 = new TextField (player1name);
        TextField txt2 = new TextField (player2name);
        txt1.setAlignment(Pos.BASELINE_CENTER);
        txt2.setAlignment(Pos.BASELINE_CENTER);
        panel.add(txt1, 0, 1);
        panel.add(txt2, 0, 2);
        panel.add(but1, 1, 1);
        panel.add(but2, 1, 2);
        panel.add(but3, 0, 3);
        but1.setOnAction(new EventHandler<ActionEvent>(){
            public void handle (ActionEvent e){
                player1name = txt1.getText();
            }
        });
        but2.setOnAction(new EventHandler<ActionEvent>(){
            public void handle (ActionEvent e){
                player2name = txt2.getText();
            }
        });
        but3.setOnAction(new EventHandler<ActionEvent>(){
            public void handle (ActionEvent e){
                setGame();
            }
        });
        Scene menuScene = new Scene (panel);
        mainStage.setTitle("Setup");
        mainStage.setScene(menuScene);
    }





    private void setGame (){
        setUp(1000, 700, 26, 20);
        Group gameBoardGroup = new Group();
        Scene gameScene = new Scene (gameBoardGroup, scrw, scrh-scale);
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

        Player player1 = new Player(2, player1name, Color.BLACK);
        Player player2 = new Player (1, player2name, Color.WHITE);
        turns.addPlayer(player1);
        turns.addPlayer(player2);
        this.group = gameBoardGroup;
        this.panelplayer1 = new SidePanel (new GridPane(), player1, scale, new Point2D(0,0), gameBoardGroup, hex);
        this.panelplayer2 = new SidePanel (new GridPane(), player2, scale, new Point2D(0, 0), gameBoardGroup, hex);
        turns.setUp();

        addOnMouseMoveHandler(gameBoardGroup, this.panelplayer1);
        addOnMouseMoveHandler(gameBoardGroup, this.panelplayer2);
        mainStage.setTitle("Hive Game");
        mainStage.setScene(gameScene);
        mainStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
