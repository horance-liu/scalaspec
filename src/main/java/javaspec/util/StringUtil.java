package javaspec.util;

public final class StringUtil {
  private StringUtil() {
  }

  public static String ltrim(String str) {
    return str.replaceAll("^\\s*", "");
  }

  public static String rtrim(String str) {
    return str.replaceAll("\\s*$", "");
  }

  public static String trim(String word) {
    return ltrim(rtrim(word));
  }

  public static boolean exists(String word, CharacterSpec spec) {
    return pred(word, spec, true);
  }

  public static boolean forall(String word, CharacterSpec spec) {
    return pred(word, spec, false);
  }

  private static boolean pred(String word, CharacterSpec spec, boolean shortcut) {
    for (int i = 0; i < word.length(); i++)
      if (spec.satisfy(word.charAt(i)) == shortcut)
        return shortcut;
    return !shortcut;
  }
}
