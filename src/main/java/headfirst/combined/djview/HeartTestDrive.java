package headfirst.combined.djview;
  
public class HeartTestDrive {

    public static void main (String[] args) {
		HeartModel heartModel = HeartModel.getInstance();
        ControllerInterface model = new HeartController(heartModel);
        //HeartModel heart2 = HeartModel.getInstance();



        //  BeatModelInterface model1 = new BeatModel();
        // ControllerInterface controller = new BeatController(model1);
    }
}