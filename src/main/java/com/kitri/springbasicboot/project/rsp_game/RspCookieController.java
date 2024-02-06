package com.kitri.springbasicboot.project.rsp_game;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rsp_cookie")
public class RspCookieController {

    @PostMapping("/a")
    public int putSession1(HttpServletRequest request){
        HttpSession session = request.getSession();
        Count count1 = (Count) session.getAttribute("count");
        count1.setCount1(count1.getCount1() + 1);
        return count1.getCount1();
    }

    @PostMapping("/b")
    public int putSession2(HttpServletRequest request){
        HttpSession session = request.getSession();
        Count count1 = (Count) session.getAttribute("count");
        count1.setCount2(count1.getCount2() + 1);
        return count1.getCount2();
    }

    @PostMapping("/c")
    public int putSession3(HttpServletRequest request){
        HttpSession session = request.getSession();
        Count count1 = (Count) session.getAttribute("count");
        count1.setCount3(count1.getCount3() + 1);
        return count1.getCount3();
    }
}
