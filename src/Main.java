import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        StepTracker stepTracker = new StepTracker();


        while(true){
           printMenu();
           int command = scanner.nextInt();

           if (command  == 1){
               stepTracker.saveSteps();
           }else if (command == 2){
               stepTracker.monthState();
           }else if(command == 3){
               stepTracker.changeGoal();

           }else if (command == 4){
               System.out.println("Программа завершена");
               break;
           }else{
               System.out.println(" К сожалению такой команды нет :-( ");
           }
        }
        }


    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определенный день");
        System.out.println("2 - Напечатать статистику за определенный месяц");
        System.out.println("3 - изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из приложения");
    }
}