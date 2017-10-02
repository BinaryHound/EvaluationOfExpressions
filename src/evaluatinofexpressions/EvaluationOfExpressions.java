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
        return 1;
    }
}
