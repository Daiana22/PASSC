package Blackboard;

public class WorkerAssembleBackrest extends AbstractWorker{
    public WorkerAssembleBackrest(Blackboard b,Boolean ws){
        super(b,ws);
        stage=1;
    }
    public boolean execCond(Chair c){
        int a[];
        a = b.getChairStages(c);
        if((a[stage] == 0) && (a[stage -1] == 1)) {
            return true;
        }
        return false;
    }
    protected void updateBlackboard(Chair c) {
        int a[];
        a = b.getChairStages(c);
        if ((a[stage] == 0) && (a[stage - 1] == 1)) {
            b.setChairStage(c, stage);
            System.out.println("Backrest is assembled");
        }
    }
}
