package Blackboard;

public class WorkerAssembleStabilizerBar extends AbstractWorker{
    public WorkerAssembleStabilizerBar(Blackboard b,Boolean ws){
        super(b,ws);
        stage=3;
    }
    public boolean execCond(Chair c){
        int a[];
        a = b.getChairStages(c);
        if((a[stage] == 0) && (a[stage - 3] == 1) && (a[stage - 1] == 1)) {
            return true;
        }
        return false;
    }
    protected void updateBlackboard(Chair c) {
        int a[];
        a = b.getChairStages(c);
        if ((a[stage] == 0) && (a[stage - 3] == 1) && (a[stage - 1] == 1)) {
            b.setChairStage(c, stage);
            System.out.println("Stabilizer bar is assembled");
        }
    }
}
