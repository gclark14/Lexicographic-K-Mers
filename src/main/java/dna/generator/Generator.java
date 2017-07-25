package dna.generator;

import dna.alphabet.Alphabet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gabe.clark
 * @since 7/24/17
 */
public class Generator {
    private List<String> permutations = new ArrayList<>();

    private Alphabet alphabet = new Alphabet();

    // MAX_CHAR refers to the last element of the given domain to use
    private final char MAX_CHAR = '6';
    // UPPER_BOUND is the largest number to create with character aliases
    private final int UPPER_BOUND = generateMax();
    // Length refers to the digits of the numbers created
    private final int DIGITS = 3;

    public void generate(){
        for (int i = 0; i <= UPPER_BOUND; i++){
            parse(Integer.toString(i));
        }
    }

    void parse(String i){
        StringBuilder candidate = new StringBuilder();
        // create string with map characters
        for (int j = 0; j < i.length(); j++){
            if (alphabet.map.containsKey(Character.getNumericValue(i.charAt(j)))){
                candidate.append(i.charAt(j));
            }
        }
        // make sure its characters are all map characters
        for (int j = 0; j < candidate.length(); j++){
            if (!alphabet.map.containsKey(Character.getNumericValue(candidate.charAt(j) % (MAX_CHAR +1))))
                return;
        }
        StringBuilder convertedCandidate = new StringBuilder();
        for (int j = 0; j < candidate.length(); j++){
            convertedCandidate.append(alphabet.map.get(Character.getNumericValue(candidate.charAt(j))));
        }
        permutations.add(convertedCandidate.toString());
    }

    void printList(){
        for (String str: permutations)
            System.out.println(str);
    }

    int generateMax(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < DIGITS; i++){
            builder.append(MAX_CHAR);
        }
        return Integer.parseInt(builder.toString());
    }

    // pad (MAX_CHAR - 1) times
    void pad(){
        for(int i = 0; i < permutations.size(); i++){
            while(permutations.get(i).length() < DIGITS){
                String s = "A" + permutations.get(i);
                permutations.set(i, s);
            }
        }
    }
}
