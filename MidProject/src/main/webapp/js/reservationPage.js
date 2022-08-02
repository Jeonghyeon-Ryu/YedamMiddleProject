

 // Initialize and add the map
        function initMap() {
          // The location of Uluru
          const uluru = { lat: 40.74870057421415, lng: -73.98569658832044 };
          // The map, centered at Uluru
          const map = new google.maps.Map(document.getElementById("map"), {
            zoom: 4,
            center: uluru,
          });
          // The marker, positioned at Uluru
          const marker = new google.maps.Marker({
            position: uluru,
            map: map,
          });
        }
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAOz2kmmysFlXcKaDjAkofoS-73LfVaOt0&callback=initMap&libraries=&v=weekly"