public class Converter {

    double step = 0.75;
    double calory = 50;


    void convertToDistance(double allStep){
        double meters = allStep * step;
        double kilometers = meters / 1000;
        System.out.println("Вы прошли: " + kilometers + " км");
    }


    void convertToCalory(double allStep){

        double calories = allStep * calory;
        double kilocalories = calories/1000;

        System.out.println("Килокалорий сгорело: "+kilocalories);

    }
}
