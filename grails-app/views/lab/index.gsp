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
            <div class="line">
                <div class="filler">${ingredients[0].name}</div>
                <div class="filler"></div>
                <div class="filler">${ingredients[1].name}</div>
            </div>
            <div class="line">
                <div class="filler">
                    <div class="slot" style="background-image:url(${resource(dir: 'icons/effects', file: ingredients[0].e4.name.toLowerCase() + '.png')})"></div> 
                    <div class="slot" style="background-image:url(${resource(dir: 'icons/effects', file: ingredients[0].e3.name.toLowerCase() + '.png')})"></div> 
                    <div class="slot" style="background-image:url(${resource(dir: 'icons/effects', file: ingredients[0].e2.name.toLowerCase() + '.png')})"></div> 
                    <div class="slot" style="background-image:url(${resource(dir: 'icons/effects', file: ingredients[0].e1.name.toLowerCase() + '.png')})"></div> 
                </div>
                <div class="filler"></div>
                <div class="filler">
                    <div class="slot" style="background-image:url(${resource(dir: 'icons/effects', file: ingredients[1].e1.name.toLowerCase() + '.png')})"></div> 
                    <div class="slot" style="background-image:url(${resource(dir: 'icons/effects', file: ingredients[1].e2.name.toLowerCase() + '.png')})"></div> 
                    <div class="slot" style="background-image:url(${resource(dir: 'icons/effects', file: ingredients[1].e3.name.toLowerCase() + '.png')})"></div> 
                    <div class="slot" style="background-image:url(${resource(dir: 'icons/effects', file: ingredients[1].e4.name.toLowerCase() + '.png')})"></div> 
                </div>
            </div>
            <div class="line">
                <div class="bigslot" style="background-image:url(${resource(dir: 'icons/reagents', file: ingredients[0].name.toLowerCase() + '.png')})"></div> 
                <div class="bigslot" style="background-image:url(${resource(dir: 'icons/reagents', file: ingredients[1].name.toLowerCase() + '.png')})"></div> 
            </div>
            <div class="line">
                <div class="bigslot" style="background-image:url(${resource(dir: 'icons/reagents', file: ingredients[2].name.toLowerCase() + '.png')})"></div> 
                <div class="bigslot" style="background-image:url(${resource(dir: 'icons/reagents', file: ingredients[3].name.toLowerCase() + '.png')})"></div> 
            </div>
            <div class="line">
                <div class="filler">
                    <div class="slot" style="background-image:url(${resource(dir: 'icons/effects', file: ingredients[2].e4.name.toLowerCase() + '.png')})"></div> 
                    <div class="slot" style="background-image:url(${resource(dir: 'icons/effects', file: ingredients[2].e3.name.toLowerCase() + '.png')})"></div> 
                    <div class="slot" style="background-image:url(${resource(dir: 'icons/effects', file: ingredients[2].e2.name.toLowerCase() + '.png')})"></div> 
                    <div class="slot" style="background-image:url(${resource(dir: 'icons/effects', file: ingredients[2].e1.name.toLowerCase() + '.png')})"></div> 
                </div>
                <div class="filler"></div>
                <div class="filler">
                    <div class="slot" style="background-image:url(${resource(dir: 'icons/effects', file: ingredients[3].e1.name.toLowerCase() + '.png')})"></div> 
                    <div class="slot" style="background-image:url(${resource(dir: 'icons/effects', file: ingredients[3].e2.name.toLowerCase() + '.png')})"></div> 
                    <div class="slot" style="background-image:url(${resource(dir: 'icons/effects', file: ingredients[3].e3.name.toLowerCase() + '.png')})"></div> 
                    <div class="slot" style="background-image:url(${resource(dir: 'icons/effects', file: ingredients[3].e4.name.toLowerCase() + '.png')})"></div> 
                </div>
            </div>
            <div class="line">
                <div class="filler">${ingredients[2].name}</div>
                <div class="filler"></div>
                <div class="filler">${ingredients[3].name}</div>
            </div>
        </div>
    </body>
</html>
