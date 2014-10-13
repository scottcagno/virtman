<!DOCTYPE html>
<html lang="en">
<head id="head">
	<title>Storage</title>
	<#include "../stubs/header.ftl"/>
</head>
<body id="body">
<#include "../stubs/hypervisor-nav.ftl"/>

<!-- content -->
<section id="storage-list" class="wow fadeInDown">
    <div class="container">
        <div class="col-sm-6 col-sm-offset-3">
            <h4 class="text-muted"><i class="fa fa-database"></i> Storage List</h4>
            <div class="panel panel-default">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Volume</th>
                        <th>Size</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#if storageList?has_content>
                        <#list storageList as dev>
                        <tr>
                            <td>${(dev.name)!}</td>
                            <td>${(dev.volume)!}</td>
                            <td>${(dev.size + "GB")!}</td>
                        </tr>
                        </#list>
                    <#else>
                        <tr class="text-center">No Storage Devices</tr>
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
<script>$('#storage-list').addClass('active');</script>
<!-- scripts -->

<!-- footer -->
<#include "../stubs/footer.ftl"/>
<!-- footer -->

</body>
</html>
