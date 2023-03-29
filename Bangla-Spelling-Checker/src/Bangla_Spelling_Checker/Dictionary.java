package Bangla_Spelling_Checker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.TreeSet;

public class Dictionary {
    static String path = "Dictionary\\dic.txt";
    static LinkedHashMap<Integer, String> mp = new LinkedHashMap<>();
    static LinkedHashMap<Integer, Character> map = new LinkedHashMap<>();
    static TreeSet<String> correct_word = new TreeSet<>();
    static ArrayList<String> words = new ArrayList<>();
    static int alphabet_number = 64;

    public static class Node {
        int size = 65;
        Node[] nodes = new Node[70];
        int freq = 0;
        boolean end;

        public Node() {
            end = false;
            for (int i = 1; i < 70; i++) {
                nodes[i] = null;
            }
        }
    };

    static Node root;

    static void insert(Node root, String word) {
        int index = 70;
        int sum = 0;
        Node wordNode = root;
        for (int i = 0; i < word.length(); i++) {
            Dic_index value = new Dic_index(word.charAt(i));
            index = value.get_index();
            map.put(index, word.charAt(i));
            if (wordNode.nodes[index] == null) {
                wordNode.nodes[index] = new Node();
            }
            sum = sum + index;
            wordNode = wordNode.nodes[index];
        }
        wordNode.end = true;
        // System.out.println(wordNode);
        mp.put(sum, word);
        words.add(word);
    }

    static void Suggestions(Node root, String res) {
        if (root.end == true) {
            if (words.contains(res)) {
                correct_word.add(res);
            }
        }
        for (int i = 1; i <= 64; i++) {
            if (root.nodes[i] != null) {
                res = res + map.get(i);
                // System.out.println(res);
                Suggestions(root.nodes[i], res);
                if (res.length() - 1 > 0) {
                    res = res.substring(0, res.length() - 1);
                }
            }
        }
    }

    static boolean checkPresent(Node root, String word) {
        int index = 70;
        for (int i = 0; i < word.length(); i++) {
            Dic_index value = new Dic_index(word.charAt(i));
            index = value.get_index();
            if (root.nodes[index] == null) {
                Suggestions(root, word.substring(0, i));
                return false;
            }
            root = root.nodes[index];
        }
        if (root.end == true) {
            return true;
        }
        Suggestions(root, word);
        return false;
    }

    static boolean searchword(String word) {
        if (words.contains(word)) {
            return true;
        } else {
            return false;
        }
    }

//	static boolean checkfreq(String word, String word1, int p) {
//		int diff = 0;
//		for (int i = 0; i < word.length(); i++) {
//			char c = word.charAt(i);
//			if (!word1.contains(Character.toString(c))) {
//				diff++;
//			}
//		}
//		if(diff<=2) {
//		Dic_index value = new Dic_index(word);
//		int sum = value.getsum();
//		Dic_index value1 = new Dic_index(word1);
//		int sum1 = value1.getsum();
//		if (Math.abs(sum1 - sum) > p * 10) {
//			return true;
//		} else {
//			return false;
//		}
//		}
//		 else {
//				return false;
//			}
//	}

    public static TreeSet<String> modify(String word) {
        int sum = 0, index;
        for (int i = 0; i < word.length(); i++) {
            Dic_index value = new Dic_index(word.charAt(i));
            index = value.get_index();
        }
        // 1st char multiple alphabate
        for (int i = 1; i <= 64; i++) {
            String s = map.get(i) + word.substring(1);
            if (words.contains(s)) {
                correct_word.add(s);
            }
        }
        int x = (word.length() / 2);
        for (int j = 0; j < words.size(); j++) {
            if (words.get(j).length() == 1) {
                continue;
            }
            int p = editDist(word, words.get(j), word.length(), words.get(j).length());
            if (p <= Math.min(x, 3) && words.get(j).length() >= 2) {
                // System.out.println(p+" "+words.get(j).length());
                correct_word.add(words.get(j));
            }
//			else if (p <= 3) {
//				if (checkfreq(word, words.get(j), p)) {
//					correct_word.add(words.get(j));
//				}
//			}
        }
        return correct_word;
    }

    static int editDist(String str1, String str2, int m, int n) {
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            return editDist(str1, str2, m - 1, n - 1);
        }
        return 1 + Math.min(editDist(str1, str2, m, n - 1),
                Math.min(editDist(str1, str2, m - 1, n), editDist(str1, str2, m - 1, n - 1)));
    }

    public static void main(String[] args) throws IOException {
        root = new Node();
        BufferedReader br = new BufferedReader(new FileReader(path));
        int i = 0;
        String string = br.readLine();
        while (string != null) {
            insert(root, string);
            string = br.readLine();
        }
        br.close();
        Scanner sc = new Scanner(System.in);
        String edited = sc.next();
//		if (searchword(edited)) {
//			System.out.println("found");
//		} else {
//			checkPresent(root, edited);
//			modify(edited);
//			System.out.println(correct_word);
//		}
    }
}
