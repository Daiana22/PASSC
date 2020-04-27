package PipesAndFilters;

public class Main {
    public static void main(String[] args) {
        AbstractWorker w1 = new WorkerCutSeat();
        AbstractWorker w2 = new WorkerAssembleBackrest();
        AbstractWorker w3 = new WorkerAssembleFeet();
        AbstractWorker w4 = new WorkerAssembleStabilizerBar();
        AbstractWorker w5 = new WorkerPackage();
        Chair c1 = w5.operate(w4.operate(w3.operate(w2.operate(w1.operate(new Chair())))));
        System.out.println();
        Chair c2 = w5.operate(w4.operate(w3.operate(w1.operate(w2.operate(new Chair())))));
    }
}
