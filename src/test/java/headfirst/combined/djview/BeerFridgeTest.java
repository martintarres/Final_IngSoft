package headfirst.combined.djview;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by martin on 23/06/2016.
 */
public class BeerFridgeTest {
  /* @Test
    public void ceroAlEmpezar() throws Exception {
        BeerFridgeModel clase= BeerFridgeModel.getInstance();
        int a= clase.getJUG1();
        int b= clase.getJUG2();
        int c= clase.getBPM();
        assertTrue(a==0);
        assertTrue(b==0);
        assertTrue(c==0);
    }*/
  @Test
  public void setBPM() throws Exception {
      BeerFridgeModel beerFridgeModel= BeerFridgeModel.getInstance();
      beerFridgeModel.setTempDeseada(20);
      assertTrue(beerFridgeModel.getTempDeseada()==20);
      beerFridgeModel.setTempDeseada(-10);
      assertTrue(beerFridgeModel.getTempDeseada()==-10);
  }
    @Test
    public void increaseBPM() throws Exception {
        BeerFridgeModel clase1= BeerFridgeModel.getInstance();
        BeerFridgeController controlador= new BeerFridgeController(clase1);
        clase1.setTempDeseada(4);
        controlador.increaseBPM();
        assertEquals(5,clase1.getTempDeseada());
    }
    /*@Test
    public void increaseBPM2() throws Exception {
        MyAnotadorModel clase2= new MyAnotadorModel();
        MyAnotadorController controlador= new MyAnotadorController(clase2);
        clase2.setJUG2(-3);
        controlador.increaseBPM();
        assertEquals(-2,clase2.getJUG2());
    }

    @Test
    public void decreaseBPM() throws Exception {
        MyAnotadorModel clase3= new MyAnotadorModel();
        MyAnotadorController controlador= new MyAnotadorController(clase3);
        clase3.setJUG1(3);
        controlador.decreaseBPM();
        assertEquals(4,clase3.getJUG1());
    }
    @Test
    public void decreaseBPM2() throws Exception {
        MyAnotadorModel clase4= new MyAnotadorModel();
        MyAnotadorController controlador= new MyAnotadorController(clase4);
        clase4.setJUG1(-1);
        controlador.decreaseBPM();
        assertEquals(0,clase4.getJUG1());
    }

    @Test
    public void setBPMt() throws Exception {
        MyAnotadorModel clase5= new MyAnotadorModel();
        MyAnotadorController controlador= new MyAnotadorController(clase5);
        controlador.setBPM(30);
        assertEquals(30,clase5.getBPM());
        */
}
