#TSP visualization service for canvas
class Bias
  path: null
  canvas: null
  context: null
  colors: [
    "#cce",
    "#eec",
    "#ecc",
    "#cec",
    "#ece",
    "#ccc",
    "#eee",
    "#cee"]
  lo: null
  md: null
  hi: null
  x: null
  y: null
  
  constructor: (id, levels) ->
    @canvas = document.getElementById "bias-#{id}"
    @context = @canvas.getContext '2d'
    @x = @canvas.width / 2
    @y = @canvas.height / 2
    @lo = @y * 6 / 13
    @md = @y * 9 / 13
    @hi = @y * 12 / 13
    @drawFrame()
    if levels
      levels = levels.replace("[", "").replace("]", "").replace(/\s+/g, ' ').split ","
      console.log "Biases: #{@levels}"
      for i in [0..7]
        @drawSlice @canvas.width / 2, @canvas.height / 2, i, levels[i]

  drawFrame: ->
    r = Math.PI * 2
    @context.strokeStyle = "#aaa"
    #outermost ring
    #@context.fillStyle = "#e8e8e8"
    @context.beginPath()
    @context.arc @x, @y, @hi, 0, r
    @context.closePath()
    @context.stroke()
    #@context.fill()
    #middle ring
    #@context.fillStyle = "#eaeaea"
    @context.beginPath()
    @context.arc @x, @y, @md, 0, r
    @context.closePath()
    @context.stroke()
    #@context.fill()
    #innermost ring
    #@context.fillStyle = "#efefef"
    @context.beginPath()
    @context.arc @x, @y, @lo, 0, r
    @context.closePath()
    @context.stroke()
    #@context.fill()

  drawSlice: (x, y, i, m) ->
    p = 0.25 * Math.PI
    o = 0.125 * Math.PI
    switch m
      when "LOW" then level = @lo
      when "MEDIUM" then level = @md
      when "HIGH" then level = @hi
      else return 1
    @context.fillStyle = @colors[i % @colors.length]
    @context.strokeStyle = "#888"
    @context.beginPath()
    @context.arc @x, @y, level, p * i + o, p * (i + 1) + o
    @context.lineTo @canvas.width / 2, @canvas.height / 2
    @context.closePath()
    @context.fill()
    @context.stroke()
    #@context.fillStyle= "#555"
    #@context.font = "14px Courier New"
    #@context.fillText "#{i}", x - 4.5, y - 13

  drawLine: (x1, x2, y1, y2) ->
    @context.strokeStyle = "#bbb"
    @context.moveTo x1, y1
    @context.lineTo x2, y2
    @context.stroke()

window.Bias = Bias
