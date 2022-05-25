import java.util.Scanner;
import java.util.ArrayList;

class Main {

    public static void DisplayMenu() {
        System.out.println("What do you want to do?");
        System.out.println("1. Take Quiz");
        System.out.println("2. View Results");
        System.out.println("3. I'm done now!");
    }

    public static void DisplayLesson() {
        System.out.println("Which Lesson Do You want to take?");
        System.out.println("1. Web Development");
        System.out.println("2. Programing Principles");
        System.out.println("3. Never mind, I want to take quiz later"); // to go back to previous menu

    }

    public static Results takeTest(Question[] questions, Scanner input) {
        int userScore = 0;
        String userName;
//        Ask Questions
        for (int x = 0; x < questions.length; x++) {
            boolean wrongInput = false;
            String userAnswer = "";

            do {
                System.out.println(questions[x].lessonQuestion);
                System.out.println("What is your answer?: ");
                userAnswer = input.nextLine();

                if (userAnswer.length() == 1) { // if they accidentally put double A or etc. error handling
                    if (userAnswer.toUpperCase().equals(questions[x].lessonAnswer)) { // .toUppercase is used just in case user put lower case
                        userScore++;
                    }
                    wrongInput = false;
                } else {
                    System.out.println("Please just input one character!");
                    wrongInput = true;
                }
            } while (wrongInput);

        }
//        Get Name
        System.out.print("Please Enter Your Name:");
        userName = input.nextLine(); // to get user name
//        Get Date
        java.util.Date date = new java.util.Date(); // to get current date

//        Save Test Results
        Results testResult = new Results(userName, date, userScore); //this stores only 1`result


        //        Print Score for user
        testResult.DisplayResults();

        return testResult;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean inMenu = true;
        ArrayList<Results> listResults = new ArrayList<>();
        while (inMenu) {
            DisplayMenu();
            int userInput = input.nextInt();
            switch (userInput) {
                case (1):
                    DisplayLesson();
                    userInput = input.nextInt();
                    input.nextLine();
                    switch (userInput) {
                        case (1):
                            Question[] questions = {
                                    new Question("Which one of these is not a data type?\n" +
                                            "A) Boolean\n" +
                                            "B) String\n" +
                                            "C) Int\n" +
                                            "D) Number\n", "D"),
                                    new Question("Choose the appropriate data type for 5.5\n" +
                                            "A) Int\n" +
                                            "B) String\n" +
                                            "C) Double\n" +
                                            "D) Long\n", "C"),
                                    new Question("A Class is?\n" +
                                            "A) An Object\n" +
                                            "B) An executable piece of code\n" +
                                            "C) An abstract definition of an object\n" +
                                            "D) A variable\n", "C"),
                                    new Question("Which is not a part of defining an object?\n" +
                                            "A) Method\n" +
                                            "B) Description\n" +
                                            "C) Association with other objects\n" +
                                            "D) Name\n", "B"),
                                    new Question("Given the declaration :int [] ar = {1,2,3,4,5]; What is the value of ar[4]?\n" +
                                            "A) 2\n" +
                                            "B) 3\n" +
                                            "C) 4\n" +
                                            "D) 5\n", "D"),
                            };

                            listResults.add(takeTest(questions, input));
                            break;

                        case (2):
                            questions = new Question[]{
                                    new Question("What does HTML stand for?\n" +
                                            "A) Hyper Text Mark up Language\n" +
                                            "B) Hot Mail\n" +
                                            "C) How to make Laksa\n" +
                                            "D) I don't know\n", "A"),
                                    new Question("<body> is opening or closing tag?\n" +
                                            "A) Closing\n" +
                                            "B) Opening\n" +
                                            "C) I don't know\n" +
                                            "D) Both\n", "B"),
                                    new Question("</body> is opening or closing tag?\n" +
                                            "A) Opening\n" +
                                            "B) Closing\n" +
                                            "C) Both\n" +
                                            "D) I don't know\n", "B"),
                                    new Question("<br> is what type of tag?\n" +
                                            "A) Broken\n" +
                                            "B) Description\n" +
                                            "C) Association with other objects\n" +
                                            "D) Line Break\n", "D"),
                                    new Question("What should values always be closed in?\n" +
                                            "A) Parentheses\n" +
                                            "B) Commas\n" +
                                            "C) Quotation Mark\n" +
                                            "D) Bracket\n", "C"),
                            };

                            listResults.add(takeTest(questions, input));
                            break;
                        case (3):
                            // go back to previous menu
                            break;
                        default:
                            System.out.println("Option is not valid, please select lesson again!");

                    }
                    break;
                case (2):
                    if (listResults.size() != 0) { //truthy
                        input.nextLine();
                        System.out.print("What is Your Name?: ");
                        String userName = input.nextLine();

                        boolean nameExist = false;
                        for (int i = 0; i < listResults.size(); i++) {
                            if (userName.equalsIgnoreCase(listResults.get(i).getUserName())) {
                                listResults.get(i).DisplayResults();
                                nameExist = true;
                            }
                        }
                        if (nameExist == false) {
                            System.out.println("Name not Found!");
                        }


                    } else {//falsy
                        System.out.println("No Results Just Yet");
                    }
                    break;
                case (3):
                    inMenu = false;
                    System.out.println("Thank You for using this program!");
                    break;
                default:
                    System.out.println("Option is not valid, Please select again!");

            }
        }
    }
}
