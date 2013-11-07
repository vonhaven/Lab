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
            <div class="lab box">
                <div class="line">
                    <div class="filler">${ingredients[0].name}</div>
                    <div class="filler"></div>
                    <div class="filler">${ingredients[1].name}</div>
                </div>
                <div class="line">
                    <div class="filler">
                        <g:each in="${0..3}">
                            <div class="slot">${ingredients[0].effects[0]}</div> 
                        </g:each>
                    </div>
                    <div class="filler"></div>
                    <div class="filler">
                        <g:each in="${0..3}">
                            <div class="slot">${ingredients[1].effects}</div> 
                        </g:each>
                    </div>
                </div>
                <div class="line">
                    <div class="bigslot">${ingredients[0].code}</div> 
                    <div class="bigslot">${ingredients[1].code}</div> 
                </div>
                <div class="line">
                    <div class="bigslot">${ingredients[2].code}</div> 
                    <div class="bigslot">${ingredients[3].code}</div> 
                </div>
                <div class="line">
                    <div class="filler">
                        <g:each in="${0..3}">
                            <div class="slot">${ingredients[2].effects}</div> 
                        </g:each>
                    </div>
                    <div class="filler"></div>
                    <div class="filler">
                        <g:each in="${0..3}">
                            <div class="slot">${ingredients[3].effects}</div> 
                        </g:each>
                    </div>
                </div>
                <div class="line">
                    <div class="filler">${ingredients[2].name}</div>
                    <div class="filler"></div>
                    <div class="filler">${ingredients[3].name}</div>
                </div>
            </div>
        </div>
	</body>
</html>
