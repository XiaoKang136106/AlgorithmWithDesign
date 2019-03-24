package 设计模式.design_c_command_;

public class Invoker {
	private Command command;
	public Invoker(Command command){
		
		this.command = command;
	}
	
	public void execute(){
		
		command.execute();
	}
	

}
