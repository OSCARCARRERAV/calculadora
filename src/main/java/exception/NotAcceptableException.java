package exception;

import org.springframework.http.HttpStatus;

public class NotAcceptableException extends Exception {
	
	private static final long serialVersionUID = 35716883803901352L;

	public NotAcceptableException(String message) {
	    super(message);
	  }

	  public HttpStatus getStatus() {
	    return HttpStatus.NOT_ACCEPTABLE;
	  }

}
