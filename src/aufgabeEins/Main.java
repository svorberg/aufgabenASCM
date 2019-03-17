package aufgabeEins;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<String> list1 = getFileAsArrayList("src/aufgabeEins/List1.txt");
		ArrayList<String> list2 = getFileAsArrayList("src/aufgabeEins/List2.txt");
		ArrayList<String> onlyIn1 = getComparedAMinusB(list1, list2);
		ArrayList<String> onlyIn2 = getComparedAMinusB(list2, list1);
		ArrayList<String> inBoth = getComparedAAndB(list1, list2);
		jsonOutputForAscm(onlyIn1, onlyIn2, inBoth);
	}

	/**
	 * Gibt JSON auf Console aus
	 * 
	 * @param onlyIn1
	 * @param onlyIn2
	 * @param inBoth
	 */
	public static void jsonOutputForAscm(ArrayList<String> onlyIn1, ArrayList<String> onlyIn2,
			ArrayList<String> inBoth) {

		System.out.println("{");
		System.out.println("\t" + "\"onlyInList1\":\t[");
		boolean start = true;
		for (String s : onlyIn1) {
			if (start) {
				System.out.print("\t\t\"" + s + "\"");
				start = false;
			} else {
				System.out.print(",\n\t\t\"" + s + "\"");
			}
		}
		System.out.println("\n\t],");
		System.out.println("\t" + "\"onlyInList2\":\t[");
		start = true;
		for (String s : onlyIn2) {
			if (start) {
				System.out.print("\t\t\"" + s + "\"");
				start = false;
			} else {
				System.out.print(",\n\t\t\"" + s + "\"");
			}
		}
		System.out.println("\n\t],");
		System.out.println("\t" + "\"inBothLists\":\t[");
		start = true;
		for (String s : inBoth) {
			if (start) {
				System.out.print("\t\t\"" + s + "\"");
				start = false;
			} else {
				System.out.print(",\n\t\t\"" + s + "\"");
			}
		}
		System.out.println("\n\t]");
		System.out.println("}");

	}

	/**
	 * Gibt alle Objekte zurück die nur in Liste a stehen.
	 * 
	 * @param a
	 *            - ArrayList
	 * @param b
	 *            - ArrayList
	 * @return ArrayList
	 */
	public static ArrayList<String> getComparedAMinusB(ArrayList<String> a, ArrayList<String> b) {
		ArrayList<String> list = new ArrayList<>();
		for (String s1 : a) {
			boolean treffer = false;
			for (String s2 : b) {
				if (s1.equals(s2)) {
					treffer = true;
					break;
				}
			}
			if (treffer == false) {
				list.add(s1);
			}

		}
		return list;
	}

	/**
	 * Gibt alle Objekte zurück die in beiden Listen stehen
	 * 
	 * @param a
	 *            - ArrayList
	 * @param b
	 *            - ArrayList
	 * @return ArrayList
	 */
	public static ArrayList<String> getComparedAAndB(ArrayList<String> a, ArrayList<String> b) {
		ArrayList<String> list = new ArrayList<>();
		for (String s1 : a) {
			for (String s2 : b) {
				if (s1.equals(s2)) {
					list.add(s1);
					break;

				}
			}

		}
		return list;
	}

	/**
	 * Liest die Datei unter dem angegebenen Pfad zeilenweise ein und gibt die
	 * Zeilen als ArrayList zurück
	 * 
	 * @param path
	 *            of File
	 * @return rows as ArrayList
	 */
	public static ArrayList<String> getFileAsArrayList(String path) {
		ArrayList<String> file = new ArrayList<>();
		File f = new File(path);
		BufferedReader reader = null;
		try {
			String line;
			reader = new BufferedReader(new FileReader(f));
			while ((line = reader.readLine()) != null) {
				file.add(line);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		try {
			reader.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		return file;
	}

}
