package pets;

public class Dog extends Pet {
	public static class Factory implements simple.rtti.Factory<Dog> {
		public Dog create() {
			return new Dog();
		}
	}
}
