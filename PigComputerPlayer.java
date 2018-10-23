package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.Game;
import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.infoMsg.GameState;
import edu.up.cs301.game.infoMsg.NotYourTurnInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
     info.setGame(game);

     if(info instanceof NotYourTurnInfo)
     {
         return;
     }
     else {
         Random rand = new Random();

         sleep(500);
         if (rand.nextInt(2) == 0) {
             PigHoldAction action = new PigHoldAction(this);
             game.sendAction(action);
             sleep(1000);

         } else {
             PigRollAction action = new PigRollAction(this);
             game.sendAction(action);
             sleep(1000);

         }
     }
    }//receiveInfo

}
