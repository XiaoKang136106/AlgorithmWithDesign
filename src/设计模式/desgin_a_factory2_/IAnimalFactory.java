package 设计模式.desgin_a_factory2_;
//动物工厂用于创建动物对象
public interface IAnimalFactory {
	//创建猫
	ICat createCat();
	//创建狗
	IDog createDog();
	

}
