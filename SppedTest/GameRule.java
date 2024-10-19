import javax.swing.*;
import java.awt.*;

public class GameRule extends JFrame {

    public GameRule() {
        setTitle("게임 방법");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        JLabel jLabel = new JLabel("<html>1. 마음의 준비를 한다<br>2. 빨간박스를 클릭한다<br>3. 초록색으로 바뀌면 빠르게 클릭한다<br>4. 3번 반복한다<br><br>*주의: 초록색으로 바뀌기 전에 누르면 초기화 됩니다.</html>");
        jLabel.setFont(new Font("Arial", Font.BOLD, 18));
        jLabel.setBounds(210, 60, 310,200);
        mainPanel.add(jLabel);

        add(mainPanel);
        setVisible(true);
    }
}