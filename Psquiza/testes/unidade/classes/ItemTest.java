package unidade.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projetoLP2.classes.Item;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {

    private Item item1, item2;

    @BeforeEach
    void criaObjetos(){
        item1 = new Item("aeiou");
        item2 = new Item("uoiea");
    }

    @Test
    void testToString() {
        assertEquals("PENDENTE - aeiou", item1.toString());
        assertEquals("PENDENTE - uoiea", item2.toString());
    }
}
