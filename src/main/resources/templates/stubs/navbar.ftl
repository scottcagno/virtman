<div id="navbar" class="navbar navbar-default navbar-static-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/">QEMU Manager</a>
		</div>
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav navbar-right">
                <li class="active">
                    <a href="/qemu/overview"><i class="fa fa-tachometer"></i> Overview</a>
                </li>
                <li>
                    <a href="/qemu/networks"><i class="fa fa-cloud"></i> Networks</a>
                </li>
                <li>
                    <a href="/qemu/storage"><i class="fa fa-database"></i> Storage</a>
                </li>
                <li>
                    <a href="/qemu/domains"><i class="fa fa-cubes"></i> Domains</a>
                </li>
                <li>
                    <a href="/logout">
                        <i class="fa fa-lock"></i> Logout
                    </a>
                </li>
			</ul>
		</div>
	</div>
</div>

<#if alert??>
	<div id="alert" class="col-sm-10 col-sm-offset-1">
		<div class="alert alert-info alert-dismissable">
			<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
			${alert}
		</div>
	</div>
<#elseif alertError??/>
	<div id="alert" class="col-sm-10 col-sm-offset-1">
		<div class="alert alert-danger alert-dismissable">
			<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
			${alertError}
		</div>
	</div>
<#elseif alertSuccess??/>
	<div id="alert" class="col-sm-10 col-sm-offset-1">
		<div class="alert alert-success alert-dismissable">
			<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
			${alertSuccess}
		</div>
	</div>
</#if>