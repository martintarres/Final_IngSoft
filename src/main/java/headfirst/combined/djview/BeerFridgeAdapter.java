package headfirst.combined.djview;

/**
 * Created by Martin on 10/06/2016.
 */
public class BeerFridgeAdapter implements BeatModelInterface {

    BeerFridgeModel bf=BeerFridgeModel.getInstance();
    //@Override
    public BeerFridgeAdapter(BeerFridgeModel bf){this.bf=bf;}

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
        return bf.getTempDeseada();
    }

    @Override
    public void registerObserver(BeatObserver o) {

    }

    @Override
    public void removeObserver(BeatObserver o) {

    }

    @Override
    public void registerObserver(BPMObserver o) {

    }

    @Override
    public void removeObserver(BPMObserver o) {

    }
}
