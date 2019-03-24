package 设计模式.design_c_command_;

public class CommandImpl extends Command {

	public CommandImpl(Receiver receiver) {
		super(receiver);
	}

	@Override
	public void execute() {
		receiver.receive();
	}

	


}
