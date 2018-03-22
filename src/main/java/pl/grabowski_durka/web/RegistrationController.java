package pl.grabowski_durka.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import pl.grabowski_durka.dto.UserDto;
import pl.grabowski_durka.entity.User;

/**
 * @author Marcin
 */
@Controller
public class RegistrationController {

    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "register";
    }


}
