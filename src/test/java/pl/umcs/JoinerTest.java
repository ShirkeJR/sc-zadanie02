package pl.umcs;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JoinerTest {

    @Test
    public void shouldJoinStrings() {
        //given
        Joiner joiner = Joiner.on("; ");
        List<String> stringsToJoin = Arrays.asList("Harry", "Ron", "Hermione");

        //when
        String actualJoin = joiner.join(stringsToJoin);

        //then
        assertEquals("Harry; Ron; Hermione", actualJoin);
    }

    @Test
    public void shouldSkipNulls() {
        //given
        Joiner joiner = Joiner.on("; ").skipNulls();
        List<String> stringsToJoin = Arrays.asList("Harry", null, "Ron", "Hermione");

        //when
        String actualJoin = joiner.join(stringsToJoin);

        //then
        assertEquals("Harry; Ron; Hermione", actualJoin);
    }

    @Test
    public void shouldUseSpecifiedStringInsteadOfNulls() {
        //given
        Joiner joiner = Joiner.on("; ").useForNull("SpecifiedString");
        List<String> stringsToJoin = Arrays.asList("Harry", null, "Ron", "Hermione");

        //when
        String actualJoin = joiner.join(stringsToJoin);

        assertEquals("Harry; SpecifiedString; Ron; Hermione", actualJoin);
    }

    @Test
    public void shouldConvertArgumentsToStrings() {
        //given
        Joiner joiner = Joiner.on(",");
        List<Integer> numbersToJoin = Arrays.asList(1, 5, 7);

        //when
        String actualJoin = joiner.join(numbersToJoin);

        //then
        assertEquals("1,5,7", actualJoin);
    }
}
