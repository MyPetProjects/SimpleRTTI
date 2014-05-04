package pets;

import java.util.*;

public abstract class PetCreator {
	private static Random rand = new Random();
	
	public abstract List<Class<? extends Pet>> getTypes();
	
	public Pet getRandomPet() {
		int index = rand.nextInt(getTypes().size());
		try {
			return getTypes().get(index).newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Pet[] getPetArray(int size) {
		Pet[] petArray = new Pet[size];
		for (int i = 0; i < size; i++) {
			petArray[i] = getRandomPet();
		}
		return petArray;
	}
	
	public ArrayList<Pet> getPetList(int size) {
		ArrayList<Pet> petList = new ArrayList<Pet>();
		Collections.addAll(petList, getPetArray(size));
		return petList;
	}
}
