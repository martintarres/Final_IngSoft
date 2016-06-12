package headfirst.combined.djview;

import headfirst.combined.djview.BPMObserver;
import headfirst.combined.djview.BeatModelInterface;
import headfirst.combined.djview.BeatObserver;

import java.util.ArrayList;
import java.util.Random;

public class BeerFridgeModel implements BeerFridgeInterface, Runnable {
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
    private static int tempActual;
    private static int tempDeseada;
    Random random;
    static Thread thread;
    private static BeerFridgeModel uniqueInstance;
    //int contador;                                                                                 //no hace falta contador
    private  int ruido;
    private  int cambio = 1;

    private BeerFridgeModel() {
        tempDeseada=10;                                                                             //ver si se la puede resetear
        //tempActual = random.nextInt(20);
        tempActual=20;
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
                /*try {                                                                // creeria que no hace falta dormirlo dos veces
                    Thread.sleep(time);
                } catch (Exception e) {
                }*/
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
}