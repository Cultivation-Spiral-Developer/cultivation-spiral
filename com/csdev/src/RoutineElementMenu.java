import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import java.math.BigInteger;

public class RoutineElementMenu extends JPanel implements ListSelectionListener {
	
	static final long serialVersionUID = 4L;
	
	public final Game.RoutineSettings ownRoutineSettings;
	JList<String> storedList = null;
	
	public void valueChanged(ListSelectionEvent e) {
        JList<Game.RoutineElements> list = (JList<Game.RoutineElements>)e.getSource();
        if (e.getValueIsAdjusting() == false) {
        	updateLabel(Game.getKnownRoutineElements(ownRoutineSettings)[list.getSelectedIndex()]);
        }
    }
	
	public void updateLabel(Game.RoutineElements e) {
		if (ownRoutineSettings.currentElement != e) {
			Game.RoutineElements switchedRoutine = Game.currentPlaythrough.weeklyRoutine[Game.weekDayNumber()][ownRoutineSettings.placement];
			Game.autoOn = false;
			Game.currentRoutineSettings.currentElement = e;
			if (Game.routineElementAllowed(e)) {
				Game.currentPlaythrough.weeklyRoutine[Game.weekDayNumber()][ownRoutineSettings.placement] = e;
				if (e.ownEffect != null) {
					Game.currentGame.new SFX(e.ownEffect).execute();
				}
			}
			Game.currentPlaythrough.sendStats();
			for (int i = 0; i < 6; i++) {
				if (switchedRoutine == Game.RoutineElements.BODYARMOR) {
					if (Game.getHealthEffect(Game.currentPlaythrough.weeklyActions[Game.weekDayNumber()][i]).compareTo(Game.simulatedHealth) > 0) {
						for (int j = 0; j < Game.Action.values().length; j++) {
							if (Game.Action.values()[j].healthCost.equals(BigInteger.ZERO) && Game.actionIsAllowed(Game.Action.values()[j], Game.TimeSlot.values()[i])) {
								Game.currentPlaythrough.weeklyActions[Game.weekDayNumber()][i] = Game.Action.values()[j];
							}
						}
					}
					Game.resolveAction(Game.currentPlaythrough.weeklyActions[Game.weekDayNumber()][i], true, false);
				}
			}
			Game.assembleMiddlePanel();
			Game.assembleRoutinePanel();
			Game.assembleButtonPanel();
			Game.mainPanel.repaint();
		}
	}
	
	public String[] elementNames() {
		if (ownRoutineSettings != null) {
			return Game.getVisibleRoutineElements(ownRoutineSettings);
		}
		return new String[0];
	}
	
	public JList getList() {
		Boolean optionsExplored = false;
		int exploredIndex = 0;
		for (int i = 0; i < Game.currentPlaythrough.progress.newEntries.length; i++) {
			if (Game.currentPlaythrough.progress.newEntries[i].equals(ownRoutineSettings.name)) {
				optionsExplored = true;
				exploredIndex = i;
			}
		}
		if (storedList == null) {
			JList<String> list = new JList<String>(elementNames());
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list.setCellRenderer(new Game.SpecialCellRenderer());
			list.addListSelectionListener(this);
			storedList = list;
		}
		if (Game.routineElementAllowed(Game.currentPlaythrough.weeklyRoutine[Game.weekDayNumber()][ownRoutineSettings.placement]) == false) {
			storedList.setSelectedIndex(0);
		} else {
			Game.RoutineElements[] known = Game.getKnownRoutineElements(ownRoutineSettings);
			for (int i = 0; i < known.length; i++) {
				if (known[i] == Game.currentRoutineSettings.currentElement) {
					storedList.setSelectedIndex(i);
				} else if (optionsExplored) {
					for (int j = 0; j < Game.currentPlaythrough.progress.newEntries.length; j++) {
						if (Game.currentPlaythrough.progress.newEntries[j].equals(known[i].name)) {
							optionsExplored = false;
						}
					}
				}
			}
		}
		if (optionsExplored && exploredIndex < Game.currentPlaythrough.progress.newEntries.length) {
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
	
	public RoutineElementMenu(Game.RoutineSettings r) {
		ownRoutineSettings = r;
	}

	public RoutineElementMenu() {
		ownRoutineSettings = null;
	}

}
