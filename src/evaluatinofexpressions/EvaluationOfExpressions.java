package evaluatinofexpressions;
import java.util.Stack;

/**
 *
 * @author The Genius
 */
public class EvaluationOfExpressions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        if(args.length != 1){
            System.out.println("USAGE: java EvaluateExpression \"Expressions\"");
            System.exit(1);
        }
        try {
            
        } catch(Exception ex){
            System.out.println("Wrong Expressions: " + args[0]);
        }
    }
    
    //Main Expression Handling method.
    public static int evaluateExpression(String expression){
        //Values of the numbers.
        Stack<Integer> operandStack = new Stack<>();
        //Values of +, -, *, or /.
        Stack<Character> operatorStack = new Stack<>();
        
        //Preparation for extraction of operands.
        expression = insertBlanks(expression);
        
        
        
        return 1;
    }
    
    
    public static String insertBlanks(String s){
        
        String result = "";
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == ')' ||
               s.charAt(i) == '+' || s.charAt(i) == '-' ||
               s.charAt(i) == '/' || s.charAt(i) == '*'){
                result += " " + s.charAt(i) + " ";
            } else {
                result += s.charAt(i);
            }
        }
        return result;
    }
    
}
