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
    //@Test
    /*public void getJUG1() throws Exception {
        BeerFridgeModel beerFridgeModel= BeerFridgeModel.getInstance();
        BeerFridgeAdapter adapter= new BeerFridgeAdapter(beerFridgeModel);
        beerFridgeModel.setTempDeseada(5);
        assertEquals(5,adapter.getBPM());
    }
*/
   // @Test
   /* public void getJUG2() throws Exception {
        MyAnotadorModel clase= new MyAnotadorModel();
        MyAnotadorAdapter adapter= new MyAnotadorAdapter(clase);
        clase.setJUG2(7);
        assertEquals(7,adapter.getJUG2());
    }*/

}
