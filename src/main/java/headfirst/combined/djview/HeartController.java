package headfirst.combined.djview;
  
public class HeartController implements ControllerInterface {
	HeartModel model;
	DJView view;

	public HeartController(HeartModel model) {
		this.model = model;
		view = new DJView(this, new HeartAdapter(model));
        view.createView();
        view.createControls();
		view.disableStopMenuItem();
		view.disableStartMenuItem();
	}
  
	public void start() {}
 
	public void stop() {}
    
	public void increaseBPM() {

        HeartModel model= HeartModel.getInstance();

      /*  int bpm = model.getHeartRate();
        setBPM(bpm+1);
*/
     /*   if (bpm == model.getHeartRate()) {
            bpm = model.getHeartRate();
            setBPM(bpm + 1);
        } else {
           bpm=bpm+1;
            System.out.println("ya hay creados " + bpm);
          // setBPM(bpm);

            //	}
        }*/
    }
    
	public void decreaseBPM() {}
  
 	public void setBPM(int bpm) {
        //model.bpm=bpm;
         }

}



