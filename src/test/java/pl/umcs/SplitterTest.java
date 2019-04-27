package pl.umcs;

import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SplitterTest {

    @Test
    public void shouldSplitString() {
        //given
        Splitter splitter = Splitter.on("; ");
        String stringToSplit = "Harry; Ron; Hermione";

        //when
        List<String> actualSplit = splitter.splitToList(stringToSplit);

        //then
        assertEquals(Arrays.asList("Harry", "Ron", "Hermione"), actualSplit);
    }

    @Test
    public void shouldOmitEmptyStrings() {
        //given
        Splitter splitter = Splitter.on("; ").omitEmptyStrings();
        String stringToSplit = "; Harry; ; ; Ron; Hermione; ";

        //when
        List<String> actualSplit = splitter.splitToList(stringToSplit);

        //then
        assertEquals(Arrays.asList("Harry", "Ron", "Hermione"), actualSplit);
    }

    @Test
    public void shouldTrimWhitespaces() {
        //given
        Splitter splitter = Splitter.on("; ").trimResults();
        String stringToSplit = "Harry;     Ron;               Hermione";

        //when
        List<String> actualSplit = splitter.splitToList(stringToSplit);

        //then
        assertEquals(Arrays.asList("Harry", "Ron", "Hermione"), actualSplit);
    }

    
    @Test
    public void shouldLimitStrings() {
        //given
        Splitter splitter = Splitter.on("; ").limit(2);
        String stringToSplit = "Harry; Ron; Hermione";

        //when
        List<String> actualSplit = splitter.splitToList(stringToSplit);

        //then
        assertEquals(Arrays.asList("Harry", "Ron; Hermione"), actualSplit);
    }
}
