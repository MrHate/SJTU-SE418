package dgy.container;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public class ContainerCore {
	final private int threshold = 5;
	private ArrayList<Object> mem = new ArrayList<Object>();
	private int head = 0; // top
	private int tail = 0; // button

	private Object popAsQueue(){
		Object res = mem.get(tail);
		++tail;
		if(tail > 10){
			for(int i = tail; i < head; i++){
				mem.set(i-tail,mem.get(i));
			}
			head -= tail;
			tail = 0;
		}
		return res;
	}

	private Object popAsStack(){
		return mem.get(--head);
	}

	public Object pop(){
		if(isEmpty())return null;
		return (head - tail) < threshold ? popAsQueue() : popAsStack();
	}

	public void push(Object o){
		mem.add(head++,o);
		System.out.println(mem);
	}

	public boolean isEmpty(){
		return head == tail;
	}

	public void clear(){
		head = 0;
		tail = 0;
		mem.clear();
	}
}

