package pets;

public class Cat extends Pet {
	public static class Factory implements simple.rtti.Factory<Cat> {
		public Cat create() {
			return new Cat();
		}
	}
}
