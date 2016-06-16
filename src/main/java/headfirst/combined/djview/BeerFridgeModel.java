package headfirst.combined.djview;

import headfirst.combined.djview.BPMObserver;
import headfirst.combined.djview.BeatModelInterface;
import headfirst.combined.djview.BeatObserver;
import java.util.*;


public class BeerFridgeModel implements BeerFridgeInterface, Runnable {

    ArrayList beatObservers = new ArrayList();
    ArrayList bpmObservers = new ArrayList();
    int tempActual;
    Random random = new Random();
    Thread thread;
    private boolean var;
    private int ruido;
    int tempDeseada;
    private int CantBirra;
    private static BeerFridgeModel uniqueInstance;

    public static BeerFridgeModel getInstance() {
        if(uniqueInstance == null){
            uniqueInstance= new BeerFridgeModel();
        }

        return uniqueInstance;
    }


   private BeerFridgeModel() {

        thread = new Thread(this);
        thread.start();
        tempActual=20;

    }


    public void run() {


        for(;;) {

            var=random.nextBoolean();
            ruido=(int) random.nextInt(3);
            if(var)
            {
                tempActual=tempActual+ruido;
            }
            else{
                tempActual=tempActual-ruido;
            }
            notifyBeatObservers();
            notifyBPMObservers();
            try {
                Thread.sleep(1000);
           } catch (Exception e) {}
        }
    }
    public int getHeartRate() {

        return tempDeseada;

    }


    public void registerObserver(BeatObserver o) {
        beatObservers.add(o);
    }

    public void removeObserver(BeatObserver o) {
        int i = beatObservers.indexOf(o);
        if (i >= 0) {
            beatObservers.remove(i);
        }
    }

    public void notifyBeatObservers() {
        for(int i = 0; i < beatObservers.size(); i++) {
            BeatObserver observer = (BeatObserver)beatObservers.get(i);
            observer.updateBeat();
        }
    }

    public void registerObserver(BPMObserver o) {
        bpmObservers.add(o);
    }

    public void removeObserver(BPMObserver o) {
        int i = bpmObservers.indexOf(o);
        if (i >= 0) {
            bpmObservers.remove(i);
        }
    }

    public void notifyBPMObservers() {
        for(int i = 0; i < bpmObservers.size(); i++) {
            BPMObserver observer = (BPMObserver)bpmObservers.get(i);
            observer.updateBPM();
        }
    }

    public int getCantBirra(){
        return CantBirra;
    }
}

































/*
    ArrayList beatObservers = new ArrayList();
    ArrayList bpmObservers = new ArrayList();
    int tempActual;
    int tempDeseada;
    Random random;
    Thread thread;
   // private static BeerFridgeModel uniqueInstance;
    //int contador;                                                                                 //no hace falta contador
    private  int ruido;
    private  int cambio = 1;
    int time=1;

    public BeerFridgeModel() {
        tempDeseada=10;                                                                             //ver si se la puede resetear
        //tempActual = random.nextInt(20);
        tempActual=20;
        thread=new Thread(this);
        thread.start();
    }



    public static BeerFridgeModel getInstance() {

        if (uniqueInstance == null) {

            uniqueInstance = new BeerFridgeModel();
            BeerFridgeModel.thread = new Thread(uniqueInstance);
            thread.start();
        }
            return BeerFridgeModel.uniqueInstance;


    }

       public void run() {

            while(true) {

                ruido = (int)(random.nextDouble() * 10 - 5);                      //Numeros aleatorios entre el 5 y -5
                this.tempActual= this.ruido + this.tempActual;
                notifyBeatObservers();                                             // Actualiza el cambio
                System.out.println(" aca llega?");
                try {
                    thread.sleep(1000);                                            // Duerme 1 segundo para mantener el cambio
                } catch (Exception e) {}

                if(tempActual>tempDeseada){
                    tempActual=tempActual-cambio;
                    notifyBeatObservers();                                          //actualiza la vista
                }
                else{
                    tempActual=tempActual+cambio;
                    notifyBeatObservers();
               }
               try {                                                                // creeria que no hace falta dormirlo dos veces
                    Thread.sleep(time);
                } catch (Exception e) {
                }
            }

            }



 public void run() {
     int lastrate = -1;

     for (; ; ) {
         int change = random.nextInt(10);
         if (random.nextInt(2) == 0) {
             time += change;
         }
         int rate = tempActual / (time + change);
         if (rate < 12 && rate > 80) {
             time += change;
             notifyBeatObservers();
             if (rate != lastrate) {
                 lastrate = rate;
                 notifyBPMObservers();
             }

             try {
                 Thread.sleep(time);
             } catch (Exception e) {
             }
         }
     }
 }
    public void on()
    {
        thread.run();
    }
    public void off() {
        //thread.stop();
        try {
            thread.wait();
        } catch (Exception e) {
        }
    }


    public int getTempDeseada() {
        return tempDeseada;
    }
    public void setTempDeseada(int temp){
        tempDeseada=temp;
    }

    public int getTempActual(){ return tempActual;}
    public void setTempActual(int temp) {
        tempActual=temp;
    }

   public void registerObserver(BeatObserver o) {
        beatObservers.add(o);
    }

    public void removeObserver(BeatObserver o) {
        int i = beatObservers.indexOf(o);
        if (i >= 0) {
            beatObservers.remove(i);
        }
    }

    public void notifyBeatObservers() {
        for (int i = 0; i < beatObservers.size(); i++) {
            BeatObserver observer = (BeatObserver) beatObservers.get(i);
            observer.updateBeat();
        }
    }

    public void registerObserver(BPMObserver o) {
        bpmObservers.add(o);
    }

    public void removeObserver(BPMObserver o) {
        int i = bpmObservers.indexOf(o);
        if (i >= 0) {
            bpmObservers.remove(i);
        }
    }

    public void notifyBPMObservers() {
        for (int i = 0; i < bpmObservers.size(); i++) {
            BPMObserver observer = (BPMObserver) bpmObservers.get(i);
            observer.updateBPM();
        }
    }
*/