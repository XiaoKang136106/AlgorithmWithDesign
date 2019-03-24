package 设计模式.design_c_visitor_;

public interface Visitable {
	//此方法用于接受一个数据集合
	public void accept(Visitor visitor);

}
