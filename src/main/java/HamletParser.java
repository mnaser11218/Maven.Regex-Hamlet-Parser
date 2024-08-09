import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = getHamletData();
    }

    public String loadFile(){
        WriteToFile writeToFile = new WriteToFile();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");
        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();

                Pattern pattern = Pattern.compile("Hamlet", Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(line);
                if(matcher.find() ){
                    matcher.appendReplacement(result, "Leon");
                    matcher.appendTail(result).append("\n");
                }
                else{
                    result.append(line).append("\n");
                }
            }
            writeToFile.write(result.toString());

        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        this.loadFile();
        WriteToFile writeToFile = new WriteToFile();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("updatedFile.txt").getFile());
        StringBuilder result = new StringBuilder("");
        String r ="";
        StringBuilder results2 = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                Pattern pattern = Pattern.compile("Horatio", Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(line);
                if(matcher.find() ){
                    matcher.appendReplacement(result, "Tariq");
                    matcher.appendTail(result).append("\n");
                }
                else{
                    result.append(line).append("\n");
                }
            }
            writeToFile.write(result.toString());
            hamletData = result.toString();

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

       hamletData = result.toString();
        return hamletData;
    }
    public static void main(String[] args) {
        HamletParser hamletParser = new HamletParser();
        hamletParser.getHamletData();
    }
}
