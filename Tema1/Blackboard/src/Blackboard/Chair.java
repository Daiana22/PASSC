package Blackboard;

public class Chair {
    public int stages[] = new int[5];
    public int[] getStages(){
        return stages;
    }
    public void setStage(int nr){
        stages[nr]=1;
    }
}
