let filterButton = document.querySelector('.filter-button');
filterButton.addEventListener('click',modalOpenAction);
let modalCloseButton = document.querySelector('.modal-close-button');
modalCloseButton.addEventListener('click',modalCloseAction);
function modalOpenAction(e){
    let modal = document.querySelector('#modal');
    modal.style.visibility = "visible";
}
function modalCloseAction(e) {
    if(e.target.parentElement == document.querySelector('.modal-close-button')){
        let modal = e.target.parentElement.parentElement.parentElement.parentElement;
        modal.style.visibility = "hidden";
    }
}