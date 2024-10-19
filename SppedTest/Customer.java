import java.util.Arrays;

public class Customer {
    private String id;
    private String password;
    private int score;
    private String oneSay;
    public Customer(String id, String password, int score, String oneSay){
        this.id = id;
        this.password = password;
        this.score = score;
        this.oneSay = oneSay;
    }
    public Customer(String id, String password){
        this(id, password, 0,"");
    }
    public String getId() {
        return id;
    }

    public String getPassWord() {
        return password;
    }

    public int getScore() {
        return score;
    }
    public String getOneSay() {
        return oneSay;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setOneSay(String oneSay) {
        this.oneSay = oneSay;
    }

    // 사용자 이름이나 비밀번호가 배열에 포함되어 있는지 확인하는 메서드
    // 문제점: getId와 getPassword로 값을 받아오고, id, passsword 각각 받아왔어야했다. 
    // equalsInoreCase는 피교하는 용도
    public static boolean contains(Customer[] values, String targetId, String targetPassWord) {
        return Arrays.stream(values)
                .anyMatch(value -> value != null && value.getId().equalsIgnoreCase(targetId) && value.getPassWord().equals(targetPassWord));
    }
}
