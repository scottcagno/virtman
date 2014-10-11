package com.cagnosolutions.starter.app.qemu

import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

/**
 * Created by Scott Cagno.
 * Copyright Cagno Solutions. All rights reserved.
 */

@CompileStatic
@Controller
@RequestMapping(value = "/qemu/domain")
class DomainController {

    @Autowired
    QEMUService qemuService

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    String viewDomain(Model model, @PathVariable String name) {
        if(!qemuService.connected)
            return "redirect:/qemu"
        def qemu = qemuService.conn
        def domain = qemu.domainLookupByName name
        model.addAllAttributes([host: qemu.getURI(), domain: domain])
        "qemu/domain/domain"
    }
}
