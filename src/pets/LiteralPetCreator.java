package pets;

import java.util.*;

public class LiteralPetCreator extends PetCreator {
	@SuppressWarnings("unchecked")
	public static final List<Class<? extends Pet>> allTypes =
	  Collections.unmodifiableList(Arrays.asList(
		Cat.class, Dog.class, Rat.class, Hamster.class));
	
	private static final List<Class<? extends Pet>> types = 
	  allTypes.subList(allTypes.indexOf(Dog.class), allTypes.size());
	
	@Override
	public List<Class<? extends Pet>> getTypes() {
		return types;
	}
	
	public static void main(String[] args) {
		System.out.println(types);
	}
}
