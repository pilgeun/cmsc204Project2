/**
 * 
 * @author PHILIP SONG
 */

public class Notation {
	
	public Notation() {
		
	}

	/**
	 * Convert infix to postfix expression, use queue for internal structure
	 * @param infix
	 * @return
	 * @throws QueueOverflowException 
	 * @throws StackUnderflowException 
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
		
		MyQueue<Character> postFix = new MyQueue<Character>();
		MyStack<Character> operandStack = new MyStack<Character>();
		
		for(int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			
			if (Character.isDigit(c))
				try {
					postFix.enqueue(c);
				} catch (QueueOverflowException e) {
					throw new InvalidNotationFormatException();
				}
			
			else if (c == '(')
				try {
					operandStack.push(c);
				} catch (StackOverflowException e) {
					throw new InvalidNotationFormatException();
				}
			
			else if (c == ')') {
				try {
					while(!operandStack.isEmpty() && operandStack.top()!='(') {
						postFix.enqueue(operandStack.pop());
					}
					
					operandStack.pop();	// get rid of '('
				} catch (StackUnderflowException | QueueOverflowException e) {
						throw new InvalidNotationFormatException();
				}
			}
			
			else if (c == '+' || c == '-') {
				try {
					if (operandStack.top() == '+' || operandStack.top() == '-')
						postFix.enqueue(operandStack.pop());
					
					else if (operandStack.top() == '*' || operandStack.top() == '/')
					{
						postFix.enqueue(operandStack.pop());
						postFix.enqueue(operandStack.pop());
					}
					
					operandStack.push(c);
				} catch (StackUnderflowException | QueueOverflowException | StackOverflowException e) {
					throw new InvalidNotationFormatException(); 
				
				}
			}
			
			else if (c == '*' || c == '/' || c == '%') {
				try {
					if (operandStack.top() == '*' || operandStack.top() == '/'  || operandStack.top() == '%')
						postFix.enqueue(operandStack.pop());
					
					else if (operandStack.isEmpty()) 
						throw new InvalidNotationFormatException();
					
					operandStack.push(c);
				} catch (StackUnderflowException | QueueOverflowException | StackOverflowException e) {
					throw new InvalidNotationFormatException(); 
				}
			}
			
			else	// catches invalid characters
				throw new InvalidNotationFormatException();
		}
		
		return postFix.toString();
	}
	
	/**
	 * Convert postfix to infix expression
	 * @param postfix
	 * @return
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {

		MyStack<String> infixStack = new MyStack<String>();
		
		for(int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);
			
			if(Character.isDigit(c))
				try {
					infixStack.push(c+"");
				} catch (StackOverflowException e) {
					throw new InvalidNotationFormatException();
				}
			else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%')	// if it's an operator
			{
				if (infixStack.size() >= 2)
				{
					String s1;
					String s2;
					
					try {
						s1 = infixStack.pop();
						s2 = infixStack.pop();
						
						String temp = "(" +s2 +c+ s1+ ")";
						infixStack.push(temp);	
						
					} catch (StackUnderflowException | StackOverflowException e) {
						throw new InvalidNotationFormatException();
					}
					
				}
				else 
					throw new InvalidNotationFormatException();
			}
			
			else 
				throw new InvalidNotationFormatException();
			
		}
		
		return infixStack.toString();
	}

	/**
	 * Evaluates a postfix expression from a string to a double
	 * @param complexPostfix
	 * @return
	 * @throws StackOverflowException 
	 * @throws StackUnderflowException 
	 * @throws NumberFormatException 
	 */
	public static double evaluatePostfixExpression(String complexPostfix) throws InvalidNotationFormatException {
		MyStack<Double> postfixStack = new MyStack<Double>();
		
			for (int i = 0; i < complexPostfix.length(); i++) {
				char c = complexPostfix.charAt(i);
				
				
				if(Character.isDigit(c))
					try {
						postfixStack.push((double)c - '0');
					} catch (StackOverflowException e) {
						e.printStackTrace();
					}
				else if (c == '+' || c == '-' || c == '*' || c == '/')
				{
					if (postfixStack.size() >= 2)
					{
						double d1;
						double d2;
						
						try {
							d1 = postfixStack.pop();
							d2 = postfixStack.pop();
						
							if (c == '+')
								postfixStack.push(d1+d2);
								
							else if	(c == '-')
								postfixStack.push(d2-d1);
			
							else if	(c == '*')
								postfixStack.push(d1*d2);
									
							else if	(c == '/')
								postfixStack.push(d2/d1);
							else if (c == '%')
								postfixStack.push(d2%d1);
						
						} catch (StackUnderflowException | StackOverflowException e) {
							e.printStackTrace();
						}
					}
					
					else 
						throw new InvalidNotationFormatException();
				}
				
				else 
					throw new InvalidNotationFormatException();
			}
		
		try {
			return postfixStack.pop();
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
