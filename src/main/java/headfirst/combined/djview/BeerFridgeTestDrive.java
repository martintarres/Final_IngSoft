package  headfirst.combined.djview;

import headfirst.combined.djview.BeatModelInterface;
import headfirst.combined.djview.BeerFridgeInterface;
import headfirst.combined.djview.BeerFridgeModel;

/**
 * Created by Martin on 09/06/2016.
 */
public class BeerFridgeTestDrive {
    BeerFridgeModel model = BeerFridgeModel.getInstance();
    ControllerInterface controller = new BeatController(model);
}
