package com.kitri.springbasicboot.project.rsp_game;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rsp")
public class RspController {
    @GetMapping
    public String home(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("count") == null) {
            session.setAttribute("count", new Count());
        }
        return "/project/rsp_game/rsp";
    }

}
