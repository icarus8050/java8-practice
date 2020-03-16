package section_7;

public class CustomSpliterator {

    public int countWordsIteratively(String s) {
        int counter = 0;
        boolean lastSpace = true;
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                lastSpace = true;
            } else {
                if (lastSpace) {
                    counter++;
                }

                lastSpace = false;
            }
        }

        return counter;
    }
}
