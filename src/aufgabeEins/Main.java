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

	}

	/**
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
