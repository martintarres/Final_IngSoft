package headfirst.combined.djview;

import org.junit.Test;

import static org.junit.Assert.*;
public class BeerFridgeAdapterTest {
@Test
    public void setBPM() throws Exception {
        BeerFridgeModel beerFridgeModel= BeerFridgeModel.getInstance();
        BeerFridgeAdapter adapter= new BeerFridgeAdapter(beerFridgeModel);
        adapter.setBPM(20);
        assertEquals(20,beerFridgeModel.getTempDeseada());
    adapter.setBPM(10);
    assertEquals(10,beerFridgeModel.getTempDeseada());
    }


}
