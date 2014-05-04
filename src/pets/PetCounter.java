package pets;

import java.util.LinkedHashMap;
import java.util.Map;
import simple.rtti.*;

@SuppressWarnings("serial")
public class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer> {

	public PetCounter() {
		for (Class<? extends Pet> petClass : LiteralPetCreator.allTypes) {
			put(petClass, 0);
		}
	}
	
	public void count(Pet pet) {
		for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
			if (pair.getKey().isInstance(pet)) {
				pair.setValue(pair.getValue()+1);
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		PetCounter petCounter = new PetCounter();
		TypeCounter typeCounter = new TypeCounter(Pet.class);
		for (Pet pet : Pets.getPetList(8)) {
			System.out.print(pet.getClass().getSimpleName()+" ");
			petCounter.count(pet);
			typeCounter.count(pet);
		}
		System.out.println();
		System.out.println(petCounter);
		System.out.println(typeCounter);
	}
}
