/**
 * Class for question.
 */
class Question {
    /**
     * { initializing a variable }.
     */
    private String questiontxt;
    /**
     * { initializing a variable }.
     */
    private String[] choices;
    /**
     * { index of correct answer }.
     */
    private int correctansrind;
    /**
     * { initializing a variable }.
     */
    private int maxmark;
    /**
     * { initializing a variable }.
     */
    private int penalty;
    /**
     * { initializing a variable }.
     */
    private String response;
    /**
     * Constructs the object.
     */
    Question() {

    }
    /**
     * Constructs the object.
     *
     * @param      question1       The question 1
     * @param      choices1        The choices 1
     * @param      correctansrind1  The correct answer 1
     * @param      maxmark1       The maximum marks 1
     * @param      penalty1        The penalty 1
     */
    Question(final String question1, final String[] choices1,
             final int correctansrind1, final int maxmark1, final int penalty1) {
        this.questiontxt = question1;
        this.choices = choices1;
        this.correctansrind = correctansrind1;
        this.maxmark = maxmark1;
        this.penalty = penalty1;
        this.response = "";

    }
    /**
     * { function_description }.
     *
     * @param      choice  The choice
     *
     * @return     { description_of_the_return_value }
     */
    public boolean evaluateResponse(final String choice) {
        return getCorrectAnswer().equals(choice);
    }
    /**
     * Gets the correct answer.
     *
     * @return     The correct answer.
     */
    public String getCorrectAnswer() {
        return choices[correctansrind - 1];
    }
    /**
     * Gets the question text.
     *
     * @return     The question text.
     */
    public String getquestiontxt() {
        return questiontxt;
    }
    /**
     * Gets the choice.
     *
     * @return     The choice.
     */
    public String[] getChoice() {
        return choices;
    }
    /**
     * Gets the maximum marks.
     *
     * @return     The maximum marks.
     */
    public int getMaxmark() {
        return maxmark;
    }
    /**
     * Gets the penalty.
     *
     * @return     The penalty.
     */
    public int getPenalty() {
        return penalty;
    }
    /**
     * Sets the response.
     *
     * @param      answer  The answer
     */
    public void setResponse(final String answer) {
        this.response = answer;
    }
    /**
     * Gets the response.
     *
     * @return     The response.
     */
    public String getResponse() {
        return this.response;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        s += questiontxt + '(' + maxmark + ')' + '\n';
        for (String choice : choices) {
            s += choice + '\t';
        }
        s = s.trim() + '\n';
        return s;
    }
}