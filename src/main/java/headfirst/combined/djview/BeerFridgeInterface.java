package headfirst.combined.djview;

/**
 * Created by martin on 09/06/2016.
 */
public interface BeerFridgeInterface {




       /* void on();
        void off();
        void setTempDeseada(int temp);
        void setTempActual(int temp);
        int getTempActual();
        int getTempDeseada();*/

        void setTempDeseada(int temp);
        int getHeartRate();
        int getTempDeseada();
        void registerObserver(BeatObserver o);

        void removeObserver(BeatObserver o);

        void registerObserver(BPMObserver o);

        void removeObserver(BPMObserver o);

}
