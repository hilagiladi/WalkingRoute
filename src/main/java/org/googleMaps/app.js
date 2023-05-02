function initMap() {
    // Get the map element and the origin/destination data from the data attributes
    const mapElement = document.getElementById('map');
    const origin = mapElement.dataset.origin;
    const destination = mapElement.dataset.destination;

    // Create a new map object
    const map = new google.maps.Map(mapElement, {
        zoom: 7,
        center: { lat: 48.8566, lng: 2.3522 } // Default to Paris
    });

    // Use the DirectionsService to calculate directions between the origin and destination
    const directionsService = new google.maps.DirectionsService();
    const directionsRenderer = new google.maps.DirectionsRenderer({
        map: map
    });

    directionsService.route(
        {
            origin: origin,
            destination: destination,
            travelMode: google.maps.TravelMode.DRIVING
        },
        (response, status) => {
            if (status === 'OK') {
                directionsRenderer.setDirections(response);
            } else {
                window.alert('Directions request failed due to ' + status);
            }
        }
    );

}
