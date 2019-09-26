"use strict";

// 回顶按钮的显示与隐藏、回顶功能
let scrollTopBtn = document.getElementById("scrollTop");

scrollTopBtn.onclick = function () {
  window.scrollTo(0, 0)
};
window.onscroll = function () {
  if (document.documentElement.scrollTop + document.body.scrollTop > 50) {
    scrollTopBtn.classList.remove("mdui-fab-hide");
    scrollTopBtn.classList.remove("mdui-hidden");
  } else {
    scrollTopBtn.classList.add("mdui-fab-hide");
  }
};

// 一言 api
let hitokoto = '一言', author = '点击可复制';
let hitokoto_ = '', author_ = '';
let btn = document.getElementById("hitokoto");
btn.onmouseenter = function () {
  fetch("https://v1.hitokoto.cn/")
    .then(data => data.json())
    .then(data => {
      hitokoto_ = hitokoto;
      author_ = author;
      hitokoto = data.hitokoto;
      author = data.from;
    });
  btn.setAttribute("mdui-tooltip", "{content: '" + hitokoto + "  ---- " + author + "', position: 'left'}");
};
btn.onclick = function () {
  const input = document.createElement('input');
  input.style.opacity = '0';
  input.style.display = 'absolute';
  document.body.appendChild(input);
  input.value = hitokoto_ + "  ----  " + author_;

  input.select();
  document.execCommand('copy');
  document.body.removeChild(input);

  mdui.snackbar({
    message: '复制成功',
    position: 'right-top'
  });
};
