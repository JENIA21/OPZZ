import java.util.Scanner;

import static jdk.nashorn.internal.objects.Global.Infinity;
public class Main {
    static CalculatorInterf i = new Calculator();

    private static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Введите ваше выражение");
        String input = scan.nextLine();
        if (i.сheck(input) == 0 ) {
            if (i.calculator(i.translate(input)) != Infinity) {
                System.out.println(i.translate(input));
                System.out.println("Ответ: " + i.calculator(i.translate(input)));
            }
            else {
                System.out.println("Вы пытаетесь поделить на ноль");
            }
        } else {
            System.out.println("Вы ввели некорректные данные, повторите попытку");
        }
    }
}







