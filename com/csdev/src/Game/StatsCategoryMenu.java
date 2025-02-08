package Game;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class StatsCategoryMenu implements ListSelectionListener {
	
static final long serialVersionUID = 4L;

JList<String> storedList = null;
	
	public void valueChanged(ListSelectionEvent e) {
        JList<Game.StatsCategory> list = (JList<Game.StatsCategory>)e.getSource();
        if (e.getValueIsAdjusting() == false) {
        	updateLabel(Game.getAllowedStats()[list.getSelectedIndex()]);
        }
    }
	
	public void updateLabel(Game.StatsCategory r) {
		if (Game.currentStatsCategory != r) {
			Game.currentStatsCategory = r;
			if (r.currentStats == null) {
				r.currentStats = Game.getAllowedStatsElements(r)[0];
			}
			Game.assembleMiddlePanel();
			Game.assembleButtonPanel();
			Game.mainPanel.repaint();
		}
	}
	
	public JList getList() {
		if (storedList == null) {
			String[] names = new String[Game.getAllowedStats().length];
			for (int i = 0; i < names.length; i++) {
				names[i] = Game.getAllowedStats()[i].name;
			}
			JList<String> list = new JList<String>(names);
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list.setCellRenderer(new Game.SpecialCellRenderer());
			if (Game.currentStatsCategory == null) {
				list.setSelectedIndex(0);
			}
			list.addListSelectionListener(this);
			storedList = list;
		}
		Game.StatsCategory[] allowed = Game.getAllowedStats();
		for (int i = 0; i < storedList.getModel().getSize(); i++) {
			if (allowed[i] == Game.currentStatsCategory) {
				storedList.setSelectedIndex(i);
			}
		}
        return storedList;
	}

	public StatsCategoryMenu() {
		// TODO Auto-generated constructor stub
	}

}
