import java.util.Arrays;
/**
 * Class for quiz.
 */
class Quiz {
    /**
     * { initializing a variable }.
     */
    private final int onehundred = 100;
    /**
     * { initializing a variable }.
     */
    private Question[] questions;
    /**
     * { initializing a variable }.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Quiz() {
        questions = new Question[10];
        size = 0;
    }
    /**
     * Adds a question.
     *
     * @param      q     The question
     */
    public void addQuestion(final Question q) {
        questions[size++] = q;
    }
    /**
     * Gets the question.
     *
     * @param      index  The index
     *
     * @return     The question.
     */
    public Question getQuestion(final int index) {
        return questions[index];
    }

    public Question[] getQuestions() {
        // System.out.println(Arrays.toString(Arrays.copyOf(questions, size)));
        return Arrays.copyOf(questions, size);
    }
    /**
     * Shows the report.
     *
     * @return     { description_of_the_return_value }
     */
    public String showReport() {
        String s = "";
        int marks = 0;

        for (Question question : getQuestions()) {
            s += question.getquestiontxt() + '\n' + ' ';
            if (question.evaluateResponse(question.getResponse())) {
                s += "Correct Answer! " + '-' + " Marks Awarded: "
                + question.getMaxmark();
                marks += question.getMaxmark();
            } else {
                s += "Wrong Answer! " + '-' + " Penalty: "
                + question.getPenalty();
                marks += question.getPenalty();
            }
            s += '\n';
        }
        s += "Total Score: " + marks;
        return s;
    }

}