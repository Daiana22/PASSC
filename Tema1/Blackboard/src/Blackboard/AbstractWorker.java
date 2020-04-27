package Blackboard;

public abstract class AbstractWorker {
    protected Blackboard b;
    protected int stage;//etapa la care lucreaza muncitorul(0=cut seat, 1=assemble backrest,...)
    protected Boolean WorkerState;
    public AbstractWorker(Blackboard b, Boolean WorkerState){
        this.b = b;
        this.WorkerState = WorkerState;
    }
    public Boolean getWorkerState(){
        return WorkerState;
    }
    public void setWorkerState(Boolean NewState){
        WorkerState = NewState;
    }
    public abstract boolean execCond(Chair c);//verifica daca s-a executat starea respectiva
    public void execAction(Chair c){
        this.updateBlackboard(c);
    }
    protected abstract void updateBlackboard(Chair c);
}
