package 设计模式.design_c_command_;

public abstract class Command {
	
	protected Receiver receiver;
	
	public Command(Receiver receiver){
		this.receiver=receiver;
		
	}
	
	public abstract void execute();

}
