package Blackboard;

public class WorkerPackage extends AbstractWorker{
    public WorkerPackage(Blackboard b,Boolean ws){
        super(b,ws);
        stage=4;
    }
    public boolean execCond(Chair c){
        int a[];
        a = b.getChairStages(c);
        if((a[stage] == 0) && (a[stage-4] == 1) && (a[stage-3] == 1) && (a[stage-2] == 1) && (a[stage-1] == 1)) {
            return true;
        }
        return false;
    }
    protected void updateBlackboard(Chair c) {
        int a[];
        a = b.getChairStages(c);
        if ((a[stage] == 0) && (a[stage-4] == 1) && (a[stage-3] == 1) && (a[stage-2] == 1) && (a[stage-1] == 1)) {
            b.setChairStage(c, stage);
            System.out.println("The chair is packed");
        }
    }
}
