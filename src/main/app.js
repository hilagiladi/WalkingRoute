function initMap() {
    // Specify the map center and zoom level
    let center = {lat: 37.7749, lng: -122.4194};
    let zoom = 8;

    // Create a new map object and set the center and zoom
    let map = new google.maps.Map(document.getElementById('map'), {
        center: center,
        zoom: zoom
    });

    // Specify the origin and destination for directions
    const origin = 'Leshem 48 Even Sapir, Israel';
    const destination = 'Golomb Jerusalem, Israel';

    // Create a new directions service object and specify the options
    let directionsService = new google.maps.DirectionsService();
    let directionsRenderer = new google.maps.DirectionsRenderer();
    directionsRenderer.setMap(map);

    // Make the directions request
    directionsService.route({
        origin: origin,
        destination: destination,
        travelMode: google.maps.TravelMode.DRIVING
    }, function(response, status) {
        if (status === google.maps.DirectionsStatus.OK) {
            directionsRenderer.setDirections(response);
        } else {
            window.alert('Directions request failed due to ' + status);
        }
    });
}
