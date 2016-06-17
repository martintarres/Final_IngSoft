package headfirst.combined.djview;

/**
 * Created by martin on 09/06/2016.
 */
public class TestDrive {
    public static void main(String[] args) {

        BeatModelInterface model = new BeatModel();
        ControllerInterface controller = new BeatController(model);

        HeartModel heartModel = HeartModel.getInstance();
        ControllerInterface model1 = new HeartController(heartModel);

        BeerFridgeInterface beerFridgemodel= BeerFridgeModel.getInstance();
        ControllerInterface controller1 = new BeerFridgeController(beerFridgemodel);


    }
}
