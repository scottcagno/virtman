<!DOCTYPE html>
<html lang="en">
<head id="head">
    <title>${domain.name!}</title>
<#include "../../stubs/header.ftl"/>
</head>
<body id="body">
<#include "../../stubs/domain-nav.ftl"/>

<!-- content -->
<section id="domain" class="wow fadeInDown">
    <div class="container">
        <div class="col-sm-6 col-sm-offset-3">
            <#if domain?has_content>
                Id : ${domain.id} <br/>
                Name : ${domain.name} <br/>
                UUID : ${domain.uuid} <br/>
                Memory : ${domain.memory?c + " MB"} <br/>
                vCPU : ${domain.vcpu} <br/>
                Autostart : ${domain.autostart?c} <br/>
            </#if>
            <#--
            <h4 class="text-muted"><i class="fa fa-cube"></i> ${(domain.name)!}</h4>
            <div class="panel panel-default">
                <table class="table table-striped">
                    <tbody>
                        <tr>
                            <td>Id</td>
                            <td>
                                <#if domain.getID() == -1>
                                    -
                                <#else>
                                    ${domain.getID()}
                                </#if>
                            </td>
                        </tr>
                        <tr>
                            <td>Name</td>
                            <td>${(domain.name)!}</td>
                        </tr>
                        <tr>
                            <td>Status</td>
                            <td>
                                <#if domain.isActive() == 1>
                                    <span class="label label-success">Running</span>
                                <#elseif domain.isActive() == 0>
                                    <span class="label label-danger">Shutoff</span>
                                </#if>
                            </td>
                        </tr>
                        <tr>
                            <td>More</td>
                            <td>stuff will be listed...</td>
                        </tr>
                        <tr>
                            <td colspan="2" class="text-center">
                                <a href="#" class="btn btn-default btn-block">Edit this domain</a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            -->


        </div>
    </div>
</section>
<!-- content -->

<!-- scripts -->
<#include "../../stubs/scripts.ftl"/>
<!-- scripts -->

<!-- footer -->
<#include "../../stubs/footer.ftl"/>
<!-- footer -->

</body>
</html>
