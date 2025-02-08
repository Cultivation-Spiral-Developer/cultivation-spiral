package Game;

import java.math.BigInteger;

public class Goal {

	String name;
	final int index;
	final int tier;
	final BigInteger requirement;
	final boolean endPoint;
	final BigInteger previousRequirements;
	String toolTip;
	String completionText = "Goal complete!";
	Goal nextGoal;
	
	int barDisplay = 1000;
	int barEnd = 1000;
	String storedString;
	String previousString;
	
	public Goal getNextGoal() {
		if (nextGoal == null) {
			if (index == 4) {
				nextGoal = Game.Action.DANCEEARLY.ownGoal;
			} else if (index == 5) {
				nextGoal = Game.Action.HANGOUT.ownGoal;
			} else if (index == 8 || index == 9) {
				nextGoal = Game.Action.PLAYTOGETHER.ownGoal;
			} else if (index == 12 || index == 13) {
				nextGoal = Game.Action.FINDTANAKAACTION.ownGoal;
			} else if (index == 21) {
				nextGoal = Game.Action.JACKALTRAINING.ownGoal;
			} else if (index == 22) {
				nextGoal = Game.Action.VOLUNTEER.ownGoal;
			} else if (index == 24) {
				nextGoal = Game.Action.VANDALISM.ownGoal;
			} else if (index == 27 && tier == 1) {
				nextGoal = Game.Action.VANDALISM.ownGoal;
			} else {
				nextGoal = new Goal(this);
			}
		}
		if (nextGoal.endPoint) {
			return null;
		}
		return nextGoal;
	}
	
	public Goal(String s, int i, BigInteger n, String u, String t) {
		name = s;
		index = i;
		tier = 0;
		requirement = n;
		previousRequirements = BigInteger.ZERO;
		endPoint = false;
		storedString = s + ": 0/" + Game.format(n);
		previousString = storedString;
		completionText = u;
		toolTip = t;
	}
	
