package headfirst.combined.djview;

import org.junit.Before;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;
/**
 * Created by martin on 23/06/2016.
 */
public class BeerFridgeControllerTest {

    @Test
    public void increasetemp() throws Exception {
        BeerFridgeModel beerFridgeModel = BeerFridgeModel.getInstance();
        BeerFridgeController controlador = new BeerFridgeController(beerFridgeModel);
        beerFridgeModel.setTempDeseada(2);
        controlador.increaseBPM();
        assertEquals(3, beerFridgeModel.getTempDeseada());
    }

    @Test
    public void decreasetemp() throws Exception {
        BeerFridgeModel beerFridgeModel = BeerFridgeModel.getInstance();
        BeerFridgeController controlador = new BeerFridgeController(beerFridgeModel);
        beerFridgeModel.setTempDeseada(3);
        controlador.decreaseBPM();
        assertEquals(2, beerFridgeModel.getTempDeseada());
    }

    @Test
    public void decreasetemp2() throws Exception {
        BeerFridgeModel beerFridgeModel = BeerFridgeModel.getInstance();
        BeerFridgeController controlador = new BeerFridgeController(beerFridgeModel);
        beerFridgeModel.setTempDeseada(-1);
        controlador.decreaseBPM();
        assertEquals(-2, beerFridgeModel.getTempDeseada());
    }

    @Test
    public void setBPMt() throws Exception {
        BeerFridgeModel beerFridgeModel = BeerFridgeModel.getInstance();
        BeerFridgeController controlador = new BeerFridgeController(beerFridgeModel);
        controlador.setBPM(30);
        assertEquals(30, beerFridgeModel.getTempDeseada());

    }
}
