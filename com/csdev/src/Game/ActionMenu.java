package Game;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class ActionMenu extends JPanel implements ListSelectionListener {
	
static final long serialVersionUID = 4L;
	
	public final Game.Spot ownSpot;
	JList<String> storedList = null;
	
	public void valueChanged(ListSelectionEvent e) {
        JList<Game.Action> list = (JList<Game.Action>)e.getSource();
        if (e.getValueIsAdjusting() == false) {
        	updateLabel(Game.getVisibleActions(ownSpot, Game.currentTimeSlot)[list.getSelectedIndex()]);
        }
    }
	
	public void updateLabel(Game.Action a) {
		if (ownSpot.currentAction != a) {
			ownSpot.currentAction = a;
			if (Game.currentPlaythrough.weeklyActions[Game.weekDayNumber()][Game.timeSlotNumber()] != a) {
				Game.autoOn = false;
			}
			Game.currentPlaythrough.sendStats();
			for (int i = 0; i < Game.currentTimeSlot.placement; i++) {
				Game.resolveAction(Game.currentPlaythrough.weeklyActions[Game.weekDayNumber()][i], true, false);
			}
			if (Game.actionIsAllowed(a, Game.currentTimeSlot)) {
				Game.currentPlaythrough.weeklyActions[Game.weekDayNumber()][Game.timeSlotNumber()] = a;
				if (!a.setNext) {
					for (int i = 0; i < Game.Action.values().length; i++) {
						if (Game.Action.values()[i].previousAction == a || Game.Action.values()[i].alternativePrevious == a) {
							Game.addNewEntry(Game.Action.values()[i].name);
						}
					}
				}
			}
			if (a == Game.Action.HOTELCHECKEVENING || a == Game.Action.HOTELCHECKMIDNIGHT || a == Game.Action.HOTELCHECKPREDAWN) {
				Game.addNewEntry(Game.Action.HOTELMORNING.name);
				Game.addNewEntry(Game.Action.HOTELNOON.name);
				if (a == Game.Action.HOTELCHECKEVENING) {
					Game.addNewEntry(Game.Action.HOTELMIDNIGHT.name);
				}
				if (a != Game.Action.HOTELCHECKPREDAWN) {
					Game.addNewEntry(Game.Action.HOTELPREDAWN.name);
				}
			}
			Game.setGoalBar(Game.getVisibleGoal(a, true), true);
			Game.assembleMiddlePanel();
			Game.assembleRoutinePanel();
			Game.assembleButtonPanel();
			Game.mainPanel.repaint();
		}
	}
	
	public String[] actionNames() {
		if (ownSpot != null) {
			String[] result = new String[Game.getVisibleActions(ownSpot, Game.currentTimeSlot).length];
			for (int i = 0; i < result.length; i++) {
				result[i] = Game.getVisibleActions(ownSpot, Game.currentTimeSlot)[i].name;
			}
			return result;
		}
		return new String[0];
	}
	
	public JList getList() {
		Boolean spotExplored = false;
		int exploredIndex = 0;
		for (int i = 0; i < Game.currentPlaythrough.progress.newEntries.length; i++) {
			if (Game.currentPlaythrough.progress.newEntries[i].equals(ownSpot.name)) {
				spotExplored = true;
				exploredIndex = i;
			}
		}
		if (storedList == null) {
			JList<String> list = new JList<String>(actionNames());
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list.setCellRenderer(new Game.SpecialCellRenderer());
			list.addListSelectionListener(this);
			storedList = list;
		}
		if (ownSpot.currentAction == null) {
			storedList.setSelectedIndex(0);
		} else {
			Game.Action[] visible = Game.getVisibleActions(ownSpot, Game.currentTimeSlot);
			for (int i = 0; i < visible.length; i++) {
				if (visible[i] == ownSpot.currentAction) {
					storedList.setSelectedIndex(i);
				} else if (spotExplored) {
					for (int j = 0; j < Game.currentPlaythrough.progress.newEntries.length; j++) {
						if (Game.currentPlaythrough.progress.newEntries[j].equals(visible[i].name)) {
							spotExplored = false;
						}
					}
				}
			}
		}
		if (spotExplored) {
			String[] newNewEntries = new String[Game.currentPlaythrough.progress.newEntries.length-1];
			for (int i = 0; i < Game.currentPlaythrough.progress.newEntries.length; i++) {
				if (i < exploredIndex) {
					newNewEntries[i] = Game.currentPlaythrough.progress.newEntries[i];
				} else if (i > exploredIndex) {
					newNewEntries[i-1] = Game.currentPlaythrough.progress.newEntries[i];
				}
			}
			Game.currentPlaythrough.progress.newEntries = newNewEntries;
		}
        
        return storedList;
	}
	
	public ActionMenu(Game.Spot p) {
		ownSpot = p;
	}

	public ActionMenu() {
		ownSpot = null;
	}

}
