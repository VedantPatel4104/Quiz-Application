import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    private ArrayList<Question> questions = new ArrayList<>();
    private int score = 0;
    private Scanner scanner = new Scanner(System.in);

    public void loadQuestions() {
        questions.add(new Question("What is the default value of int in Java?",
                new String[]{"0", "null", "undefined", "1"}, 1));
        questions.add(new Question("Which keyword is used to inherit a class in Java?",
                new String[]{"this", "super", "extends", "implements"}, 3));
        questions.add(new Question("Which of these is not a Java access modifier?",
                new String[]{"public", "private", "protected", "friendly"}, 4));
    }

    public void start() {
        for (Question q : questions) {
            q.display();
            System.out.print("Your answer (1-4): ");
            int answer = scanner.nextInt();
            if (q.isCorrect(answer)) {
                score++;
                System.out.println("✅ Correct!");
            } else {
                System.out.println("❌ Wrong!");
            }
        }
        System.out.println("\n🏁 Quiz Complete! Your score: " + score + "/" + questions.size() + "\n");
    }
}
