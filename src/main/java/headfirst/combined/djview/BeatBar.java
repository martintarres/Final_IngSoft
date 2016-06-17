package headfirst.combined.djview;
  
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BeatBar extends JProgressBar implements Runnable {
    JProgressBar progressBar;
	Thread thread;

/*	JFrame ventana=new JFrame();
	JPanel p1=new JPanel();
	String[] List={"BeatModel","BeerFridgeModel","HeartModel"};
	JComboBox MenuMod=new JComboBox(List);

	public void creaMenu(){
		ventana.setTitle("Menu de Modelos");
		ventana.setDefaultCloseOperation(ventana.EXIT_ON_CLOSE);
		Container panelContenedor=ventana.getContentPane();
		ventana.pack();
		ventana.setVisible(true);



	}*/
	public BeatBar() {
		thread = new Thread(this);
		setMaximum(100);
		thread.start();
	}

	public void run() {

		for(;;) {
			int value = getValue();
			value = (int)(value * .75);
			setValue(value);
			repaint();
			try {
				Thread.sleep(50);
			} catch (Exception e) {};

		}
	}

}
