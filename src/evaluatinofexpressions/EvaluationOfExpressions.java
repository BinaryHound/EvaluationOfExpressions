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
        
        String[] tokens = expression.split(" ");
        
        for(String token: tokens){
            if(token.length() == 0){
                continue;
            }else if(token.charAt(0) == '+' || token.charAt(0) == '-'){
                while(!operatorStack.isEmpty() &&
                      (operatorStack.peek() == '+' ||
                       operatorStack.peek() == '-' ||
                       operatorStack.peek() == '*' ||
                       operatorStack.peek() == '/' )){
                    processAnOperator(operandStack, operatorStack);
                }
            }else if(token.charAt(0) == '*' || token.charAt(0) == '/'){
                while(!operatorStack.isEmpty() && 
                      (operatorStack.peek() == '*' ||
                       operatorStack.peek() == '/')){
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0));
            }else if(token.trim().charAt(0) == '('){
                operatorStack.push('(');
            }else if(token.trim().charAt(0) == ')'){
                while(operatorStack.peek() != '('){
                    processAnOperator(operandStack, operatorStack);
                }
                operandStack.pop();
            }else {
                operandStack.push(new Integer(token));
            }
        }
        while(!operatorStack.isEmpty()){
            processAnOperator(operandStack, operatorStack);
        }
        
        return operandStack.pop();
    }
    
    public static void processAnOperator(Stack<Integer> operandStack, Stack<Character> operatorStack){
        char op = operatorStack.pop();
        int op1 = operandStack.pop();
        int op2 = operandStack.pop();
        switch(op){
            case '+':
                operandStack.push(op2 + op1);
                break;
            case '-':
                operandStack.push(op2 - op1);
                break;
            case '*':
                operandStack.push(op2 * op1);
                break;
            case '/':
                operandStack.push(op2 / op1);
                break;
        }
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
