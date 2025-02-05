import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;

public class OptionMenu extends JPanel implements ListSelectionListener {
	
	static final long serialVersionUID = 4L;
	JList<String> storedList = null;
	
	public void valueChanged(ListSelectionEvent e) {
        JList<Game.OptionSettings> list = (JList<Game.OptionSettings>)e.getSource();
        if (e.getValueIsAdjusting() == false) {
        	updateLabel(Game.OptionSettings.values()[list.getSelectedIndex()]);
        }
    }
	
	public void updateLabel(Game.OptionSettings s) {
		if (Game.currentOptionSettings != s) {
			Game.currentOptionSettings = s;
			Game.assembleMiddlePanel();
			Game.assembleButtonPanel();
			Game.mainPanel.repaint();
		}
	}
	
	public String[] optionNames() {
		String[] result = new String[Game.OptionSettings.values().length];
		for (int i = 0; i < Game.OptionSettings.values().length; i++) {
			result[i] = Game.OptionSettings.values()[i].name;
		}
		return result;
	}
	
	public JList getList() {
		if (storedList == null) {
			JList<String> list = new JList<String>(optionNames());
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list.setCellRenderer(new Game.SpecialCellRenderer());
			list.addListSelectionListener(this);
			storedList = list;
		}
		for (int i = 0; i < Game.OptionSettings.values().length; i++) {
			if (Game.OptionSettings.values()[i] == Game.currentOptionSettings) {
				storedList.setSelectedIndex(i);
			}
		}
        
        return storedList;
	}

	public OptionMenu() {

	}

}
