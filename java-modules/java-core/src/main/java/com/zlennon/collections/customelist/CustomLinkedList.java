/**
 * 
 */
package com.zlennon.collections.customelist;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zlennon
 *
 */
public class CustomLinkedList<T> { 
		private Node[] node;
		private static int size=0;
		public CustomLinkedList(){
			node=new Node[10];
		/*	Node headNode = new Node();
			headNode.data=null;
			headNode.next=0;
			node[0]=headNode;*/
		}
		public CustomLinkedList(int size){
			
		}
		static class Node<T>{
			int head;
			Object data;
			int next;
		}
		
		public void add(int i,Node n){
			if(size==0){
				node[0]=n;
				size++;
			}else if(size==(node.length-1)){
				node[size-2].next=n.head;
				node[0].head=n.next;
				node[size]=n;
				size++;
			}else{
				node[i-1].next=n.head;
				n.next=node[i+1].head;
				node[i]=n;
				size++;
			}
		}
		public int size(){
			return size;
		}
		public static void main(String[] args) {
			CustomLinkedList<Object> customLinkedList =new CustomLinkedList<Object>();
			CustomLinkedList.Node node=new Node();
			node.head=2;
			node.data="dddd";
			node.next=4;
			customLinkedList.add(5, node);
			
			CustomLinkedList.Node node1=new Node();
			node.head=5;
			node.data="ddd";
			node.next=9;
			customLinkedList.add(8, node1);
			List list = new LinkedList();
			list.add(node);
			System.out.println(customLinkedList.size());
		}
}
