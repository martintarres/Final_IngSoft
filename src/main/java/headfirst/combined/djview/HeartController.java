package headfirst.combined.djview;
  
public class HeartController implements ControllerInterface {
	HeartModelInterface model;
	DJView view;

	public HeartController(HeartModelInterface model) {
		this.model = model;
		this.view=view;
		view = new DJView(this, new HeartAdapter(model));
        view.createView();
        view.createControls();
		view.disableStopMenuItem();
		view.disableStartMenuItem();
	}

	public HeartController(HeartModelInterface heartModel, DJView view) {
		this.model=model;
		this.view=view;
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



