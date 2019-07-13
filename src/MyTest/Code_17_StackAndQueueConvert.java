package MyTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code_17_StackAndQueueConvert {
	
	public static class TwoStackQueue {
		private Stack<Integer> pushStack;
		private Stack<Integer> pollStack;
		
		public TwoStackQueue() {
			pushStack = new Stack<Integer>();
			pollStack = new Stack<Integer>();
		}
		
		public void push(int i) {
			pushStack.push(i);
		}
		
		public int poll() {
			if (pushStack.isEmpty() && pollStack.isEmpty()) {
				throw new RuntimeException("queue is Empty.");
			}
			if (pollStack.isEmpty()) {
				while (!pushStack.isEmpty()) {
					pollStack.push(pushStack.pop());
				}
			}
			return pollStack.pop();
		}
		
		public int peek() {
			if (pushStack.isEmpty() && pollStack.isEmpty()) {
				throw new RuntimeException("queue is Empty.");
			}
			if (pollStack.isEmpty()) {
				while (!pushStack.isEmpty()) {
					pollStack.push(pushStack.pop());
				}
			}
			return pollStack.peek();
		}
	}

	public static class TwoQueueStack {
		private Queue<Integer> pushQueue;
		private Queue<Integer> pollQueue;
		
		public TwoQueueStack() {
			pushQueue = new LinkedList<Integer>();
			pollQueue = new LinkedList<Integer>();
		}
		
		public void push(int i) {
			pushQueue.add(i);
		}
		
		public int peek() {
			if (pushQueue.isEmpty()) {
				throw new RuntimeException("stack is empty.");
			}
			while (pushQueue.size() != 1) {
				pollQueue.add(pushQueue.poll());
			}
			int res = pushQueue.poll();
			pollQueue.add(res);
			swap();
			return res;
		}
		
		public int pop() {
			if (pushQueue.isEmpty()) {
				throw new RuntimeException("stack is empty.");
			}
			while (pushQueue.size() != 1) {
				pollQueue.add(pushQueue.poll());
			}
			int res = pushQueue.poll();
			swap();
			return res;
		}
		
		public void swap() {
			Queue<Integer> temp = pushQueue;
			pushQueue = pollQueue;
			pollQueue = temp;
		}
		
	}
	
}
