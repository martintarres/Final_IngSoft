package headfirst.combined.djview;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NuevaVista extends JFrame implements ActionListener, BeatObserver, BPMObserver {
    ControllerInterface controller;
    BeatModelInterface model;

    JFrame ventana = new JFrame();
    JFrame ventanaOut=new JFrame();
    Container panelContenedor;
    Container PanelContenedor2;
    JPanel panelOut = new JPanel();
    JButton setButton;
    JButton buttonMas;
    JButton buttonMenos;
    JTextField TextField;
    BeatBar beatBar;
    JLabel etiquetaOut;
    JLabel etiquetaIn;

    public  NuevaVista(ControllerInterface controller, BeatModelInterface model){
        //construirVentanaControles();
        //construirVentanaSalida();
        this.controller = controller;
        this.model = model;
        model.registerObserver((BeatObserver)this);
        model.registerObserver((BPMObserver)this);
    }

    //public static void main (String[] args) {
        //NuevaVista vista=new NuevaVista();
// }


    public void construirVentanaSalida(){

        ventanaOut.setTitle("View");
        PanelContenedor2=ventanaOut.getContentPane();
        panelOut=new JPanel();
        panelOut.setLayout(new GridLayout(1,2));

        ventanaOut.setDefaultCloseOperation(ventanaOut.EXIT_ON_CLOSE);
        ventanaOut.setSize(new Dimension(100,80));
        etiquetaOut=new JLabel("offline",SwingConstants.CENTER);
        beatBar=new BeatBar();
        beatBar.setValue(0);

        JPanel tempPanel=new JPanel();
        tempPanel.setLayout(new GridLayout(2,1));
        tempPanel.add(beatBar);
        tempPanel.add(etiquetaOut);

        panelOut.add(tempPanel);
        PanelContenedor2.add(panelOut);




        ventanaOut.pack();
        ventanaOut.setVisible(true);
    }


   public void construirVentanaControles(){

        ventana.setTitle("BeerFridgeModel");
       panelContenedor=ventana.getContentPane();
        ventana.setDefaultCloseOperation(ventana.EXIT_ON_CLOSE);
        ventana.setSize(new Dimension(100,80));
        JPanel panel=new JPanel();
        JPanel panel2=new JPanel();
        JPanel panel3=new JPanel();
         setButton=new JButton("Set ºC");
         buttonMas=new JButton("+");
         buttonMenos=new JButton("-");
         TextField = new JTextField(1);

        setButton.addActionListener(this);
        buttonMas.addActionListener(this);
        buttonMenos.addActionListener(this);


        JPanel panelGeneral=new JPanel();
        panelGeneral.setLayout(new GridLayout(3,2));
        panel.setLayout(new GridLayout(1,2));
        panel2.setLayout(new GridLayout(1,2));
        panel3.setLayout(new GridLayout(1,1));

        etiquetaIn=new JLabel("Temperatura");
        //panelContenedor.add(etiqueta);

        panel.add(setButton);
        panel.add(TextField);
        panel2.add(buttonMenos);
        panel2.add(buttonMas);
        panel3.add(etiquetaIn);

        panelGeneral.add(panel3);
        panelGeneral.add(panel);
        panelGeneral.add(panel2);


        panelContenedor.add(panelGeneral);


        ventana.pack();
        ventana.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == setButton) {
            int bpm = Integer.parseInt(TextField.getText());
            controller.setBPM(bpm);
        } else if (event.getSource() == buttonMas) {
            controller.increaseBPM();
        } else if (event.getSource() == buttonMenos) {
            controller.decreaseBPM();
        }

    }

    public void updateBPM() {
        if (model != null) {
            int bpm = model.getBPM();
            if (bpm == 0) {
                if (etiquetaOut != null) {
                    etiquetaOut.setText("offline");
                }
            } else {
                if (etiquetaOut != null) {
                    etiquetaOut.setText("TemperaturaºC " + model.getBPM());
                }
            }
        }
    }
    public void updateBeat() {
        if (beatBar != null) {
            beatBar.setValue(100);
        }
    }


}
