package Game;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class StatsMenu extends JPanel implements ListSelectionListener {
	
	static final long serialVersionUID = 4L;
	
	public final Game.StatsCategory ownStatsCategory;
	JList<String> storedList = null;
	
	public void valueChanged(ListSelectionEvent e) {
        JList<Game.Achievement> list = (JList<Game.Achievement>)e.getSource();
        if (e.getValueIsAdjusting() == false) {
        	updateLabel(Game.getAllowedStatsElements(ownStatsCategory)[list.getSelectedIndex()]);
        }
    }
	
	public void updateLabel(Game.StatsElements e) {
		if (Game.currentStatsCategory.currentStats != e) {
			Game.currentStatsCategory.currentStats = e;
			Game.assembleMiddlePanel();
			Game.assembleButtonPanel();
			Game.mainPanel.repaint();
		}
	}
	
	public String[] statNames() {
		if (ownStatsCategory != null) {
			return Game.getVisibleStatsElements(ownStatsCategory);
		}
		return new String[0];
	}
	
	public JList getList() {
		if (storedList == null) {
			JList<String> list = new JList<String>(statNames());
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list.setCellRenderer(new Game.SpecialCellRenderer());
			if (ownStatsCategory.currentStats == null) {
				list.setSelectedIndex(0);
			}
	        list.addListSelectionListener(this);
	        storedList = list;
		}
		Game.StatsElements[] allowed = Game.getAllowedStatsElements(ownStatsCategory);
		for (int i = 0; i < allowed.length; i++) {
			if (allowed[i] == ownStatsCategory.currentStats) {
				storedList.setSelectedIndex(i);
			}
		}
        
        return storedList;
	}
	
	public StatsMenu(Game.StatsCategory c) {
		ownStatsCategory = c;
	}

	public StatsMenu() {
		ownStatsCategory = null;
	}

}