(function() {
  var Frame;

  Frame = (function() {

    Frame.prototype.canvas = null;

    Frame.prototype.context = null;

    Frame.prototype.x = null;

    Frame.prototype.y = null;

    function Frame() {
      this.canvas = document.getElementById("oneToFour");
      this.context = this.canvas.getContext('2d');
      this.x = this.canvas.width;
      this.y = this.canvas.height;
      this.drawLegs();
    }

    Frame.prototype.drawLegs = function() {
      var r;
      r = Math.PI * 2;
      this.context.strokeStyle = "#aaa";
      this.context.beginPath();
      this.drawLineUp(82);
      this.drawLineUp(250);
      this.drawLineUp(417);
      this.drawLineUp(584);
      this.drawLineOver(82);
      this.finishHim();
      this.context.closePath();
      return this.context.stroke();
    };

    Frame.prototype.drawLineUp = function(x) {
      this.context.moveTo(x, this.y);
      return this.context.lineTo(x, this.y / 2);
    };

    Frame.prototype.drawLineOver = function(x) {
      this.context.moveTo(x, this.y / 2);
      return this.context.lineTo(this.x - x + 4, this.y / 2);
    };

    Frame.prototype.finishHim = function() {
      this.context.moveTo(this.x / 2, this.y / 2);
      return this.context.lineTo(this.x / 2, 0);
    };

    return Frame;

  })();

  window.Frame = Frame;

}).call(this);
