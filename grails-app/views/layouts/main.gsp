<!DOCTYPE html>
<html>
	<head>
		<title><g:layoutTitle default="Alchemy Lab"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
		<g:layoutHead/>
		<r:layoutResources/>
	</head>
	<body>
        <div class="main">
            <div class="title">
                Alchemy Lab
                <a class="subtitle">
                    by Vonhaven
                </a>
                <div class="favorites">
                    <a href="home">
                        home
                    <a/> |
                    <a href="lab">
                        lab
                    <a/> |
                    <a href="reagents">
                        reagents
                    <a/>
                </div>
                <!--div class="pagetitle">
                    &lt;<g:layoutTitle/>/&gt;
                </div-->
            </div>
            <g:layoutBody/>
            <g:javascript library="application"/>
            <r:layoutResources/>
        </div>
	</body>
</html>
