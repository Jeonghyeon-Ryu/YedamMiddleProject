window.addEventListener('load',function(){
        let rightScrollButton = document.querySelector('.right-scroll-button');
        let leftScrollButton = document.querySelector('.left-scroll-button');
        rightScrollButton.addEventListener('click', rightScrollFunction);
        leftScrollButton.addEventListener('click', leftScrollFunction);
        document.querySelector('.left-scroll-button').style.visibility='hidden';
    })
    
    function rightScrollFunction() {
        // Header Width
        let headerWidth = document.querySelector('header').getBoundingClientRect().width;
        // Filter Box Width & Left Right Button Width
        let filterBoxWidth = headerWidth*0.8;
        let scrollButtonWidth = headerWidth*0.1;

        // Filter Inner Box
        let filterInnerBox = document.querySelector('.filter-inner-box');

        let transform = filterInnerBox.style.transform;
        let translateX = +transform.slice(11,transform.indexOf("px"));

        // 박스 길이 < items 길이 - left 면 이동금지
        if(filterBoxWidth < (585 + translateX)){
            if(filterBoxWidth > (585 + translateX - 100)){
                console.log("11111111111");
                filterInnerBoxLeft = (filterBoxWidth - 605) + "px";
                filterInnerBox.style.transform = 'translateX('+filterInnerBoxLeft+')';
                document.querySelector('.right-scroll-button').style.visibility='hidden';
            } else {
                console.log("2222222222");
                filterInnerBox.style.transform = 'translateX('+ (translateX - 100)+"px"+')';
                if(document.querySelector('.left-scroll-button').style.visibility=='hidden'){
                    document.querySelector('.left-scroll-button').style.visibility='visible';
                }
            }
        }
    }
    
    function leftScrollFunction() {
        // Header Width
        let headerWidth = document.querySelector('header').getBoundingClientRect().width;
        // Filter Box Width & Left Right Button Width
        let filterBoxWidth = headerWidth*0.8;
        let scrollButtonWidth = headerWidth*0.1;

        // Filter Inner Box
        let filterInnerBox = document.querySelector('.filter-inner-box');
        let filterInnerBoxLeft = +getComputedStyle(filterInnerBox).left.slice(0,getComputedStyle(filterInnerBox).left.indexOf("px"));

        let transform = filterInnerBox.style.transform;
        let translateX = +transform.slice(11,transform.indexOf("px"));

        // Left 가 20 보다 커지면 오른쪽으로 이동금지
        if(translateX < 20){
            if(20 < (translateX + 100)){
                filterInnerBox.style.transform = 'translateX('+"0px"+')';
                document.querySelector('.left-scroll-button').style.visibility='hidden';
            } else {
                filterInnerBox.style.transform = 'translateX('+ (translateX + 100) + "px"+')';
                if(document.querySelector('.right-scroll-button').style.visibility=='hidden'){
                    document.querySelector('.right-scroll-button').style.visibility='visible';
                }
            }
        }
    }