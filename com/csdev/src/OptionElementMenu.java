import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.io.*;
import java.math.BigInteger;

public class OptionElementMenu extends JPanel implements ListSelectionListener {
	
static final long serialVersionUID = 4L;
JList<String> storedList = null;
	
	public final Game.OptionSettings ownOptionSettings;
	
	public void valueChanged(ListSelectionEvent e) {
        JList<Game.OptionElements> list = (JList<Game.OptionElements>)e.getSource();
        if (e.getValueIsAdjusting() == false) {
        	if (ownOptionSettings == Game.OptionSettings.SAVES) {
				if (Game.selectedSave != list.getSelectedIndex()) {
					Game.selectedSave = list.getSelectedIndex();
					Game.selectSave(list.getSelectedIndex());
					Game.assembleMiddlePanel();
					Game.mainPanel.repaint();
				}
        	} else {
        		updateLabel(Game.getKnownOptionElements(ownOptionSettings)[list.getSelectedIndex()]);
        	}
        }
    }
	
	public void updateLabel(Game.OptionElements e) {
		if (Game.currentPlaythrough.currentOptions[ownOptionSettings.index] != e) {
			Game.currentPlaythrough.currentOptions[ownOptionSettings.index] = e;
			if (e == Game.OptionElements.RESULTSKIPUNSEEN) {
				Game.removeEntry("Unseen");
			} else if (e == Game.OptionElements.LOOPLYSCHEDULE) {
				Game.removeEntry("Looply");
			}
			Game.assembleMiddlePanel();
			Game.assembleButtonPanel();
			Game.mainPanel.repaint();
		}
	}
	
	public String[] elementNames() {
		if (ownOptionSettings == Game.OptionSettings.SAVES) {
			if (Game.saveNames.length > 0) {
				String[] truncated = new String[Game.saveNames.length];
				for (int i = 0; i < Game.saveNames.length; i++) {
					if (Game.saveNames[i].substring(Game.saveNames[i].length() - 4).equals(".sav")) {
						truncated[i] = Game.saveNames[i].substring(0, Game.saveNames[i].length() - 4);
					} else {
						truncated[i] = Game.saveNames[i];
					}
				}
				return truncated;
			} else {
				return new String[]{"no saves found"};
			}
		/*} else if (ownOptionSettings == Game.OptionSettings.GENDERS) {
			String[] namesFound = new String[23];
			namesFound[0] = "Protagonist";
			namesFound[22] = "Unmet Characters";
			int total = 2;
			for (int i = 0; i < 21; i++) {
				if (!Game.currentPlaythrough.relationships[i].equals(BigInteger.ZERO)) {
					namesFound[i+1] = Game.currentPlaythrough.personNames[i];
					total++;
				}
			}
			String[] result = new String[total];
			total = 0;
			for (int i = 0; i < namesFound.length; i++) {
				if (namesFound[i] != null) {
					result[total] = namesFound[i];
					total++;
				}
			}
			return result;*/
		} else if (ownOptionSettings != null) {
			return Game.getVisibleOptionElements(ownOptionSettings);
		}
		return new String[0];
	}
	
	public JList getList() {
		if (storedList == null) {
			JList<String> list = new JList<String>(elementNames());
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list.setCellRenderer(new Game.SpecialCellRenderer());
	        list.addListSelectionListener(this);
        	storedList = list;
		} 
		if (ownOptionSettings == Game.OptionSettings.SAVES) {
			if (Game.selectedSave < Game.saveNames.length) {
				storedList.setSelectedIndex(Game.selectedSave);
				Game.examinedSave = Game.selectSave(Game.selectedSave);
			}
		} else {
			Game.OptionElements[] known = Game.getKnownOptionElements(ownOptionSettings);
			for (int i = 0; i < known.length; i++) {
				if (known[i] == Game.currentPlaythrough.currentOptions[ownOptionSettings.index]) {
					storedList.setSelectedIndex(i);
				}
			}
		}
        
        return storedList;
	}

	public OptionElementMenu(Game.OptionSettings o) {
		ownOptionSettings = o;
		if (o == Game.OptionSettings.SAVES) {
			Game.saveNames = new String[0];
			FileInputStream fin = null;
			ObjectInputStream ois = null;

			String path = Playthrough.getSaveFolderPath();
			File f = new File(path);
			File[] matchingFiles = f.listFiles(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					if (name.endsWith("sav")) {
						String[] newNames = new String[Game.saveNames.length+1];
						for (int i = 0; i < Game.saveNames.length; i++) {
							newNames[i] = Game.saveNames[i];
						}
						newNames[Game.saveNames.length] = name;
						Game.saveNames = newNames;
						return true;
					}
					return false;
				}
			});
			String[] finalNames = new String[Game.saveNames.length+1];
			for (int i = 0; i < Game.saveNames.length; i++) {
				finalNames[i] = Game.saveNames[i];
			}
			finalNames[Game.saveNames.length] = "Start Over";
			Game.saveNames = finalNames;
			if (matchingFiles == null) {
				matchingFiles = new File[0];
			}
			try {
				/*Game.foundSaves = new Playthrough[matchingFiles.length+1];
				for (int i = 0; i < matchingFiles.length; i++) {
					fin = new FileInputStream(matchingFiles[i]);
					ois = new ObjectInputStream(fin);
					Game.foundSaves[i] = (Playthrough) ois.readObject();
					Game.foundSaves[i].repair();
				}
				Game.foundSaves[matchingFiles.length] = new Playthrough();
				String[] finalNames = new String[Game.saveNames.length+1];
				for (int i = 0; i < Game.saveNames.length; i++) {
					finalNames[i] = Game.saveNames[i];
				}
				finalNames[Game.saveNames.length] = "Start Over";
				Game.saveNames = finalNames;*/
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (fin != null) {
					try {
						fin.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				if (ois != null) {
					try {
						ois.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
