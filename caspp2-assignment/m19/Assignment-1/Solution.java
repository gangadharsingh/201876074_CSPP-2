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
    public static Quiz[] quizset = new Quiz[20];
    public static int quizsetsize = 0;
    /**
     * Loads questions.
     *
     * @param      s              The scanner object for user input
     * @param      q              The quarter
     * @param      questionCount  The question count
     * @param      quiz  The quiz object
     */
    static void loadQuestions(final Scanner s, Quiz q, final int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        String questset = "";
        for (int i = 0; i < questionCount; i++) {
            questset += s.nextLine();
            /*            questset += ":";
            */
        }
        String[] tokens = questset.split(":");
        int x = Integer.parseInt(tokens[4]);
        int  choiceno = tokens[1].split(",").length;
        if (tokens[0].length() < 1) {
            System.out.println("Error! Malformed question");
            quizsetsize = 0;
            return;
        } else if ((Integer.parseInt(tokens[3])) > choiceno) {
            System.out.println("Error! Correct answer choice number is out of range for " + tokens[0]);
            quizsetsize = 0;
            return;
        } else if (x > 0) {
            System.out.println("Invalid penalty for " + tokens[0]);
            quizsetsize = 0;
            return;
        } else if (Integer.parseInt(tokens[3]) < 0) {
            System.out.println("Invalid max marks for " + tokens[0]);
            quizsetsize = 0;
            return;
        } else if (choiceno < 2) {
            System.out.println(tokens[0] + " does not have enough answer choices");
            quizsetsize = 0;
            return;
        } else {
            for (int i = 0; i < questionCount; i++) {
                q = new Quiz(tokens[0], tokens[1].split(","), Integer.parseInt(
                                 tokens[2]), Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]));
                quizset[quizsetsize++] = q;
            }
            System.out.println(questionCount + " are added to the quiz");
        }
    }

    public static String[] useresponse = new String[100];
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
        if (quizsetsize != 0) {
            for (int i = 0; i < quizsetsize; i++) {
                System.out.println(quizset[i].getquestiontext() + "(" + answerCount + ")");
                String str = "";
                for (int j = 0; j < quizset[i].getchoice().length - 1; j++) {
                    str += quizset[i].getchoice()[j] + "\t";
                }
                str += quizset[i].getchoice()[quizset[i].getchoice().length - 1];
                System.out.println(str + "\n");
            }
            if (answerCount == 1) {
                useresponse[0] = s.nextLine();
            } else {
                for (int j = 0; j < answerCount; j++) {
                    useresponse[j] = s.nextLine();
                }
            }
        }
    }

    /**
     * Displays the score report
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
        if (quizsetsize != 0) {
            int totalscore = 0;
            for (int i = 0; i < quizsetsize; i++) {
                System.out.println(quizset[i].getquestiontext());
                for (int j = 0; j < quizset[i].getchoice().length - 1; j++) {
                    if (quizset[i].getchoice()[j].equals(useresponse[j])) {
                        System.out.println(" Correct Answer! - Marks Awarded: " + quizset[i].getmaxmark());
                        totalscore += quizset[i].getmaxmark();
                    } else {
                        System.out.println("Wrong Answer! - Penalty: " + quizset[i].getpenalty());
                        totalscore += quizset[i].getpenalty();
                    }
                }
            }
            System.out.println("Total Score: " + totalscore);
        }
    }
}
/**
 * Class for quiz.
 */
class Quiz {
    private String questtext;
    private String[] choice;
    private int correctans;
    private int maxmark;
    private int penalty;
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