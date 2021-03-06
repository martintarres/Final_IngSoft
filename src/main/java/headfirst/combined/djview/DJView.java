package headfirst.combined.djview;
    
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DJView implements ActionListener,  BeatObserver, BPMObserver {
	BeatModelInterface model;
    ControllerInterface controller;
    BeerFridgeInterface model1;

    JFrame viewFrame;
    JPanel viewPanel;
	BeatBar beatBar;
	JLabel bpmOutputLabel;
    JFrame controlFrame;
    JPanel controlPanel;
    JLabel bpmLabel;
    JTextField bpmTextField;
    JButton setBPMButton;
    JButton increaseBPMButton;
    JButton decreaseBPMButton;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem startMenuItem;
    JMenuItem stopMenuItem;
    String[] seleccion={"Heart Model","Beat Model","Beer Fridge"};
    JComboBox<String> opcion= new JComboBox<String>(seleccion);

    public DJView(ControllerInterface controller, BeatModelInterface model) {	
		this.controller = controller;
		this.model = model;
		model.registerObserver((BeatObserver)this);
		model.registerObserver((BPMObserver)this);
    }

    
    public void createView() {
		// Create all Swing components here
        viewPanel = new JPanel(new GridLayout(1, 2));
        viewFrame = new JFrame("View");
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setSize(new Dimension(100, 80));
        bpmOutputLabel = new JLabel("offline", SwingConstants.CENTER);
		beatBar = new BeatBar();
		beatBar.setValue(0);
        JPanel bpmPanel = new JPanel(new GridLayout(2, 1));
		bpmPanel.add(beatBar);
        bpmPanel.add(bpmOutputLabel);
        viewPanel.add(bpmPanel);
        viewFrame.getContentPane().add(viewPanel, BorderLayout.CENTER);
        viewFrame.pack();
        viewFrame.setVisible(true);
	}
  
  
    public void createControls() {
		// Create all Swing components here
        JFrame.setDefaultLookAndFeelDecorated(true);
        controlFrame = new JFrame("Control");
        controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlFrame.setSize(new Dimension(100, 80));

        controlPanel = new JPanel(new GridLayout(1, 2));

        menuBar = new JMenuBar();
        menu = new JMenu("DJ Control");
        startMenuItem = new JMenuItem("Start");
        menu.add(startMenuItem);
        startMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                controller.start();
            }
        });
        stopMenuItem = new JMenuItem("Stop");
        menu.add(stopMenuItem); 
        stopMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                controller.stop();
            }
        });
        JMenuItem exit = new JMenuItem("Quit");
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        menu.add(exit);
        menuBar.add(menu);
        controlFrame.setJMenuBar(menuBar);

        bpmTextField = new JTextField(2);
        bpmLabel = new JLabel("Enter BPM:", SwingConstants.RIGHT);
        setBPMButton = new JButton("Set");
        setBPMButton.setSize(new Dimension(10,40));
        increaseBPMButton = new JButton(">>");
        decreaseBPMButton = new JButton("<<");
        setBPMButton.addActionListener(this);
        increaseBPMButton.addActionListener(this);
        decreaseBPMButton.addActionListener(this);
        opcion.addActionListener(this);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));

		buttonPanel.add(decreaseBPMButton);
		buttonPanel.add(increaseBPMButton);

        JPanel enterPanel = new JPanel(new GridLayout(1, 2));
        enterPanel.add(bpmLabel);
        enterPanel.add(bpmTextField);
        JPanel insideControlPanel = new JPanel(new GridLayout(3, 1));
        insideControlPanel.add(enterPanel);
        insideControlPanel.add(setBPMButton);
        insideControlPanel.add(buttonPanel);
        controlPanel.add(insideControlPanel);
        insideControlPanel.add(opcion);
        controlPanel.add(insideControlPanel);
        
        bpmLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        bpmOutputLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        controlFrame.getRootPane().setDefaultButton(setBPMButton);
        controlFrame.getContentPane().add(controlPanel, BorderLayout.CENTER);

        controlFrame.pack();
        controlFrame.setVisible(true);
    }

	public void enableStopMenuItem() {
    	stopMenuItem.setEnabled(true);
	}

	public void disableStopMenuItem() {
    	stopMenuItem.setEnabled(false);
	}

	public void enableStartMenuItem() {
    	startMenuItem.setEnabled(true);
	}

	public void disableStartMenuItem() {
    	startMenuItem.setEnabled(false);
	}

    public void actionPerformed(ActionEvent event) {
		if (event.getSource() == setBPMButton) {
			int bpm = Integer.parseInt(bpmTextField.getText());
        	controller.setBPM(bpm);
		} else if (event.getSource() == increaseBPMButton) {
			controller.increaseBPM();
		} else if (event.getSource() == decreaseBPMButton) {
			controller.decreaseBPM();
        } else if (event.getSource()==opcion){
            if (opcion.getSelectedItem()== "Heart Model"){
                controller.stop();
                model.removeObserver((BeatObserver) this);
                model.removeObserver((BPMObserver) this);
                HeartModel heart= HeartModel.getInstance();
                //setModel(new HeartAdapter(HeartModel.getInstance()));
                setModel( new HeartAdapter(heart));
                //setController(new HeartController(HeartModel.getInstance(), this));
                setController(new HeartController(heart,this));
                controller.start();
                model.registerObserver((BeatObserver) this);
                model.registerObserver((BPMObserver) this);
                updateBeat();
                updateBPM();


            }
            else if(opcion.getSelectedItem()== "Beat Model"){
                controller.stop();
                model.removeObserver((BeatObserver) this);
                model.removeObserver((BPMObserver) this);
                setModel(new BeatModel());
                setController( new BeatController(model, this));
                controller.start();
                model.registerObserver((BeatObserver) this);
                model.registerObserver((BPMObserver) this);
                updateBeat();
                updateBPM();



            }
            else if(opcion.getSelectedItem()== "Beer Fridge") {
                controller.stop();
                model.removeObserver((BeatObserver) this);
                model.removeObserver((BPMObserver) this);
                //
                //BeerFridgeInterface Beer = BeerFridgeModel.getInstance();
               BeerFridgeModel Beer= BeerFridgeModel.getInstance();

                //setModel(new BeerFridgeAdapter(BeerFridgeModel.getInstance()));
                setModel(new BeerFridgeAdapter(Beer));

                setController(new BeerFridgeController(BeerFridgeModel.getInstance(), this));
                controller.start();
                model.registerObserver((BeatObserver) this);
                model.registerObserver((BPMObserver) this);
                updateBeat();
                updateBPM();
            }
        }
    }

	public void updateBPM() {
		if (model != null) {
			int bpm = model.getBPM();
			if (bpm == 0) {
				if (bpmOutputLabel != null) {
                    if(!BeerFridgeModel.Activo)
        			bpmOutputLabel.setText("offline");
                    else{
                        bpmOutputLabel.setText("Temp Actual: " + model.getBPM());
                    }
				}
			} else {
				if (bpmOutputLabel != null) {
                        if(opcion.getSelectedItem()== "Heart Model"){
                            bpmOutputLabel.setText("Numero de Intentos: " + model.getBPM());
                        }
                        else if (opcion.getSelectedItem()== "Beat Model"){
                            bpmOutputLabel.setText("Current BPM: " + model.getBPM());
                        }
                        else if (opcion.getSelectedItem()== "Beer Fridge") {


                            bpmOutputLabel.setText("Temp Actual: " + model.getBPM());
                        }
				}
			}
		}
	}
  
	public void updateBeat() {
		if (beatBar != null) {
			 beatBar.setValue(100);
		}
	}

    public void setController(ControllerInterface controller){
        this.controller= controller;
    }

    public void setModel(BeatModelInterface newModel){
        this.model=newModel;
    }
}
