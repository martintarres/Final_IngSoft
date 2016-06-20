package headfirst.combined.djview;

/**
 * Created by Yepez Hinostroza on 19/06/2016.
 */
public class Diferenciador implements Runnable{
    int tiempoMax;
    Thread hilo;
    public Diferenciador(int diferencia){
        tiempoMax=diferencia*1000*3;
        hilo=new Thread(this);
    }
    public void run(){
        try{
            Thread.sleep(tiempoMax);
        } catch (Exception e){}
    }
}
