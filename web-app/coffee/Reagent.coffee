#Reagent metadata and bias visualization object
class Reagent
    canvas: null
    context: null
    colors: ["#cce","#eec","#ecc","#cec","#ece","#ccc","#eee","#cee"]
    lo: null
    md: null
    hi: null
    x: null
    y: null
  
    constructor: (id, levels, weight, value) ->
        @canvas = document.getElementById "bias-#{id}"
        @context = @canvas.getContext '2d'
        @x = @canvas.width / 2
        @y = @canvas.height / 2
        @lo = @y * 6 / 13
        @md = @y * 9 / 13
        @hi = @y * 12 / 13
        @drawFrame()
        if levels
            biases = [
                levels % 4,
                Math.floor(levels / 4) % 4,
                Math.floor(levels / 16) % 4,
                Math.floor(levels / 64) % 4,
                Math.floor(levels / 256) % 4,
                Math.floor(levels / 1024) % 4,
                Math.floor(levels / 4096) % 4,
                Math.floor(levels / 16384) % 4
            ]
        for i in [0..7]
            @drawSlice @canvas.width / 2, @canvas.height / 2, i, biases[i]
        @drawMetaData weight, value

    drawFrame: ->
        r = Math.PI * 2
        @context.strokeStyle = "#aaa"
        @context.beginPath()
        @context.arc @x, @y, @hi, 0, r
        @context.closePath()
        @context.stroke()
        @context.beginPath()
        @context.arc @x, @y, @md, 0, r
        @context.closePath()
        @context.stroke()
        @context.beginPath()
        @context.arc @x, @y, @lo, 0, r
        @context.closePath()
        @context.stroke()

    drawSlice: (x, y, i, m) ->
        p = 0.25 * Math.PI
        o = 0.125 * Math.PI
        switch m
            when 1 then level = @lo
            when 2 then level = @md
            when 3 then level = @hi
            else return 1
        @context.fillStyle = @colors[i % @colors.length]
        @context.strokeStyle = "#888"
        @context.beginPath()
        @context.arc @x, @y, level, p * i + o, p * (i + 1) + o
        @context.lineTo @canvas.width / 2, @canvas.height / 2
        @context.closePath()
        @context.fill()
        @context.stroke()

    drawLine: (x1, x2, y1, y2) ->
        @context.strokeStyle = "#bbb"
        @context.moveTo x1, y1
        @context.lineTo x2, y2
        @context.stroke()

    drawMetaData: (weight, value) ->
        @context.fillStyle = "#777"
        @context.font = "14px Courier New"
        @context.fillText "#{value}", 6, 11
        @context.fillText ".#{weight}", 6, @y * 2

window.Reagent = Reagent
