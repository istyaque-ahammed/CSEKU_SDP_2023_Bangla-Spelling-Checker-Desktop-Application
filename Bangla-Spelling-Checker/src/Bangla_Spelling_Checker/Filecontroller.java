package Bangla_Spelling_Checker;

public class Filecontroller {
    String path = null;

    Filecontroller(String string) {
        if (string.charAt(0) == '\u0985') {
            path = "Dictionary\\অ.txt";
        } else if (string.charAt(0) == '\u0986') {
            path = "Dictionary\\আ.txt";
        } else if (string.charAt(0) == '\u0987') {
            path = "Dictionary\\ই.txt";
        } else if (string.charAt(0) == '\u0988') {
            path = "Dictionary\\ঈ.txt";
        } else if (string.charAt(0) == '\u0989') {
            path = "Dictionary\\উ.txt";
        } else if (string.charAt(0) == '\u098A') {
            path = "Dictionary\\ঊ.txt";
        } else if (string.charAt(0) == '\u098B') {
            path = "Dictionary\\ঋ.txt";
        } else if (string.charAt(0) == '\u098F') {
            path = "Dictionary\\এ.txt";
        } else if (string.charAt(0) == '\u0990') {
            path = "Dictionary\\ঐ.txt";
        } else if (string.charAt(0) == '\u0993') {
            path = "Dictionary\\ও.txt";
        } else if (string.charAt(0) == '\u0994') {
            path = "Dictionary\\ঔ.txt";
        } else if (string.charAt(0) == '\u0995') {
            path = "Dictionary\\ক.txt";
        } else if (string.charAt(0) == '\u0996') {
            path = "Dictionary\\খ.txt";
        } else if (string.charAt(0) == '\u0997') {
            path = "Dictionary\\গ.txt";
        } else if (string.charAt(0) == '\u0998') {
            path = "Dictionary\\ঘ.txt";
        } else if (string.charAt(0) == '\u0999') {
            path = "Dictionary\\ঙ.txt";
        } else if (string.charAt(0) == '\u099A') {
            path = "Dictionary\\চ.txt";
        } else if (string.charAt(0) == '\u099B') {
            path = "Dictionary\\ছ.txt";
        } else if (string.charAt(0) == '\u099C') {
            path = "Dictionary\\জ.txt";
        } else if (string.charAt(0) == '\u099D') {
            path = "Dictionary\\ঝ.txt";
        } else if (string.charAt(0) == '\u099E') {
            path = "Dictionary\\ঞ.txt";
        } else if (string.charAt(0) == '\u099F') {
            path = "Dictionary\\ট.txt";
        } else if (string.charAt(0) == '\u09A0') {
            path = "Dictionary\\ঠ.txt";
        } else if (string.charAt(0) == '\u09A1') {
            path = "Dictionary\\ড.txt";
        } else if (string.charAt(0) == '\u09A2') {
            path = "Dictionary\\ঢ.txt";
        } else if (string.charAt(0) == '\u09A3') {
            path = "Dictionary\\ণ.txt";
        } else if (string.charAt(0) == '\u09A4') {
            path = "Dictionary\\ত.txt";
        } else if (string.charAt(0) == '\u09A5') {
            path = "Dictionary\\থ.txt";
        } else if (string.charAt(0) == '\u09A6') {
            path = "Dictionary\\দ.txt";
        } else if (string.charAt(0) == '\u09A7') {
            path = "Dictionary\\ধ.txt";
        } else if (string.charAt(0) == '\u09A8') {
            path = "Dictionary\\ন.txt";
        } else if (string.charAt(0) == '\u09AA') {
            path = "Dictionary\\প.txt";
        } else if (string.charAt(0) == '\u09AB') {
            path = "Dictionary\\ফ.txt";
        } else if (string.charAt(0) == '\u09AC') {
            path = "Dictionary\\ব.txt";
        } else if (string.charAt(0) == '\u09AD') {
            path = "Dictionary\\ভ.txt";
        } else if (string.charAt(0) == '\u09AE') {
            path = "Dictionary\\ম.txt";
        } else if (string.charAt(0) == '\u09AF') {
            path = "Dictionary\\য.txt";
        } else if (string.charAt(0) == '\u09B0') {
            path = "Dictionary\\র.txt";
        } else if (string.charAt(0) == '\u09B2') {
            path = "Dictionary\\ল.txt";
        } else if (string.charAt(0) == '\u09B6') {
            path = "Dictionary\\শ.txt";
        } else if (string.charAt(0) == '\u09B7') {
            path = "Dictionary\\ষ.txt";
        } else if (string.charAt(0) == '\u09B8') {
            path = "Dictionary\\স.txt";
        } else if (string.charAt(0) == '\u09B9') {
            path = "Dictionary\\হ.txt";
        } else if (string.charAt(0) == '\u09CE') {
            path = "Dictionary\\ৎ.txt";
        } else if (string.charAt(0) == '\u09DC') {
            path = "Dictionary\\ড়.txt";
        } else if (string.charAt(0) == '\u09DD') {
            path = "Dictionary\\ঢ়.txt";
        } else if (string.charAt(0) == '\u09DF') {
            path = "Dictionary\\য়.txt";
        } else if (string.charAt(0) == '\u0982') {
            path = "Dictionary\\ং.txt";
        } else if (string.charAt(0) == '\u0983') {
            path = "Dictionary\\ঃ.txt";
        } else if (string.charAt(0) == '\u0981') {
            path = "Dictionary\\◌ঁ.txt";
        }
    }

    public String pathName() {
        return path;
    }
}

