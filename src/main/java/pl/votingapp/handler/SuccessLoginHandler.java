package pl.votingapp.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SuccessLoginHandler extends SimpleUrlAuthenticationSuccessHandler{

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response,
                          Authentication authentication) throws IOException, ServletException
    {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        List<String> authorities =
                userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList());

        System.out.println(userDetails.getUsername());
        authorities.stream().forEach(System.out::println);

        if (authorities.contains("USER")) {
            new DefaultRedirectStrategy().sendRedirect(request, response, "/");
        } else if (authorities.contains("ADMIN")) {
            new DefaultRedirectStrategy().sendRedirect(request, response, "/");
        } else {
            new DefaultRedirectStrategy().sendRedirect(request, response, "/");
        }
    }
}
