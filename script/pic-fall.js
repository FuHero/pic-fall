/**
 * Created by fuzhong on 2015/7/14.
 * ͼƬ�ٲ���
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
 * �������ص�һ��ͼƬ
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
 * ����һ��ͼƬ,��ɺ󴥷�������һ��ͼƬ
 * @param fallHeightArr ��ĻͼƬ���ĸ߶�����
 * @param dataIndex Ҫ���ص�ͼƬ��index
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
 * ������Ļ���ܳ��ص�fall����
 * @returns {Array} ͼƬ������
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
 * ��ȡ��Ļ��ͼƬ���ĸ߶�
 * @param num ͼƬ��������
 * @returns {Array} �߶�����
 */
function getFallHeightArray (num) {
    var fallHeightArr = []
    for (var i=0; i<num; i++) {
        fallHeightArr[i] = 0;
    }
    return fallHeightArr;
}

/**
 * ��Ԫ���б���У���ȡ�þ������px
 * @param num ͼƬ������
 */
function stepContainerCenter (num) {
    var width = document.body.clientWidth;
    var left = Math.floor((width-num*238)/2);
    if (left > 0) {
        document.getElementsByClassName('container')[0].style.marginLeft = left+'px';
    }
}

/**
 * ��ȡ������Ԫ�ص�index
 * @param arr Ŀ������
 * @param element Ŀ��Ԫ��
 * @returns {number} index
 */
function getMinIndex (arr, element) {
    for (var i=0; i<arr.length; i++) {
        if (arr[i] == element) {
            return i;
        }
    }
}