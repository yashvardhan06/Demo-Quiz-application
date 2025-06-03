import java.util.*;

class Question {
    String question;
    List<String> options;
    int correctAnswer;

    public Question(String question, List<String> options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}

public class QuizApplication {
    private static final List<Question> QUESTIONS = Arrays.asList(
        new Question("What is the capital of France?", Arrays.asList("Berlin", "Madrid", "Paris", "Rome"), 3),
        new Question("What is 2 + 2?", Arrays.asList("3", "4", "5", "6"), 2),
        new Question("What is the largest planet?", Arrays.asList("Earth", "Mars", "Jupiter", "Saturn"), 3)
    );
    private static final int TIME_LIMIT_SECONDS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (Question question : QUESTIONS) {
            System.out.println(question.question);
            for (int i = 0; i < question.options.size(); i++) {
                System.out.println((i + 1) + ". " + question.options.get(i));
            }

            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\nTime is up!");
                    System.exit(0);
                }
            };
            timer.schedule(task, TIME_LIMIT_SECONDS * 1000);

            int userAnswer = scanner.nextInt();
            timer.cancel();

            if (userAnswer == question.correctAnswer) {
                score++;
            }
        }

        System.out.println("Your final score is: " + score);
    }
}
