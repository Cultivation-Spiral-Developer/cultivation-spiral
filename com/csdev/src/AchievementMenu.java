import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class AchievementMenu extends JPanel implements ListSelectionListener {
	
	static final long serialVersionUID = 4L;
	
	public final Game.AchievementCategory ownAchievementCategory;
	JList<String> storedList = null;
	
	public void valueChanged(ListSelectionEvent e) {
        JList<Game.Achievement> list = (JList<Game.Achievement>)e.getSource();
        if (e.getValueIsAdjusting() == false) {
        	updateLabel(Game.getKnownAchievements(ownAchievementCategory)[list.getSelectedIndex()]);
        }
    }
	
	public void updateLabel(Game.Achievement e) {
		if (Game.currentAchievementCategory.currentAchievement != e) {
			Game.currentAchievementCategory.currentAchievement = e;
			Game.assembleMiddlePanel();
			Game.mainPanel.repaint();
		}
	}
	
	public String[] achievementNames() {
		if (ownAchievementCategory != null) {
			return Game.getVisibleAchievements(ownAchievementCategory);
		}
		return new String[0];
	}
	
	public JList getList() {
		Boolean optionsExplored = false;
		int exploredIndex = 0;
		for (int i = 0; i < Game.currentPlaythrough.progress.newEntries.length; i++) {
			if (Game.currentPlaythrough.progress.newEntries[i].equals(Game.getAchievementCategoryDisplay(ownAchievementCategory))) {
				optionsExplored = true;
				exploredIndex = i;
			}
		}
		if (storedList == null) {
			JList<String> list = new JList<String>(achievementNames());
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list.setCellRenderer(new Game.SpecialCellRenderer());
			if (ownAchievementCategory.currentAchievement == null) {
				list.setSelectedIndex(0);
			} else {
				for (int i = 0; i < list.getModel().getSize(); i++) {
					if (Game.getKnownAchievements(ownAchievementCategory)[i] == ownAchievementCategory.currentAchievement) {
						list.setSelectedIndex(i);
					} else if (optionsExplored) {
						for (int j = 0; j < Game.currentPlaythrough.progress.newEntries.length; j++) {
							if (Game.currentPlaythrough.progress.newEntries[j].equals(list.getModel().getElementAt(i))) {
								optionsExplored = false;
							}
						}
					}
				}
			}
	        list.addListSelectionListener(this);
	        storedList = list;
		} else {
			for (int i = 0; i < storedList.getModel().getSize(); i++) {
				if (Game.getKnownAchievements(ownAchievementCategory)[i] == ownAchievementCategory.currentAchievement) {
					storedList.setSelectedIndex(i);
				} else if (optionsExplored) {
					for (int j = 0; j < Game.currentPlaythrough.progress.newEntries.length; j++) {
						if (Game.currentPlaythrough.progress.newEntries[j].equals(storedList.getModel().getElementAt(i))) {
							optionsExplored = false;
						}
					}
				}
			}
		}
		if (optionsExplored) {
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
	
	public AchievementMenu(Game.AchievementCategory c) {
		ownAchievementCategory = c;
	}

	public AchievementMenu() {
		ownAchievementCategory = null;
	}

}