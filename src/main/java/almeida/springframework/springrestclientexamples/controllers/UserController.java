package almeida.springframework.springrestclientexamples.controllers;

import almeida.springframework.springrestclientexamples.services.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;

@Slf4j
@Controller
public class UserController {


    private ApiService apiService;

    public UserController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping({"", "/", "/index"})
    public String index(){
        return "index";
    }

    @PostMapping("/users")
    public String formPost(Model model, ServerWebExchange serverWebExchange){

        serverWebExchange.getFormData().subscribe(map -> {
            String limit = map.getFirst("limit");

            if(StringUtils.isEmpty(limit)) {
                limit = "10";
            }
            model.addAttribute("users", apiService.getUsers(Integer.valueOf(limit)));
        });

        return "userlist";
    }

}
