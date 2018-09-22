import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
/**
  * write your code below this comment
  */
class Task {
	private String title;
	private String assignedTo;
	private int timeToComplete;
	private boolean important;
	private boolean urgent;
	private String status;
	Task() {
	}
	/**
	 * Constructs the object.
	 *
	 * @param      ttle          The ttle
	 * @param      asgnTo        The asgn to
	 * @param      tmToComplete  The time to complete
	 * @param      imp           The imp
	 * @param      urg           The urg
	 * @param      stat          The stat
	 */
	Task(String ttle, String asgnTo,
	     int tmToComplete, boolean imp,
	     boolean urg, String stat) {
		if (ttle.length() != 0) {
			title = ttle;
		} else {
			System.out.println("Title not provided"); return;
		}
		assignedTo = asgnTo;
		if (tmToComplete < 0) {
			System.out.println("Invalid timeToComplete " + tmToComplete);
			return;
		} else {
			timeToComplete = tmToComplete;
		}
		important = imp;
		urgent = urg;
		if (stat.equals("todo") || stat.equals("done")) {
			status = stat;
		} else {
			System.out.println("Invalid status " + stat);
			return;
		}
	}
	/**
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public String gettitle() {
		return title;
	}
	/**
	 * { function_description }
	 *
	 * @param      ttle  The ttle
	 */
	public void settitle(String ttle) {
		title = ttle;
	}

	/**
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public String getassignedTo() {
		return title;
	}
	/**
	 * { function_description }
	 *
	 * @param      assgnTo  The assgn to
	 */
	public void setassignedTo(String assgnTo) {
		assignedTo = assgnTo;
	}

	/**
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int getimeToComplete() {
		return timeToComplete;
	}
	/**
	 * { function_description }
	 *
	 * @param      tmToComplete  The time to complete
	 */
	public void setimeToComplete(int tmToComplete) {
		timeToComplete = tmToComplete;
	}

	/**
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public boolean getimportant() {
		return important;
	}
	/**
	 * { function_description }
	 *
	 * @param      imp   The imp
	 */
	public void setimportant(boolean imp) {
		important = imp;
	}

	/**
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public boolean geturgent() {
		return urgent;
	}
	/**
	 * { function_description }
	 *
	 * @param      urg   The urg
	 */
	public void seturgent(boolean urg) {
		urgent = urg;
	}

	/**
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public String getstatus() {
		return status;
	}

	/**
	 * { function_description }
	 *
	 * @param      stat  The stat
	 */
	public void setstatus(String stat) {
		status = stat;
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		String str = "";
		if (title == null && timeToComplete < 0) {
			return "wrong";
		} else {
			str += title + ", " + assignedTo + ", ";
			str	+= timeToComplete + ", ";
		}
		if (important) {
			str	+= "Important";
		} else {
			str += "Not Important";
		}
		str += ", ";
		if (urgent) {
			str	+= "Urgent";
		} else {
			str += "Not Urgent";
		}
		if (status.equals("todo") || status.equals("done")) {
			str	+= ", " + status;
		} else {
			return "wrong";
		}
		return str;
	}
}
/**
 * Class for todoist.
 */
class Todoist {
	private Task[] taskset;
	private int tasksize;
	/*
	 * Map <String, Task> = new HashMap<String, Task> ();
	 */
	Todoist() {
		taskset = new Task[20];
		tasksize = 0;
	}
	/**
	 * Adds a task.
	 *
	 * @param      task  The task
	 */
	void addTask(Task task) {
		if (taskset.length == tasksize + 1) {
			resize();
		}
		taskset[tasksize++] = task;
	}
	/**
	 * { function_description }
	 */
	void resize() {
		taskset = Arrays.copyOf(taskset, taskset.length * 2);
	}
	/**
	 * Gets the next task.
	 *
	 * @param      personame  The personame
	 *
	 * @return     The next task.
	 */
	public Task getNextTask(String personame) {
		for (int i = 0; i < tasksize; i++) {
			if (taskset[i].getassignedTo() == personame) {
				if (taskset[i].getstatus() == "todo")
					if (taskset[i].getimportant())
						if (taskset[i].geturgent()) {
							return taskset[i];
						}
			}
		}
		return null;
	}
	/**
	 * Gets the next task.
	 *
	 * @param      personame  The personame
	 * @param      t          { parameter_description }
	 *
	 * @return     The next task.
	 */
	public Task getNextTask(String personame, int t) {

		return null;
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		String str = "";
		for (int i = 0; i < tasksize; i++) {
			str += taskset[i] + "\n";
		}
		return str;
	}
	/**
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int totalTime4Completion() {
		int time = 0;
		for (int i = 0; i < tasksize; i++) {
			if (taskset[i].getstatus() == "todo") {
				time += taskset[i].getimeToComplete();
			}
		}
		return time;
	}
}
/**
 * Class for todoist main.
 */
public class TodoistMain {

	/**
	 * Starts a test.
	 */
	public static void startTest() {
		Todoist todo = new Todoist();
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			String[] tokens = s.nextLine().split(",");
			switch (tokens[0]) {
			case "task":
				testTask(tokens);
				break;
			case "add-task":
				testAddTask(todo, tokens);
				break;
			case "print-todoist":
				if (todo.toString() != "wrong") {
					System.out.println(todo);
				} else {
					break;
				}
				break;
			case "get-next":
				System.out.println(todo.getNextTask(tokens[1]));
				break;
			/*case "get-next-n":
			    int n = Integer.parseInt(tokens[2]);
			    Task[] tasks = todo.getNextTask(tokens[1], n);
			    System.out.println(Arrays.deepToString(tasks));
			break;*/
			case "total-time":
			    System.out.println(todo.totalTime4Completion());
			break;
			default:
				break;
			}
		}
	}

	/**
	 * method to test add task.
	 *
	 * @param      todo    The todo
	 * @param      tokens  The tokens
	 */
	public static void testAddTask(final Todoist todo, final String[] tokens) {
		try {
			todo.addTask(createTask(tokens));
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * method to test the creation of task object.
	 *
	 * @param      tokens  The tokens
	 */
	public static void testTask(final String[] tokens) {
		try {
			System.out.println(createTask(tokens));
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * Creates a task object.
	 *
	 * @param      tokens     The tokens
	 *
	 * @return     Task object
	 *
	 * @throws     Exception  if task inputs are invalid
	 */
	public static Task createTask(final String[] tokens) throws Exception {
		String title = tokens[1];
		String assignedTo = tokens[2];
		int timeToComplete = Integer.parseInt(tokens[3]);
		boolean important = tokens[4].equals("y");
		boolean urgent = tokens[5].equals("y");
		String status = tokens[6];
		return new Task(
		           title, assignedTo, timeToComplete, important, urgent, status);
	}

	/**
	 * main method.
	 *
	 * @param      args  The command line arguments
	 */
	public static void main(final String[] args) {
		startTest();
	}
}
