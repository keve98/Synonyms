public class Main {
    public static void main(String[] args){

        String inputFileName = "input.txt";
        String outputFileName = "output.txt";

        FileManagement fileManagement = new FileManagement();
        SynonymDictionary synonymDictionary = new SynonymDictionary();

        fileManagement.loadFile(inputFileName);

        synonymDictionary.calcResult(fileManagement.pairs, fileManagement.dictionary);

        fileManagement.writeInFile(outputFileName, synonymDictionary.getResult());



    }
}
