package Bangla_Spelling_Checker;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

import Bangla_Spelling_Checker.Dictionary.Node;

public class Spell extends Filecontroller {
    static LinkedHashMap<String, Integer> dictionary;
    char[] alphabets;
    static int error = 0;

    public Spell(String path) throws Exception {
        super(path);
        // dictionary construct
        this.dictionary = construct(path);
        // System.out.println(this.dictionary);
        char start = '\u0981', end = '\u09FF';
        int charl = end - start + 1;
        this.alphabets = new char[charl];
        int i = 0;
        char c = start;
        while (c <= end) {
            alphabets[i] = c;
            c++;
            i++;
        }
        // System.out.println(dictionary);
    }

    public LinkedHashMap<String, Integer> construct(String path) throws Exception {
        LinkedHashMap<String, Integer> dictionary = new LinkedHashMap<String, Integer>();
        // InputStreamReader=a bridge from byte streams to character streams
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
        int i = 0;
        String string = br.readLine();
        while (string != null) {
            dictionary.put(string, i);
            i++;
            string = br.readLine();
        }
        br.close();
        return dictionary;
    }

    public static boolean trueString(String s) {
        if (dictionary.get(s) != null) {
            return true;
        }
        return false;
    }

    public TreeSet<String> getSuggestionSpell(String word) throws Exception {
        TreeSet<String> words = new TreeSet<String>();
        // System.out.println(word);
        // System.out.println(word);
        // System.out.println(dictionary.containsKey(word));
        error = 1;
//		if (dictionary.get(word) !=null) {
//			System.out.printf("সঠিক শব্দ = ");
//				words.add(word);
//				return words;
//			}
        // System.out.printf("প্রস্তাবিত শব্দ ");
        // System.err.printf(word);
        // System.out.println(" এর জন্য: ");
        ArrayList<String> edits = Edit(word);
        // System.err.println(edits);
        this.dictionary = construct(Dictionary.path);
        ArrayList<String> a = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < alphabets.length; j++) {
                String childString = word.substring(0, i) + alphabets[j] + word.substring(i + 1);
                if (dictionary.containsKey(childString)) {
                    // System.out.println(childString);
                    word = childString;
                    // System.out.println("hi");
                    edits.add(childString);
                    // a.add(childString);
                }
            }
        }
        // System.out.println(a);
        for (String edit : edits) {
            if (edit.length() > 1) {
                words.add(edit);
            }
        }
        return words;
    }

    //
    static char[] swap(String str, int i, int j) {
        char ch[] = str.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return ch;
    }

    public ArrayList<String> Edit(String word) throws Exception {
        ArrayList<String> edits = new ArrayList<String>();
        String editedWord;
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < alphabets.length; j++) {
                editedWord = word.substring(0, i) + alphabets[j] + word.substring(i + 1);
                // System.out.printf(editedWord+" ");
                if (dictionary.get(editedWord) != null) {
                    edits.add(editedWord);
                }
                editedWord = word.substring(0, i) + alphabets[j] + word.substring(i);
                // System.out.println(editedWord);
                if (dictionary.get(editedWord) != null) {
                    edits.add(editedWord);
                }
                editedWord = word.substring(0, i) + alphabets[j] + '\u09cd' + word.substring(i);
                // System.out.println(editedWord);
                if (dictionary.get(editedWord) != null) {
                    edits.add(editedWord);
                }
                editedWord = word.substring(0, i) + alphabets[j] + '\u09cd' + word.substring(i + 1);
                // System.out.println(editedWord);
                if (dictionary.get(editedWord) != null) {
                    edits.add(editedWord);
                }
//				editedWord1=alphabets[j] + word.substring(i + 1);
//				Filecontroller file = new Filecontroller(editedWord1);
//				String path = file.pathName();
                // System.out.println(path);
//				if (path == null) {
//					continue;
//				}
//				this.dictionary = construct(path);
//				if (dictionary.get(editedWord1) != null) {
//					edits.add(editedWord1);
//				}
            }
        }
        // System.out.println(edits);
        for (int i = 1; i < word.length() - 1; i++) {
            editedWord = word.substring(0, i) + word.substring(i + 2);
            // System.out.println(editedWord);
            if (dictionary.get(editedWord) != null) {
                edits.add(editedWord);
            }
        }
        editedWord = word.substring(0, word.length() - 2) + word.substring(word.length() - 1);
        // System.out.println("hi "+editedWord);
        if (dictionary.get(editedWord) != null) {
            edits.add(editedWord);
        }
        for (int i = 2; i < word.length(); i++) {
            String x = word.substring(0, i);
            // System.out.println(x);
            if (dictionary.get(x) != null) {
                edits.add(x);
            }
        }
        // for hoshonto
        for (int j = 1; j < word.length(); j++) {
            editedWord = word.substring(0, j) + '\u09cd' + word.substring(j);
            // System.out.println(editedWord);
            if (dictionary.get(editedWord) != null) {
                edits.add(editedWord);
            }
        }
        for (int j = 1; j < word.length() - 3; j++) {
            editedWord = word.substring(0, j) + '\u09cd' + word.substring(j, j + 3) + '\u09cd' + word.substring(j + 3);
            // System.out.println(editedWord);
            if (dictionary.get(editedWord) != null) {
                edits.add(editedWord);
            }
        }
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < word.length(); j++) {
                if (i != j) {
                    char[] c = swap(word, i, j);
                    String string = String.valueOf(c);
                    // System.out.println(string);
                    Filecontroller file = new Filecontroller(string);
                    String path = file.pathName();
                    // System.out.println(path);
                    if (path == null) {
                        continue;
                    }
                    this.dictionary = construct(path);
                    // System.out.println(path+" "+string+" "+dictionary.containsKey(string));
                    if (dictionary.containsKey(string)) {
                        // System.out.println("hi");
                        edits.add(string);
                    }
                }
            }
        }
        // addition
        StringBuffer sb = new StringBuffer(word);
        for (int i = 0; i < alphabets.length; i++) {
            sb.append(alphabets[i]);
            if (dictionary.get(sb.toString()) != null) {
                edits.add(sb.toString());
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        if (word.charAt(0) == '\u0996') {
            String path = "Dictionary\\\\ক্ষ.txt\"";
            String s = "ক্ষ" + word.substring(1);
            // System.out.println(s);
            this.dictionary = construct(path);
            // System.out.println(path+" "+dictionary.get(s));
            if (dictionary.get(s) != null) {
                edits.add(s);
            }
        }
        // System.out.println(edits);
        return edits;
    }

    public static void main(String[] args) throws Exception {
        String path = null;
        TreeSet<String> correctStrings;
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        String[] words = sentence.split(" ");
        Dictionary.root = new Node();
        BufferedReader br = new BufferedReader(new FileReader(Dictionary.path));
        int i = 0;
        String string = br.readLine();
        while (string != null) {
            Dictionary.insert(Dictionary.root, string);
            // System.out.println(string);
            string = br.readLine();
        }
        br.close();
        for (i = 0; i < words.length; i++) {
            // System.out.println(words[i]);
//			System.out.println(words[i].charAt(0));
            String x = words[i];
            Filecontroller file = new Filecontroller(x);
            path = file.pathName();
            if (x.charAt(0) == '\u0995' && x.charAt(1) == '\u09cd' && x.charAt(2) == '\u09B7') {
                path = "File\\ক্ষ.txt";
            }
            // System.out.println(path.toString());
            Spell spell = new Spell(path);
            // Dictionary.Node wordNode = new Node();
            if (trueString(words[i])) {
                // System.out.printf("সঠিক শব্দ = ");
                System.out.println(words[i]);
                continue;
            } else if (Dictionary.searchword(words[i])) {
                // System.out.printf("সঠিক শব্দ = ");
                System.out.println(words[i]);
                continue;
            } else {
                // System.out.println(path);
                correctStrings = spell.getSuggestionSpell(words[i]);
                Dictionary.modify(words[i]);
                Dictionary.checkPresent(Dictionary.root, words[i]);
                correctStrings.addAll(Dictionary.correct_word);
                // System.out.println(correctStrings.size());
//				Iterator<String> itr = correctStrings.iterator();
//				while (itr.hasNext()) {
//					System.out.print(itr.next() + " ");
//				}
//				System.out.println();
            }
        }
    }
}