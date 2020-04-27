package PipesAndFilters;

public class WorkerCutSeat extends AbstractWorker{
    public Chair operate(Chair c){
        System.out.println("Cut seat");
        c.setStage(0);
        return c;
    }
}
