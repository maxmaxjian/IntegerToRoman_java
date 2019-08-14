import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class Solution1Test {

    private int input;
    private String output;
    private Solution soln = new Solution1();

    public Solution1Test(int input, String output) {
        this.input = input;
        this.output = output;
    }

    @Parameterized.Parameters
    public static Collection parameters() {
        return Arrays.asList(new Object[][]{
                {3, "III"},
                {4, "IV"},
                {9, "IX"},
                {8, "VIII"},
                {58, "LVIII"},
                {1994, "MCMXCIV"},
                {1, "I"},
                {2, "II"},
                {3, "III"},
                {4, "IV"},
                {5, "V"},
                {6, "VI"},
                {7, "VII"},
                {8, "VIII"},
                {9, "IX"},
                {10, "X"}
        });
    }

    @Test
    public void intToRoman() {
        System.out.println(String.format("input = %d, expected = %s, actual = %s",
                input, output, soln.intToRoman(input)));
        assertEquals(output, soln.intToRoman(input));
    }
}