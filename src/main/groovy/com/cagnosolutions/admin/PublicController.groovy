package com.cagnosolutions.admin
import groovy.transform.CompileStatic
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Created by Scott Cagno.
 * Copyright Cagno Solutions. All rights reserved.
 */

@CompileStatic
@Controller
class PublicController {

    @RequestMapping(value = "/login")
    String login() {
        "login"
    }

    @RequestMapping(value = "/")
    String catcher() {
        "redirect:/hypervisor"
    }

    @ExceptionHandler(value = [Exception.class, RuntimeException.class])
    String errors(Exception e, Model model) {
        def stack = []
        for (frame in e.getStackTrace()) {
            stack << frame.toString()
        }
        model.addAllAttributes([message: e.getLocalizedMessage(), exception: stack.join('\n')])
        "error"
    }

}


