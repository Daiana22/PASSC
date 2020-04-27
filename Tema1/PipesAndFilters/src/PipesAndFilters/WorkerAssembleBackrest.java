package PipesAndFilters;

public class WorkerAssembleBackrest extends AbstractWorker{
    public Chair operate(Chair c) {
        if(c.getStage(0)==1) {//verificam daca avem sezut
            System.out.println("Assemble backrest");
            c.setStage(1);
            return c;
        }
        return null;
    }
}
