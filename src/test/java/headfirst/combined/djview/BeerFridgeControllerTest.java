package headfirst.combined.djview;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by martin on 23/06/2016.
 */
public class BeerFridgeControllerTest {
    @Test
    public void increasetemp() throws Exception {
        BeerFridgeModel beerFridgeModel = BeerFridgeModel.getInstance();
        BeerFridgeController controlador = new BeerFridgeController(beerFridgeModel);
        beerFridgeModel.setTempDeseada(4);
        controlador.increaseBPM();
        assertEquals(5, beerFridgeModel.getTempDeseada());
    }

    @Test
    public void decreasetemp() throws Exception {
        BeerFridgeModel beerFridgeModel = BeerFridgeModel.getInstance();
        BeerFridgeController controlador = new BeerFridgeController(beerFridgeModel);
        beerFridgeModel.setTempDeseada(3);
        controlador.decreaseBPM();
        assertEquals(4, beerFridgeModel.getTempDeseada());
    }

    @Test
    public void decreasetemp2() throws Exception {
        BeerFridgeModel beerFridgeModel = BeerFridgeModel.getInstance();
        BeerFridgeController controlador = new BeerFridgeController(beerFridgeModel);
        beerFridgeModel.setTempDeseada(-1);
        controlador.decreaseBPM();
        assertEquals(0, beerFridgeModel.getTempDeseada());
    }

    @Test
    public void setBPMt() throws Exception {
        BeerFridgeModel beerFridgeModel = BeerFridgeModel.getInstance();
        BeerFridgeController controlador = new BeerFridgeController(beerFridgeModel);
        controlador.setBPM(30);
        assertEquals(30, beerFridgeModel.getTempDeseada());

    }
}
