package 设计模式.desgin_a_singleton_;
//双重检查[推荐用]
//优点：线程安全；延迟加载；效率较高
public class Singleton3 {
	private static volatile Singleton3 singleton;

    private Singleton3() {}

    public static Singleton3 getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton3();
                }
            }
        }
        return singleton;
    }

}
