package headfirst.combined.djview;

import headfirst.combined.djview.*;

public class BeerFridgeAdapter implements BeatModelInterface {
    BeerFridgeModel bf= BeerFridgeModel.getInstance();
    BeerFridgeInterface beerFridge;



    public BeerFridgeAdapter(BeerFridgeInterface beerFridge) {
        this.beerFridge=beerFridge;
    }


    public void initialize() {

    }

    public void on() {

    }

    public void off() {

    }

    public void setBPM(int bpm) {
        bf.tempDeseada=bpm;

    }

    public int getBPM() {
        return bf.getHeartRate();


    }



    public void registerObserver(BeatObserver o) {
        beerFridge.registerObserver(o);
    }

    public void removeObserver(BeatObserver o) {

        beerFridge.removeObserver(o);
    }

    public void registerObserver(BPMObserver o) {

        beerFridge.registerObserver(o);
    }

    public void removeObserver(BPMObserver o) {
        beerFridge.removeObserver(o);

    }
}
