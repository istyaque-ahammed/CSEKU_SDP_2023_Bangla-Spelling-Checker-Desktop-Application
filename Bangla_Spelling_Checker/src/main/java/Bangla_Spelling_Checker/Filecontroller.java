/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bangla_Spelling_Checker;

/**
 *
 * @author HP
 */
public class Filecontroller {
	String path = null;

	Filecontroller(String string) {
		if (string.charAt() == '\u0985') {
			path = "Dictionary\\.txt";
		} else if (string.charAt() == '\u0986') {
			path = "Dictionary\\আ.txt";
		} else if (string.charAt() == '\u0987') {
			path = "Dictionary\\ই.txt";
		} else if (string.charAt() == '\u0988') {
			path = "Dictionary\\ঈ.txt";
		} else if (string.charAt() == '\u0989') {
			path = "Dictionary\\উ.txt";
		} else if (string.charAt() == '\u098A') {
			path = "Dictionary\\ঊ.txt";
		} else if (string.charAt() == '\u098B') {
			path = "Dictionary\\ঋ.txt";
		} else if (string.charAt() == '\u098F') {
			path = "Dictionary\\এ.txt";
		} else if (string.charAt() == '\u0990') {
			path = "Dictionary\\ঐ.txt";
		} else if (string.charAt() == '\u0993') {
			path = "Dictionary\\ও.txt";
		} else if (string.charAt() == '\u0994') {
			path = "Dictionary\\ঔ.txt";
		} else if (string.charAt() == '\u0995') {
			path = "Dictionary\\ক.txt";
		} else if (string.charAt() == '\u0996') {
			path = "Dictionary\\খ.txt";
		} else if (string.charAt() == '\u0997') {
			path = "Dictionary\\গ.txt";
		} else if (string.charAt() == '\u0998') {
			path = "Dictionary\\ঘ.txt";
		} else if (string.charAt() == '\u0999') {
			path = "Dictionary\\ঙ.txt";
		} else if (string.charAt() == '\u099A') {
			path = "Dictionary\\চ.txt";
		} else if (string.charAt() == '\u099B') {
			path = "Dictionary\\ছ.txt";
		} else if (string.charAt() == '\u099C') {
			path = "Dictionary\\জ.txt";
		} else if (string.charAt() == '\u099D') {
			path = "Dictionary\\ঝ.txt";
		} else if (string.charAt() == '\u099E') {
			path = "Dictionary\\ঞ.txt";
		} else if (string.charAt() == '\u099F') {
			path = "Dictionary\\ট.txt";
		} else if (string.charAt() == '\u09A0') {
			path = "Dictionary\\ঠ.txt";
		} else if (string.charAt() == '\u09A1') {
			path = "Dictionary\\ড.txt";
		} else if (string.charAt() == '\u09A2') {
			path = "Dictionary\\ঢ.txt";
		} else if (string.charAt() == '\u09A3') {
			path = "Dictionary\\ণ.txt";
		} else if (string.charAt() == '\u09A4') {
			path = "Dictionary\\ত.txt";
		} else if (string.charAt() == '\u09A5') {
			path = "Dictionary\\থ.txt";
		} else if (string.charAt() == '\u09A6') {
			path = "Dictionary\\দ.txt";
		} else if (string.charAt() == '\u09A7') {
			path = "Dictionary\\ধ.txt";
		} else if (string.charAt() == '\u09A8') {
			path = "Dictionary\\ন.txt";
		} else if (string.charAt() == '\u09AA') {
			path = "Dictionary\\প.txt";
		} else if (string.charAt() == '\u09AB') {
			path = "Dictionary\\ফ.txt";
		} else if (string.charAt() == '\u09AC') {
			path = "Dictionary\\ব.txt";
		} else if (string.charAt() == '\u09AD') {
			path = "Dictionary\\ভ.txt";
		} else if (string.charAt() == '\u09AE') {
			path = "Dictionary\\ম.txt";
		} else if (string.charAt() == '\u09AF') {
			path = "Dictionary\\য.txt";
		} else if (string.charAt() == '\u09B0') {
			path = "Dictionary\\র.txt";
		} else if (string.charAt() == '\u09B2') {
			path = "Dictionary\\ল.txt";
		} else if (string.charAt() == '\u09B6') {
			path = "File\\শ.txt";
		} else if (string.charAt() == '\u09B7') {
			path = "File\\ষ.txt";
		} else if (string.charAt() == '\u09B8') {
			path = "File\\স.txt";
		} else if (string.charAt() == '\u09B9') {
			path = "File\\হ.txt";
		} else if (string.charAt() == '\u09CE') {
			path = "File\\ৎ.txt";
		} else if (string.charAt() == '\u09DC') {
			path = "File\\ড়.txt";
		} else if (string.charAt() == '\u09DD') {
			path = "File\\ঢ়.txt";
		} else if (string.charAt() == '\u09DF') {
			path = "File\\য়.txt";
		} else if (string.charAt() == '\u0982') {
			path = "File\\ং.txt";
		} else if (string.charAt() == '\u0983') {
			path = "File\\ঃ.txt";
		} else if (string.charAt() == '\u0981') {
			path = "File\\◌ঁ.txt";
		}
	}

	public String pathName() {
		return path;
	}
}