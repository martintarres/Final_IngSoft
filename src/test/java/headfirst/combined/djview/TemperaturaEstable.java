package headfirst.combined.djview;
import com.sun.javaws.exceptions.ExitException;
import org.junit.Test;


/**
 * Created by Yepez Hinostroza on 19/06/2016.
 */
public class TemperaturaEstable {
    @Test
    public void main() throws Exception {
        BeerFridgeModel beerFridgemodel= BeerFridgeModel.getInstance();
        ControllerInterface controller = new BeerFridgeController(beerFridgemodel);
        int diferencia=Math.abs(beerFridgemodel.getTempDeseada()-beerFridgemodel.tempActual);
        Diferenciador diferenciador= new Diferenciador(diferencia);
        diferenciador.hilo.start();
        diferenciador.hilo.join();

        if(Math.abs(beerFridgemodel.getTempDeseada()-beerFridgemodel.tempActual)>5)
        {
            throw new Exception("Demora mucho en alcanzar la temp Deseada");
        }



    }

}