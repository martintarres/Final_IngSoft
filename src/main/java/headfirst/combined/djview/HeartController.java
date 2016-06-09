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
        int bpm = model.getHeartRate();
        setBPM(bpm+1);}
    
	public void decreaseBPM() {}
  
 	public void setBPM(int bpm) {model.bpm=bpm*1000;}

}



