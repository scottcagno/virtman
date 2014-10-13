package com.cagnosolutions.admin.hypervisor

import groovy.transform.CompileStatic
import org.libvirt.Connect
import org.springframework.stereotype.Service

/**
 * Created by Scott Cagno.
 * Copyright Cagno Solutions. All rights reserved.
 */

@CompileStatic
@Service(value = "visor")
class HypervisorService {

    Connect conn = null

    boolean connect(String host) {
        conn = new Connect(host)
        conn.connected
    }

    def disconnect() {
        if(conn != null && conn.connected) {
            conn.close()
            conn = null
        }
    }



    /*
     * * * HYPERVISOR OVERVIEW METHODS
     */

    String getHost() {
        conn.getURI()
    }

    Map getVisorOverview() {
        if(conn == null || !conn.connected)
            return null
        [
            host: conn.getURI(),
            name: conn.getHostName(),
            visor: conn.getType().toLowerCase(),
            ram: conn.nodeInfo().memory/1024/1024 + 1 as int,
            cpu: conn.nodeInfo().cpus,
            arch: conn.nodeInfo().model,
            doms: conn.numOfDomains()
        ]
    }

    List getNetworkOverview() {
        if(conn == null || !conn.connected)
            return null
        def networkList = []
        conn.listNetworks().each { String networkName ->
            def network = conn.networkLookupByName networkName
            networkList << [
                name: networkName,
                device: network.bridgeName,
                state: (network.isActive()==1)
            ]
        }
        networkList
    }

    List getStorageOverview() {
        if(conn == null || !conn.connected)
            return null
        def storageList = []
        conn.listStoragePools().each { String storageName ->
            def dev = conn.storagePoolLookupByName storageName
            dev.listVolumes().each { String volumeName ->
                def vol = dev.storageVolLookupByName volumeName
                storageList << [
                    name: volumeName,
                    volume: vol.path.replace(volumeName,''),
                    size: vol.info.capacity/1024/1024/1024 as int,
                ]
            }
        }
        storageList
    }

    List getDomainOverview() {
        if(conn == null || !conn.connected)
            return null
        def domainList = []
        conn.listDefinedDomains().each { String name ->
            def dom = conn.domainLookupByName name
            domainList << [
                id: dom.getID(),
                name: name,
                state: (dom.isActive() == 1)
            ]
        }
        domainList
    }



    /*
     * * * DOMAIN LEVEL CALLS
     */

    Map getDomainByName(String name) {
        if(conn == null || !conn.connected)
            return null
        def domain = conn.domainLookupByName name
        [
            id: domain.getID(),
            name: domain.name,
            uuid: domain.UUIDString,
            memory: domain.info.memory/1024 as int,
            vcpu: domain.info.nrVirtCpu,
            autostart: domain.autostart
        ]
    }
}
