package com.ezreb.utils;

public class ProceduralArray {

	public ProceduralArray(Class<?> c) {
		// TODO Auto-generated constructor stub
		//String[] s = new String[5];
		//System.out.println("---------------------------");
		//System.out.println(obj.getClass());
		//System.out.println("---------------------------");
		this.c = c;
	}
	private Object[] o = new Object[0];
	private Class<?> c;
	public boolean addToArray(Object addend) {
		if(c.equals(addend.getClass())) {
			Object[] o2 = new Object[o.length+1];
			for (int i = 0; i < o.length; i++) {
				o2[i] = o[i];
			}
			o2[o.length] = addend;
			this.o = o2;
			this.length = o.length;
			return true;
		} else {
			return false;
		}
	}
	public int length = 0;
	public Object[] getArray() {
		return this.o;
	}
}
class test {
	public static void main(String[] args) {
		ProceduralArray pa = new ProceduralArray(String.class);
		pa.addToArray("Hello");
		pa.addToArray("My");
		pa.addToArray("Name");
		pa.addToArray("Is");
		pa.addToArray("Adam");
		pa.addToArray("And");
		pa.addToArray("I");
		pa.addToArray("Suck");
		pa.addToArray("Because");
		pa.addToArray("I");
		pa.addToArray("Hate");
		pa.addToArray("Everyone");
		pa.addToArray("And");
		pa.addToArray("Everything");
		pa.addToArray(":D");
		Object[] pa2 = pa.getArray();
		for (Object object : pa2) {
			try {
				String pa3 = (String) object;
				System.out.println(pa3);
			} catch(ClassCastException c) {
				System.out.println("it broke");
			}
		}
	}
}
