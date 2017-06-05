package main.dictionary;

public class Word {

    private String content;

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Word)) return false;
        Word otherWord = (Word) other;
        return this.getContent().equals(otherWord.getContent());
    }

    @Override
    public int hashCode() {
        return this.getContent().hashCode();
    }

    public boolean isNeighbourTo(Word other) {
        if (this.getLength() != other.getLength() || this.equals(other)) {
            return false;
        }
        int diffCounter = 0;

        char[] word1 = this.getContent().toCharArray();
        char[] word2 = other.getContent().toCharArray();
        for (int i = 0; i < this.getLength(); i++) {
            if (word1[i] != word2[i]) {
                diffCounter++;
            }
        }
        if (diffCounter == 1) {
            return true;
        }
        return false;
    }

    public Word(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public int getLength() {
        return content.length();
    }

}
