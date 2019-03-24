package 设计模式.desgin_a_factory1_;

public class StudentWorkerFactory implements IWorkerFactory {

	@Override
	public Worker getWorker() {
		return new StudentWorker();
	}

}