	public Goal(Goal g) {
		if (g.index == 1) {
			if (g.tier == 0) {
				name = "Stand out from the crowd";
				requirement = Game.TEN_THOUSAND.multiply(BigInteger.valueOf(1));
				completionText = "New Action unlocked: " + Game.Action.MEETUP.name + " at " + Game.Spot.TANAKASHOUSE.name;
				toolTip = "Unlock a new Action involving " + Game.currentPlaythrough.personNames[5];
				endPoint = false;
			} else if (g.tier == 1) {
				name = "See past the mask";
				requirement = Game.TEN_THOUSAND.multiply(BigInteger.valueOf(4));
				completionText = "New Stance unlocked: " + Game.RoutineElements.VULNERABLE.name;
				toolTip = "Unlock a new Stance";
				endPoint = false;
			} else if (g.tier == 2) {
				name = "Work up your courage";
				requirement = Game.TEN_THOUSAND.multiply(BigInteger.valueOf(30));
				completionText = "New Action unlocked: " + Game.Action.DATE.name + " " + Game.Spot.DOWNTOWN.name;
				toolTip = "Unlock a new Action involving " + Game.currentPlaythrough.personNames[5];
				endPoint = false;
			} else {
				name = "";
				requirement = BigInteger.ZERO;
				endPoint = true;
			}
		} else if (g.index == 2) {
			if (g.tier == 0) {
				name = "Get to know each other";
				requirement = Game.THOUSAND.multiply(BigInteger.valueOf(8));
				completionText = "New Action unlocked: " + Game.Action.PLAYCONSOLE.name + " at " + Game.Spot.YUMENOSHOUSE.name;
				toolTip = "Unlock a new Action involving " + Game.currentPlaythrough.personNames[1];
				endPoint = false;
			} else if (g.tier == 1) {
				name = "Build trust";
				requirement = Game.THOUSAND.multiply(BigInteger.valueOf(25));
				completionText = "New Action unlocked: " + Game.Action.CLEANEARLY.name + " at " + Game.Spot.YUMENOSHOUSE.name;
				toolTip = "Unlock a new Action involving " + Game.currentPlaythrough.personNames[1];
				endPoint = false;
			} else if (g.tier == 2) {
				name = "Build intimacy";
				requirement = Game.hundred(10);
				completionText = "New Action unlocked: " + Game.Action.SLEEPOVER.name + " at " + Game.Spot.YUMENOSHOUSE.name;
				toolTip = "Unlock a new Action involving " + Game.currentPlaythrough.personNames[1];
				endPoint = false;
			} else if (g.tier == 3) {
				name = "Receive direction";
				requirement = Game.hundred(15);
				completionText = "New Stance unlocked: " + Game.RoutineElements.FOCUSED.name;
				toolTip = "Unlock a new Stance";
				endPoint = false;
			} else if (g.tier == 4) {
				name = "Consider a different goal";
				requirement = Game.thousand(3);
				completionText = "New Action unlocked: " + Game.Action.GAMEDESIGN.name + " at " + Game.Spot.YUMENOSHOUSE.name;
				toolTip = "Unlock a new Meaning-of-Life-related Action";
				endPoint = false;
			} else if (g.tier == 5) {
				name = "Refuse to be dissuaded";
				requirement = Game.thousand(20);
				completionText = "New Action unlocked: Combat drills " + Game.Spot.DOWNTOWN.name;
				toolTip = "Unlock a new Action involving " + Game.currentPlaythrough.personNames[1];
				endPoint = false;
			} else if (g.tier == 6) {
				name = "Show your determination";
				requirement = Game.thousand(20);
				completionText = "New Action unlocked: More combat drills " + Game.Spot.DOWNTOWN.name;
				toolTip = "Unlock a new Action involving " + Game.currentPlaythrough.personNames[1];
				endPoint = false;
			} else {
				name = "";
				requirement = BigInteger.ZERO;
				endPoint = true;
			}
		} else if (g.index == 3) {
			if (g.tier == 0) {
				name = "Tough it out";
				requirement = Game.THOUSAND.multiply(BigInteger.valueOf(35));
				completionText = "New Stance unlocked: " + Game.RoutineElements.TOUGH.name;
				toolTip = "Unlock a new passive ability";
				endPoint = false;
			} else if (g.tier == 1) {
				name = "Prove you aren't a pushover";
				requirement = Game.TEN_THOUSAND.multiply(BigInteger.valueOf(4));
				completionText = "New Action unlocked: " + Game.Action.VANDALISM.name + " " + Game.Spot.DOWNTOWN.name;
				toolTip = "Unlock a new Action involving " + Game.currentPlaythrough.personNames[0];
				endPoint = false;
			} else {
				name = "";
				requirement = BigInteger.ZERO;
				endPoint = true;
			}
		} else if (g.index == 6) {
			//4 feeds into Goal 19
			//5 feeds back into Goal 1
			if (g.tier == 0) {
				name = "Receive an invitation";
				toolTip = "Unlock another career path";
				completionText = "New area unlocked: " + Game.currentPlaythrough.personNames[2] + "'s Mansion";
				requirement = Game.hundred(1);
				endPoint = false;
			} else if (g.tier == 1) {
				name = "Receive a more prestigious invitation";
				toolTip = "Unlock a new Action involving " + Game.currentPlaythrough.personNames[2];
				completionText = "New Action unlocked: " + Game.Action.HOBNOB.name + " at " + Game.Spot.COUNTRYCLUB.name;
				requirement = Game.thousand(30);
				endPoint = false;
			} else if (g.tier == 2) {
				name = "Become " + Game.hisHer(2) + " favorite";
				toolTip = "Unlock a new Action involving " + Game.currentPlaythrough.personNames[2];
				completionText = "New Action unlocked: " + Game.Action.DUMONTSPA.name + " at " + Game.Spot.COUNTRYCLUB.name;
				requirement = Game.thousand(100);
				endPoint = false;
			} else {
				name = "";
				requirement = BigInteger.ZERO;
				endPoint = true;
			}
		} else if (g.index == 10) {
			//7 is infinite
			//8 and 9 feed back into 2
			if (g.tier == 0) {
				name = "Reach an understanding";
				toolTip = "Unlock a new Action involving " + Game.currentPlaythrough.personNames[0];
				completionText = "New Action unlocked: " + Game.Action.DOORUNLOCKED.name + " at " + Game.Spot.HOME.name;
				requirement = Game.TEN_THOUSAND.multiply(BigInteger.valueOf(15));
				endPoint = false;
			} else if (g.tier == 1) {
				name = "Learn some tricks";
				toolTip = "Unlock a new Equipment";
				completionText = "New Equipment unlocked: " + Game.RoutineElements.LARCENY.name;
				requirement = Game.TEN_THOUSAND.multiply(BigInteger.valueOf(30));
				endPoint = false;
			} else if (g.tier == 2) {
				name = "Make an impact";
				toolTip = "Unlock a new Action involving " + Game.currentPlaythrough.personNames[0];
				completionText = "New Action unlocked: " + Game.Action.ARGUE.name + " at " + Game.Spot.HASHIMOTOSHOUSE.name;
				requirement = Game.thousand(5);
				endPoint = false;
			} else {
				name = "";
				requirement = BigInteger.ZERO;
				endPoint = true;
			}
		} else if (g.index == 11) {
			if (g.tier == 0) {
				name = "Learn how to serve yourself";
				toolTip = "Unlock a new Diet";
				completionText = "New Diet unlocked: " + Game.RoutineElements.FINEDINING.name;
				requirement = Game.hundred(7);
				endPoint = false;
			} else if (g.tier == 1) {
				name = "Prove your competence";
				toolTip = "Unlock a new Action involving " + Game.currentPlaythrough.personNames[2];
				completionText = "New Action unlocked: " + Game.Action.DUMONTNOON.name + " at " + Game.Spot.DUMONTSMANSION.name;
				requirement = Game.thousand(4);
				endPoint = false;
			} else if (g.tier == 2) {
				name = "Observe high society";
				toolTip = "Unlock a new Equipment";
				completionText = "New Equipment unlocked: " + Game.RoutineElements.OSTENTATIOUS.name;
				requirement = Game.thousand(6);
				endPoint = false;
			/*} else if (g.tier == 3) {
				name = "Project dependability";
				toolTip = "Unlock a new Action involving " + Game.currentPlaythrough.personNames[2];
				completionText = "New Action unlocked: " + Game.Action.DUMONTEVENING.name + " at " + Game.Spot.DUMONTSMANSION.name;
				requirement = Game.thousand(10);
				endPoint = false;*/
			} else {
				name = "";
				requirement = BigInteger.ZERO;
				endPoint = true;
			}
		} else if (g.index == 14) {
			name = "";
			requirement = BigInteger.ZERO;
			endPoint = true;
		} else if (g.index == 15) {
			//12 is inital requirement before getting clues, leads to 14
			//13 is Jackal meeting, leads to 14
			//14 is tracking down Tanaka
			if (g.tier == 0) {
				name = "Meet " + Game.currentPlaythrough.personNames[3] + "'s standards";
				toolTip = "Unlock the ability to join " + Game.currentPlaythrough.personNames[3] + "'s outings";
				completionText = "New Action unlocked: " + Game.Action.SEARCHTOGETHER.name + " on " + Game.Spot.SLUMS.name;
				requirement = Game.thousand(3);
				endPoint = false;
			} else if (g.tier == 1) {
				name = "Observe " + Game.hisHer(3) + " body";
				toolTip = "Unlock a new recovery Action";
				completionText = "New Action unlocked: " + Game.Action.RECEIVETREATMENT.name + " at " + Game.Spot.TOWER.name;
				requirement = Game.thousand(4);
				endPoint = false;
			} else if (g.tier == 2) {
				name = "Form a more personal relationship";
				toolTip = "Unlock a new Action involving " + Game.currentPlaythrough.personNames[3];
				completionText = "New Action unlocked: " + Game.Action.WARSTORIES + " at " + Game.Spot.JACKALSHACK.name;
				requirement = Game.thousand(50);
				endPoint = false;
			/*} else if (g.tier == 3) {
				name = "Learn another approach";
				toolTip = "Unlock a new Stance";
				completionText = "New Stance unlocked: " + Game.RoutineElements.ADAPTIVE.name;
				requirement = Game.thousand(100);
				endPoint = false;*/
			} else {
				name = "";
				requirement = BigInteger.ZERO;
				endPoint = true;
			}
		} else if (g.index == 16) {
			if (g.tier == 0) {
				name = "Demonstrate trustworthiness";
				toolTip = "Unlock a new kind of Wetwork mission";
				completionText = "New Action unlocked: " + Game.Action.VIPESCORT.name + " on " + Game.Spot.SLUMS.name;
				requirement = Game.thousand(100);
				endPoint = false;
			} else {
				name = "";
				requirement = BigInteger.ZERO;
				endPoint = true;
			}
		} else if (g.index == 17) {
			name = "";
			requirement = BigInteger.ZERO;
			endPoint = true;
		} else if (g.index == 18) {
			if (g.tier == 0) {
				name = "Provide preliminary data";
				toolTip = "Unlock a new Action involving " + Game.currentPlaythrough.personNames[4];
				completionText = "New Action unlocked: " + Game.Action.ENDURANCE.name + " at " + Game.Spot.TOWER.name;
				requirement = Game.hundred(15);
				endPoint = false;
			/*} else if (g.tier == 1) {
				name = "Make a deal";
				toolTip = "Unlock a new Action involving " + Game.currentPlaythrough.personNames[4];
				completionText = "New Action unlocked: " + Game.Action.PERSONALTREATMENT.name + " at " + Game.Spot.TOWER.name;
				requirement = Game.thousand(20);
				endPoint = false;
			} else if (g.tier == 2) {
				name = "Spark inspiration";
				toolTip = "Unlock a new Action involving " + Game.currentPlaythrough.personNames[4];
				completionText = "New Action unlocked";
				requirement = Game.billion;
				endPoint = false;*/
			} else {
				name = "";
				requirement = BigInteger.ZERO;
				endPoint = true;
			}
		} else if (g.index == 20) {
			//19 is infinite
			if (g.tier == 0) {
				name = "Learn about an exotic job opportunity";
				toolTip = "Unlock a new language-related Action";
				completionText = "New Action unlocked: " + Game.Action.LANGUAGECOURSE.name + " " + Game.Spot.DOWNTOWN.name;
				requirement = Game.thousand(20);
				endPoint = false;
			} else if (g.tier == 1) {
				name = "Land the job";
				toolTip = "Unlock an Action in another city";
				completionText = "New Action unlocked: " + Game.Action.OFFICENOON.name + " in " + Game.Locale.METROPOLIS.name;
				requirement = Game.thousand(30);
				endPoint = false;
			} else {
				name = "";
				requirement = BigInteger.ZERO;
				endPoint = true;
			}
		} else if (g.index == 23) {
			//21 leads to 15
			//22 leads back to 18
			/*if (g.tier == 0) {
				name = "Become a real scientist";
				toolTip = "Unlock a new career-related Action";
				completionText = "New Action unlocked: ";
				requirement = Game.billion;
				endPoint = false;
			} else {*/
				name = "";
				requirement = BigInteger.ZERO;
				endPoint = true;
			//}
		} else if (g.index == 25) {
			//24 leads back to 18
			name = "";
			requirement = BigInteger.ZERO;
			endPoint = true;
		} else if (g.index == 27) {
			//26 is infinite
			if (g.tier == 0) {
				name = "Earn honesty";
				toolTip = "Unlock a new Action involving " + Game.currentPlaythrough.personNames[0];
				completionText = "New Action unlocked: " + Game.Action.INFILTRATEEARLY.name + " at " + Game.Spot.TOWER.name;
				requirement = Game.thousand(30);
				endPoint = false;
			} else {
				//next goal goes here
				name = "";
				requirement = BigInteger.ZERO;
				endPoint = true;
			}
		} else if (g.index == 28) {
			name = "";
			requirement = BigInteger.ZERO;
			endPoint = true;
		} else {
			String firstPart = g.name;
			String result = g.name;
			for (int i = g.name.length()-1; i >= 0; i--) {
				if (g.name.charAt(i) == ' ') {
					firstPart = g.name.substring(0, i);
					result = g.name.substring(i+1);
					break;
				}
			}
			int current = 1;
			try {
				current = Integer.parseInt(result);
			} catch (Exception ex) {
				firstPart = g.name;
			}
			name = firstPart + " " + (current+1);
			requirement = g.requirement.add(g.requirement);
			completionText = g.completionText;
			endPoint = false;
			toolTip = g.toolTip;
		}
		previousRequirements = g.previousRequirements.add(g.requirement);
		index = g.index;
		tier = g.tier+1;
		if (toolTip == null) {
			toolTip = "No further Goals for this Action";
		}
	}

}
