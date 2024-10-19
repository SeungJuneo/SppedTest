import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;

public class Ranking extends JFrame{
    public Ranking(){
        setTitle("랭킹");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel thankYouLabel = new JLabel("No.");
        gbc.gridx = 1;
        gbc.gridy = 0;
        thankYouLabel.setHorizontalAlignment(SwingConstants.CENTER);
        thankYouLabel.setFont(new Font("", Font.PLAIN, 45));
        mainPanel.add(thankYouLabel, gbc);

        JLabel nickNameLabel = new JLabel("닉네임");
        gbc.gridx = 2;
        nickNameLabel.setFont(new Font("", Font.PLAIN, 45));
        mainPanel.add(nickNameLabel,gbc);

        JLabel oneSaying = new JLabel("한마디");
        gbc.gridx = 3;
        oneSaying.setFont(new Font("", Font.PLAIN, 45));
        mainPanel.add(oneSaying,gbc);

        JLabel speed = new JLabel("속도");
        gbc.gridx = 4;
        speed.setFont(new Font("", Font.PLAIN, 45));
        mainPanel.add(speed,gbc);

        for (int i=1;i<=RegisterPage.getUserCount();i++){
            JLabel numLabel = new JLabel(String.valueOf(i));
            gbc.gridx = 1;
            gbc.gridy = i;
            mainPanel.add(numLabel, gbc);
        }
        for (int i=0;i<RegisterPage.getUserCount();i++){
            if (RegisterPage.getCustomer()[i].getScore()>ThankYouMainPage.getScoreArr()[i]){
                RegisterPage.getCustomer()[i].setScore(ThankYouMainPage.getScoreArr()[i]);
            }else if (RegisterPage.getCustomer()[i].getScore()==0){
                RegisterPage.getCustomer()[i].setScore(ThankYouMainPage.getScoreArr()[i]);
            }
            
        }
        Arrays.sort(RegisterPage.customers, (c1, c2) -> {
            if (c1 == null && c2 == null) return 0;
            if (c1 == null) return 1;
            if (c2 == null) return -1;
            return Integer.compare(c1.getScore(), c2.getScore());
        });
        for (int i = 0;i<RegisterPage.getUserCount();i++){
            JLabel idLabel = new JLabel(String.valueOf(RegisterPage.getCustomer()[i].getId()));
            gbc.gridx = 2;
            gbc.gridy = i+1;
            mainPanel.add(idLabel, gbc);
            
            JLabel oneSayLabel = new JLabel(String.valueOf(RegisterPage.getCustomer()[i].getOneSay()));
            oneSayLabel.setBounds(10,10,100,20);
            gbc.gridx = 3;
            gbc.gridy = i+1;
            mainPanel.add(oneSayLabel, gbc);

            JLabel humanScore = new JLabel(String.valueOf(RegisterPage.getCustomer()[i].getScore())+"ms");
            gbc.gridx = 4;
            gbc.gridy = i+1;
            mainPanel.add(humanScore,gbc);
        }


        JButton oneMoreButton = new JButton("다시하기");
        gbc.gridx = 0;
        gbc.gridy = 0;
        oneMoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainReactionSpeedPage.setSum(0);
                // 회원가입 페이지 열기
                new MainReactionSpeedPage().setVisible(true);;
                setVisible(false);
            }
        });
        mainPanel.add(oneMoreButton,gbc);

        JButton comeBack = new JButton("메인으로 돌아가기");
        gbc.gridx = 0;
        gbc.gridy = 1;
        comeBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainSpeedPage().setVisible(true);
                setVisible(false);
            }
        });
        mainPanel.add(comeBack,gbc);

        add(mainPanel);
        setVisible(true);
    }
}
