package pets;

import java.util.ArrayList;

public class Pets {
	//private static final PetCreator creator = new LiteralPetCreator();
	private static final PetCreator creator = new FactoryPetCreator();
	
	public static Pet getRandomPet() {
		return creator.getRandomPet();
	}
	
	public static Pet[] getPetArray(int size) {
		return creator.getPetArray(size);
	}
	
	public static ArrayList<Pet> getPetList(int size) {
		return creator.getPetList(size);
	}
}
