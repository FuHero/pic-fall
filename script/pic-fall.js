/**
 * Created by fuzhong on 2015/7/14.
 * 图片瀑布流
 */

var data = ["../image/11.jpg", "../image/5.jpg", "../image/9.jpg", "../image/14.jpg", "../image/5.jpg", "../image/6.jpg",
    "../image/7.jpg", "../image/8.jpg", "../image/9.jpg", "../image/10.jpg", "../image/11.jpg", "../image/12.jpg",
    "../image/2.jpg", "../image/13.jpg", "../image/4.jpg", "../image/15.jpg", "../image/6.jpg", "../image/7.jpg",
    "../image/8.jpg", "../image/9.jpg", "../image/11.jpg", "../image/10.jpg", "../image/12.jpg", "../image/1.jpg",
    "../image/3.jpg", "../image/4.jpg", "../image/5.jpg", "../image/6.jpg", "../image/7.jpg", "../image/8.jpg",
    "../image/9.jpg", "../image/10.jpg", "../image/11.jpg", "../image/12.jpg", "../image/2.jpg", "../image/1.jpg",
    "../image/7.jpg", "../image/8.jpg", "../image/9.jpg", "../image/10.jpg", "../image/11.jpg", "../image/12.jpg",
    "../image/1.jpg", "../image/8.jpg", "../image/5.jpg", "../image/12.jpg", "../image/3.jpg", "../image/12.jpg",
    "../image/7.jpg", "../image/2.jpg", "../image/9.jpg", "../image/15.jpg", "../image/11.jpg", "../image/13.jpg",
    "../image/14.jpg", "../image/5.jpg", "../image/16.jpg", "../image/1.jpg"];

var num;
var fallHeightArr;

/**
 * 触发加载第一张图片
 */
window.onload = function () {
    num = getScreenFallNum();
    stepContainerCenter(num);
    fallHeightArr = getFallHeightArray(num);
    onloadPic(fallHeightArr, 0);
}

window.onresize = function () {
    document.getElementsByClassName('container')[0].innerHTML = '';
    num = getScreenFallNum();
    stepContainerCenter(num);
    fallHeightArr = getFallHeightArray(num);
    onloadPic(fallHeightArr, 0);
}

/**
 * 加载一张图片,完成后触发加载下一张图片
 * @param fallHeightArr 屏幕图片流的高度数组
 * @param dataIndex 要加载的图片的index
 */
function onloadPic (fallHeightArr, dataIndex) {
    var minHeihght = Math.min.apply(null, fallHeightArr);
    //var index = getMinIndex(fallHeightArr, minHeihght);
    var index = fallHeightArr.indexOf(minHeihght);
    var fall = document.getElementsByClassName('pic-fall')[index];
    var img = document.createElement('img');
    img.src = data[dataIndex];
    dataIndex++;
    img.onload = function () {
        fall.appendChild(img);
        if (dataIndex < data.length) {
            var height = img.height/(img.width/218);
            fallHeightArr[index] += height;
            onloadPic(fallHeightArr, dataIndex++);
        }
    }
}

/**
 * 创建屏幕所能承载的fall条数
 * @returns {Array} 图片流条数
 */
function getScreenFallNum () {
    var width = document.body.clientWidth;
    var num = Math.floor(width/238);

    for (var i=0; i<num; i++) {
        var pic = document.createElement('div');
        pic.className = "pic-fall";
        var container = document.getElementsByClassName('container').item(0);
        container.appendChild(pic);
    }
    return num;
}

/**
 * 获取屏幕中图片流的高度
 * @param num 图片流的条数
 * @returns {Array} 高度数组
 */
function getFallHeightArray (num) {
    var fallHeightArr = []
    for (var i=0; i<num; i++) {
        fallHeightArr[i] = 0;
    }
    return fallHeightArr;
}

/**
 * 让元素列表居中，获取该距左多少px
 * @param num 图片流条数
 */
function stepContainerCenter (num) {
    var width = document.body.clientWidth;
    var left = Math.floor((width-num*238)/2);
    if (left > 0) {
        document.getElementsByClassName('container')[0].style.marginLeft = left+'px';
    }
}

/**
 * 获取数组中元素的index
 * @param arr 目标数组
 * @param element 目标元素
 * @returns {number} index
 */
function getMinIndex (arr, element) {
    for (var i=0; i<arr.length; i++) {
        if (arr[i] == element) {
            return i;
        }
    }
}