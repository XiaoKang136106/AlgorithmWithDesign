package 设计模式.desgin_a_factory2_;

public class BlackAnimalFactory implements IAnimalFactory {

	@Override
	public ICat createCat() {
		return new BlackCat();

	}

	@Override
	public IDog createDog() {
		return new BlackDog();
	}

}
