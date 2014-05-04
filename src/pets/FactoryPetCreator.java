package pets;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FactoryPetCreator extends PetCreator {
	
	static List<simple.rtti.Factory<? extends Pet>> petFactories = 
	  new ArrayList<simple.rtti.Factory<? extends Pet>>();
	
	static {
		petFactories.add(new Cat.Factory());
		petFactories.add(new Dog.Factory());
	}

	private static Random random = new Random(); 
	
	@Override
	public Pet getRandomPet() {
		int index = random.nextInt(petFactories.size());
		return petFactories.get(index).create();
	}
	
	@Override
	public List<Class<? extends Pet>> getTypes() {
		return null;
	}
}
