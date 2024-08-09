import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser2 {

    private String hamletData;

    public HamletParser2() {
        this.hamletData = loadFile();
    }

    private String loadFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData() {
        return hamletData;
    }

    public static void writeFile(String s) {
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/newHamlet2.txt");
            fileWriter.write(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String replaceHamletWithLeon(String line){
        Pattern pattern = Pattern.compile("hamlet", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(line);
        String newText = matcher.replaceAll("Leon");
        return newText;

    }
    public String replaceHoratioWithTariq(String line) {

        Pattern pattern = Pattern.compile("Horatio", Pattern.CASE_INSENSITIVE);
        Matcher  matcher = pattern.matcher(line);
        return matcher.replaceAll("Tariq");
    }

    public void runUpdatedFile() {
        HamletParser2 hamletParser2 = new HamletParser2();
        String hamletText = hamletParser2.getHamletData();
        String replaceHamletWithLeon = hamletParser2.replaceHamletWithLeon(hamletText);
        String replaceHoratioWithTariq = hamletParser2.replaceHoratioWithTariq(replaceHamletWithLeon);
        this.hamletData = replaceHoratioWithTariq;
        writeFile(replaceHoratioWithTariq);

    }


}
