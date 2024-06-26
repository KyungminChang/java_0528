package day16;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import lombok.AllArgsConstructor;
import lombok.Data;

public class FuntionalInterfaceEx01 {

	public static void main(String[] args) {
		List<Person> list = new ArrayList<Person>();
		
		list.add(new Person("홍길동", "1", 21));
		list.add(new Person("고길동", "2", 40));
		list.add(new Person("둘리", "3", 10000));
		
		print(list, (c)->{
			System.out.println(c.getName());
		});
		
		print(list, (c)->System.out.println(c.getAge()));
		
		print(list, c->System.out.println(c));
		
		printString(list, (p)->p.getName());
		printString(list, (p)->p.getNum());
		
		increaseAge(list, (p) -> {
			p.setAge(p.getAge() + 1);
			return p;
		});
		
		Person p = randomPerson(()->{
			int min = 0, max = 10000;
			int r = (int)(Math.random()*(max - min + 1)+min);
			return new Person("", "", 0);
		});
		System.out.println(p);
		print2(list, p1->p1.getAge() >30);
		print2(list, p1->p1.getName().equals("홍길동"));
	}
	
	public static void print2(List<Person> list, Predicate<Person> p) {
		for(Person tmp : list) {
			if(p.test(tmp)) {
				System.out.println(tmp);
			}
		}
	}
	public static void increaseAge(List<Person> list, UnaryOperator<Person> op) {
		for(int i=0;i<list.size();i++){
			list.set(i, op.apply(list.get(i)));
		}
	}
	
	public static void print(List<Person> list, Consumer<Person> c) {
		for(Person tmp : list) {
			c.accept(tmp);
		}
		
	}
	public static Person randomPerson(Supplier<Person> p) {
		return p.get();
	}
	
	public static void printString(List<Person> list, Function<Person, String> f) {
		for(Person tmp : list) {
			System.out.println(f.apply(tmp));
		}
	}
}
@Data
@AllArgsConstructor
class Person {
	private String name;//이름
	private String num;//주민번호
	private int age;//나이
	@Override
	public String toString() {
		return num + " " + name + "(" + age + ")";
	}
}