package com.cagnosolutions.starter.app.site

import groovy.transform.CompileStatic
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
/**
 * Created by Scott Cagno.
 * Copyright Cagno Solutions. All rights reserved.
 */

@CompileStatic
@Controller(value = "siteController")
class SiteController {

    // login
    @RequestMapping(value = "/login")
    String login() {
        "login"
    }

    // error
    @ExceptionHandler(value = [Exception.class, RuntimeException.class])
    String errors(Exception e, Model model) {
        def stack = []
        for (frame in e.getStackTrace()) {
            stack << frame.toString()
        }
        model.addAllAttributes([message: e.getLocalizedMessage(), exception: stack.join('\n')])
        "error"
    }

    // index
    @RequestMapping(value = ["/","/index","/home"], method = RequestMethod.GET)
    String index() {
        "redirect:/secure/overview"
    }

    // overview
    @RequestMapping(value = "", method = RequestMethod.GET)
    String overview() {
        "overview"
    }

}


