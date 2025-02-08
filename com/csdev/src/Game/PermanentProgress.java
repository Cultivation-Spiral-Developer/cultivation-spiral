package Game;

import java.io.Serializable;

import java.util.*;
import java.math.BigInteger;

import Scenes.*;

public class PermanentProgress implements Serializable {
	
	public static final long serialVersionUID = 4L;
	
	String[] newEntries = new String[0];
	HashMap<Game.Action, String[]> seenVariants = new HashMap<Game.Action, String[]>();
	HashMap<List<Integer>, Scene[]> watchedScenes = new HashMap<List<Integer>, Scene[]>();
	EnumMap<Game.PlotEvent, Scene[]> watchedPlotEvents = new EnumMap<>(Game.PlotEvent.class);
	EnumMap<Game.Achievement, BigInteger> highestAchievements = new EnumMap<>(Game.Achievement.class);
	
	int totalDays;
	BigInteger totalStamina = BigInteger.ZERO;
	BigInteger totalHealth = BigInteger.ZERO;
	BigInteger totalFinances = BigInteger.ZERO;
	
	Playthrough[] archivedLoops = new Playthrough[0];

	public String[] getWatchedSceneText(Scene s, int sceneProgress) {
		String[] result = new String[0];
		if (s == null) {
			return result;
		}
		if (s.associatedEvent != null) {
			if (watchedPlotEvents.get(s.associatedEvent) == null) {
				return result;
			}
			result = new String[watchedPlotEvents.get(s.associatedEvent).length];
			for (int i = 0; i < result.length; i++) {
				if (watchedPlotEvents.get(s.associatedEvent)[i].screens.length > sceneProgress) {
					result[i] = watchedPlotEvents.get(s.associatedEvent)[i].screens[sceneProgress].rawString();
				} else {
					result[i] = "";
				}
			}
		} else {
			if (watchedScenes.get(((List<Integer>)new ArrayList<Integer>(Arrays.asList(new Integer[]{s.associatedGoalIndex, s.associatedGoalTier})))) == null) {
				return result;
			}
			result = new String[watchedScenes.get(((List<Integer>)new ArrayList<Integer>(Arrays.asList(new Integer[]{s.associatedGoalIndex, s.associatedGoalTier})))).length];
			for (int i = 0; i < result.length; i++) {
				if (watchedScenes.get(((List<Integer>)new ArrayList<Integer>(Arrays.asList(new Integer[]{s.associatedGoalIndex, s.associatedGoalTier}))))[i].screens.length > sceneProgress) {
					result[i] = watchedScenes.get(((List<Integer>) new ArrayList<Integer>(Arrays.asList(new Integer[]{s.associatedGoalIndex, s.associatedGoalTier}))))[i].screens[sceneProgress].rawString();
				} else {
					result[i] = "";
				}
			}
		}
		return result;
	}
	
	public void repair() {
		if (watchedPlotEvents == null) {
			watchedPlotEvents = new EnumMap<>(Game.PlotEvent.class);
		}
	}

	public PermanentProgress() {
		// TODO Auto-generated constructor stub
	}

}
