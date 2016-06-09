package headfirst.combined.djview;

/**
 * Created by martin on 09/06/2016.
 */
public class TestDrive {
    public static void main(String[] args) {
        HeartModel heartModel = HeartModel.getInstance();
        ControllerInterface model = new HeartController(heartModel);
        //HeartModel heart2 = HeartModel.getInstance();


        BeatModelInterface model1 = new BeatModel();
        ControllerInterface controller = new BeatController(model1);


    }
}
