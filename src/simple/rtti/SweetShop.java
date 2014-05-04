package simple.rtti;

import java.lang.reflect.*;
import pets.*;

class Gum {
	static {System.out.println("Creating Gum");}
	
	public Gum() {}
}

public class SweetShop {
	protected static void printRecurs(int arg) {
		arg++;
		System.out.println(arg);
		try {
			Class<?> classObj = Class.forName("simple.rtti.SweetShop");
			Method method = classObj.getMethod("printRecurs", int.class);
			method.invoke(null, arg);
		} catch (StackOverflowError e) {
			System.out.println("Stack overflow at " + arg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String className = "pets.PetCounter";
		printRecurs(0);
		try {
			Class<?> classObj = Class.forName(className);
			try {
				//classObj.getMethod("main", String[].class).invoke(null, (Object)null);
				PetCounter reflPetCounter = (PetCounter)classObj.getConstructor((Class<?>[])null).newInstance((Object[])null);
				System.out.println(reflPetCounter);
				classObj.getMethod("count", Pet.class).invoke(reflPetCounter, (new Rat()));
				System.out.println(reflPetCounter);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
/*			System.out.println(classObj);
			System.out.println("Constructors:");
			Constructor<?>[] ctors = classObj.getConstructors();
			for (Constructor<?> ctor : ctors) {
				System.out.println(ctor.toString().replaceAll("\\w+\\.", ""));
			}
			
			System.out.println("Methods:");
			Method[] methods = classObj.getMethods();
			for (Method method : methods) {
				System.out.println(method.toString().replaceAll("\\w+\\.", ""));
			}*/
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}