// var xiaoming = {
//     name:"小明",
//     birth:1990,
//     age:function () {
//         var y = new Date().getFullYear();
//         return y - this.birth;
//     }
// }
//
// alert(xiaoming.age());
// alert(xiaoming.age);


//装饰器
// var count = 0;
// var oldParseInt = Math.max;
//
// window.Math.max = function () {
//     count += 1;
//     return oldParseInt.apply(null,[arguments1, arguments2, arguments3]);
// };
//
// alert(Math.max(5, 4, 2));
// alert(Math.max(4, 8, 2));
// alert(count);

//map()  --将一个函数应用到数组中
// function pow(x) {
//     return x * x;
// }
// var arr = [1,2,3,4,5,6,7,8,9];
// var newArr = [];
// newArr = arr.map(String)
// alert(newArr); //变成字符串
// alert(arr.map(pow));    //每个元素求平方

'use strict';
function normalize(arr) {
    var i;

    var name = arr.map(function (t) {
            return arr[i].slice(0,1).toUpperCase() + arr[i].slice(1).toLowerCase();
        });


    alert(arr);
}

// 测试:
if (normalize(['adam', 'LISA', 'barT']).toString() === ['Adam', 'Lisa', 'Bart'].toString()) {
    alert('测试通过!');
}
else {
    alert('测试失败!');
}
