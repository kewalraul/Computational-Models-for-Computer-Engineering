package lec5_assgnments;

class Link {
	public long data;
	public Link next;

	public Link(long d) {
		data = d;
	}

	public void displayLink() {
		System.out.print(data + " ");
	}
}

class Queue{
	Link front=null;
	
	public void insert(long key) {
		Link newlink= new Link(key);
		Link previous=null;
		Link current= front;
		
		while(current !=null && key > current.data) {
			previous=current;
			current=current.next;
		}
		
		if(previous==null) {
			front=newlink;
		}
		else {
			previous.next=newlink;
			newlink.next=current;
		}
	}
	
	public Link remove() {
		Link temp=front;
		front=front.next;
		return temp;
	}
	
	public void display() {
		Link current_item=front;
		System.out.println("Queue Details");
		while(current_item!=null) {
			current_item.displayLink();
			current_item=current_item.next;
		}
		System.out.println(" ");
	}
	
}
public class PriorityQueue {

	public static void main(String[] args) {
		
		Queue obj=new Queue();
		obj.insert(2);
		obj.insert(9);
		obj.insert(5);
		obj.insert(6);
		obj.display();
		obj.remove();
		obj.display();
	}

}
