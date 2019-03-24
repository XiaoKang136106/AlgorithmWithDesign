package 设计模式.design_c_cor_;

public class HRRequestHandle implements RequestHandle {

	@Override
	public void handleRequest(Request reqeust) {

		if(reqeust instanceof DimissionRequest){
			
			System.out.println("要离职,人事审批!");
		}
			System.out.println("处理完毕");
	}

}
