import java.util.Scanner;

public class StepTracker {
      Scanner scanner = new Scanner(System.in);
      int[][] monthData = new int[12][30];
      int GoalOfSteps = 10000;
      double sum = 0;
      int max = 0;
      int bestSequence = 0;

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

      public void monthState() {


          System.out.println("Ведите Месяц");
          int month = scanner.nextInt();

          for (int i = 0; i <= 29; i++) {
              System.out.print(i + " День: " + monthData[month][i] + ", ");
          }

          System.out.println();

          sumOfSteps(month);
          averageSteps();
          maxSteps(month);
          bestSequenceFinder(month,GoalOfSteps);

          converter.convertToCalory(sum);
          converter.convertToDistance(sum);

          System.out.println();

      }


      public int maxSteps(int month){
          for (int i = 0; i <= 29; i++) {
              if (monthData[month][i] > max) {
                  max = monthData[month][i];
              }
          }
          System.out.println("Наибольшее число шагов за месяц: " + max);

          return max;
      }


      public double averageSteps(){
          double average = sum / 30;
          System.out.println("В среднем вы проходили: " + average);
          return average;
      }


      public double sumOfSteps(int month){
          for (int i = 0; i <= 29; i++) {
          sum = sum + monthData[month][i];
      }
          System.out.println("Всего шагов пройдено: " + sum);
          return  sum;
      }

      public int bestSequenceFinder(int month, int GoalOfSteps){
          int counter = 0;
          int bestSequence = 0;

          for(int i = 0; i <= 29;i++){
              if(monthData[month][i] >= GoalOfSteps){
                  counter++;
                  if(counter>bestSequence){
                      bestSequence = counter;
                  }
              }else{
                  counter = 0;
              }
          }
          System.out.println("Лучшая серия составила: " + bestSequence + " дней!!!");
          return bestSequence;
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