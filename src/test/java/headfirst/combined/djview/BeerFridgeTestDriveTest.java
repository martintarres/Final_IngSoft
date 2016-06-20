package headfirst.combined.djview;

import com.sun.javaws.exceptions.ExitException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yepez Hinostroza on 19/06/2016.
 */
public class BeerFridgeTestDriveTest {
    @Test
    public void main() throws Exception {
        BeerFridgeModel beer1= BeerFridgeModel.getInstance();
        BeerFridgeModel beer2= BeerFridgeModel.getInstance();
        if(beer1!=beer2)
        {
            throw new Exception("Se ha creado otro modelo");
        }
    }

}