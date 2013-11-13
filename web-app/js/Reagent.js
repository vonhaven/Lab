(function() {
  var Reagent;

  Reagent = (function() {

    Reagent.prototype.canvas = null;

    Reagent.prototype.context = null;

    Reagent.prototype.colors = ["#cce", "#eec", "#ecc", "#cec", "#ece", "#ccc", "#eee", "#cee"];

    Reagent.prototype.lo = null;

    Reagent.prototype.md = null;

    Reagent.prototype.hi = null;

    Reagent.prototype.x = null;

    Reagent.prototype.y = null;

    function Reagent(id, levels, weight, value) {
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
      this.drawMetaData(weight, value);
    }

    Reagent.prototype.drawFrame = function() {
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

    Reagent.prototype.drawSlice = function(x, y, i, m) {
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

    Reagent.prototype.drawLine = function(x1, x2, y1, y2) {
      this.context.strokeStyle = "#bbb";
      this.context.moveTo(x1, y1);
      this.context.lineTo(x2, y2);
      return this.context.stroke();
    };

    Reagent.prototype.drawMetaData = function(weight, value) {
      this.context.fillStyle = "#777";
      this.context.font = "14px Courier New";
      this.context.fillText("" + value, 6, 11);
      return this.context.fillText("." + weight, 6, this.y * 2);
    };

    return Reagent;

  })();

  window.Reagent = Reagent;

}).call(this);
