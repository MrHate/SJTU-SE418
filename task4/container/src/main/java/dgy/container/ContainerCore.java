package dgy.container;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ContainerCore {
	private final int threshold = 5;
	private final int timeout = 2000;

	private ArrayList<Date> timestamps = new ArrayList<Date>();
	private ArrayList<Object> mem = new ArrayList<Object>();
	private int head = 0; // top
	private int tail = 0; // button

	private Object popAsQueue(){
		Object res = mem.get(tail);
		++tail;
		if(tail > 10){
			for(int i = tail; i < head; i++){
				mem.set(i-tail,mem.get(i));
				timestamps.set(i-tail,timestamps.get(i));
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
		Object res = (head - tail) < threshold ? popAsQueue() : popAsStack();
		System.out.print("pop: ");
		System.out.println(res);
		return res;
	}

	public void push(Object o){
		doTimeout();
		mem.add(head,o);
		timestamps.add(head,new Date());
		++head;
		System.out.print("push: ");
		System.out.println(o);
	}

	public boolean isEmpty(){
		doTimeout();
		return head == tail;
	}

	public void clear(){
		head = 0;
		tail = 0;
		mem.clear();
	}

	private void doTimeout(){
		Date now = new Date();
		for(int i = tail; i < head; i++){
			if(now.getTime() - timestamps.get(i).getTime() > timeout){
				System.out.print("timeout: ");
				System.out.println(mem.get(tail));
				++tail;
			}
		}
	}
}

