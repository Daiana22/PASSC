package PipesAndFilters;

public class WorkerAssembleStabilizerBar extends AbstractWorker{
    public Chair operate(Chair c){
        //verificam daca avem sezut, spatar si picioare
        if((c.getStage(0)==1)&&(c.getStage(1)==1)&&(c.getStage(2)==1)) {
            System.out.println("Assemble stabilizer bar");
            c.setStage(3);
            return c;
        }
        return null;
    }
}
