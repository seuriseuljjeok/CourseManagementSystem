package presentation;

import global.Constants;
import global.Locale;
import model.MLecture;
import valueObject.VLecture;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.Vector;

public class PResultPanel extends JPanel{
    private Vector<VLecture> vLectures;
    private JTable table;
    public JScrollPane scrollPane;
    private DefaultTableModel tableModel;

    public PResultPanel(){
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.table = new JTable();
        this.scrollPane = new JScrollPane();
        this.scrollPane.setViewportView(this.table);
        this.add(scrollPane);

        String [] header = {Locale.LResultPanel.LECTURENO, Locale.LResultPanel.LECTURENAME};
        this.tableModel = new DefaultTableModel(header,0);
        this.table.setModel(tableModel);
        this.vLectures = new Vector<>();
    }
    
    public Vector<VLecture> getLectures(){return this.vLectures;}

    public void initialize(String fileName){
        MLecture eLecture = new MLecture();
        this.vLectures = eLecture.getDirectories(fileName);
        this.setData();
    }
    
    public void finish(String fileName) throws IOException {
        MLecture eLecture = new MLecture();
        eLecture.save(fileName, this.vLectures);
    }
    
    public void addLectures(Vector<VLecture> vSelectedLectures){
        this.vLectures.add(vSelectedLectures.get(0));
        this.setData();
    }
    
    public Vector<VLecture> removeSelectedLectures(){
        Vector<VLecture> removedLectures = new Vector<>();
        int[] index = this.table.getSelectedRows();
        for(int i= index.length-1; i>=0; i--){
            VLecture removedLecture = this.vLectures.remove(index[i]);
            removedLectures.add(removedLecture);
        }
        this.setData();
        return removedLectures;
    }

    private void setData(){
        this.tableModel.setRowCount(0);
        for(VLecture vLecture : this.vLectures){
            Vector<String> row = new Vector<>();
            row.add(vLecture.getId());
            row.add(vLecture.getName());
            this.tableModel.addRow(row);
        }
        if(this.vLectures.size()>0) this.table.setRowSelectionInterval(0,0);
    }
}
