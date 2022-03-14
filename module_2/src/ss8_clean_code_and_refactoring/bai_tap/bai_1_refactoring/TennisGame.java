package ss8_clean_code_and_refactoring.bai_tap.bai_1_refactoring;

public class TennisGame {

    public static final int LOVE = 0;
    public static final int FIFTEEN = 1;
    public static final int THIRTY = 2;
    public static final int FORTY = 3;

    public static String getScore(String player1Name, String player2Name, int playerScore1, int playerScore2) {
        String score = "";
        if (playerScore1 == playerScore2) {
           score=checkEvenScore(playerScore1);
        } else if (playerScore1 >= 4 || playerScore2 >= 4) {
            score = checkWin(player1Name,player2Name,playerScore1, playerScore2);
        } else {
            score = Score(playerScore1, playerScore2);
        }
        return score;
    }

    public static String checkWin(String player1Name, String player2Name,int playerScore1, int playerScore2) {
        String score = "";
        int minusResult = playerScore1 - playerScore2;
        if (minusResult == 1) score = "Advantage "+player1Name;
        else if (minusResult == -1) score = "Advantage "+player2Name;
        else if (minusResult >= 2) score = "Win for "+player1Name;
        else score = "Win for "+player2Name;
        return score;
    }

    public static String Score(int playerScore1, int playerScore2) {
        int tempScore = 0;
        String score = "";
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = playerScore1;
            else {
                score += "-";
                tempScore = playerScore2;
            }
            switch (tempScore) {
                case LOVE:
                    score += "Love";
                    break;
                case FIFTEEN:
                    score += "Fifteen";
                    break;
                case THIRTY:
                    score += "Thirty";
                    break;
                case FORTY:
                    score += "Forty";
                    break;
            }
        }
        return score;
    }
    public static String checkEvenScore(int playerScore1){
        String score="";
        switch (playerScore1) {
            case LOVE:
                score = "Love-All";
                break;
            case FIFTEEN:
                score = "Fifteen-All";
                break;
            case THIRTY:
                score = "Thirty-All";
                break;
            case FORTY:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }

}
