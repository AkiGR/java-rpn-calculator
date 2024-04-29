import java.util.Stack;

/**
 * 逆ポーランド記法への変換を行うクラス。
 */
public class ReversePolishNotationConverter {

    /**
     * 中置記法の式を逆ポーランド記法に変換するメソッド。
     * 
     * @param expression 変換する中置記法の式
     * @return 変換された逆ポーランド記法の式
     */
    public static String convertToRPN(String expression) {
        StringBuilder rpn = new StringBuilder(); // 逆ポーランド記法の式を構築するための StringBuilder
        Stack<Character> operatorStack = new Stack<>(); // 演算子を一時的に保持するスタック

        // 式の各文字に対して処理を行うループ
        for (char token : expression.toCharArray()) {
            // 文字が数字である場合、そのまま出力に追加
            if (Character.isDigit(token)) {
                rpn.append(token);
            } else if (Utils.isOperator(token)) { // 文字が演算子である場合
                // スタックが空でなく、かつスタックの一番上の演算子の優先度が現在の演算子より高い場合、スタックの演算子を出力に追加
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(token)) {
                    rpn.append(operatorStack.pop());
                }
                // 現在の演算子をスタックに追加
                operatorStack.push(token);
            }
        }

        // スタックに残っている演算子を出力に追加
        while (!operatorStack.isEmpty()) {
            rpn.append(operatorStack.pop());
        }

        // 逆ポーランド記法の式を文字列として返す
        return rpn.toString();
    }

    /**
     * 演算子の優先度を返すメソッド。
     * 
     * @param operator 優先度を調べる演算子
     * @return 演算子の優先度
     */
    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1; // 足し算と引き算の優先度は最低
            case '*':
            case '/':
                return 2; // 掛け算と割り算の優先度は高い
            default:
                return 0; // 演算子でない場合は優先度を 0 として扱う
        }
    }
}
