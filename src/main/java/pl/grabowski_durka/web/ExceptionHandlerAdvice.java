package pl.grabowski_durka.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = RuntimeException.class)
    public ModelAndView handleException(RuntimeException ex) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("errorMessage", ex.getMessage());
        return mav;
    }
}
