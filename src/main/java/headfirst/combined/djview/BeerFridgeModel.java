package headfirst.combined.djview;

import headfirst.combined.djview.BPMObserver;
import headfirst.combined.djview.BeatModelInterface;
import headfirst.combined.djview.BeatObserver;
import java.util.*;


public class BeerFridgeModel implements BeerFridgeInterface, Runnable{

    ArrayList beatObservers = new ArrayList();
    ArrayList bpmObservers = new ArrayList();
    int tempActual;
    Random random = new Random();
    Thread thread;
    private boolean var;
    private int ruido;
    public int tempDeseada;
    private int CantBirra;
    private static BeerFridgeModel uniqueInstance;

    public static BeerFridgeModel getInstance() {
        if(uniqueInstance == null){
            uniqueInstance= new BeerFridgeModel();
        }

        return uniqueInstance;
    }


    private BeerFridgeModel() {
        tempActual=20;
        tempDeseada=10;
        thread = new Thread(this);
        thread.start();
        tempActual=20;
        CantBirra=50;


    }


    public void run() {


        for(;;) {

            var=random.nextBoolean();
            ruido= random.nextInt(3);
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
            if(tempActual<tempDeseada)
            {
                tempActual++;
            }
            else if(tempActual>tempDeseada){
                tempActual--;
            }

            notifyBeatObservers();
            notifyBPMObservers();
            try {
                Thread.sleep(500);
            } catch (Exception e) {}

        }
    }
    public int getHeartRate() {

        return tempActual;

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

    public void setTempDeseada(int temp){
        tempDeseada=temp;
    }

    public int getTempDeseada()
    {
        return tempDeseada;
    }

    /*public void esperando()
    {
        try
        {
            Thread.sleep(15000);
        } catch (Exception e) {}
    }*/
}

