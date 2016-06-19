package headfirst.combined.djview;

import headfirst.combined.djview.*;

public class BeerFridgeAdapter implements BeatModelInterface {
    //BeerFridgeModel bf= BeerFridgeModel.getInstance();
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
        int temp =bpm;
        this.beerFridge.setTempDeseada(temp);

    }

    public int getBPM() {
        return beerFridge.getHeartRate();


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
