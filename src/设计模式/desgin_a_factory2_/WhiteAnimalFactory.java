package 设计模式.desgin_a_factory2_;

public class WhiteAnimalFactory implements IAnimalFactory {

	@Override
	public ICat createCat() {
		return new WhiteCat();

	}

	@Override
	public IDog createDog() {
		return new WhiteDog();
	}

}
