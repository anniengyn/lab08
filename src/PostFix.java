import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PostFix {

	public static void main(String[] args) throws StackUnderflow, StackOverflow, IOException, FormatException {

		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));

		System.out.print("Please enter an infix expression: ");
		String pfx = reader.readLine();
		

		System.out.println("Infix to Postfix: " + infixToPostfix(pfx));
	}

	// takes a String representing a postfix expression and determines the value represented by that expression
	// source: https://www.includehelp.com/c/evaluation-of-postfix-expressions-using-stack-with-c-program.aspx 
	//         https://www.geeksforgeeks.org/stack-set-4-evaluation-postfix-expression/



	public static Double evaluate(String pfx) throws StackUnderflow, StackOverflow {

		Stack<Double> stack = new StackAsList<Double>(20);
		char[] c = pfx.toCharArray();

		Double a, b;

		// evaluate postfix expression
		for (char input : c) {
			// if character is a number, push it to stack
			if (Character.isDigit(input)) {
				stack.push((double) Character.getNumericValue(input));
			}
			else if (input == '+' 
					|| input == '*'
					|| input == '/'
					|| input == '-'
					|| input == '^') {

				// The top-most value taken from the stack is b, the second value taken is a

				b = stack.pop();
				a = stack.pop();

				// otherwise if input is an operator, pop element a and element b from stack
				// apply operator and push the value obtained onto stack
				switch (input) {
				case '^':
					stack.push((Double)(Math.pow(a, b)));
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


	// priority levels of operators, 3 = high priority 1 = lowest priority
	// https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/
	public static int precedence(char operator) {
		switch (operator) {
		case '^':
			return 3;
		case '*':
		case '/':
			return 2;
		case '+':
		case '-':
			return 1;
		default:
			return -1;
		}
	}

	public static String infixToPostfix(String ifx) throws StackOverflow, StackUnderflow, FormatException {



		Stack<Character> stack2 = new StackAsList<Character>(20);

		char[] c = ifx.toCharArray();
		// initialize empty String for result
		String pfxResult = "";

		for (char input : c) {

			if (!Character.isDigit(input) 
				&& input != '+' 
				&& input != '-'
				&& input != '*'
				&& input != '/'
				&& input != '^'
				&& input != '('
				&& input != ')') 
			{
				throw new FormatException("Wrong string format!");
			}

			 

			if (Character.isDigit(input)) {
				pfxResult += input;
			} 
			else if (input == '(') {
				stack2.push(input);
			}

			else if (input == ')') {
				while (!stack2.isEmpty() && stack2.peek() != '(')
					pfxResult += stack2.pop();

				stack2.pop();

			}
			else if (input == '+' || input == '*' || input == '/' || input == '-' || input == '^') {
				if (stack2.isEmpty()) {
					stack2.push(input);
				}
				else if (!stack2.isEmpty() && precedence(input) > precedence((char)stack2.peek())) {
					stack2.push(input);
				}
				else if(!stack2.isEmpty() && precedence(input) <= precedence((char)stack2.peek())) {
					while(!stack2.isEmpty() || precedence(input) >= precedence((char)stack2.peek())) {
						pfxResult += stack2.pop();
					}
					stack2.push(input);
				}
			}


		}
		while(!stack2.isEmpty()) {
			pfxResult += stack2.pop();
		}
		return pfxResult; 
	}
}



