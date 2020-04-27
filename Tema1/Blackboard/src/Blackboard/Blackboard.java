package Blackboard;

import java.util.ArrayList;

public class Blackboard {
    public ArrayList<Chair> chairs = new ArrayList<Chair>();
    public int[] getChairStages(Chair c){
        return c.getStages();
    }
    public void setChairStage(Chair c, int nr_stage){
        c.setStage(nr_stage);
    }
    public ArrayList<Chair> getUnfinishedChairs(){
        int a[];
        ArrayList<Chair> unfinishedChairs = new ArrayList<Chair>();
        for(Chair c: chairs){
            a=c.getStages();
            if(a[4]==0){
                unfinishedChairs.add(c);
            }
        }
        return unfinishedChairs;
    }
    public void addChair(Chair c){
        chairs.add(c);
    }
}
