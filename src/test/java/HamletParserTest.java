import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser2 hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser2();
        this.hamletParser.runUpdatedFile();
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
       // ClassLoader classLoader = getClass().getClassLoader();  setUp();
        //File file = new File(classLoader.getResource("updatedFile.txt").getFile());

        Pattern pattern = Pattern.compile("hamlet", Pattern.CASE_INSENSITIVE);
        //  Pattern pattern2 = Pattern.compile( "HORATIO", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletText);
        //  Matcher matcher2 = pattern2.matcher(result);
        boolean results = matcher.find();
        // matcher.appendReplacement(hamletText, "Leon");
        Assert.assertFalse(results);

    }


}