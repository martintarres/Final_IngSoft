package  headfirst.combined.djview;


/**
 * Created by Martin on 09/06/2016.
 */
public class BeerFridgeTestDrive {
    public static void main (String[] args) {
        BeerFridgeModel beerfridgemodel = BeerFridgeModel.getInstance();
        ControllerInterface controller = new BeerFridgeController(beerfridgemodel);
    }
}
