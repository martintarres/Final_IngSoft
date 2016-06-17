package headfirst.combined.djview;

/**
 * Created by martin on 09/06/2016.
 */
public class TestDrive {
    public static void main(String[] args) {

        BeatModelInterface model1 = new BeatModel();
        ControllerInterface controller = new BeatController(model1);

        HeartModel heartModel = HeartModel.getInstance();
        ControllerInterface controlHeart = new HeartController(heartModel);



        BeerFridgeInterface beerFridgeModel = BeerFridgeModel.getInstance();
        ControllerInterface controllerBeerFridge = new BeerFridgeController(beerFridgeModel);


    }
}
