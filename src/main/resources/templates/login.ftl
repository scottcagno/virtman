<!DOCTYPE html>
<html lang="en">
<head id="head">
	<title>Login Page</title>
	<#include "stubs/header.ftl"/>
</head>
<body id="body">

<!-- content -->
<section id="login" class="pad-top wow fadeInDown">
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4 col-sm-4 col-sm-offset-4 col-xs-10 col-xs-offset-1">
                <#if RequestParameters.error??>
                    <div id="alert">
                        <div class="alert alert-danger alert-dismissable">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            Sorry, your login credentials are incorrect.
                        </div>
                    </div>
                </#if>
                <h2 class="text-muted">Login</h2>
                <form role="form" method="post" action="/login">
                    <div class="form-group">
                        <input type="text" name="username" class="form-control" placeholder="Username" autofocus="true" required="true"/>
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" placeholder="Password" required="true"/>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button class="btn btn-md btn-block btn-primary" type="submit">Login</button>
                </form>
            </div>
        </div>
    </div>
</section>
<!-- content -->

<!-- scripts -->
<#include "stubs/scripts.ftl"/>
<!-- scripts -->

<!-- footer -->
<#include "stubs/footer.ftl"/>
<!-- footer -->

</body>
</html>
