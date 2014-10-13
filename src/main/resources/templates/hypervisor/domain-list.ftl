<!DOCTYPE html>
<html lang="en">
<head id="head">
	<title>Domains</title>
	<#include "../stubs/header.ftl"/>
</head>
<body id="body">
<#include "../stubs/hypervisor-nav.ftl"/>

<!-- content -->
<section id="domain-list" class="wow fadeInDown">
    <div class="container">
        <div class="col-sm-6 col-sm-offset-3">
            <h4 class="text-muted"><i class="fa fa-cube"></i> Domain List</h4>
            <div class="panel panel-default">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>State</th>
                            <th>Details</th>
                        </tr>
                    </thead>
                    <tbody>
                        <#list domainList as dom>
                        <tr>
                            <td>
                                <#if dom.id == -1>
                                    -
                                <#else>
                                    ${dom.id}
                                </#if>
                            </td>
                            <td>${(dom.name)!}</td>
                            <td>
                                <#if dom.state == true>
                                    <span class="label label-success">Running</span>
                                <#else>
                                    <span class="label label-danger">Shutoff</span>
                                </#if>
                            </td>
                            <td>
                                <a href="/hypervisor/domain/${(dom.name)!}">View</a>
                            </td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>
<!-- content -->

<!-- scripts -->
<#include "../stubs/scripts.ftl"/>
<script>$('#domain-list').addClass('active');</script>
<!-- scripts -->

<!-- footer -->
<#include "../stubs/footer.ftl"/>
<!-- footer -->

</body>
</html>
