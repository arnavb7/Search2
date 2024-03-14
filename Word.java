

public class Word {
    private String word;
    private int strength;

    public Word(String word, int strength) {
        this.word = word;
        this.strength = strength;
    }

    public String getWord() {
        return word;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public String toString() {
        return getWord() + "\nStrength: " + getStrength();
    }
}
