import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class ThankYouMainPage extends JFrame{
    public static String[] oneSay = new String[10];

    public static String[] getOneSay() {
        return oneSay;
    }
    public static int[] scoreArr = new int[10];
    
    public static int[] getScoreArr(){
        return scoreArr;
    }

    

    // private static int avr = -1;

    // public static int getAvr() {
    //     return avr;
    // }

    public ThankYouMainPage(){
        setTitle("수고하셨습니다!");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        
        JLabel thankYouLabel = new JLabel("Thank you for playing");
        thankYouLabel.setHorizontalAlignment(SwingConstants.CENTER);
        thankYouLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        thankYouLabel.setBounds(205, 50, 365, 65);
        mainPanel.add(thankYouLabel);

        scoreArr[RegisterPage.getUserCount()-1] = MainReactionSpeedPage.getSum()/MainSpeedPage.getAgainInt();
        JLabel avveregeOutput = new JLabel("Reaction Time: "+String.valueOf(scoreArr[RegisterPage.getUserCount()-1])+" ms");
        avveregeOutput.setOpaque(true);
        
        avveregeOutput.setBackground(Color.GRAY);
        avveregeOutput.setForeground(Color.BLUE);
        // 사이즈 조절
        avveregeOutput.setHorizontalAlignment(SwingConstants.CENTER);
        avveregeOutput.setFont(new Font("Arial", Font.PLAIN, 20));
        // 위치 조절
        avveregeOutput.setBounds(205, 116, 365, 105);
        mainPanel.add(avveregeOutput);

        JLabel sayOneLabel = new JLabel("한마디: ");
        sayOneLabel.setBounds(205, 229, 80, 25);
        mainPanel.add(sayOneLabel);

        JTextField sayOneText = new JTextField(20);
        sayOneText.setBounds(270, 229, 300, 25);
        sayOneText.setDocument(new LimitDocument(20));
        mainPanel.add(sayOneText);

        ActionListener sayOneAction;
        sayOneText.addActionListener(sayOneAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (RegisterPage.getUserCount() <= 10){
                    String oneText = sayOneText.getText();
                    RegisterPage.customers[RegisterPage.getUserCount()-1].setOneSay(oneText);
                }
                new Ranking();
                setVisible(false);
            }
        });


        add(mainPanel);
        setVisible(true);
    }
    class LimitDocument extends PlainDocument{
        private final int limit;

        LimitDocument(int limit){
            this.limit = limit;
        }
        @Override
        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException{
            if (str == null) {
                return;
            }    
            if ((getLength()+str.length()) <= limit){
                super.insertString(offset, str, attr);
            }
        }
    }

}
