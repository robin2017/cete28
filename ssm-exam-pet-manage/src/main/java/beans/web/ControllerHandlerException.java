package beans.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ControllerHandlerException {
	@ExceptionHandler(ServiceException.class)
	@ResponseBody
	public JsonResult handleServiceException(ServiceException e) {
		 //e.printStackTrace();
		 return new JsonResult(e);
	}
}
