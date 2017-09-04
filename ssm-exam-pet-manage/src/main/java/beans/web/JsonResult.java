package beans.web;

public class JsonResult {
    private static final int SUCCESS=1;
    private static final int ERROR=2;
	private int state;
	private String message;
	private Object data;
	
	public JsonResult() {
		this.state=SUCCESS;
		this.message="ok";
	}
	public JsonResult(Object data) {
		this();
		this.data=data;
	}
	public JsonResult(Throwable e) {
		this.state=ERROR;
		this.message=e.getMessage();
	}
	public Object getData() {
		return data;
	}
	public String getMessage() {
		return message;
	}
	public int getState() {
		return state;
	}
}
