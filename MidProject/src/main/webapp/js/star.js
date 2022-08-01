document.getElementById('Appstar-rated').addEventListener('click', function(event) {
    if (event.target.tagName.toLowerCase() != 'span') return;
    
    if (event.target.classList.contains('upstar-rated')) {
        event.target.classList.remove('upstar-rated');
    } else {
        Array.prototype.forEach.call(document.getElementsByClassName('upstar-rated'), function(el) {
        el.classList.remove('upstar-rated');
        });
        event.target.classList.add('upstar-rated');
    }
});