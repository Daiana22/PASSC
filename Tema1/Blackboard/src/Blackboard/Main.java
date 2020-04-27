package Blackboard;
import java.util.*;

public class Main {//Control
    public static void main(String[] args){
        ArrayList<AbstractWorker> workers = new ArrayList<AbstractWorker>();
        Chair c1 = new ChairWithoutBackrest();
        Chair c2 = new ChairWithoutStabilizerBar();
        Blackboard b = new Blackboard();
        b.addChair(c1);
        b.addChair(c2);
        workers.add(new WorkerCutSeat(b,false));
        workers.add(new WorkerAssembleBackrest(b,false));
        workers.add(new WorkerAssembleFeet(b,false));
        workers.add(new WorkerAssembleStabilizerBar(b,false));
        workers.add(new WorkerPackage(b,false));

        ArrayList<Chair> chairs = new ArrayList<Chair>();
        chairs = b.getUnfinishedChairs();
        int i;
        while(!chairs.isEmpty()){
            for(Chair c : chairs){
                for(i=0;i<workers.size();i++){
                    workers.get(i).setWorkerState(workers.get(i).execCond(c));
                }
                for(i=0;i<workers.size();i++){
                    if(workers.get(i).getWorkerState()){
                        workers.get(i).execAction(c);
                        workers.get(i).setWorkerState(false);
                    }
                }
            }
            chairs = b.getUnfinishedChairs();
        }
    }
}
