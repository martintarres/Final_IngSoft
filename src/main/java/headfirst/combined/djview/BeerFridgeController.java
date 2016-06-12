package headfirst.combined.djview;

/**
 * Created by Martin on 09/06/2016.
 */
public class BeerFridgeController implements ControllerInterface {

    BeerFridgeInterface model;
    DJView view;

    public BeerFridgeController(BeerFridgeInterface model) {
        this.model = model;
        view = new DJView(this, new BeerFridgeAdapter(model));                      //qu{e onda esto?
        //view = new DJView(this, model);
        view.createView();
        view.createControls();
        view.disableStopMenuItem();
        view.enableStartMenuItem();
        // model.initialize();
    }


    public void start() {
        model.on();
        view.disableStartMenuItem();
        view.enableStopMenuItem();

    }

    public void stop() {
        model.off();
        view.disableStopMenuItem();
        view.enableStartMenuItem();
    }

    public void increaseBPM() {                     // increase
        int temNueva = model.getTempDeseada();
        model.setTempDeseada(temNueva + 1);
    }

    public void decreaseBPM() {
        int temNueva = model.getTempDeseada();
        model.setTempDeseada(temNueva - 1);
    }
    public void setBPM(int temNueva) {
        model.setTempDeseada(temNueva);
    }
}





