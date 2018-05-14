package pl.votingapp.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = Throwable.class)
    public ModelAndView handleException(Throwable ex) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("errorMessage", ex.getStackTrace());
        return mav;
    }
}
