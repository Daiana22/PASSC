package Blackboard;

public class WorkerAssembleFeet extends AbstractWorker{
    public WorkerAssembleFeet(Blackboard b,Boolean ws){
        super(b,ws);
        stage=2;
    }
    public boolean execCond(Chair c){
        int a[];
        a = b.getChairStages(c);
        if((a[stage] == 0) && (a[stage-2] == 1)) {
            return true;
        }
        return false;
    }
    protected void updateBlackboard(Chair c) {
        int a[];
        a = b.getChairStages(c);
        if ((a[stage] == 0) && (a[stage-2] == 1)) {
            b.setChairStage(c, stage);
            System.out.println("Feet are assembled");
        }
    }
}
