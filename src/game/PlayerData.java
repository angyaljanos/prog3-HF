package game;

public class PlayerData {
    private String name;
    private int score;

    public PlayerData(String PlayerName, int score){
        if(PlayerName.replaceAll(" ", "").length() < 1)
            name = "Nameless";
        else
            name = PlayerName;

        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
