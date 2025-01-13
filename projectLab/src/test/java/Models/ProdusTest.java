package Models;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProdusTest {
    @Test
    public void testProdus() {
        Produs produs=new Produs("Laptop", 2300);
        assertEquals("Laptop", produs.getDenumire());
        assertEquals(2300, produs.getPret());
    }

}