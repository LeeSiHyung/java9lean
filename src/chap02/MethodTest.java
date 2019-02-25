package chap02;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class MethodTest {
	
	public static void main(String[] args) {
		EvilManager boss = new EvilManager();
		Employee fred = new Employee();
		fred.name = "Fred";
		fred.salary = 95000;
		System.out.println(fred.salary);
		boss.giveRandomRaise(fred);
		System.out.println(fred.salary);
		
		// 기본타입 매개변수는 업데이트 되지 않는다.
		boss.increaseRandomly(fred.salary);
		System.out.println(fred.salary);
		
		
		Person p = new Person();
		System.out.println(p.getFriends().size());
		
		CreditCardForm c = new CreditCardForm();
		System.out.println(c.expirationYear);
		
		// 정적 임포트
		double x = 2;
		double y = 3;
		System.out.println(pow(x, 2));
		System.out.println(pow(y, 2));
		System.out.println(sqrt(pow(x, 2) + pow(y, 2)));
		
		double r = sqrt(pow(x, 2) + pow(y, 2));
		
		// 정적 중첩 클래스
		Invoice invoice = new Invoice();
		invoice.addItem("test", 1, 12122);
		invoice.addItem("test", 1, 12122);
		invoice.addItem("test", 1, 12122);
		System.out.println(invoice.items.size());
		
		Invoice2 newItem = new Invoice2();
		Invoice2.Item item = new Invoice2.Item("test", 1, 22);
		newItem.add(item);
		newItem.add(item);
		System.out.println(newItem.items.size());
		
		// 내부 클래스
		Network myFace = new Network();
		Network.Member fred2 = myFace.enroll("Fred");
		// 내부 클래스의 각 객체는 외부 클래스의 객체에 대한 참조를 포함한다.
		System.out.println(myFace.members.size());
		fred2.deactivate();
		System.out.println(myFace.members.size());
		
		System.out.println(fred2.belongsTo(myFace));
	}
	
	static class Employee{
		
		private String name;
		private int id;
		private double salary;
		
		public Employee() {
		}
		
		public Employee(String name, double salary) {
			this.name = name;
			this.salary = salary;
		}
		
		public Employee(double salary) {
			this("", salary);
		}
		
		// 초기화 블록
		{
			Random generator = new Random();
			id = 1 + generator.nextInt(1_000_000);
		}
		
		
		
		public void raiseSalary(double byPercent) {
			double raise = this.salary * byPercent / 100;
			this.salary += raise;
		}
	}
	static class EvilManager{
		
		private Random generator = new Random();
		
		public void giveRandomRaise(Employee e) {
			double percentage = 10 * generator.nextGaussian();
			e.raiseSalary(percentage);
		}
		
		public void increaseRandomly(double x) {
			double amount = x * generator.nextDouble();
			x += amount;
		}
	}
	
	static class Person{
		
		private final ArrayList<Person> friends = new ArrayList<>();
		public ArrayList<Person> getFriends() {
			// 변경 가능한 객체를 가리키는 참조의 경우 final 이여도 객체의 내용을 변경할 수 있다.
			friends.add(new Person());
			friends.add(new Person());
			friends.add(new Person());
			return friends;
		}
		
	}
	
	static class CreditCardForm{
		private static final ArrayList<Integer> expirationYear = new ArrayList<>();
		static {
			int year = LocalDate.now().getYear();
			for(int i = year; i <= year + 20; i++) {
				expirationYear.add(i);
			}
		}
		
	}
	
	static class Invoice{
		private static class Item{
			String description;
			int quantity;
			double unitPrice;
			
		}
		private ArrayList<Item> items = new ArrayList<>();
		public void addItem(String description, int quantity, double unitPrice) {
			Item newItem = new Item();
			items.add(newItem);
		}
	}
	
	static class Invoice2{
		public static class Item{
			String description;
			int quantity;
			double unitPrice;
			
			public Item(String description, int quantity, double unitPrice) {
				this.description = description;
				this.quantity = quantity;
				this.unitPrice = unitPrice;
			}
			
			// 정적 중첩 클래스는 내부에서 외부 객체의 메소드에 직접 접근이 불가한다.
			public void remove() {
				// items.remove(this);
			}
		}
		private ArrayList<Item> items = new ArrayList<>();
		public void add(Item item) {
			items.add(item);
		}
	}
	
	
	static class Network{
		public class Member{
			private String name;
			private ArrayList<Member> friends;
			
			public Member(String name) {
				this.name = name;
				friends = new ArrayList<>();
			}
			
			public void deactivate() {
				// 정적 중첩 클래스와 다르게 외부 클래스 인스턴스 변수에 직접 접근이 가능하다.
				// members.remove(this);
				// unenroll(this);
				Network.this.members.remove(this);
			}
			
			public boolean belongsTo(Network n) { 
				return Network.this == n;
			}
		}
		
		private ArrayList<Member> members = new ArrayList<>();
		
		public Member enroll(String name) {
			// Member newMember = new Member(name);
			Member newMember = this.new Member(name);
			members.add(newMember);
			return newMember;
		}
		
		public void unenroll(Member m) {
			members.remove(m);
		}
	}
}
