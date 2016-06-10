package headfirst.combined.djview;

/**
 * Created by Martin on 09/06/2016.
 */
public class BeerFridgeController implements ControllerInterface {

    BeerFridgeModel model;
    DJView view;

    public BeerFridgeController(BeerFridgeModel model) {
        this.model = model;
        view = new DJView(this,new HeartAdapter(model));
        view.createView();
        view.createControls();
        view.disableStopMenuItem();
        view.enableStartMenuItem();
       // model.initialize();
    }


    /*public void start() {
        model.on();
        view.disableStartMenuItem();
        view.enableStopMenuItem();

    }


    public void stop(){
            model.off();
            view.disableStopMenuItem();
            view.enableStartMenuItem();
    }
*/

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    public void increaseBPM() {
            //int bpm = model.getBPM();
            //model.setBPM(bpm + 1);

    }


    public void decreaseBPM() {
        //int bpm = model.getBPM();
        //model.setBPM(bpm - 1);
    }

    public void setBPM(int bpm) {
            //model.setBPM(bpm);
        }

    }

