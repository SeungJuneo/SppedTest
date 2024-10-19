
import javax.swing.*;
import javax.swing.text.Style;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainSpeedPage extends JFrame{
    private static int againInt = 3;

    public static int getAgainInt() {
        return againInt;
    }

    public MainSpeedPage() {
        setTitle("Reaction Speed Button");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        JMenu jMenuLogin = new JMenu("로그인");
        jMenuLogin.setFont(new Font(null, Font.PLAIN, 14));
        jMenuLogin.setBounds(650, 39, 100,20);
        mainPanel.add(jMenuLogin);

        jMenuLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 회원가입 페이지 열기
                new AdvancedLoginPage().setVisible(true);
            }
        });


        JMenu jMenuRegister = new JMenu("회원가입");
        jMenuRegister.setFont(new Font(null, Font.PLAIN, 14));
        jMenuRegister.setBounds(650, 60, 100,20);
        mainPanel.add(jMenuRegister);


        jMenuRegister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 회원가입 페이지 열기
                new RegisterPage().setVisible(true);
            }
        });


        JLabel jLabel = new JLabel("반응속도 테스트");
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setFont(new Font(null, Font.BOLD, 20));
        jLabel.setBounds(300, 60, 160,37);
        mainPanel.add(jLabel);

        JButton startButton = new JButton("시 작");
        startButton.setFont(new Font(null, Font.BOLD, 28));
        startButton.setBounds(300, 190, 160,37);
        mainPanel.add(startButton);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (RegisterPage.userCount!=0 && AdvancedLoginPage.ifLogin){
                    // 로그인 페이지 열기
                    new MainReactionSpeedPage().setVisible(true);
                    setVisible(false);
                }else if (!AdvancedLoginPage.ifLogin){
                    JOptionPane.showMessageDialog(null, "로그인 후 진행해주세요",  "Please login",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        JButton rankingButton = new JButton("랭킹");
        rankingButton.setFont(new Font(null, Font.BOLD, 23));
        rankingButton.setBounds(300, 250, 160,37);
        mainPanel.add(rankingButton);

        rankingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (RegisterPage.userCount!=0 && AdvancedLoginPage.ifLogin){
                    new Ranking().setVisible(true);
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "로그인 후 랭킹 열람이 가능합니다",  "Please login",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        JButton gameRuleButton = new JButton("게임방법");
        gameRuleButton.setFont(new Font(null, Font.BOLD, 21));
        gameRuleButton.setBounds(300, 310, 160,37);
        mainPanel.add(gameRuleButton);

        gameRuleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameRule().setVisible(true);
            }
        });

        add(mainPanel);
        setVisible(true);
    }

}
