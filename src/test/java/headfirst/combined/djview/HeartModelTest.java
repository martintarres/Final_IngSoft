package headfirst.combined.djview;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeartModelTest {

    @Test
    public void agetInstance() throws Exception {


        HeartModel heartModel = HeartModel.getInstance();
        heartModel.contador = -1;
        HeartModel modelo = HeartModel.getInstance();
        assertEquals(0, modelo.contador);
    }

    public void getInstace2() throws Exception {
        HeartModel heartModel = HeartModel.getInstance();
        HeartModel heartModel1 = HeartModel.getInstance();
        assertFalse(heartModel.contador == 0);
    }

    public void sumarIntentos() throws Exception {
        HeartModel heartModel = HeartModel.getInstance();
        int temp = heartModel.contador;
        heartModel.getHeartRate();
        assertEquals(temp + 1, heartModel.contador);
    }


}