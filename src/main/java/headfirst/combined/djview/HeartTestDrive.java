package headfirst.combined.djview;
  
public class HeartTestDrive {

    public static void main (String[] args) {
		HeartModel heartModel = HeartModel.getInstance();

        ControllerInterface model = new HeartController(heartModel);
        //HeartModel heart2 = HeartModel.getInstance();

      /*  BeerFridgeInterface beerFridgemodel=new BeerFridgeModel();
        ControllerInterface controller2 = new BeerFridgeController(beerFridgemodel);

          BeatModelInterface model1 = new BeatModel();
         ControllerInterface controller3 = new BeatController(model1);*/
    }

}
