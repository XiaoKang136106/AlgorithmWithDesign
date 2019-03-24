package 设计模式.design_c_cor_;

import java.net.Authenticator.RequestorType;

public class Test {
	
	
	public static void main(String[] args) {
		//最后处理
		RequestHandle hr =new HRRequestHandle();
		RequestHandle pmr = new PMRRequestHandle(hr);
		//先处理
		RequestHandle tl = new TLRquestHandle(pmr);
		
		//创建加钱请求1
		Request request = new AddMoneyRequest();
		tl.handleRequest(request);
		//创建请假请求2
		Request request2 = new LeaveRequest();
		tl.handleRequest(request2);
		//创建离职请求
		Request reqeust3 = new DimissionRequest();
		tl.handleRequest(reqeust3);
	}

}
