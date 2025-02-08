package Game;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class SpotMenu extends JPanel implements ListSelectionListener {
	
	static final long serialVersionUID = 4L;
	
	public final Game.Locale ownLocale;
	JList<String> storedList = null;
	
	public void valueChanged(ListSelectionEvent e) {
        JList<Game.Spot> list = (JList<Game.Spot>)e.getSource();
        if (e.getValueIsAdjusting() == false) {
        	updateLabel(Game.getAllowedSpots(ownLocale, Game.currentTimeSlot)[list.getSelectedIndex()]);
        }
    }
	
	public void updateLabel(Game.Spot s) {
		if (ownLocale.currentSpot != s) {
			ownLocale.currentSpot = s;
			if (Game.currentPlaythrough.weeklyActions[Game.weekDayNumber()][Game.timeSlotNumber()].ownSpot != s) {
				Game.autoOn = false;
			}
			Boolean found = false;
			for (int i = 0; s.currentAction != null && i < Game.getAllowedActions(s, Game.currentTimeSlot).length; i++) {
				if (Game.getAllowedActions(s, Game.currentTimeSlot)[i] == s.currentAction) {
					found = true;
				}
			}
			Game.currentPlaythrough.sendStats();
			for (int i = 0; i < Game.currentTimeSlot.placement; i++) {
				Game.resolveAction(Game.currentPlaythrough.weeklyActions[Game.weekDayNumber()][i], true, false);
			}
			if (s.currentAction == null || found == false) {
				s.currentAction = Game.getVisibleActions(s, Game.currentTimeSlot)[0];
			}
			Game.setGoalBar(Game.getVisibleGoal(s.currentAction, true), true);
			if (Game.actionIsAllowed(s.currentAction, Game.currentTimeSlot)) {
				Game.currentPlaythrough.weeklyActions[Game.weekDayNumber()][Game.timeSlotNumber()] = s.currentAction;
				if (!s.currentAction.setNext) {
					for (int i = 0; i < Game.Action.values().length; i++) {
						if (Game.Action.values()[i].previousAction == s.currentAction || Game.Action.values()[i].alternativePrevious == s.currentAction) {
							if (Game.timeSlotNumber() < 5) {
								if (Game.currentPlaythrough.weeklyActions[Game.weekDayNumber()][Game.timeSlotNumber() + 1] != Game.Action.values()[i]) {
									Game.addNewEntry(Game.Action.values()[i].name);
								}
							} else {
								if (Game.currentPlaythrough.weeklyActions[(Game.weekDayNumber() + 1) % 7][0] != Game.Action.values()[i]) {
									Game.addNewEntry(Game.Action.values()[i].name);
								}
							}
						}
					}
					if (s.currentAction == Game.Action.HOTELCHECKEVENING || s.currentAction == Game.Action.HOTELCHECKMIDNIGHT || s.currentAction == Game.Action.HOTELCHECKPREDAWN) {
						Game.addNewEntry(Game.Action.HOTELMORNING.name);
						Game.addNewEntry(Game.Action.HOTELNOON.name);
						if (s.currentAction == Game.Action.HOTELCHECKEVENING) {
							Game.addNewEntry(Game.Action.HOTELMIDNIGHT.name);
						}
						if (s.currentAction != Game.Action.HOTELCHECKPREDAWN) {
							Game.addNewEntry(Game.Action.HOTELPREDAWN.name);
						}
					}
				}
			}
			Game.assembleMiddlePanel();
			Game.assembleRoutinePanel();
			Game.assembleButtonPanel();
			Game.mainPanel.repaint();
		}
	}
	
	public String[] spotNames() {
		if (ownLocale != null) {
			String[] result = new String[Game.getAllowedSpots(ownLocale, Game.currentTimeSlot).length];
			for (int i = 0; i < result.length; i++) {
				result[i] = Game.getAllowedSpots(ownLocale, Game.currentTimeSlot)[i].name;
			}
			return result;
		}
		return new String[0];
	}
	
	public JList getList() {
		if (storedList == null) {
			JList<String> list = new JList<String>(spotNames());
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list.setCellRenderer(new Game.SpecialCellRenderer());
			list.addListSelectionListener(this);
			storedList = list;
		}
		if (ownLocale.currentSpot == null) {
			storedList.setSelectedIndex(0);
		} else {
			Game.Spot[] allowed = Game.getAllowedSpots(ownLocale, Game.currentTimeSlot);
			for (int i = 0; i < allowed.length; i++) {
				if (allowed[i] == ownLocale.currentSpot) {
					storedList.setSelectedIndex(i);
				}
			}
		}
        
        return storedList;
	}
	
	public SpotMenu(Game.Locale o) {
		ownLocale = o;
	}

	public SpotMenu() {
		ownLocale = null;
	}

}
