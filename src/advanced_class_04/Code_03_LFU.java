package advanced_class_04;

import java.util.HashMap;
//次数作为一个双端链表，然后在次数下挂上一个双端链表，存储操作名
public class Code_03_LFU {

	//小链表类型
	public static class Node {
		public Integer key;
		public Integer value;
		public Integer times;
		public Node up;
		public Node down;

		public Node(int key, int value, int times) {
			this.key = key;
			this.value = value;
			this.times = times;
		}
	}

	public static class LFUCache {

		public static class NodeList {
			public Node head;
			public Node tail;
			public NodeList last;
			public NodeList next;

			public NodeList(Node node) {
				head = node;
				tail = node;
			}

			public void addNodeFromHead(Node newHead) {
				//替换头结点
				newHead.down = head;
				head.up = newHead;
				head = newHead;
			}

			public boolean isEmpty() {
				return head == null;
			}

			public void deleteNode(Node node) {
				//次数发生改变，修改这个操作所在的下挂链表
				if (head == tail) {
					head = null;
					tail = null;
				} else {
					if (node == head) {
						head = node.down;
						head.up = null;
					} else if (node == tail) {
						tail = node.up;
						tail.down = null;
					} else {
						node.up.down = node.down;
						node.down.up = node.up;
					}
				}
				node.up = null;
				node.down = null;
			}
		}

		private int capacity;
		private int size;
		private HashMap<Integer, Node> records;//key(Integer) -> Node
		private HashMap<Node, NodeList> heads;//一个Node来自哪个list
		private NodeList headList;//所有list的头部

		public LFUCache(int capacity) {
			this.capacity = capacity;
			this.size = 0;
			this.records = new HashMap<>();
			this.heads = new HashMap<>();
			headList = null;
		}

		public void set(int key, int value) {
			if (records.containsKey(key)) {
				Node node = records.get(key);
				node.value = value;
				node.times++;
				NodeList curNodeList = heads.get(node);
				move(node, curNodeList);
			} else {
				if (size == capacity) {
					Node node = headList.tail;
					headList.deleteNode(node);
					modifyHeadList(headList);
					records.remove(node.key);
					heads.remove(node);
					size--;
				}
				Node node = new Node(key, value, 1);
				if (headList == null) {
					headList = new NodeList(node);
				} else {
					if (headList.head.times.equals(node.times)) {
						headList.addNodeFromHead(node);
					} else {
						NodeList newList = new NodeList(node);
						newList.next = headList;
						headList.last = newList;
						headList = newList;
					}
				}
				records.put(key, node);
				heads.put(node, headList);
				size++;
			}
		}

		private void move(Node node, NodeList oldNodeList) {
			oldNodeList.deleteNode(node);
			NodeList preList = modifyHeadList(oldNodeList) ? oldNodeList.last
					: oldNodeList;
			NodeList nextList = oldNodeList.next;
			if (nextList == null) {
				NodeList newList = new NodeList(node);
				if (preList != null) {
					preList.next = newList;
				}
				newList.last = preList;
				if (headList == null) {
					headList = newList;
				}
				heads.put(node, newList);
			} else {
				if (nextList.head.times.equals(node.times)) {
					nextList.addNodeFromHead(node);
					heads.put(node, nextList);
				} else {
					NodeList newList = new NodeList(node);
					if (preList != null) {
						preList.next = newList;
					}
					newList.last = preList;
					newList.next = nextList;
					nextList.last = newList;
					if (headList == nextList) {
						headList = newList;
					}
					heads.put(node, newList);
				}
			}
		}

		// return whether delete this head
		private boolean modifyHeadList(NodeList nodeList) {
			if (nodeList.isEmpty()) {
				if (headList == nodeList) {
					headList = nodeList.next;
					if (headList != null) {
						headList.last = null;
					}
				} else {
					nodeList.last.next = nodeList.next;
					if (nodeList.next != null) {
						nodeList.next.last = nodeList.last;
					}
				}
				return true;
			}
			return false;
		}

		public Integer get(int key) {
			if (!records.containsKey(key)) {
				return null;
			}
			Node node = records.get(key);
			node.times++;
			NodeList curNodeList = heads.get(node);
			move(node, curNodeList);
			return node.value;
		}
	}
}