import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        Pattern pattern = Pattern.compile("Horatio", Pattern.CASE_INSENSITIVE);
        //  Pattern pattern2 = Pattern.compile( "HORATIO", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletText);
        //  Matcher matcher2 = pattern2.matcher(result);
        boolean results = matcher.find();
        Assert.assertFalse(results);
    }


    @Test
    public void testChangeHoratioToTariq() {
        Pattern pattern = Pattern.compile("Tariq", Pattern.CASE_INSENSITIVE);
        //  Pattern pattern2 = Pattern.compile( "HORATIO", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletText);
        //  Matcher matcher2 = pattern2.matcher(result);
        boolean results = matcher.find();
        Assert.assertTrue(results);
    }

    @Test
    public void testFindHoratio() {
        Pattern pattern = Pattern.compile("Horatio", Pattern.CASE_INSENSITIVE);
        //  Pattern pattern2 = Pattern.compile( "HORATIO", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletText);
        //  Matcher matcher2 = pattern2.matcher(result);
        boolean results = matcher.find();
        Assert.assertFalse(results);
    }

    @Test
    public void testFindHamlet() {

        Pattern pattern = Pattern.compile("Hamlet", Pattern.CASE_INSENSITIVE);
        //  Pattern pattern2 = Pattern.compile( "HORATIO", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletText);
        //  Matcher matcher2 = pattern2.matcher(result);
        boolean results = matcher.find();
        System.out.println(results);
        Assert.assertFalse(results);

    }
}