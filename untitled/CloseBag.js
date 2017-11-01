function sum(arr) {
    return arr.reduce(function (x, y) {
        return  x + y;
    });
}
document.write("求和函数:")
document.write(sum([1,2,3,4,5]));


//返回函数
//在这个例子中，我们在函数lazy_sum中又定义了函数sum，
// 并且，内部函数sum可以引用外部函数lazy_sum的参数和局部变量，
// 当lazy_sum返回函数sum时，相关参数和变量都保存在返回的函数中，
// 这种称为“闭包（Closure）”的程序结构拥有极大的威力。
function  lazy_sum(arr) {
    var sum = function () {
        return arr.reduce(function (x, y) {
            return x + y;
        });
    }

    return sum();
}

//f是一个求和函数，调用f才是求和
var f = lazy_sum([1,2,3,4,5]);
alert(f);


function count() {
    var arr = [];
    for(var i = 1; i <=3; i++){
        arr.push(function (n) {
                return function () {
                    return n * n;
                }
            })(i);
    }

    return arr;
}

//使用闭包实现计数器，将x隐藏以来了
function creat_counter(initial) {
    var x = initial || 0;       //如果没参数的时候，与上0就是0
    return {
        inc :function () {
            x += 1;
            return x;
        }
    }
}

var c1 = creat_counter();
alert(c1.inc());
alert(c1.inc());
alert(c1.inc())


//使用闭包新建一个函数
// function mark_pow(n) {
//     return function (x) {
//         return Math.pow(x, n);
//     }
// }
//
// var pow2 = mark_pow(2);
// var pow3 = mark_pow(3);
//
// alert(pow2(5));
// alert(pow3(7));


var name = "The Window";
var object = {
    name : "My Object",
    getNameFunc : function(){
        return function(){
            return this.name;
        };
    }
};
alert(object.getNameFunc()());


var name = "The Window";
var object = {
    name : "My Object",
    getNameFunc : function(){
        var that = this;
        return function(){
            return that.name;
        };
    }
};
alert(object.getNameFunc()());