import java.util.Scanner;

public class StepTracker {
      Scanner scanner = new Scanner(System.in);
      int[][] monthData = new int[12][30];
      int goalOfSteps = 10000;
      int max = 0;


      Converter converter = new Converter();

      public int[][] saveSteps(){
          int day = 0;
          int month = 0;
          int steps = 0;

          while(true) {
              System.out.println("ВВедите Месяц");

              int monthIncert = scanner.nextInt();
              if (monthIncert < 0 | monthIncert > 11) {
                  System.out.println("Введите месяц от 0 до 11");
              } else {
                  month = monthIncert;
                  break;
              }
          }
         while (true){
         System.out.println("Введите день");

         int dayIncert = scanner.nextInt();

          if(dayIncert<0 | dayIncert > 29){
              System.out.println("Введите день от 0 до 29");
          }else{
              day = dayIncert;
              break;
          }
          }
         while (true) {
             System.out.println("Теперь введите количество ваших шагов");

             int stepsIncert = scanner.nextInt();
             if (stepsIncert < 0) {
                 System.out.println("Ввведенная цель должнабыть положительной!!!");
             } else {
                 steps = stepsIncert;
                 break;
             }

         }
         monthData[month][day] = steps;
         return  monthData;
      }

      public void monthState() {
          int month = 0;

          while(true) {
              System.out.println("Ведите Месяц");
              int monthIncert = scanner.nextInt();
              if(monthIncert < 0 | monthIncert > 11){
                  System.out.println("Введите месяц от 0 до 11");
              }else{
                  for (int i = 0; i <= 29; i++) {
                  System.out.print(i + " День: " + monthData[month][i] + ", ");
                  }break;
              }
          }
          System.out.println();

          sumOfSteps(month);
          averageSteps(month);
          maxSteps(month);
          bestSequenceFinder(month,goalOfSteps);

          converter.convertToCalory(sumOfSteps(month));
          converter.convertToDistance(sumOfSteps(month));

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


      public double averageSteps(int month){
          ;
          double average = sumOfSteps(month)/ 30;
          System.out.println("В среднем вы проходили: " + average);
          return average;
      }


      public double sumOfSteps(int month){
          double sum = 0;
          for (int i = 0; i <= 29; i++) {
          sum = sum + monthData[month][i];
      }
          System.out.println("Всего шагов пройдено: " + sum);
          return  sum;
      }

      public int bestSequenceFinder(int month, int goalOfSteps){
          int counter = 0;
          int bestSequence = 0;

          for(int i = 0; i <= 29;i++){
              if(monthData[month][i] >= goalOfSteps){
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
          System.out.println("Сейчас ваша цель составляет: "+goalOfSteps);
          System.out.println("Хотите изменить текущую цель?");
          System.out.println("1.Да");
          System.out.println("2.Нет");
          int command = scanner.nextInt();
          if(command == 1){
              while (true) {
                  System.out.println("Какова ваша новая цель?");
                  int goal = scanner.nextInt();
                  if (goal < 0) {
                      System.out.println("Ввведенная цель должнабыть положительной!!!");
                  } else {
                      goalOfSteps = goal;
                      System.out.println("Поздравляю, теперь ваша цель: " + goalOfSteps);
                      break;
                  }
              }
          }else if(command == 2){
              System.out.println("Вы решили не менять цель по шагам. Ваша цель все еще: " + goalOfSteps);
          }else{
              System.out.println(" К сожалению такой команды нет :-( ");
          }

          return goalOfSteps;
      }





}