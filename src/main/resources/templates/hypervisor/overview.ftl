<!DOCTYPE html>
<html lang="en">
<head id="head">
	<title>Overview</title>
	<#include "../stubs/header.ftl"/>
</head>
<body id="body">
<#include "../stubs/hypervisor-nav.ftl"/>

<!-- content -->
<section id="overview" class="wow fadeInDown">
    <div class="container">
        <div class="col-sm-6 col-sm-offset-3">
            <h4 class="text-muted"><i class="fa fa-tachometer"></i> Overview</h4>
            <div class="panel panel-default">
                <table class="table table-striped">
                    <tbody>
                        <tr>
                            <td>Hostname</td>
                            <td>${(overview.name)!}</td>
                        </tr>
                        <tr>
                            <td>Hypervisor</td>
                            <td>${(overview.visor)!}</td>
                        </tr>
                        <tr>
                            <td>Memory (GB)</td>
                            <td>${(overview.ram)!}</td>
                        </tr>
                        <tr>
                            <td>Logical CPU's</td>
                            <td>${(overview.cpu)!}</td>
                        </tr>
                        <tr>
                            <td>Architecture</td>
                            <td>${(overview.arch)!}</td>
                        </tr>
                        <tr>
                            <td>Domains</td>
                            <td>${(overview.doms)!}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>
<!-- content -->

<!-- scripts -->
<#include "../stubs/scripts.ftl"/>
<script>$('#overview').addClass('active');</script>
<!-- scripts -->

<!-- footer -->
<#include "../stubs/footer.ftl"/>
<!-- footer -->

</body>
</html>
