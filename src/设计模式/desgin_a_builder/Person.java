package 设计模式.desgin_a_builder;

public class Person {
	
	private String head;	 //part1 头
    
    private String body;	//part2 身体
    
    private String foot;	//part3 脚

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getFoot() {
		return foot;
	}

	public void setFoot(String foot) {
		this.foot = foot;
	}

	@Override
	public String toString() {
		return "Person [head=" + head + ", body=" + body + ", foot=" + foot + "]";
	}
	
    
    
	
	

}
