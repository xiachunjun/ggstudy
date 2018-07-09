package com.ggstudy.logic.suanfa;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author xcj
 *         tree的结构需要比较器，如果new一个tree结构的时候没传比较器，那就key必须包含compareTo方法否则会报错，比如用Object()对象做为key时
 */
public class TreeTest {
	public static void main(String[] args) {
		TreeTest treeTest = new TreeTest();
		Object o = new Object();
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		for (int i = 0; i < 10; i++) {
			treeSet.add(i);
			treeSet.add(i);
		}
		System.out.println(treeSet);

		TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
		for (int i = 0; i < 10; i++) {
			treeMap.put(i, i);
			treeMap.put(i, i + 1);
		}
		System.out.println(treeMap);

		Node<?, ?> root = treeTest.buildTree();

		treeTest.readTree(root);
	}

	/**
	 * @param root
	 * 遍历二叉树
	 */
	public void readTree(Node<?, ?> root) {
		ArrayList<Node<?, ?>> nodeList = new ArrayList<TreeTest.Node<?, ?>>();
		ArrayList<Node<?, ?>> todoList = new ArrayList<TreeTest.Node<?, ?>>();
		todoList.add(root);

		while (todoList.size() > 0) {
			ArrayList<Node<?, ?>> tmpList = new ArrayList<TreeTest.Node<?, ?>>();
			for (Node<?, ?> n : todoList) {
				nodeList.add(n);
				if (n.left != null) {
					tmpList.add(n.left);
				}
				if (n.right != null) {
					tmpList.add(n.right);
				}
			}
			todoList = tmpList;
		}
		System.out.println(nodeList);

	}

	public Node<?, ?> buildTree() {
		Node<String, String> root = new Node<String, String>("root", "root");
		Node<String, String> _1 = new Node<String, String>("1", "11");
		Node<String, String> _2 = new Node<String, String>("2", "22");
		Node<String, String> _3 = new Node<String, String>("3", "33");
		Node<String, String> _4 = new Node<String, String>("4", "44");
		Node<String, String> _5 = new Node<String, String>("5", "55");
		Node<String, String> _6 = new Node<String, String>("6", "66");
		root.left = _1;
		root.right = _2;
		_1.left = _3;
		_1.right = _4;
		_2.left = _5;
		_2.right = _6;
		return root;
	}

	class Node<K, V> {
		K k;
		V v;
		Node<K, V> left = null;
		Node<K, V> right = null;
		Node<K, V> parent = null;

		public Node(K k, V v) {
			this.k = k;
			this.v = v;
		}

		public Node(K k, V v, Node<K, V> left, Node<K, V> right, Node<K, V> parent) {
			this.k = k;
			this.v = v;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}

		public String toString() {
			return k.toString() + "=" + v.toString();
		}
	}

}
