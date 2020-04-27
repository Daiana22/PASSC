package PipesAndFilters;

public class WorkerAssembleFeet extends AbstractWorker{
    public Chair operate(Chair c){
        if(c.getStage(0)==1) {//verificam daca avem sezut
            System.out.println("Assemble feet");
            c.setStage(2);
            return c;
        }
        return null;
    }
}
