package 设计模式.design_c_cor_;

public class TLRquestHandle implements RequestHandle{

	RequestHandle rh;
	public TLRquestHandle(RequestHandle rh){
		this.rh= rh;
		
	}
	
	@Override
	public void handleRequest(Request request) {
		if(request instanceof LeaveRequest){
			System.out.println("要请假,审核批准!!!!!!!!");
		}else{
			rh.handleRequest(request);
		}
		
		
	}

}
