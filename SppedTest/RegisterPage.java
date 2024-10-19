import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPage extends JFrame {
    public static Customer[] customers = new Customer[100];
    
    public static Customer[] getCustomer() {
        return customers;
    }
    public static int userCount = 0;

    public static int getUserCount() {
        return userCount;
    }

    public RegisterPage() {
        // 프레임 설정
        setTitle("회원가입 창");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // 메인 패널 설정
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        // 사용자 이름 레이블과 텍스트 필드
        JLabel userLabel = new JLabel("Id");
        userLabel.setBounds(95, 70, 80, 25);
        mainPanel.add(userLabel);
        
        JTextField userText = new JTextField(20);
        userText.setBounds(150, 70, 165, 25);
        mainPanel.add(userText);

        // 비밀번호 레이블과 텍스트 필드
        JLabel passwordLabel = new JLabel("Pw");
        passwordLabel.setBounds(95, 110, 80, 25);
        mainPanel.add(passwordLabel);
        
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(150, 110, 165, 25);
        mainPanel.add(passwordText);


        // 회원가입 버튼
        JButton registerButton = new JButton("회원가입");
        registerButton.setFont(new Font("", Font.PLAIN, 12));
        registerButton.setBounds(150, 150, 100, 29);
        mainPanel.add(registerButton);

        ActionListener registerAcction;
        // 회원가입 버튼 클릭 이벤트 리스너
        registerButton.addActionListener(registerAcction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = String.valueOf(passwordText.getPassword());

                if (username.isBlank()){
                    JOptionPane.showMessageDialog(null, "아이디를 적어주세요.",  "Failed",
                            JOptionPane.INFORMATION_MESSAGE);
                }else if (password.isBlank()){
                    JOptionPane.showMessageDialog(null, "패스워드를 적어주세요.",  "Failed",
                            JOptionPane.INFORMATION_MESSAGE);
                }else{
                    Customer[] customers = getCustomer();
                    for(int i=0; i<userCount; ++i) {
                        if (customers[i].getId().equals(username)) {
                            JOptionPane.showMessageDialog(null, "이미 존재하는 계정입니다.",  "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }

                    customers[userCount] = new Customer(username, password);
                    ++userCount;

                    JOptionPane.showMessageDialog(null, "회원가입 되었습니다.",  "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                }
            }
        });
        userText.addActionListener(registerAcction);
        passwordText.addActionListener(registerAcction);
        
        // 메인 패널을 프레임에 추가
        add(mainPanel);
        setVisible(true);
    }
}
