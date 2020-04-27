package Blackboard;

public class WorkerCutSeat extends AbstractWorker{
    public WorkerCutSeat(Blackboard b, Boolean ws){
        super(b,ws);
        stage=0;
    }
    public boolean execCond(Chair c){
            int a[];
            a = b.getChairStages(c);
            if(a[stage] == 0) {
                return true;
            }
            return false;
    }
    protected void updateBlackboard(Chair c) {
        int a[];
        a = b.getChairStages(c);
        if (a[stage] == 0) {
            b.setChairStage(c, stage);
            System.out.println("Seat is cut");
        }
    }
}
