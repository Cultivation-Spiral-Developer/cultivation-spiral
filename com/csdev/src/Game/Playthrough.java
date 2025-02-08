package Game;

import java.awt.Color;

import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.File;

import java.math.BigInteger;
import java.net.URLDecoder;

public class Playthrough implements Serializable {
	
	public static final long serialVersionUID = 4L;
	
	PermanentProgress progress = new PermanentProgress();
	
	int currentDay = 0;
	int loops = 0;
	boolean loopOver;
	BigInteger startMOL = BigInteger.ZERO;
	
	public Game.Action[][] weeklyActions = new Game.Action[Game.WeekDay.values().length][Game.TimeSlot.values().length];
	Game.RoutineElements[][] weeklyRoutine = new Game.RoutineElements[Game.WeekDay.values().length][Game.RoutineSettings.values().length];
	
	Game.Action[][][] archivedActions = new Game.Action[0][0][0];
	Game.RoutineElements[][][] archivedRoutine = new Game.RoutineElements[0][0][0];
	
	Color highlightColor = new Color(245, 235, 215);
	Color darkHighlightColor = new Color(60, 20, 0);
	
	BigInteger totalStamina = BigInteger.ZERO;
	BigInteger totalHealth = BigInteger.ZERO;
	BigInteger totalFinances = BigInteger.ZERO;
	
	BigInteger currentStamina = Game.hundred(1);
	BigInteger currentHealth = Game.hundred(1);
	BigInteger currentSanity = BigInteger.ZERO;
	BigInteger currentQi = BigInteger.ZERO;
	
	BigInteger yesterdayRoutineCost = BigInteger.ZERO;
	BigInteger yesterdayHealth = Game.hundred(1);
	BigInteger yesterdayMaxHealth = Game.hundred(1);
	
	BigInteger[] relationships = new BigInteger[21];
	BigInteger[] attributes = new BigInteger[21];
	BigInteger[] goals = new BigInteger[Game.totalGoals];
	
	Game.Locale currentLocale = Game.Locale.COLLEGETOWN;
	
	Game.OptionElements[] currentOptions = new Game.OptionElements[Game.OptionSettings.values().length];
	float bgmVolume = -32f;
	float sfxVolume = -16f;
	String[] personNames = new String[21];
	public Game.Gender[] personGenders = new Game.Gender[21];
	public Game.Locale[] personStatus = new Game.Locale[21];
	int[] romance = new int[21];
	public Game.Gender ownGender = Game.Gender.MALE;
	Game.Gender unmetGender = Game.Gender.FEMALE;
	
	Game.WindowContents NewDayContents = new Game.WindowContents();
	
	BigInteger daydreams = BigInteger.ZERO;
	
	int[] upgradeLevels = new int[42];
	
	boolean wealthOne = false;
	boolean wealthTwo = false;
	boolean wealthThree = false;

	boolean hashimotoFeat = false;
	
	boolean duMontFeat = false;
	
	boolean investigatorFeat = false;
	boolean jackalFeat = false;
	
	boolean heiligFeat = false;
	
	boolean tanakaFeat = false;
	boolean saviorFeat = false;
	
	boolean collegeTownDestruction = false;
	boolean metropolisFall = false;
	
	public void sendStats() {
		Game.simulatedStamina = currentStamina;
		Game.simulatedHealth = currentHealth;
		Game.simulatedSanity = currentSanity;
		Game.simulatedQi = currentQi;
		for (int i = 0; i < 21; i++) {
			Game.simulatedRelationships[i] = relationships[i];
			Game.simulatedAttributes[i] = attributes[i];
		}
		for (int i = 0; i < goals.length; i++) {
			Game.simulatedGoals[i] = goals[i];
		}
	}
	
	public void receiveStats() {
		if (!Game.recentLoad && Game.tested == null) {
			new File(getSaveFolderPath() + "previousSave.sav").delete();
			new File(getSaveFolderPath() + "currentSave.sav").renameTo(new File(getSaveFolderPath() + "previousSave.sav"));
		}

		currentStamina = Game.simulatedStamina;
		currentHealth = Game.simulatedHealth;
		currentSanity = Game.simulatedSanity;
		currentQi = Game.simulatedQi;
		for (int i = 0; i < 21; i++) {
			relationships[i] = Game.simulatedRelationships[i];
			attributes[i] = Game.simulatedAttributes[i];
		}
		for (int i = 0; i < goals.length; i++) {
			goals[i] = Game.simulatedGoals[i];
		}
		if (Game.tested == null) {
			saveToFile("currentSave");
		}
		if (currentDay % 10 == 9 && Game.tested == null) {
			saveToFile("d" + (currentDay+1));
		}
	}
	
