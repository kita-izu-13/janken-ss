"use strict";


//IDの取得
let action1 = document.getElementById("action1");
console.log(action1);
let action2 = document.getElementById("action2");
//console.log(action2);
let action3 = document.getElementById("action3");
//console.log(action3);


//マウスオーバー時
action1.addEventListener("mouseover",function(){
	action1.style.cursor = "url(image/gu.cur),auto";
});
action2.addEventListener("mouseover",function(){
	action2.style.cursor = "url(image/choki.cur),auto";
});
action3.addEventListener("mouseover",function(){
	action3.style.cursor = "url(image/pa.cur),auto";
});

//マウスオーバーが外れた時 style
action1.addEventListener("mouseleave",function(){
	aaction1.style.cursor="";
});
action2.addEventListener("mouseleave",function(){
	aaction2.style.cursor="";
});
action3.addEventListener("mouseleave",function(){
	aaction3.style.cursor="";
});