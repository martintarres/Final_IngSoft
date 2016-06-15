package  headfirst.combined.djview;


/**
 * Created by Martin on 09/06/2016.
 */
public class BeerFridgeTestDrive {
    public static void main (String[] args) {
        //BeerFridgeInterface beerFridgemodel = BeerFridgeModel.getInstance();
        BeerFridgeInterface beerFridgemodel=new BeerFridgeModel();
        ControllerInterface controller = new BeerFridgeController(beerFridgemodel);
    }
}
