package Hive.GameController;

import Hive.HexBoard;
import Hive.Player;
import java.util.ArrayList;

/**
 * Created by malens on 2017-01-22.
 */
public class TurnManager {

    private Player currentPlayer;
    private ArrayList<Player> allPlayers;
    public static int turnCounter=1;
    private HexBoard board;
    private GameController controller;



    public void setBoard(HexBoard board) {
        this.board = board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    public Player getOtherPlayer(){
        if (currentPlayer==allPlayers.get(0)) return allPlayers.get(1);
        else return allPlayers.get(0);
    }


    public GameController getController() {

        return controller;
    }

    public int getTurnCounter() {
        return turnCounter;
    }

    public TurnManager(GameController controller) {

        this.controller = controller;
        this.allPlayers = new ArrayList<>();
    }

    void addPlayer(Player player){
        allPlayers.add(player);
    }

    public void setUp(){
        currentPlayer = allPlayers.get(0);
        turnCounter = 1;
        update();
    }

    public void nextTurn(){
        if (currentPlayer == allPlayers.get(1))
            this.turnCounter++;

        currentPlayer = nextPlayer();
        update();

    }

    public Player nextPlayer(){
        if (currentPlayer==allPlayers.get(0)) {
            currentPlayer = allPlayers.get(1);
        } else
            currentPlayer = allPlayers.get(0);
        this.update();
        return currentPlayer;
    }

    void update(){
        if (currentPlayer == this.controller.getPanelplayer1().getOwner()){
            this.controller.getPanelplayer1().getPanel().setVisible(true);
            this.controller.getPanelplayer2().getPanel().setVisible(false);
        }else{
            this.controller.getPanelplayer1().getPanel().setVisible(false);
            this.controller.getPanelplayer2().getPanel().setVisible(true);
        }



    }




}
