
public class PostFix {

	public static void main(String[] args) throws StackUnderflow, StackOverflow {
		String pfx ="1 * 2 + 3";
		System.out.println("Evaluation of postfix expression: " + evaluate(pfx));
//		printf(" \n Result of expression evaluation : %d \n", pop());
	}
	
	// takes a String representing a postfix expression and determines the value represented by that expression
	// source: https://www.includehelp.com/c/evaluation-of-postfix-expressions-using-stack-with-c-program.aspx 
	//         https://www.geeksforgeeks.org/stack-set-4-evaluation-postfix-expression/
	public static int evaluate(String pfx) throws StackUnderflow, StackOverflow {
		StackAsList<Integer> stack = new StackAsList<Integer>();
		char[] c = pfx.toCharArray();
		int a, b;
		
		// evaluate postfix expression
		for (char input : c) {
			// if character is a number, push it to stack
			if (Character.isDigit(input)) {
				stack.push(Character.getNumericValue(input));
			}
			else  {
				
				a = stack.pop();
				b = stack.pop();
				
				// otherwise if input is an operator, pop element a and element b from stack
				// apply operator and push the value obtained onto stack
				switch (input) {
				case '^':
					stack.push((int)(Math.pow(a, b)));
					break;
					
				case '*':
					stack.push(a * b);
					break;
					
				case '/':
					stack.push(a / b);
					break;
					
				case '+':
					stack.push(a + b);
					break;
					
				case '-':
					stack.push(a - b);
					break;
					
				}
				
			}
		}
		return stack.pop();
		
		

}
	
	// converts an infix expression which is presented as a String to a String representing a postfix expression
	
//	public String infixToPostfix (String ifx) throws StackOverflow, StackUnderflow {
//		StackAsList<Integer> stack = new StackAsList<Integer>();
//		char[] c = ifx.toCharArray();
//		String pfxResult = "";
//
//
//		return pfxResult;
//		
//	}
	

	
	// read an infix String from the console, evaluates the result and prints the result to the console



}
	

	
