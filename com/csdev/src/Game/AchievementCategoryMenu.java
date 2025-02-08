package Game;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;


public class AchievementCategoryMenu implements ListSelectionListener {
	
	static final long serialVersionUID = 4L;
	JList<String> storedList = null;
	
	public void valueChanged(ListSelectionEvent e) {
        JList<Game.AchievementCategory> list = (JList<Game.AchievementCategory>)e.getSource();
        if (e.getValueIsAdjusting() == false) {
        	updateLabel(Game.AchievementCategory.values()[list.getSelectedIndex()]);
        }
    }
	
	public void updateLabel(Game.AchievementCategory r) {
		if (Game.currentAchievementCategory != r) {
			Game.currentAchievementCategory = r;
			if (r.currentAchievement == null) {
				r.currentAchievement = Game.getKnownAchievements(r)[0];
			}
			Game.assembleMiddlePanel();
			Game.mainPanel.repaint();
		}
	}
	
	public JList getList() {
		if (storedList == null) {
			String[] names = new String[Game.AchievementCategory.values().length];
			for (int i = 0; i < names.length; i++) {
				names[i] = Game.getAchievementCategoryDisplay(Game.AchievementCategory.values()[i]);
			}
			JList<String> list = new JList<String>(names);
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list.setCellRenderer(new Game.SpecialCellRenderer());
			if (Game.currentAchievementCategory == null) {
				list.setSelectedIndex(0);
			} else {
				for (int i = 0; i < list.getModel().getSize(); i++) {
					if (Game.AchievementCategory.values()[i] == Game.currentAchievementCategory) {
						list.setSelectedIndex(i);
					}
				}
			}
	        list.addListSelectionListener(this);
	        storedList = list;
		} else {
			for (int i = 0; i < storedList.getModel().getSize(); i++) {
				if (Game.AchievementCategory.values()[i] == Game.currentAchievementCategory) {
					storedList.setSelectedIndex(i);
				}
			}
		}
        return storedList;
	}

	public AchievementCategoryMenu() {
		// TODO Auto-generated constructor stub
	}

}
