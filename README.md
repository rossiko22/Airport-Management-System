
# Airport Management System

This is an Simple Airport Manage System

## GET Endpoints

| /flights             |Get all flights                                                                |
| ----------------- | ------------------------------------------------------------------ |
| /flight/{flightId} | Retrieves a specific flight by its ID  |
| /flights/{OriginCountry}/{destinationCountry}| Retrieves a list of flights from the specified origin country to the specified destination country |
| /flight/{flightId}/airplane | Retrieves the airplane associated with the specified flight ID  |
| /flight/{flightId}/bookings | Retrieves a list of bookings for the specified flight ID  |
|/flight/{flightId}/seats-availability| Retrieves a list of available seats for the specified flight ID |
| /flight/{flightId}/check-seat-availability/{seatId} | Checks the availability of a specific seat on the specified flight |
| /flight-changes| Retrieves a list of recent changes made to flights |
| /flight-cancellations| Retrieves a list of recently canceled flights |
| /cancel/flight/{flightId}| Cancels the specified flight |
| /seats| Retrieves a list of all seats across all flights |
| /loyality-programs| Retrieves a list of all loyalty programs |
| /flight-providers| Retrieves a list of all flight providers that our agency works with |
| /countries| Retrieves a list of all countries that our agency works with |
| /airports| Retrieves a list of all airports that our agency works with |
| /airports/{countryName}| Retrieves a list of airports from the specified country |
| /airport-type| Retrieves a list of all airport types that our agency works with |
| /airplane-models| Retrieves a list of all airplane models that our agency works with |
| /airplanes| Retrieves a list of all airplanes that we currently have |
|/airplane/{id}| Retrieves an airplane by its ID |

## Authors

- [@rossiko22](https://github.com/rossiko22)

