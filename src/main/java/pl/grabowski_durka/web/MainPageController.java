package pl.grabowski_durka.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MainPageController {

    @GetMapping(value = "/main")
    public String mainPage() {
        return "main";
    }

    @PostMapping(value = "/main")
    public String mainPostPage() {
        return "main";
    }

}
