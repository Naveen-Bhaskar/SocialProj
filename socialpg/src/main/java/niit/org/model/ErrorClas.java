package niit.org.model;

public class ErrorClas {
	private int errorCode;
	private String errorMsg;
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public ErrorClas(int errorCode,String errorMsg)
	{
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

}
