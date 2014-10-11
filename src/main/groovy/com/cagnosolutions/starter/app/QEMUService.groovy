package com.cagnosolutions.starter.app
import groovy.transform.CompileStatic
import org.libvirt.Connect
import org.libvirt.Domain
import org.libvirt.DomainInfo
import org.springframework.stereotype.Service
/**
 * Created by Scott Cagno.
 * Copyright Cagno Solutions. All rights reserved.
 */

@CompileStatic
@Service(value = "qemuService")
class QEMUService {

    VirtualMachine getVM(Connect conn, String name) {
        def vm = new VirtualMachine()
        def dom = conn.domainLookupByName name
        vm.id = dom.getID()
        vm.name = name
        vm.running = dom.info.state.equals DomainInfo.DomainState.VIR_DOMAIN_RUNNING
        vm.uuid = dom.getUUIDString()
        vm.cpu = dom.getMaxVcpus()
        vm.ram = dom.getMaxMemory()/1024L as long
        vm
    }

    Domain getDomain(Connect conn, String name) {
        conn.domainLookupByName name
    }

}
