package com.cagnosolutions.starter.app
import groovy.transform.CompileStatic
import org.libvirt.Connect
import org.libvirt.Domain
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
/**
 * Created by Scott Cagno.
 * Copyright Cagno Solutions. All rights reserved.
 */

@CompileStatic
@Controller
@RequestMapping(value = "/qemu")
class QEMUController {

    @Autowired
    QEMUService qemuService

    Connect conn = new Connect("qemu:///system")

    @RequestMapping(value = "/host", method = RequestMethod.GET)
    @ResponseBody
    Map getHost() {
        def host = [:]
        host.name = conn.getHostName()
        host.type = conn.getType()
        host
    }

    @RequestMapping(value = "/vm/{name}", method = RequestMethod.GET)
    @ResponseBody
    VirtualMachine getVM(@PathVariable String name) {
        qemuService.getVM conn, name
    }

    @RequestMapping(value = "/domain/{name}", method = RequestMethod.GET)
    @ResponseBody
    Domain getDomain(@PathVariable String name) {
        qemuService.getDomain conn, name
    }

}
