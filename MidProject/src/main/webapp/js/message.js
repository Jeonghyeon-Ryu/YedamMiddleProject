let i= 0;
		

let thisId
if (typeof variable !== 'undefined')


function openContent(id) {
	thisId = id
	document.getElementById("msContentText").style.display ='block'
	let a = document.getElementsByClassName(thisId)
	for (i = 0; i < a.length; i++) {
		a[i].style.display = 'block';
	}
	document.getElementById("msContentRoom").style.display='none'
	document.getElementById("msReceiv").setAttribute("value",thisId);
}
function openAllMs(){
	
	document.getElementById("msContentText").style.display ='none'
	let a = document.getElementsByClassName(thisId)
	for (i = 0; i < a.length; i++) {
		a[i].style.display = 'none';
	}
	document.getElementById("msContentRoom").style.display='block'
}
function press(f){
    if(f.keyCode == 13){ 
        msSendContent.submit(); 
    }
}

function msClear(){
	let msContentRoom =document.getElementById("msContentRoom")
	while (msContentRoom.hasChildNodes()) {
        msContentRoom.removeChild(msContentRoom.firstChild);
        console.log(123676)
    }
}