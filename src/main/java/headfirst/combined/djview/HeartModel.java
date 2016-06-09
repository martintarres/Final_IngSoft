package headfirst.combined.djview;

import java.util.*;

public class HeartModel implements HeartModelInterface, Runnable {
	ArrayList beatObservers = new ArrayList();
	ArrayList bpmObservers = new ArrayList();
	int time = 1000;
    int bpm = 85000;
	Random random = new Random(System.currentTimeMillis());
	Thread thread;
	private static HeartModel uniqueInstance;
	int contador;

	private HeartModel() {
		thread = new Thread(this);
		thread.start();

	}
	public static HeartModel getInstance() {

				if (uniqueInstance == null) {

					//System.out.println("Preuba linda");
					uniqueInstance = new HeartModel();
					uniqueInstance.contador=0;
				}
				else
				{
					uniqueInstance.contador++;

					System.out.println("Preuba fallida "+ uniqueInstance.contador);
				}
				return uniqueInstance;

	}

	public void run() {


	int lastrate = -1;

		for(;;) {
			int change =random.nextInt(10);
			if (random.nextInt(2) == 0) {
				time += change;
			}
			int rate = bpm/(time + change);
			if (rate < 120 && rate > 20) {
				time += change;
				notifyBeatObservers();
				if (rate != lastrate) {
					lastrate = rate;
					notifyBPMObservers();
			}
			}
			try {
				Thread.sleep(time);
			} catch (Exception e) {}
		}
	}
	public int getHeartRate() {
		return contador;
	}

	public void registerObserver(BeatObserver o) {
		beatObservers.add(o);
	}

	public void removeObserver(BeatObserver o) {
		int i = beatObservers.indexOf(o);
		if (i >= 0) {
			beatObservers.remove(i);
		}
	}

	public void notifyBeatObservers() {
		for(int i = 0; i < beatObservers.size(); i++) {
			BeatObserver observer = (BeatObserver)beatObservers.get(i);
			observer.updateBeat();
		}
	}

	public void registerObserver(BPMObserver o) {
		bpmObservers.add(o);
	}

	public void removeObserver(BPMObserver o) {
		int i = bpmObservers.indexOf(o);
		if (i >= 0) {
			bpmObservers.remove(i);
		}
	}

	public void notifyBPMObservers() {
		for(int i = 0; i < bpmObservers.size(); i++) {
			BPMObserver observer = (BPMObserver)bpmObservers.get(i);
			observer.updateBPM();
		}
	}
}
