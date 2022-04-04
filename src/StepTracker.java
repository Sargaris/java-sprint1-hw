import java.util.Scanner;

public class StepTracker {
      Scanner scanner = new Scanner(System.in);
      int[][] monthData = new int[12][30];
      int GoalOfSteps = 10000;

      Converter converter = new Converter();

      public int[][] saveSteps(){
         System.out.println("ВВедите Месяц");
         int month = scanner.nextInt();
         System.out.println("Введите день");
         int day = scanner.nextInt();
         System.out.println("Теперь введите количество ваших шагов");
         int steps = scanner.nextInt();

         monthData[month][day] = steps;
         return  monthData;
      }

      public void monthState(){
          double sum = 0;
          double max = 0;

          System.out.println("Ведите Месяц");
          int month = scanner.nextInt();

          for(int i = 0; i<=29 ; i++){
              System.out.print(i + " День: " + monthData[month][i]+", ");
          }

          System.out.println();

          for (int i = 0; i <= 29;i++){
              sum = sum + monthData[month][i];
          }
          System.out.println("Всего шагов пройдено: "+sum );


          for(int i = 0; i<=29 ; i++) {
              if (monthData[month][i] > max) {
                  max = monthData[month][i];
              }

          }

          System.out.println("Наибольшее число шагов за месяц: "+ max );


          double average = sum / 30;
          System.out.println("В среднем вы проходили: "+ average );

          converter.convertToCalory(sum);
          converter.convertToDistance(sum);

      }





      public int changeGoal(){
          System.out.println("Сейчас ваша цель составляет: "+GoalOfSteps);
          System.out.println("Хотите изменить текущую цель?");
          System.out.println("1.Да");
          System.out.println("2.Нет");
          int command = scanner.nextInt();
          if(command == 1){
              System.out.println("Какова ваша новая цель?");
              int goal = scanner.nextInt();
              GoalOfSteps = goal;
              System.out.println("Поздравляю, теперь ваша цель: " + GoalOfSteps);

          }else if(command == 2){
              System.out.println("Вы решили не менять цель по шагам. Ваша цель все еще: " + GoalOfSteps);
          }else{
              System.out.println(" К сожалению такой команды нет :-( ");
          }

          return GoalOfSteps;
      }





}