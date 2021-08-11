import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class SynonymDictionary {

    String result = "";
    ArrayList<String> synonymsOfFirst = new ArrayList<>();
    ArrayList<String>  synonymsOfSecond = new ArrayList<>();
    String firstWord;
    String secondWord;
    int i = -1;

    public void calcResult(ArrayList<String> pairs, Map<String, ArrayList<String>> dictionary){
        for(String l : pairs){
            String[] splited = l.split("\\s+");
            firstWord = splited[0];
            secondWord = splited[1];

            if(splited[0].equals(splited[1])){
                result += "synonyms\n";
            }
            else {
                getSynonyms(dictionary, splited[0], synonymsOfFirst);
                getSynonyms(dictionary, splited[1], synonymsOfSecond);
                checkSynonym();
            }
        }
    }

    public void getSynonyms(Map<String, ArrayList<String>> dictionary, String word,
                            ArrayList<String> synonymList){


        int sizeInTheBegining = synonymList.size();


        ArrayList<String> tempList = dictionary.get(word);

        if(tempList != null) {
            for (String l : tempList){
                if(!synonymList.contains(l)){
                    synonymList.addAll(tempList);
                }
            }
        }


        Iterator it = dictionary.keySet().iterator();

        while (it.hasNext()) {
            String key = it.next().toString();
            tempList = dictionary.get(key);
            for (String l : tempList){
                if(l.equals(word)){

                    if(!key.equals(firstWord) && !synonymList.contains(key)) {
                        synonymList.add(key);
                    }

                    tempList = dictionary.get(word);
                    if(tempList != null) {
                        for (String k : tempList){
                            if(!synonymList.contains(k)){
                                synonymList.addAll(tempList);
                            }
                        }
                    }
                }
            }
        }

        if(synonymList.size() > sizeInTheBegining){
            i++;
            getSynonyms(dictionary, synonymList.get(i), synonymList);
        }else{
            i = -1;
        }


    }

    public void checkSynonym(){
        if(synonymsOfSecond.contains(firstWord) || synonymsOfFirst.contains(secondWord)){
                result += "synonyms\n";
                return;
            }
        result += "different\n";
    }

    public String getResult(){
        return result;
    }


}
