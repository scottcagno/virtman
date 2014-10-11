package com.cagnosolutions.starter.app.qemu

import groovy.transform.CompileStatic
import org.libvirt.Connect
import org.springframework.stereotype.Service

/**
 * Created by Scott Cagno.
 * Copyright Cagno Solutions. All rights reserved.
 */

@CompileStatic
@Service(value = "qemuService")
class QEMUService {

    Connect conn = null

    boolean connect(String host) {
        try {
            conn = new Connect(host)
        } catch(ignored) {
            return false
        }
        true
    }

    def disconnect() {
        !conn.connected ?: conn.close()
        conn = null
    }

    boolean isConnected() {
        (conn != null) ? conn.connected : false
    }


}
