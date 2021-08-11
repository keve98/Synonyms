import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FileManagement {

    Map<String, ArrayList<String>> dictionary  = new HashMap<>();
    ArrayList<String> pairs = new ArrayList<>();

    int rounds;


    public void loadFile(String filename){
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            rounds = Integer.parseInt(scanner.nextLine());

            fillMaps(scanner);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public void fillMaps(Scanner scanner){
        for(int i = 0; i < rounds; i++){

            int lineOfDictionary = Integer.parseInt(scanner.nextLine());

            for(int j = 0; j < lineOfDictionary; j++){
                putLinesInMaps(dictionary, scanner);
            }

            int lineOfPairs = Integer.parseInt(scanner.nextLine());

            for(int k = 0; k < lineOfPairs; k++){
                String line = scanner.nextLine().toLowerCase();
                pairs.add(line);
            }
        }
    }

    public void putLinesInMaps(Map<String, ArrayList<String>> map, Scanner scanner){
        String line = scanner.nextLine().toLowerCase();
        String[] splited = line.split("\\s+");
        addValues(map, splited[0], splited[1]);
    }

    public void addValues(Map<String, ArrayList<String>> map, String key, String value) {
        ArrayList tempList = null;
        if (map.containsKey(key)) {
            tempList = map.get(key);
            if(tempList == null)
                tempList = new ArrayList();
            tempList.add(value);
        } else {
            tempList = new ArrayList();
            tempList.add(value);
        }
        map.put(key,tempList);
    }

    public void writeInFile(String filename, String text){
        try {
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write(text);
            myWriter.close();
            System.out.println("Successfully wrote to the file: " + filename);
        } catch (IOException e) {
            System.out.println("Could not write in to the file: " + filename);
            e.printStackTrace();
        }
    }

}
