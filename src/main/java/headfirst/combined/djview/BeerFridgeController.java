package headfirst.combined.djview;

/**
 * Created by Martin on 09/06/2016.
 */
public class BeerFridgeController implements ControllerInterface {

    BeerFridgeInterface model;
    //DJView view;
    NuevaVista nvaVista;
    BeerFridgeAdapter bfAdapt;

    public BeerFridgeController(BeerFridgeInterface model) {
        this.model = model;
        bfAdapt=new BeerFridgeAdapter(model);
        /*
        view = new DJView(this, bfAdapt);
        view.createView();
        view.createControls();
        view.disableStopMenuItem();
        view.enableStartMenuItem();
         //model.initialize();
         */
        nvaVista=new NuevaVista(this,bfAdapt);
        nvaVista.construirVentanaControles();
        nvaVista.construirVentanaSalida();

    }


    public void start() {

    }

    public void stop() {

          }

    public void increaseBPM() {

        int tempNva=model.getTempDeseada();
       this.setBPM(tempNva+1);

    }

    public void decreaseBPM() {

        int tempNew=model.getTempDeseada();
        //int tempNueva=bfAdapt.getBPM();
        this.setBPM(tempNew-1);
    }
    public void setBPM(int bpm) {
        //model.setTempDeseada(temNueva);

        bfAdapt.setBPM(bpm);


    }
}





