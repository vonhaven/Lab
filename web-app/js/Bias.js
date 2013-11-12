(function() {
  var Bias;

  Bias = (function() {

    Bias.prototype.path = null;

    Bias.prototype.canvas = null;

    Bias.prototype.context = null;

    Bias.prototype.colors = ["#cce", "#eec", "#ecc", "#cec", "#ece", "#ccc", "#eee", "#cee"];

    Bias.prototype.lo = null;

    Bias.prototype.md = null;

    Bias.prototype.hi = null;

    Bias.prototype.x = null;

    Bias.prototype.y = null;

    function Bias(id, levels) {
      var biases, i;
      this.canvas = document.getElementById("bias-" + id);
      this.context = this.canvas.getContext('2d');
      this.x = this.canvas.width / 2;
      this.y = this.canvas.height / 2;
      this.lo = this.y * 6 / 13;
      this.md = this.y * 9 / 13;
      this.hi = this.y * 12 / 13;
      this.drawFrame();
      if (levels) {
        biases = [levels % 4, Math.floor(levels / 4) % 4, Math.floor(levels / 16) % 4, Math.floor(levels / 64) % 4, Math.floor(levels / 256) % 4, Math.floor(levels / 1024) % 4, Math.floor(levels / 4096) % 4, Math.floor(levels / 16384) % 4];
      }
      for (i = 0; i <= 7; i++) {
        this.drawSlice(this.canvas.width / 2, this.canvas.height / 2, i, biases[i]);
      }
    }

    Bias.prototype.drawFrame = function() {
      var r;
      r = Math.PI * 2;
      this.context.strokeStyle = "#aaa";
      this.context.beginPath();
      this.context.arc(this.x, this.y, this.hi, 0, r);
      this.context.closePath();
      this.context.stroke();
      this.context.beginPath();
      this.context.arc(this.x, this.y, this.md, 0, r);
      this.context.closePath();
      this.context.stroke();
      this.context.beginPath();
      this.context.arc(this.x, this.y, this.lo, 0, r);
      this.context.closePath();
      return this.context.stroke();
    };

    Bias.prototype.drawSlice = function(x, y, i, m) {
      var level, o, p;
      p = 0.25 * Math.PI;
      o = 0.125 * Math.PI;
      switch (m) {
        case 1:
          level = this.lo;
          break;
        case 2:
          level = this.md;
          break;
        case 3:
          level = this.hi;
          break;
        default:
          return 1;
      }
      this.context.fillStyle = this.colors[i % this.colors.length];
      this.context.strokeStyle = "#888";
      this.context.beginPath();
      this.context.arc(this.x, this.y, level, p * i + o, p * (i + 1) + o);
      this.context.lineTo(this.canvas.width / 2, this.canvas.height / 2);
      this.context.closePath();
      this.context.fill();
      return this.context.stroke();
    };

    Bias.prototype.drawLine = function(x1, x2, y1, y2) {
      this.context.strokeStyle = "#bbb";
      this.context.moveTo(x1, y1);
      this.context.lineTo(x2, y2);
      return this.context.stroke();
    };

    return Bias;

  })();

  window.Bias = Bias;

}).call(this);
