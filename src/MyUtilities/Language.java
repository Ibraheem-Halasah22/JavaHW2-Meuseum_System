package MyUtilities;

import org.jetbrains.annotations.NotNull;

public enum Language {
    ARABIC, ENGLISH, SPANISH, RUSSIAN;


    public static Language stringToLanguage( String s) {
        if (s.equalsIgnoreCase("arabic")) return Language.ARABIC;
        else if (s.equalsIgnoreCase("english")) return Language.ENGLISH;
        else if (s.equalsIgnoreCase("spanish")) return Language.SPANISH;
        else if (s.equalsIgnoreCase("russian")) return Language.RUSSIAN;
        else throw new IllegalArgumentException();

    }

}
