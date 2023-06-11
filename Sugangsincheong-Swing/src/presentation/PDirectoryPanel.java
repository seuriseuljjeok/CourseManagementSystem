package presentation;
import controller.CIndex;
import global.Constants;
import global.Locale;
import valueObject.VIndex;
import valueObject.VLecture;

import java.awt.*;
import java.io.IOException;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class PDirectoryPanel extends JPanel {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;
    private ListSelectionHandler listSelectionHandler;
    private PDirectory campusTable, collegeTable, departmentTable;
    private PLectureTable lectureTable;
    private JPanel upPanel, downPanel;

    public PDirectoryPanel() throws IOException {
        LayoutManager layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layoutManager);

        this.listSelectionHandler = new ListSelectionHandler();

        //campus/college/department table을 담은 상위 패널
        upPanel = new JPanel();
        layoutManager = new BoxLayout(upPanel, BoxLayout.X_AXIS);
        upPanel.setLayout(layoutManager);

        this.campusTable = new PDirectory(Locale.DIRECTORY_ROOT, 0);
        this.campusTable.getSelectionModel().addListSelectionListener(this.listSelectionHandler);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(this.campusTable);
        upPanel.add(scrollPane);

        this.collegeTable = new PDirectory(Locale.DIRECTORY_CAMPUS, 1);
        this.collegeTable.getSelectionModel().addListSelectionListener(this.listSelectionHandler);
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(this.collegeTable);
        upPanel.add(scrollPane);

        this.departmentTable = new PDirectory(Locale.DIRECTORY_COLLEGE, 2);
        this.departmentTable.getSelectionModel().addListSelectionListener(this.listSelectionHandler);
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(this.departmentTable);
        upPanel.add(scrollPane);
        this.add(upPanel);

        //lecture 테이블을 담은 하위 패널
        downPanel = new JPanel();
        layoutManager = new BoxLayout(downPanel, BoxLayout.Y_AXIS);
        downPanel.setLayout(layoutManager);

        this.lectureTable = new PLectureTable(Locale.DIRECTORY_DEPARTMENT);
        this.lectureTable.getSelectionModel().addListSelectionListener(this.listSelectionHandler);
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(this.lectureTable);
        downPanel.add(scrollPane);

        this.add(downPanel);

        this.updateTable(null);
    }

    private void updateTable(Object object) throws IOException {
        String fileName = null;
        int[] selectedRows;
        if (object == null) {
            this.campusTable.setData(Locale.SETDATA_ROOT);
        } else if (object.equals(this.campusTable.getSelectionModel())) {
            selectedRows = this.campusTable.getSelectedRows(); //선택된 행 다 집어넣기
            if (selectedRows.length > 0) { //선택된 행이 있으면
                fileName = this.campusTable.getFileName(selectedRows[0]); //가장 먼저 선택된 행에 관련된 파일이름 가져오기
                this.collegeTable.setData(fileName);
            }
        } else if (object.equals(this.collegeTable.getSelectionModel())) {
            selectedRows = this.collegeTable.getSelectedRows();
            if (selectedRows.length > 0) {
                fileName = this.collegeTable.getFileName(selectedRows[0]);
                this.departmentTable.setData(fileName);
            }
        } else if (object.equals(this.departmentTable.getSelectionModel())) {
            selectedRows = this.departmentTable.getSelectedRows();
            if (selectedRows.length > 0) {
                fileName = this.departmentTable.getFileName(selectedRows[0]);
                this.lectureTable.setFileName(fileName);
                this.lectureTable.setData(fileName);
            }
        } else if (object.equals(this.lectureTable)) {
            selectedRows = this.lectureTable.getSelectedRows();
            if (selectedRows.length > 0) {}
        }
    }

    public Vector<VLecture> getSelectedLectures() {
        return this.lectureTable.getSelectedLectures();    
    }


    private class ListSelectionHandler implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) { //마우스 클릭이 일어나면 valueChanged 발생.
            if(!e.getValueIsAdjusting()){ //선택이 끝나면
                try {updateTable(e.getSource());}
                catch (IOException ex) {ex.printStackTrace();}
            }
        }
    }

    private class PDirectory extends JTable {
        private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;
        private DefaultTableModel tableModel;
        private CIndex sDirectory;
        private Vector<VIndex> vDirectories;
        private String directoryName;

        public PDirectory(String directoryName, int index) throws IOException {
            this.directoryName=directoryName;
            this.sDirectory = new CIndex();
            this.vDirectories = this.sDirectory.getDirectories(this.directoryName+Locale.HEADER_FILE);

            Vector<String> header = new Vector<String>();
            if(index==0) header.add(this.vDirectories.get(0).getId());
            else if(index==1) header.add(this.vDirectories.get(0).getName());
            if(index==2) header.add(this.vDirectories.get(0).getFileName());

            this.tableModel = new DefaultTableModel(header, 0);//테이블모델 생성
            this.setModel(this.tableModel);//테이블모델 등록
        }
        @Override
        public boolean isCellEditable(int row, int col){return false;}

        public String getFileName(int index){return Locale.SLASH+this.vDirectories.get(index).getFileName();}
        
        public void setData(String fileName) throws IOException {
            this.vDirectories = this.sDirectory.getDirectories(this.directoryName + fileName); //n개의 vdirectory를 받아옴
            this.tableModel.setNumRows(0);
            for (VIndex vDirectory : this.vDirectories) {
                Vector<String> row = new Vector<String>();
                row.add(vDirectory.getName()); //파일에서 읽어온 데이터를 넣어줘야 함
                this.tableModel.addRow(row);
            }
            this.setRowSelectionInterval(0, 0); //맨 처음 것을 선택하도록
        }
    }
}
