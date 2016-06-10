package headfirst.combined.djview;

import headfirst.combined.djview.BPMObserver;
import headfirst.combined.djview.BeatModelInterface;
import headfirst.combined.djview.BeatObserver;

import java.util.ArrayList;
import java.util.Random;

public class BeerFridgeModel implements BeatModelInterface, Runnable {
    private int tempDeseada;                                                //Agrego esto
    //private int bpm                                                       //cambiarle por esto mejor
    private int tempActual;                                                 //Agrego esto

    ArrayList beatObservers = new ArrayList();
    ArrayList bpmObservers = new ArrayList();
    Random random;                                                          //Agrego ESTA
    private int ruido;
    Thread thread;
    private int cambio = 1;                                                     //Despues se le puede setear el cambio?

    private static BeerFridgeModel uniqueInstance;


    private BeerFridgeModel (){
        uniqueInstance.tempDeseada=10;
        uniqueInstance.tempActual=20;
        Thread thread= new Thread( this);
        thread.start();
    }
    public static BeerFridgeModel getInstance() {

        if (uniqueInstance == null) {

            uniqueInstance = new BeerFridgeModel();
            uniqueInstance.tempDeseada=10;
            uniqueInstance.tempActual=0;

        }
        return uniqueInstance;

    }
    @Override
    public void initialize() {

    }

    @Override
    public void on() {

    }

    @Override
    public void off() {

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
                Thread.sleep(1000);                                            // Duerme 1 segundo para mantener el cambio
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