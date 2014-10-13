package com.cagnosolutions.admin.hypervisor.domain

import com.cagnosolutions.admin.hypervisor.HypervisorService
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
class DomainController {

    @Autowired
    HypervisorService visor

    @RequestMapping(value = "/hypervisor/domain/{name}", method = RequestMethod.GET)
    String viewDomain(Model model, @PathVariable String name) {
        def domain = visor.getDomainByName name
        if(domain == null) return "redirect:/hypervisor"
        model.addAllAttributes([host: visor.getHost(), domain: domain])
        "hypervisor/domain/view"
    }
}
