import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("式を入力してください: ");
            String expression = scanner.nextLine();
            
            String rpnExpression = ReversePolishNotationConverter.convertToRPN(expression);
            System.out.println("逆ポーランド記法: " + rpnExpression);
            
            double result = ReversePolishNotationCalculator.evaluate(rpnExpression);
            System.out.println("計算結果: " + result);
        }
    }
}
