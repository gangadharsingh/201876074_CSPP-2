import java.util.Scanner;
import java.util.Arrays;
/**
 * Solution class for code-eval.
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
     * @param      quiz           The quiz object
     * @param      questionCount  The question count
     */
    public static void loadQuestions(final Scanner s, Quiz q, final int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        String questset = "";
        for (int i = 0; i < questionCount; i++) {
            questset += s.nextLine();
            questset += ":";
        }
       String[] tokens = questset.split(":");
       q = new Quiz(tokens[0], tokens[1].split(","), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]));
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
            System.out.println(quiz.getquestiontext());
            System.out.println(quiz.printchoice());
        }
        int userans = 0;
        String[] userchoice = new String[answerCount];
        for (int i = 0; i < answerCount; i++) {
            String inp = s.nextLine();
            if (inp != null) {
                userchoice[userans++] += s.nextLine();
                }
            }
        /*if (userans > 1) {
            for (String a: userchoice) {
                if (quiz.getchoice()) {
                    
                }
            }
        }*/
    }

    /**
     * Displays the score report
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
        System.out.println();
    }
}
class Quiz {
    private String questtext;
    private String[] choice;
    String userchoice = "";
    private int correctans;
    private int maxmark;
    private int penalty;
    Quiz(){

    }
    Quiz(final String qustxt, String[] chc, int corctans, int mm, int pnlty) {
        questtext = qustxt;
        choice = chc;
        correctans = corctans;
        maxmark = mm;
        penalty = pnlty;
    }
     public int getmaxmark(){
      return maxmark;
     }
     
     public void setmaxmark(int mm){
        maxmark = mm;
     }
      public int getpenalty(){
       return penalty;
      }
      
      public void setpenalty(int pnlty){
       penalty = pnlty;
      }

      public String getquestiontext(){
       return questtext;
      }
      
      public void setquestiontxt(String questxt){
       questtext = questxt;
      }

      public String[] getchoice(){
        return choice;
      }
      
      public void setchoice(String chc){
       userchoice= chc;
      }

      public int getcorrectans(){
      return correctans;
     }
     
     public void setcorrectans(int corans){
        correctans = corans;
     }
     public String printchoice() {
        return (choice[0]+"        "+choice[1]+"        "+choice[2]+"        "+choice[3]);
     }
}