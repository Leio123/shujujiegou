package basic_class_08;

import java.util.Stack;

public class Code_06_ReverseStackUsingRecursive {

	public static void reverse(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int i = getAndRemoveLastElement(stack);
		reverse(stack);
		stack.push(i);
	}

	public static int getAndRemoveLastElement(Stack<Integer> stack) {
		int result = stack.pop();
		if (stack.isEmpty()) {
			return result;
		} else {
			int last = getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}
	}
	
	public static Stack<Integer> reverse1(Stack<Integer> stack) {
		Stack<Integer> temp = new Stack<Integer>();
		while (!stack.isEmpty()) {
			temp.push(stack.pop());
		}
		return temp;
	}

	public static void main(String[] args) {
		Stack<Integer> test = new Stack<Integer>();
		test.push(1);
		test.push(2);
		test.push(3);
		test.push(4);
		test.push(5);
		reverse(test);
//		Stack<Integer> temp = reverse1(test);
		while (!test.isEmpty()) {
			System.out.println(test.pop());
		}
//		while (!temp.isEmpty()) {
//			System.out.println(temp.pop());
//		}
	}

}
