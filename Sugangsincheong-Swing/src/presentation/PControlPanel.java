package presentation;

import javax.swing.*;

import global.Locale;

//미리담기와 수강신청 사이의 이동 버튼이 담긴 패널 
public class PControlPanel extends JPanel {
    private JButton rightButton, leftButton;
    public PControlPanel(String panelID, PSugangSincheongPanel.ActionHandler actionHandler){
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.rightButton = new JButton(Locale.LControlPanel.RIGHT_BUTTON);
        this.rightButton.addActionListener(actionHandler);
        this.rightButton.setActionCommand(panelID+this.rightButton.getText());
        this.add(rightButton);

        this.leftButton = new JButton(Locale.LControlPanel.LEFT_BUTTON);
        this.leftButton.addActionListener(actionHandler);
        this.leftButton.setActionCommand(panelID+this.leftButton.getText());
        this.add(leftButton);
    }
    public Object getRightButton() {return this.rightButton;}
    public Object getLeftButton() {return this.leftButton;}

}
