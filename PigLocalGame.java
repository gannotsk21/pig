package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;
import android.view.View;

import java.util.Random;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    PigGameState theState;
    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        theState = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {

        if (theState.getID() == playerIdx)
        {
            return true;
        }
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {

        if(action instanceof PigHoldAction)
        {
            if(players.length ==1)
            {
                theState.setScore0(theState.getScore0()+theState.getRunningTotal());
                theState.setRunningTotal(0);
            }
            else {
                if (theState.getID() == 0) {
                    theState.setScore0(theState.getScore0() + theState.getRunningTotal());
                    theState.setRunningTotal(0);
                    theState.setID(1);
                } else {
                    theState.setScore1(theState.getScore1() + theState.getRunningTotal());
                    theState.setRunningTotal(0);
                    theState.setID(0);
                }
            }
            return true;
        }
        else if(action instanceof PigRollAction)
        {
            //roll
            Random rand = new Random();
            theState.setValueOnDie(rand.nextInt(6)+1);
            if(theState.getValueOnDie() != 1)
            {
                theState.setRunningTotal(theState.getRunningTotal() + theState.getValueOnDie());

            }
            else
            {
                theState.setRunningTotal(0);
                if (players.length != 1) {
                    if (theState.getID() == 0) {
                        theState.setID(1);
                    } else {
                        theState.setID(0);
                    }
                }
            }
            return true;
        }
        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {

        PigGameState copiedState = new PigGameState(theState);
        checkIfGameOver();
        p.sendInfo(copiedState);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        if(theState.getScore0() >= 50)
        {
            System.out.print("Player 1 won");
            return "Player 1 won";

        }
        else if(theState.getScore1() >= 50){
            System.out.print("Player 2 won");
            return "Player 2 won";
        }
        return null;
    }

}// class PigLocalGame
