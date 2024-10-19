import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        // 로그인 페이지 실행
        SwingUtilities.invokeLater(() -> new MainSpeedPage().setVisible(true));
    }
}
