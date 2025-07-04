import java.util.ArrayList;
import java.util.Scanner;

class Question {
    private String questionText;
    private String[] options;
    private int correctOption;

    public Question(String questionText, String[] options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public void display() {
        System.out.println("\n" + questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    public boolean isCorrect(int userAnswer) {
        return userAnswer == correctOption;
    }
}

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
        questions.add(new Question("What is the size of an int variable in Java?",
                new String[]{"8-bit", "16-bit", "32-bit", "64-bit"}, 3));
        questions.add(new Question("Which method is the entry point for a Java application?",
                new String[]{"start()", "init()", "main()", "run()"}, 3));
        questions.add(new Question("What is the output of: System.out.println(10 + 20 + \"30\")?",
                new String[]{"1030", "102030", "3030", "30"}, 1));
        questions.add(new Question("Which interface provides capability to store objects using key-value pairs?",
                new String[]{"List", "Map", "Set", "Collection"}, 2));
        questions.add(new Question("What will happen if you try to add duplicate keys in a HashMap?",
                new String[]{"Compile error", "Runtime error", "Overwrite value", "Add both keys"}, 3));
        questions.add(new Question("What is the superclass of all classes in Java?",
                new String[]{"Object", "Class", "Main", "Super"}, 1));
        questions.add(new Question("Which exception is thrown when dividing by zero in Java?",
                new String[]{"NullPointerException", "ArithmeticException", "NumberFormatException", "IOException"}, 2));
        questions.add(new Question("Which collection does not allow duplicates?",
                new String[]{"List", "Set", "Queue", "ArrayList"}, 2));
        questions.add(new Question("Which operator is used for object comparison in Java?",
                new String[]{"==", "=", "equals()", "!=="}, 3));
        questions.add(new Question("Which Java keyword is used to define a constant?",
                new String[]{"static", "final", "const", "define"}, 2));
        questions.add(new Question("Which of the following is not a primitive type?",
                new String[]{"int", "float", "String", "char"}, 3));
        questions.add(new Question("Which package contains Scanner class?",
                new String[]{"java.io", "java.util", "java.lang", "java.net"}, 2));
        questions.add(new Question("What is method overloading?",
                new String[]{"Same method name with different return types", "Same method name with different parameters", "Same method name in different classes", "Different method names with same logic"}, 2));
        questions.add(new Question("Which keyword prevents inheritance?",
                new String[]{"static", "final", "private", "abstract"}, 2));
        questions.add(new Question("What is the result of: 3 + 4 * 2?",
                new String[]{"14", "11", "10", "9"}, 2));
        questions.add(new Question("Which is used to handle exceptions?",
                new String[]{"catch", "try", "throw", "All of the above"}, 4));
        questions.add(new Question("Which keyword is used to define an abstract class?",
                new String[]{"interface", "abstract", "extends", "implements"}, 2));
        questions.add(new Question("Which loop is guaranteed to execute at least once?",
                new String[]{"for", "while", "do-while", "foreach"}, 3));
        questions.add(new Question("What does JVM stand for?",
                new String[]{"Java Virtual Machine", "Java Variable Machine", "Java Visual Machine", "Java Verified Machine"}, 1));
        questions.add(new Question("Which statement is used to exit a loop prematurely?",
                new String[]{"return", "break", "exit", "stop"}, 2));
        questions.add(new Question("Which data type would you use for true/false values?",
                new String[]{"int", "bit", "boolean", "char"}, 3));
        questions.add(new Question("Which modifier is used for method overriding?",
                new String[]{"override", "overload", "@Override", "virtual"}, 3));
    }

    public void start() {
        for (Question q : questions) {
            q.display();
            System.out.print("Your answer (1-4): ");
            int answer = getValidAnswer();
            if (q.isCorrect(answer)) {
                score++;
                System.out.println("✅ Correct!");
            } else {
                System.out.println("❌ Wrong!");
            }
        }
        System.out.println("\n🏁 Quiz Complete! Your score: " + score + "/" + questions.size() + "\n");
    }

    private int getValidAnswer() {
        while (true) {
            try {
                int answer = Integer.parseInt(scanner.nextLine());
                if (answer >= 1 && answer <= 4) {
                    return answer;
                }
                System.out.print("Please enter a number between 1 and 4: ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a number (1-4): ");
            }
        }
    }

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.loadQuestions();
        quiz.start();
    }
}
