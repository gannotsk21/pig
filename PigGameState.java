package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

public class PigGameState extends GameState{

    private int id;
    private int score0;
    private int score1;
    private int runningTotal;
    private int valueOnDie; //1-6

    PigGameState(){
        id = 0;
        score0 = 0;
        score1 = 0;
        runningTotal = 0;
        valueOnDie = 1;
    }

    PigGameState(PigGameState givenInstance){
        id = givenInstance.getID();
        score0 = givenInstance.getScore0();
        score1 = givenInstance.getScore1();
        runningTotal = givenInstance.getRunningTotal();
        valueOnDie = givenInstance.getValueOnDie();

    }

    public int getID(){
        return id;
    }
    public void setID(int newID){
        id = newID;
    }

    public int getScore0 (){
        return score0;
    }

    public void setScore0 (int newscore0){
        score0=newscore0;
    }

    public int getScore1 (){
        return score1;
    }

    public void setScore1 (int newscore1){
        score1=newscore1;
    }

    public int getRunningTotal() {
        return runningTotal;
    }

    public void setRunningTotal(int newTotal){
        runningTotal = newTotal;
    }

    public int getValueOnDie (){
        return valueOnDie;
    }

    public void setValueOnDie (int newValue){
        valueOnDie = newValue;
    }


}
