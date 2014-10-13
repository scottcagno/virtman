<!DOCTYPE html>
<html lang="en">
<head id="head">
	<title>Error</title>
	<#include "stubs/header.ftl"/>
</head>
<body>
<#include "stubs/default-navbar.ftl"/>

<!-- content -->
<section id="error" class="wow fadeInDownBig">
    <div class="container">
        <div class="jumbotron">
            <div class="text-center">
                <h2>Aw, you messed up. <small>${(exception)!'An unknown error has occoured.'}</small></h2>
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
