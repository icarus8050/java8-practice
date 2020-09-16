package effective_java.item_36;

import effective_java.item_36.Text.Style;

import java.util.EnumSet;

public class Main {
    public static void main(String[] args) {
        Text text = new Text();

        text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }
}
