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
            <g:each in="${ingredients}" var="reagent">
                <span>
                    <div>
                        <div class="reagentTitle">
                            ${reagent.name}
                        </div>
                        <canvas class="biasMap" id="bias-${reagent.code}" width="120" height="120"></canvas> 
                        <g:javascript src="Bias.js"/>
                        <script type="text/JavaScript">
                            var bias = new Bias(${reagent.code}, ${reagent.bias});
                        </script>
                    </div>
                    <g:each in="${[reagent.e1, reagent.e2, reagent.e3, reagent.e4]}" var="r">
                        <div class="line">
                            <span class="slot" style="background-image:url(${resource(dir: 'icons/effects', file: r.code + '.png')})"></span>
                            <span class="slotText">${r.name}</span>
                        </div>
                    </g:each>
                </span>
            </g:each>
        </div>
    </body>
</html>
