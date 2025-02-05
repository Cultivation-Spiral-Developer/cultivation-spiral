import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class RoutineMenu extends JPanel implements ListSelectionListener {
	
	static final long serialVersionUID = 4L;
	JList<String> storedList = null;
	
	public void valueChanged(ListSelectionEvent e) {
        JList<Game.RoutineSettings> list = (JList<Game.RoutineSettings>)e.getSource();
        if (e.getValueIsAdjusting() == false) {
        	updateLabel(Game.getAllowedRoutineSettings()[list.getSelectedIndex()]);
        }
    }
	
	public void updateLabel(Game.RoutineSettings r) {
		if (Game.currentRoutineSettings != r) {
			Game.currentRoutineSettings = r;
			r.currentElement = Game.currentPlaythrough.weeklyRoutine[Game.weekDayNumber()][r.placement];
			Game.assembleMiddlePanel();
			Game.assembleButtonPanel();
			Game.mainPanel.repaint();
		}
	}
	
	public JList getList() {
		if (storedList == null) {
			JList<String> list = new JList<String>(Game.getVisibleRoutineSettings());
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list.setCellRenderer(new Game.SpecialCellRenderer());
			list.addListSelectionListener(this);
			storedList = list;
		}
		if (Game.currentRoutineSettings == null) {
			Game.currentRoutineSettings = Game.getAllowedRoutineSettings()[0];
			storedList.setSelectedIndex(0);
		} else {
			Game.RoutineSettings[] allowed = Game.getAllowedRoutineSettings();
			for (int i = 0; i < storedList.getModel().getSize(); i++) {
				if (allowed[i] == Game.currentRoutineSettings) {
					storedList.setSelectedIndex(i);
				}
			}
		}
        
        return storedList;
	}
	
	public RoutineMenu() {
		
	}

}
