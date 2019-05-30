package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class HighScore {
	public static String FOlDER = "UFO";
	public static String FILENAME = "hightScore";
	public static String[] hightScore = new String[3];
	public static ArrayList<String> highScore = new ArrayList<>();
	public static int MAXELEMENT = 3;
	File file;
	private BufferedReader bfReader;

	public HighScore() {
		checkFile();
		readFile();
	}

	public boolean checkFile() {
		String link = "src/hightscore/HightScore.txt";
		file = new File(link);
		if (file.exists()) {
			return true;
		} else {
			try {
				file.createNewFile();
				try {
					 FileWriter fileWriter = new FileWriter(file);
					 for (int i = 0; i <MAXELEMENT; i++) {
					 fileWriter.write("0"+"\n");
					 }
					 fileWriter.close();
					 }catch (IOException e) {
					 System.out.println(e.toString());
					 }
					 return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	public void readFile() {
		try {
			FileReader reader = new FileReader(file);
			bfReader = new BufferedReader(reader);
			for (int i = 0; i < MAXELEMENT; i++) {
				// hightScore[i] = bfReader.readLine();
				highScore.add(i, bfReader.readLine());
				System.out.println(highScore.get(i));

			}
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}

	public void writeFile() {
		try {
			FileWriter fileWriter = new FileWriter(file);
			for (int i = 0; i < MAXELEMENT; i++) {
				fileWriter.write(highScore.get(i) + "\n");
			}
			fileWriter.close();
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}

	public void processHighScore() {
		int score = Shooter.powerUpsCollected + FlyingSaucer.saucersDead * 5;
		for (int i = 0; i < MAXELEMENT; i++) {
			if (score > (highScore.get(i).equalsIgnoreCase("null") ? 0 : Integer.parseInt(highScore.get(i)))) {
				highScore.add(i, score + "");
				System.out.println("qwer" + String.valueOf(score));
				break;
			}
		}
		GameData.highScore.writeFile();
	}
}
