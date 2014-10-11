<!DOCTYPE html>
<html lang="en">
<head id="head">
	<title>Networks</title>
	<#include "../stubs/header.ftl"/>
</head>
<body id="body">
<#include "navbar.ftl"/>

<!-- content -->
<section id="networks" class="wow fadeInDown">
    <div class="container">
        <div class="col-sm-6 col-sm-offset-3">
            <h4 class="text-muted"><i class="fa fa-cloud"></i> Networks</h4>
            <div class="panel panel-default">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Device</th>
                            <th>State</th>
                        </tr>
                    </thead>
                    <tbody>
                        <#if networks?has_content>
                            <#list networks as net>
                                <tr>
                                    <td>${(net.name)!}</td>
                                    <td>${(net.device)!}</td>
                                    <td>
                                        <#if net.state == true>
                                            <span class="label label-success">Active</span>
                                        <#else>
                                            <span class="label label-danger">Inactive</span>
                                        </#if>
                                    </td>
                                </tr>
                            </#list>
                        <#else>
                            <tr class="text-center">No network devies</tr>
                        </#if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>
<!-- content -->

<!-- scripts -->
<#include "../stubs/scripts.ftl"/>
<script>$('#networks').addClass('active');</script>
<!-- scripts -->

<!-- footer -->
<#include "../stubs/footer.ftl"/>
<!-- footer -->

</body>
</html>
