package PipesAndFilters;

public class Chair {
    private int[] stages = new int[5];
    public Chair(){
        stages[0]=0;
        stages[1]=0;
        stages[2]=0;
        stages[3]=0;
        stages[4]=0;
    }
    public int getStage(int nr){
        return stages[nr];
    }
    public void setStage(int nr){
        stages[nr]=1;
    }
}
