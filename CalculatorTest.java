
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    static CalculatorInterf i = new Calculator();

    @Test
    void translate() {
        String put = "2+2*2";
        String expected = "2 2 2*+";
        String actual = (i.translate(put));
        assertEquals(expected, actual);
    }

    @Test
    void translate2() {
        String put = "1+1*1+1";
        String expected = "1 1 1 *+1+";
        String actual = (i.translate(put));
        assertEquals(expected, actual);
    }

    @Test
    void translate3() {
        String put = "1/1+1/2";
        String expected = "1 1 /1 2/+";
        String actual = (i.translate(put));
        assertEquals(expected, actual);
    }

    @Test
    void calculator() {
        String put = "2+2*2";
        String expected = "ответ: 6.0";
        String actual = ("ответ: " + i.calculator(i.translate(put)));
        assertEquals(expected, actual);
    }

    @Test
    void calculator2() {
        String put = "1+1*1+1";
        String expected = "ответ: 3.0";
        String actual = ("ответ: " + i.calculator(i.translate(put)));
        assertEquals(expected, actual);
    }

    @Test
    void calculator3() {
        String put = "1*1*0";
        String expected = "ответ: 0.0";
        String actual = ("ответ: " + i.calculator(i.translate(put)));
        assertEquals(expected, actual);
    }
}

