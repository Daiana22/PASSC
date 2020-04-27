package PipesAndFilters;

public class WorkerPackage extends AbstractWorker{
    public Chair operate(Chair c){
        //verificam daca avem sezut, spatar, picioare si bara stabilizatoare
        if((c.getStage(0)==1)&&(c.getStage(1)==1)&&(c.getStage(2)==1)&&(c.getStage(3)==1)) {
            System.out.println("Package chair");
            c.setStage(4);
            return c;
        }
        return null;
    }
}
