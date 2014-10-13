<!DOCTYPE html>
<html lang="en">
<head id="head">
	<title>QEMU Home</title>
	<#include "../stubs/header.ftl"/>
</head>
<body id="body">

<!-- navbar -->
<div id="navbar" class="navbar navbar-default navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">VirtMan</a>
        </div>
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="/hypervisor/disconnect">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<#if alertError??>
    <div id="alert" class="col-sm-10 col-sm-offset-1">
        <div class="alert alert-danger alert-dismissable">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
        ${alertError}
        </div>
    </div>
<#elseif alertSuccess??>
    <div id="alert" class="col-sm-10 col-sm-offset-1">
        <div class="alert alert-success alert-dismissable">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
        ${alertSuccess}
        </div>
    </div>
</#if>
<!-- navbar -->

<!-- content -->
<section id="qemu" class="wow fadeInDown">
    <div class="container">
        <div class="col-sm-6 col-sm-offset-3">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Connect to QEMU Host
                </div>
                <div class="panel-body">
                    <form role="form" method="post" action="/hypervisor/connect">
                        <div class="form-group">
                            <input type="text" name="host" class="form-control" placeholder="Host URI" required="true"/>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <button class="btn btn-md btn-primary btn-block" type="submit">Connect</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- content -->

<!-- scripts -->
<#include "../stubs/scripts.ftl"/>
<script>$('#qemu').addClass('active');</script>
<!-- scripts -->


<!-- footer -->
<#include "../stubs/footer.ftl"/>
<!-- footer -->

</body>
</html>
