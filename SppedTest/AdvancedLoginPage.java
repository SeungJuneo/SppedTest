import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdvancedLoginPage extends JFrame {
    public static boolean ifLogin = false;
    public AdvancedLoginPage() {
        // 프레임 설정
        setTitle("로그인");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // 메인 패널 설정
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        
        // 사용자 이름 레이블과 텍스트 필드
        JLabel userLabel = new JLabel("id");
        userLabel.setFont(new Font("Arial", Font.BOLD, 12));
        userLabel.setBounds(125, 70, 80, 25);
        mainPanel.add(userLabel);
        
        JTextField userText = new JTextField(20);
        userText.setBounds(176, 70, 165, 25);
        mainPanel.add(userText);
        
        // 비밀번호 레이블과 텍스트 필드
        JLabel passwordLabel = new JLabel("pw");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        passwordLabel.setBounds(125, 120, 80, 25);
        mainPanel.add(passwordLabel);
        
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(176, 120, 165, 25);
        mainPanel.add(passwordText);
        
        // 로그인 버튼
        JButton loginButton = new JButton("로그인");
        loginButton.setFont(new Font("", Font.PLAIN, 12));
        loginButton.setBounds(177, 160, 70, 30);
        mainPanel.add(loginButton);
        
        // 회원가입 버튼
        JButton registerButton = new JButton("회원가입");
        registerButton.setBounds(260, 160, 82, 30);
        registerButton.setFont(new Font("", Font.PLAIN, 12));
        mainPanel.add(registerButton);
        
        ActionListener loginAcction;
        // 로그인 버튼 클릭 이벤트 리스너
        loginButton.addActionListener(loginAcction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userText.getText();
                String password = String.valueOf(passwordText.getPassword());
                ifLogin = false;
                if (user.isBlank()){
                    JOptionPane.showMessageDialog(null, "아이디를 적어주세요.",  "Failed",
                            JOptionPane.INFORMATION_MESSAGE);
                }else if (password.isBlank()){
                    JOptionPane.showMessageDialog(null, "패스워드를 적어주세요.",  "Failed",
                            JOptionPane.INFORMATION_MESSAGE);
                }else if (Customer.contains(RegisterPage.getCustomer(), user.toLowerCase(), password)) {
                    JOptionPane.showMessageDialog(null, "로그인 되었습니다.",  "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    ifLogin = true;
                    setVisible(false);
                } else {
                    javax.swing.UIManager.put("OptionPane.messageFont", new java.awt.Font("굴림",java.awt.Font.PLAIN,17));
                    JOptionPane.showMessageDialog(null,"존재하지 않는 계정이거나 패스워드가 잘못되었습니다");
                }
            }
        });
        passwordText.addActionListener(loginAcction);
        // 회원가입 버튼 클릭 이벤트 리스너

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 회원가입 페이지 열기
                new RegisterPage();
                setVisible(false);
            }
        });
        // 메인 패널을 프레임에 추가
        add(mainPanel);
    }

}
