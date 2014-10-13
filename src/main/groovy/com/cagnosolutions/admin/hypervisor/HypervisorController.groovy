package com.cagnosolutions.admin.hypervisor
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
/**
 * Created by Scott Cagno.
 * Copyright Cagno Solutions. All rights reserved.
 */

@CompileStatic
@Controller
@RequestMapping(value = "/hypervisor")
class HypervisorController {

    @Autowired
    HypervisorService visor

    @RequestMapping(method = RequestMethod.GET)
    String hypervisor() {
        "hypervisor/hypervisor"
    }

    @RequestMapping(value = "/connect", method = RequestMethod.POST)
    String connectToHost(String host) {
        def connected = visor.connect(host)
        if(!connected)
            return "redirect:/hypervisor"
        "redirect:/hypervisor/overview"
    }

    @RequestMapping(value = "/disconnect", method = RequestMethod.GET)
    String disconnectAndLogout() {
        visor.disconnect()
        "redirect:/logout"
    }

    @RequestMapping(value = "/overview", method = RequestMethod.GET)
    String hypervisorOverview(Model model) {
        def overview = visor.getVisorOverview()
        if(overview == null) return "redirect:/hypervisor"
        model.addAllAttributes([host: visor.getHost(), overview: overview])
        "hypervisor/overview"
    }

    @RequestMapping(value = "/network", method = RequestMethod.GET)
    String networkOverview(Model model) {
        def networkList = visor.getNetworkOverview()
        if(networkList == null) return "redirect:/hypervisor"
        model.addAllAttributes([host: visor.getHost(), networkList: networkList])
        "hypervisor/network-list"
    }

    @RequestMapping(value = "/storage", method = RequestMethod.GET)
    String storageOverview(Model model) {
        def storageList = visor.getStorageOverview()
        if(storageList == null) return "redirect:/hypervisor"
        model.addAllAttributes([host: visor.getHost(), storageList: storageList])
        "hypervisor/storage-list"
    }

    @RequestMapping(value = "/domain", method = RequestMethod.GET)
    String domainOverview(Model model) {
        def domainList = visor.getDomainOverview()
        if(domainList == null) return "redirect:/hypervisor"
        model.addAllAttributes([host: visor.getHost(), domainList: domainList])
        "hypervisor/domain-list"
    }
}