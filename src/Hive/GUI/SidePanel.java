package Hive.GUI;

import Hive.GameController.TurnManager;
import Hive.HexBoard;
import Hive.HexTile;
import Hive.Player;
import Hive.Tiles.Tile;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.util.ArrayList;

import static Hive.GameController.GameController.playing;
import static Hive.Tiles.Tile.type.BEE;

/**
 * Created by malens on 2017-01-08.
 */
public class SidePanel {
    public static boolean preview = false;
    public static boolean moves = false;
    public static ArrayList<HexTile> PossibleMoves;
    public static HexTile tilePreview;
    private GridPane panel;
    private Player owner;
    private double scale;
    private Point2D where;
    private Group scene;
    private Text title;
    private boolean queenWasPlaced = false;
    private HexBoard board;

    public boolean isQueenWasPlaced() {
        return queenWasPlaced;
    }

    public void setQueenWasPlaced() {
        this.queenWasPlaced = true;
    }

    public Player getOwner() {
        return owner;
    }

    public SidePanel(GridPane panel, Player currentPlayer, double scale, Point2D where, Group scene, HexBoard board) {
        this.board = board;
        this.panel = panel;
        panel.setPadding(new Insets(10,10,10,10));
        this.owner = currentPlayer;
        this.scale = scale;
        this.where = where;
        this.scene = scene;
        this.title = new Text();
        this.title.setText(currentPlayer.getPlayerName());
        this.title.setFill(Color.WHITE);
        this.title.setFont(Font.getDefault());
        this.title.setVisible(true);
        this.title.setFont(Font.font(30));
        this.panel.add(this.title,0,0);
        int i = 1;
        scene.getChildren().add(panel);
        for (Tile.type x: Tile.type.values()){
            HexTile hex = new HexTile(new Point2D (0,0), scale);
            Tile fake = new Tile();
            fake = fake.newTile(currentPlayer, x);
            for(int j=0;j<fake.getAvailable();j++) {
                Tile tile = new Tile();
                tile = tile.newTile(currentPlayer, x);
                hex.getTiles().push(tile);

            }
            hex.getPoly().setFill(fake.getColor());
            hex.getPlayerMarker().setFill(currentPlayer.getPlayerColor());
            panel.add(hex.getPoly(), i, 0);
            addClickHandler(hex);
            i++;
        }
    }

    public GridPane getPanel() {
        return panel;
    }

    public void addClickHandler (HexTile hex)
    {
        hex.getPoly().setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent t) {
                if (!playing){
                    return;
                }
                if (!preview)
                {
                    if (!hex.getTiles().isEmpty()) {
                        if (queenWasPlaced|| TurnManager.turnCounter<4){
                            SidePanel.this.board.Highlight(hex.getTiles().peek().getPlayer());
                            tilePreview = setTilePreview(owner, hex.getTiles().pop().getType(), new Point2D(t.getX(), t.getY()), scale);
                            tilePreview.getPoly().setFill(tilePreview.getTiles().peek().getColor());
                            scene.getChildren().add(tilePreview.getPoly());
                            if (tilePreview.getTiles().peek().getType()==BEE)
                                SidePanel.this.setQueenWasPlaced();
                            if (hex.getTiles().isEmpty())
                                hex.getPoly().setVisible(false);
                        }
                        else if (hex.getTiles().peek().getType()==BEE){
                            SidePanel.this.board.Highlight(hex.getTiles().peek().getPlayer());
                            tilePreview = setTilePreview(owner, hex.getTiles().pop().getType(), new Point2D(t.getX(), t.getY()), scale);
                            tilePreview.getPoly().setFill(tilePreview.getTiles().peek().getColor());
                            scene.getChildren().add(tilePreview.getPoly());
                            if (tilePreview.getTiles().peek().getType()==BEE)
                                SidePanel.this.setQueenWasPlaced();
                            if (hex.getTiles().isEmpty())
                                hex.getPoly().setVisible(false);

                        }
                    }
                }
            }
        });

    }


    public HexTile setTilePreview (Player player, Tile.type type, Point2D where, Double scale)
    {
        HexTile hex = new HexTile (where, scale);
        Tile tile = new Tile();
        tile = tile.newTile(player, type);
        hex.getTiles().push(tile);
        preview = true;
        return hex;
    }


    public HexTile getTilePreview() {
        return tilePreview;
    }
}
