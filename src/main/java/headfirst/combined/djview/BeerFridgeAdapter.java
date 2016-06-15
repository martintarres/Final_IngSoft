package headfirst.combined.djview;

/**
 * Created by Martin on 10/06/2016.
 */

public class BeerFridgeAdapter implements BeatModelInterface {
    BeerFridgeModel bf=new BeerFridgeModel();
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
        bf.tempActual=bpm;

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
      beerFridge.registerObserver(o);

    }
}
