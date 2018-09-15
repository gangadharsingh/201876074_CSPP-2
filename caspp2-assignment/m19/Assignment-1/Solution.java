import java.util.Scanner;
import java.util.Arrays;
/**
 * Solution class for code-eval.
 * @author: gangadharsingh.
 */
public final class Solution {
    /**
    * Constructs the object.
    */
    private Solution() {
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this Quiz
        Quiz q = new Quiz();
        // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
            case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
                break;
            case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
            case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
                break;
            default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      s              The scanner object for user input
     * @param      q              The quarter
     * @param      questionCount  The question count
     * @param      quiz  The quiz object
     */
    public static void loadQuestions(final Scanner s, Quiz q, final int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        Quiz[] quizset = new Quiz[20];
        int quizsetsize = 0;
        String questset = "";
        for (int i = 0; i < questionCount; i++) {
            questset += s.nextLine();
/*            questset += ":";
*/        }
        String[] tokens = questset.split(":");
        if (tokens[0].length() < 1) {
            System.out.println("Error! Malformed question");
            return;
        } else if (Integer.parseInt(tokens[4]) > 0) {
        for (int i = 0; i < questionCount; i++) {
            quizset[i] = new Quiz(tokens[0], tokens[1].split(","), Integer.parseInt(
                                      tokens[2]), Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]));
            quizsetsize++;
        }
        System.out.println(Integer.parseInt(tokens[4])+"Integer.parseInt(tokens[4])");
        System.out.println(questionCount + " are added to the quiz");
        } else {
            System.out.println("Invalid penalty for "+tokens[0]);
        }

    }

    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s, final Quiz quiz, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object

        for (int j = 0; j < answerCount; j++) {
/*            System.out.println(quiz.getquiz());
*/        }
        int userans = 0;
        String[] userchoice = new String[answerCount];
       /* for (int i = 0; i < answerCount; i++) {
            String inp = s.nextLine();
            if (inp != null) {
                userchoice[userans++] += s.nextLine();
            }
        }*/
        if (answerCount == 1) {
            return;
        }
        return;
    }

    /**
     * Displays the score report
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
        if (quiz.getquiz().length < 1) {
            return;
        }
    }
}
/**
 * Class for quiz.
 */
class Quiz {
    private String questtext;
    private String[] choice;
    String userchoice = "";
    private int correctans;
    private int maxmark;
    private int penalty;
    String[] quiz = new String[20];
    int quizsize = 0;
    /**
     * Constructs the object.
     */
    Quiz() {
    }
    /**
     * Constructs the object.
     *
     * @param      qustxt    The qustxt.
     * @param      chc       The chc.
     * @param      corctans  The corctans.
     * @param      mm        The millimeters.
     * @param      pnlty     The pnlty.
     */
    Quiz(final String qustxt, String[] chc, int corctans, int mm, int pnlty) {
        questtext = qustxt;
        choice = chc;
        correctans = corctans;
        maxmark = mm;
        penalty = pnlty;
        quiz[quizsize++] = qustxt + chc + corctans + mm + pnlty;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String[] getquiz() {
        return quiz;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int getmaxmark() {
        return maxmark;
    }

    /**
     * { function_description }
     *
     * @param      mm    The millimeters
     */
    public void setmaxmark(int mm) {
        maxmark = mm;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int getpenalty() {
        return penalty;
    }

    /**
     * { function_description }
     *
     * @param      pnlty  The pnlty
     */
    public void setpenalty(int pnlty) {
        penalty = pnlty;
    }

    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String getquestiontext() {
        return questtext;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String[] getchoice() {
        return choice;
    }

    /**
     * { function_description }
     *
     * @param      chc   The chc
     */
    public void setchoice(String chc) {
        userchoice = chc;
    }

    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int getcorrectans() {
        return correctans;
    }

    /**
     * { function_description }
     *
     * @param      corans  The corans
     */
    public void setcorrectans(int corans) {
        correctans = corans;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String printchoice() {
        return (choice[0] + "        " + choice[1] + "        " + choice[2] + "        " + choice[3]);
    }
}