package headfirst.combined.djview;

import headfirst.combined.djview.BPMObserver;
import headfirst.combined.djview.BeatModelInterface;
import headfirst.combined.djview.BeatObserver;

import java.util.ArrayList;
import java.util.Random;

public class BeerFridgeModel implements HeartModelInterface, Runnable {
/*    private static int tempDeseada = 10 ;                                                //Agrego esto
    //private int bpm                                                       //cambiarle por esto mejor
    private static int tempActual =20;                                                 //Agrego esto

    ArrayList beatObservers = new ArrayList();
    ArrayList bpmObservers = new ArrayList();
    private Random random;                                                          //Agrego ESTA
    private static int ruido;
    Thread thread;
    private int cambio = 1;                                                     //Despues se le puede setear el cambio?

    private static BeerFridgeModel uniqueInstance;


    private BeerFridgeModel (){

        thread= new Thread( this);
        //uniqueInstance.tempDeseada=10;
        //uniqueInstance.tempActual=20;
        thread.start();                                                     //No sé si ponerlo en el on
    }
    public static BeerFridgeModel getInstance() {

        if (uniqueInstance == null) {

            uniqueInstance = new BeerFridgeModel();


        }
        return uniqueInstance;

    }
    @Override
    public void initialize() {

    }

    @Override
    public void on() {
       // thread.start();                                                         // la clave acá el inicio


    }

    @Override
    public void off() {
        /*try {
            thread.wait();
        } catch (Exception e) {}

    }

    @Override
    public void setBPM(int bpm) {
        uniqueInstance.tempDeseada=bpm;                                                 //Setea la temp deseada
        //notifyBPMObservers();                                                           // Actualizacion ?


    }

    @Override
    public int getBPM() {
        return uniqueInstance.tempActual;                                               //Devuelve la temp Actual
    }

    @Override
    public void registerObserver(BeatObserver o) {
        beatObservers.add(o);
    }

    @Override
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

    @Override
    public void registerObserver(BPMObserver o) {
        bpmObservers.add(o);
    }

    @Override
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

    @Override
    public void run() {
        while(true) {
            ruido = (int)(random.nextDouble() * 10 - 5);                      //Numeros aleatorios entre el 5 y -5
            this.tempActual= this.ruido + this.tempActual;
            notifyBeatObservers();                                             // Actualiza el cambio
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


        }


    }

}
// VEr como actualiza bpm o temp actual
*/

    ArrayList beatObservers = new ArrayList();
    ArrayList bpmObservers = new ArrayList();
    int time = 1000;
    int bpm = 85000;
    private static int tempActual =20;
    Random random = new Random(System.currentTimeMillis());
    Thread thread;
    private static BeerFridgeModel uniqueInstance;
    int contador;
    private static int tempDeseada = 10 ;
    private static int ruido;
    private int cambio = 1;

    private BeerFridgeModel() {
        thread = new Thread(this);
        thread.start();

    }

    public static BeerFridgeModel getInstance() {

        if (uniqueInstance == null) {

            //System.out.println("Preuba linda");
            uniqueInstance = new BeerFridgeModel();
            uniqueInstance.contador = 0;
        } else {
            uniqueInstance.contador++;

            //System.out.println("Preuba fallida "+ uniqueInstance.contador);
        }
        return uniqueInstance;

    }

   //ublic void run() {

        public void run() {
            while(true) {
                ruido = (int)(random.nextDouble() * 10 - 5);                      //Numeros aleatorios entre el 5 y -5
                this.tempActual= this.ruido + this.tempActual;
                notifyBeatObservers();                                             // Actualiza el cambio
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
                try {
                    Thread.sleep(time);
                } catch (Exception e) {
                }
            }

            }



/*
        int lastrate = -1;

        for (; ; ) {
            int change = random.nextInt(10);
            if (random.nextInt(2) == 0) {
                time += change;
            }
            int rate = bpm / (time + change);
            if (rate < 120 && rate > 20) {
                time += change;
                notifyBeatObservers();
                if (rate != lastrate) {
                    lastrate = rate;
                    notifyBPMObservers();
                }*/

        /*try {
                Thread.sleep(time);
            } catch (Exception e) {
            }
        }*/



    @Override
    public int getHeartRate() {
       return 0;
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
}