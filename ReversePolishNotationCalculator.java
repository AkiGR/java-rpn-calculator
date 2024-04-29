import java.util.Stack;

/**
 * 逆ポーランド記法で与えられた式を評価するクラス。
 */
public class ReversePolishNotationCalculator {

    /**
     * 逆ポーランド記法で与えられた式を評価し、結果を返すメソッド。
     * 
     * @param rpnExpression 評価する逆ポーランド記法の式
     * @return 式の評価結果
     */
    public static double evaluate(String rpnExpression) {
        Stack<Double> stack = new Stack<>(); // 数値を一時的に保持するスタック

        // 逆ポーランド記法の式の各トークンに対して処理を行うループ
        for (char token : rpnExpression.toCharArray()) {
            // トークンが数字である場合、そのままスタックにプッシュ
            if (Character.isDigit(token)) {
                stack.push((double) (token - '0'));
            } else if (Utils.isOperator(token)) { // トークンが演算子である場合
                double operand2 = stack.pop(); // スタックから2番目のオペランドを取り出す
                double operand1 = stack.pop(); // スタックから1番目のオペランドを取り出す
                double result = performOperation(operand1, operand2, token); // 演算を行い結果を計算
                stack.push(result); // 計算結果をスタックにプッシュ
            }
        }

        // 最終的な計算結果をスタックから取り出して返す
        return stack.pop();
    }

    /**
     * 指定された演算子で指定されたオペランドを使用して演算を行うメソッド。
     * 
     * @param operand1 第1オペランド
     * @param operand2 第2オペランド
     * @param operator 演算子
     * @return 演算結果
     * @throws ArithmeticException ゼロ除算が発生した場合
     */
    private static double performOperation(double operand1, double operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2; // 足し算
            case '-':
                return operand1 - operand2; // 引き算
            case '*':
                return operand1 * operand2; // 掛け算
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero"); // ゼロ除算の場合は例外をスロー
                }
                return operand1 / operand2; // 割り算
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator); // 無効な演算子の場合は例外をスロー
        }
    }
}
