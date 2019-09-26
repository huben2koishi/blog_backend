particlesJS('particles-js',

  {
    "particles": {
      "number": {
        // 粒子数量
        "value": 80,
        // 密度
        "density": {
          "enable": true,
          "value_area": 800
        }
      },
      "color": {
        // 粒子颜色 可指定 hex rgb hsl 的颜色值或者随机(random) 数组
        "value": "#ccc"
      },
      "shape": {
        // 形状 可为 "circle" "edge" "triangle" "polygon" "star" "image" 数组
        "type": "circle",
        "stroke": {
          "width": 0,
          "color": "#000000"
        },
        // 多边形的边数
        "polygon": {
          "nb_sides": 5
        },
        // 图片的属性
        "image": {
          "src": "img/github.svg",
          "width": 100,
          "height": 100
        }
      },
      "opacity": {
        // 不透明度 0-1
        "value": 0.5,
        "random": false,
        "anim": {
          "enable": false,
          "speed": 1,
          "opacity_min": 0.1,
          "sync": false
        }
      },
      "size": {
        // 粒子大小
        "value": 5,
        "random": true,
        "anim": {
          "enable": false,
          "speed": 40,
          "size_min": 0.1,
          "sync": false
        }
      },
      "line_linked": {
        // 粒子间连线
        "enable": true,
        "distance": 150,
        "color": "#ddd",
        "opacity": 0.4,
        "width": 2
      },
      "move": {
        // 粒子移动属性
        "enable": true,
        "speed": 3,
        // 移动朝向 可为 "none" "top" "top-right" "right" "bottom-right" "bottom" "bottom-left" "left" "top-left"
        "direction": "none",
        "random": false,
        "straight": false,
        // 粒子是否飞出屏幕 "out" "bounce"
        "out_mode": "out",
        // 粒子间吸引
        "attract": {
          "enable": false,
          "rotateX": 600,
          "rotateY": 1200
        }
      }
    },
    "interactivity": {
      // 互动 "canvas" "window"
      "detect_on": "window",
      "events": {
        // 鼠标悬停
        "onhover": {
          "enable": false,
          // 模式 可为 "grab" "bubble" "repulse" 数组
          "mode": "grab"
        },
        // 鼠标点击
        "onclick": {
          "enable": false,
          // 模式 可为 "push" "remove" "bubble" "repulse" 数组
          "mode": "push"
        },
        "resize": true
      },
      "modes": {
        "grab": {
          "distance": 150,
          "line_linked": {
            "opacity": 1
          }
        },
        "bubble": {
          "distance": 150,
          "size": 10,
          "duration": 2,
          "opacity": 8,
          "speed": 3
        },
        "repulse": {
          "distance": 200
        },
        "push": {
          "particles_nb": 4
        },
        "remove": {
          "particles_nb": 2
        }
      }
    },
    // 视网膜检测
    "retina_detect": true,
  }
);
