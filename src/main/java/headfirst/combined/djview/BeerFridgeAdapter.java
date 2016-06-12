package headfirst.combined.djview;

/**
 * Created by Martin on 10/06/2016.
 */

public class BeerFridgeAdapter implements BeatModelInterface {
    BeerFridgeInterface bf;


    public BeerFridgeAdapter(BeerFridgeInterface beerFridge) {
        bf=beerFridge;
    }


    public void initialize() {

    }

    public void on() {
        bf.on();
    }

    public void off() {
        bf.off();
    }

    public void setBPM(int bpm) {
        bf.setTempDeseada(bpm);
    }

    public int getBPM() {
        return bf.getTempActual();
    }


    public void registerObserver(BeatObserver o) {

    }

    public void removeObserver(BeatObserver o) {

    }

    public void registerObserver(BPMObserver o) {

    }

    public void removeObserver(BPMObserver o) {

    }
}
