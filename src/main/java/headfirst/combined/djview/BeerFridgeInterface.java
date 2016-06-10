package headfirst.combined.djview;

/**
 * Created by martin on 09/06/2016.
 */
public interface BeerFridgeInterface {

        void initialize();

        void on();

        void off();

        void setBPM(int bpm);

        int getBPM();

        void registerObserver(BeatObserver o);

        void removeObserver(BeatObserver o);

        void registerObserver(BPMObserver o);

        void removeObserver(BPMObserver o);

}