	public static String getSaveFolderPath() {
		String path = Game.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		File test = new File(path);
		path = test.getParent();
		String fileName = "";
		char result = java.io.File.separatorChar;
		char[] charsToTest = new char[]{java.io.File.separatorChar, '/', '\\'};
		for (int j = 0; j < charsToTest.length; j++) {
			for (int i = path.length()-1; i >= 0; i--) {
				if (path.charAt(i) != charsToTest[j]) {
					fileName = path.charAt(i) + fileName;
				} else {
					i = -1;
					result = charsToTest[j];
					j = 3;
				}
				if (i == 0) {
					break;
				}
			}
		}
		//path = path.substring(0, path.length() - fileName.length() - 1);
		path = path + result + "saves" + result;
		try {
			path = URLDecoder.decode(path,"UTF-8");
		} catch (Exception e) {
			
		}
		path = path.replaceAll("file:/", "");
		path = path.replaceAll(java.io.File.separator + "u0020", java.io.File.separator + " ");
		return path;
	}
	
	public void saveToFile(String saveName) {
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		
		try {
			String path = getSaveFolderPath();
			
			new File(path).mkdir();
			
			fout = new FileOutputStream(path + saveName + ".sav");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(this);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public Playthrough loadFromFile(String saveName) {
		FileInputStream fin = null;
		ObjectInputStream ois = null;
		
		String fileName = getSaveFolderPath() + saveName + ".sav";
		
		Playthrough result = this;

		try {

			fin = new FileInputStream(fileName);
			ois = new ObjectInputStream(fin);
			result = (Playthrough) ois.readObject();

		} catch (Exception ex) {

		} finally {
			if (fin != null) {
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		result.repair();
		result.sendStats();
		return result;
	}
	
	public void repair() {
		if (goals.length < Game.totalGoals) {
			BigInteger[] newGoals = new BigInteger[Game.totalGoals];
			for (int i = 0; i < newGoals.length; i++) {
				if (i < goals.length) {
					newGoals[i] = goals[i];
				} else {
					newGoals[i] = BigInteger.ZERO;
				}
			}
			goals = newGoals;
		}
		if (currentOptions.length < Game.OptionSettings.values().length) {
			Game.OptionElements[] newOptions = new Game.OptionElements[Game.OptionSettings.values().length];
			for (int i = 0; i < currentOptions.length; i++) {
				newOptions[i] = currentOptions[i];
			}
			for (int i = newOptions.length-1; i < Game.OptionSettings.values().length; i++) {
				newOptions[i] = Game.OptionSettings.values()[i].allElements[0];
			}
			currentOptions = newOptions;
		}
		if (romance == null) {
			romance = new int[21];
		}
		progress.repair();
	}
	
	public void refreshGoals() {
		for (int i = 0; i < Game.Action.values().length; i++) {
			Game.updateActionInfo(Game.Action.values()[i]);
		}
		for (int i = 0; i < goals.length; i++) {
			Goal checkedGoal = Game.getGoal(i);
			while (checkedGoal != null) {
				if (goals[i].subtract(checkedGoal.previousRequirements).compareTo(checkedGoal.requirement) < 0) {
					checkedGoal.storedString = checkedGoal.name + ": " + Game.format(goals[i].subtract(checkedGoal.previousRequirements), checkedGoal.requirement) + "/" + Game.format(checkedGoal.requirement);
					checkedGoal.barDisplay = 1000 - goals[i].subtract(checkedGoal.previousRequirements).multiply(Game.THOUSAND).divide(checkedGoal.requirement).intValue();
					checkedGoal.barEnd = checkedGoal.barDisplay;
					checkedGoal = null;
				} else {
					if (checkedGoal.getNextGoal() == null) {
						checkedGoal.barDisplay = 0;
						checkedGoal.barEnd = checkedGoal.barDisplay;
						checkedGoal.storedString = "All goals complete!";
					}
					checkedGoal = checkedGoal.getNextGoal();
				}
			}
		}
	}
	
	public void addWeek() {
		Game.Action[][][] newArchivedActions = new Game.Action[archivedActions.length+1][0][0];
		Game.RoutineElements[][][] newArchivedRoutine = new Game.RoutineElements[archivedRoutine.length+1][0][0];
		for (int i = 0; i < archivedActions.length; i++) {
			newArchivedActions[i] = archivedActions[i];
			newArchivedRoutine[i] = archivedRoutine[i];
		}
		newArchivedActions[archivedActions.length] = new Game.Action[7][6];
		newArchivedRoutine[archivedRoutine.length] = new Game.RoutineElements[7][Game.RoutineSettings.values().length];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 6; j++) {
				newArchivedActions[archivedActions.length][i][j] = weeklyActions[i][j];
			}
			for (int j = 0; j < Game.RoutineSettings.values().length; j++) {
				newArchivedRoutine[archivedRoutine.length][i][j] = weeklyRoutine[i][j];
			}
		}
		archivedActions = newArchivedActions;
		archivedRoutine = newArchivedRoutine;
	}

	public Playthrough() {
		for (int i = 0; i < 21; i++) {
			personNames[i] = Game.defaultNames[i];
			personStatus[i] = Game.startingStatus[i];
			personGenders[i] = Game.Gender.FEMALE;
			relationships[i] = BigInteger.ZERO;
			attributes[i] = BigInteger.ZERO;
		}
		for (int i = 0; i < goals.length; i++) {
			goals[i] = BigInteger.ZERO;
		}
	}

}
