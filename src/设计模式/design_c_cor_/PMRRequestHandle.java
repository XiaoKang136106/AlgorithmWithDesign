package 设计模式.design_c_cor_;

public class PMRRequestHandle implements RequestHandle {

	RequestHandle rh;
	public PMRRequestHandle(RequestHandle rh){
		
		this.rh =rh;
	}
	
	@Override
	public void handleRequest(Request request) {
			if(request instanceof AddMoneyRequest){
				System.out.println("要加薪,审批完毕!!!!");
			}else{
				rh.handleRequest(request);
			}
		
	}

}
