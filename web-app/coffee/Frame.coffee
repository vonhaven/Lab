#
class Frame
    canvas: null
    context: null
    x: null
    y: null
  
    constructor: ->
        @canvas = document.getElementById "oneToFour"
        @context = @canvas.getContext '2d'
        @x = @canvas.width
        @y = @canvas.height
        @drawLegs()

    drawLegs: ->
        r = Math.PI * 2
        @context.strokeStyle = "#aaa"
        @context.beginPath()
        @drawLineUp 82
        @drawLineUp 250
        @drawLineUp 417
        @drawLineUp 584
        @drawLineOver 82
        @finishHim()
        @context.closePath()
        @context.stroke()

    drawLineUp: (x) ->
        @context.moveTo x, @y
        @context.lineTo x, @y / 2
        
    drawLineOver: (x) ->
        @context.moveTo x, @y / 2
        @context.lineTo @x - x + 4, @y / 2

    finishHim: ->
        @context.moveTo @x / 2, @y / 2
        @context.lineTo @x / 2, 0

window.Frame = Frame
