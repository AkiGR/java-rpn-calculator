/**
 * 文字が演算子かどうかを判定するメソッド。
 * 
 * @param c 判定する文字
 * @return 演算子であれば true、そうでなければ false
 */
public class Utils {
    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}