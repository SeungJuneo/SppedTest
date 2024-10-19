import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;


public class MainReactionSpeedPage extends JFrame {
    private final String CLICK_ME = "Click me";
    private final String CLICK = "Click !!!";
    private final String WAIT_FOR_GREEN = "Wait for green";
    private static long startTime;
    private static boolean isGreen = false;
    private Color color;
    private int count = 0;
    private static int sum = 0;
    private boolean nextToGrayBackGround = false;


    public MainReactionSpeedPage() {
        setTitle("자신의 반응속도를 시험해보세요!!");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        // JMENUBAR도 쓸만 할듯
        JLabel invisibleButton = new JLabel(CLICK_ME);

        invisibleButton.setOpaque(true);
        color = new Color(43,135,209);
        invisibleButton.setBackground(color);
        invisibleButton.setForeground(Color.WHITE);

        invisibleButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // 가운데 정렬
        invisibleButton.setHorizontalAlignment(SwingConstants.CENTER);
        // 사이즈 조절
        invisibleButton.setFont(new Font("Arial", Font.PLAIN, 20));
        // 위치 조절
        invisibleButton.setBounds(205, 80, 365, 105);
        mainPanel.add(invisibleButton);

        Random random = new Random();
        int delay = 2000 + random.nextInt(3000);

        Timer timer = new Timer(delay, e -> {
            invisibleButton.setText(CLICK);
            invisibleButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            color = new Color(0x1DDB16);
            invisibleButton.setBackground(color);
            startTime = System.currentTimeMillis();
            isGreen = true;
        });



        invisibleButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                invisibleButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                JLabel target = (JLabel) e.getSource();

                if (target.getText().equals(WAIT_FOR_GREEN)) {
                    timer.stop();
                    invisibleButton.setText(CLICK_ME);
                    JOptionPane.showMessageDialog(null, "너무 일찍 선택하였습니다.", "WAIT!",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    nextToGrayBackGround = false;
                    invisibleButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    timer.setRepeats(false);
                    timer.start();
                    invisibleButton.setText(WAIT_FOR_GREEN);
                    if (isGreen && count < MainSpeedPage.getAgainInt()) {
                        long reactionTime = System.currentTimeMillis() - startTime;
                        invisibleButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        invisibleButton.setText("<html>Reaction Time: " + reactionTime + " ms" + "<br><p style='color: white;text-align:center;'>Click to move on.</p></html>");
                        sum += reactionTime;
                        // JOptionPane.showMessageDialog(frame, "Reaction Time: " + reactionTime+" ms");
                        timer.stop();
                        color = new Color(43,135,209);
                        invisibleButton.setBackground(color);
                        isGreen = false;
                        count++;
                    } else if (count >= MainSpeedPage.getAgainInt()) {
                        timer.stop();
                        setVisible(false);
                        new ThankYouMainPage();
                    }
                }
            }
        });


        add(mainPanel);
        setVisible(true);
    }

    public static int getSum() {
        return sum;
    }

    public static void setSum(int sum) {
        MainReactionSpeedPage.sum = sum;
    }
}
