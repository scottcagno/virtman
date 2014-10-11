package com.cagnosolutions.starter.app.qemu
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
@RequestMapping(value = "/qemu")
class HostController {

    @Autowired
    QEMUService qemuService

    @RequestMapping(method = RequestMethod.GET)
    String qemu() {
        "qemu/qemu"
    }

    @RequestMapping(value = "/connect", method = RequestMethod.POST)
    String connectToHost(String host) {
        def connected = qemuService.connect(host)
        if(!connected)
            return "redirect:/qemu"
        "redirect:/qemu/overview"
    }

    @RequestMapping(value = "/disconnect", method = RequestMethod.GET)
    String disconnectAndLogout() {
        qemuService.disconnect()
        "redirect:/logout"
    }

    @RequestMapping(value = "/overview", method = RequestMethod.GET)
    String qemuOverview(Model model) {
        if(!qemuService.connected)
            return "redirect:/qemu"
        def qemu = qemuService.conn
        def overview = [
                name: qemu.getHostName(),
                visor: qemu.getType().toLowerCase(),
                ram: qemu.nodeInfo().memory/1024/1024 + 1 as int,
                cpu: qemu.nodeInfo().cpus,
                arch: qemu.nodeInfo().model,
                doms: qemu.numOfDefinedDomains()
        ]
        model.addAllAttributes([host: qemu.getURI(),overview: overview])
        "qemu/overview"
    }

    @RequestMapping(value = "/networks", method = RequestMethod.GET)
    String qemuNetworks(Model model) {
        if(!qemuService.isConnected())
            return "redirect:/qemu"
        def qemu = qemuService.conn
        def networks = []
        qemu.listNetworks().each { String name ->
            def net = qemu.networkLookupByName name
            networks << [
                    name: name,
                    device: net.bridgeName,
                    state: (net.isActive()==1)
            ]
        }
        model.addAllAttributes([host: qemu.getURI(), networks: networks])
        "qemu/networks"
    }

    @RequestMapping(value = "/storage", method = RequestMethod.GET)
    String qemuStorage(Model model) {
        if(!qemuService.isConnected())
            return "redirect:/qemu"
        def qemu = qemuService.conn
        def storage = []
        qemu.listStoragePools().each { String name ->
            def dev = qemu.storagePoolLookupByName name
            dev.listVolumes().each { String volume ->
                def vol = dev.storageVolLookupByName volume
                storage << [
                    name: volume,
                    volume: vol.path.replace(volume,''),
                    size: vol.info.capacity/1024/1024/1024 as int,
                ]
            }
        }
        model.addAllAttributes([host: qemu.getURI(), storage: storage])
        "qemu/storage"
    }

    @RequestMapping(value = "/domains", method = RequestMethod.GET)
    String qemuDomains(Model model) {
        if(!qemuService.isConnected())
            return "redirect:/qemu"
        def qemu = qemuService.conn
        def domains = []
        qemu.listDefinedDomains().each { String name ->
            def dom = qemu.domainLookupByName name
            domains << [
                    id: dom.getID(),
                    name: name,
                    state: (dom.isActive() == 1)
            ]
        }
        model.addAllAttributes([host: qemu.getURI(), domains: domains])
        "qemu/domains"
    }
}