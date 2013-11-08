<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>
            Alchemy Box
        </title>
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'lab.css')}" type="text/css">
    </head>
    <body>
        <div class="content">
            <g:each in="${reagents}" var="reagent">
                <div>
                    ${reagent.name}
                </div>
                <canvas id="biasMap" width="120" height="120"></canvas>
                <g:javascript src="Bias.js"/>
                <script type="text/JavaScript">
                    var bias = new Bias("${reagent.bias.toString.replace(' ','')}"));
                </script>
            </g:each>
        </div>
    </body>
</html>
