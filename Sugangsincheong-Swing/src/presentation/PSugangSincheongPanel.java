package presentation;

import global.Locale;
import valueObject.VAccount;
import valueObject.VLecture;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

public class PSugangSincheongPanel extends JPanel {
    private PDirectoryPanel pDirectoryPanel;
    private PControlPanel pControlPanel1, pControlPanel2;
    private PResultPanel pMiriDamgiPanel;
    private PResultPanel pSincheongPanel;
    private VAccount vAccount;

    public PSugangSincheongPanel() throws IOException {
        ActionHandler actionHandler = new ActionHandler();
        ListSelectionHandler listSelectionHandler = new ListSelectionHandler();

        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));

        this.pDirectoryPanel=new PDirectoryPanel();
        this.add(this.pDirectoryPanel);

        this.pControlPanel1 = new PControlPanel("1",actionHandler);
        this.add(this.pControlPanel1);

        this.pMiriDamgiPanel = new PResultPanel();
        this.add(pMiriDamgiPanel);

        this.pControlPanel2 = new PControlPanel("2",actionHandler);
        this.add(this.pControlPanel2);

        this.pSincheongPanel = new PResultPanel();
        this.add(pSincheongPanel);
    }

    //버튼으로 정보 옮기기
    private void moveFromLectureToMiridamgi() {
        Vector<VLecture> vLectures = this.pDirectoryPanel.getSelectedLectures();
        this.pMiriDamgiPanel.addLectures(vLectures);
    }
    
    private void moveFromMiridamgiToLecture() {
    	 Vector<VLecture> vLectures = this.pMiriDamgiPanel.removeSelectedLectures();
    }
    
    private void moveFromMiridamgiToSincheong() {
   	 Vector<VLecture> vLectures = this.pMiriDamgiPanel.removeSelectedLectures();
   	 this.pSincheongPanel.addLectures(vLectures);
    }
    
    private void moveFromSincheongToMiridamgi() {
      	 Vector<VLecture> vLectures = this.pSincheongPanel.removeSelectedLectures();  	
      	 this.pMiriDamgiPanel.addLectures(vLectures);
    }

    public class ActionHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().compareTo("1신청")==0){
                moveFromLectureToMiridamgi();
            }else if(e.getActionCommand().compareTo("1철회")==0){
                moveFromMiridamgiToLecture();
            }
            if(e.getActionCommand().compareTo("2신청")==0){
                moveFromMiridamgiToSincheong();
            }else if(e.getActionCommand().compareTo("2철회")==0){
                moveFromSincheongToMiridamgi();
            }
        }
    }

    public class ListSelectionHandler implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if(!e.getValueIsAdjusting()) updateTable(e.getSource());
        }
    }

    public void initialize(VAccount vAccount){
        this.vAccount=vAccount;
        this.pMiriDamgiPanel.initialize(this.vAccount.getID()+ Locale.LSugangsincheongPanel.MIRIDAMGI);
        this.pSincheongPanel.initialize(this.vAccount.getID()+ Locale.LSugangsincheongPanel.SINCHEONG);
    }
    private void updateTable(Object object) {
    }
}
