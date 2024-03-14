import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import static java.lang.Integer.parseInt;
import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufReader = new BufferedReader(new FileReader("newWords.txt"));
        ArrayList<Word> wordList = new ArrayList<>();

        String line = bufReader.readLine();
        while (line != null ) {
            wordList.add(new Word(line, parseInt(bufReader.readLine())));
            line = bufReader.readLine();
        }
        bufReader.close();
        //Segment of code above reads text file into an ArrayList to be searched through.

        Scanner in = new Scanner(System.in);
        System.out.println("Search:");
        String w = in.next();
        //Segment Above Creates Scanner Class
        ArrayList<Word> found = new ArrayList<Word>();
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).getWord().contains(w)) {
                found.add(wordList.get(i));
            }
        }
        //Segment Above finds all words with user-inputted String
        if (found.size() == 0) {
            System.out.println("Not Found!");
            exit(0);
        } else if (found.size() == 1) {
            System.out.println(found.get(0));
            exit(0);
        }

//        for (int j = 0; j < found.size()-1; j++) {
//            int tempIndex = 0;
//            Word value = found.get(0);
//            for (int i = 0; i < found.size()-j; i++) {
//                if (found.get(i).getStrength() >= value.getStrength()) {
//                    tempIndex = i;
//                    value = found.get(i);
//                }
//            }
//            Word temp = found.remove(found.size()-1-j);
//            found.add(found.size()-1-j, found.get(tempIndex));
//            found.set(tempIndex, temp);
//        }
        //Segment Above is simple Selection Sort algorithm to sort Words by Strength, from Lowest Strength to Highest Strength.

        if (found.size() < 5) {
            for (int i = 0; i < found.size(); i++) {
                System.out.println(found.get(i));
            }
            exit(0);
        }

        //Segment Above limits words returned.

        ArrayList<Word> strength5 = new ArrayList<Word>();
        for (int i  = 0; i < 5; i++) {
            Word value = found.get(0);
            int highIndex = 0;
            for (int j = 0; j < found.size(); j++) {
                if (found.get(j).getStrength() >= value.getStrength()) {
                    value = found.get(i);
                    highIndex = i;
                }
            }
            strength5.add(value);
            found.remove(highIndex);
        }


        for (int i = 0; i < strength5.size(); i++) {
            System.out.println(strength5.get(i));
        }
        exit(0);
        //Segment Above prints and exits.
    }
}
