<!DOCTYPE html>
<html lang="en">
<head id="head">
	<title>Domains</title>
	<#include "../stubs/header.ftl"/>
</head>
<body id="body">
<#include "navbar.ftl"/>

<!-- content -->
<section id="domains" class="wow fadeInDown">
    <div class="container">
        <div class="col-sm-6 col-sm-offset-3">
            <h4 class="text-muted"><i class="fa fa-cube"></i> Domains</h4>
            <div class="panel panel-default">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>State</th>
                        </tr>
                    </thead>
                    <tbody>
                    <#if domains?has_content>
                        <#list domains as dom>
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
                        </tr>
                        </#list>
                    <#else>
                    <tr class="text-center">No domains found</tr>
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
<script>$('#domains').addClass('active');</script>
<!-- scripts -->

<!-- footer -->
<#include "../stubs/footer.ftl"/>
<!-- footer -->

</body>
</html>
