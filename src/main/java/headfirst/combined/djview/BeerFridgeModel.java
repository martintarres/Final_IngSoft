package combined.djview;
import headfirst.combined.djview.BPMObserver;
import headfirst.combined.djview.BeatModelInterface;
import headfirst.combined.djview.BeatObserver;

import java.util.*;

public class BeerFridgeModel implements BeatModelInterface, Runnable {
    ArrayList beatObservers = new ArrayList();
    ArrayList bpmObservers = new ArrayList();
    Random random = new Random(System.currentTimeMillis());
    Thread thread;

/*
    private BeerFridgeModel{
        Thread thread= new Thread( this);
        thread.start();
    }
    */
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

    }

    @Override
    public int getBPM() {
        return 0;
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
/*
    //    int lastrate = -1;

        for(;;) {
            int change =random.nextInt(10);
            if (random.nextInt(2) == 0) {
                time += change;
            }
            int rate = bpm/(time + change);
            if (rate < 120 && rate > 20) {
                time += change;
                notifyBeatObservers();
                if (rate != lastrate) {
                    lastrate = rate;
                    notifyBPMObservers();
                }
            }
            try {
                Thread.sleep(time);
            } catch (Exception e) {}
        }
    }
*/
    }

}
