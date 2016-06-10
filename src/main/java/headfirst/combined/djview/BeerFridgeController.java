package headfirst.combined.djview;

/**
 * Created by Martin on 09/06/2016.
 */
public class BeerFridgeController implements ControllerInterface {

    BeerFridgeModel model;
    DJView view;
    BeerFridgeAdapter bfAdapter;



    public BeerFridgeController(BeerFridgeModel model) {
        this.model = model;
        view = new DJView(this,new BeerFridgeAdapter(model));
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
        int bpm=bfAdapter.getBPM();
        bfAdapter.setBPM(bpm+1);
    }


    public void decreaseBPM() {
        //int bpm = model.getBPM();
        //model.setBPM(bpm - 1);
    }

    public void setBPM(int bpm) {
            bfAdapter.setBPM(bpm);
        }

    }

