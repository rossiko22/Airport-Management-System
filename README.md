# Airport Management System

This is an Simple Airport Manage System

## GET Endpoints

| Endpoint | Description |
| ----------------- | ------------------------------------------------------------------ |
| /flights             |Get all flights                                                                |
| /flight/<span style="color:darkred;">{flightId}</span> | Retrieves a specific flight by its ID  |
| /flights/<span style="color:darkred;">{OriginCountry}</span>/<span style="color:darkred;">{destinationCountry}</span>| Retrieves a list of flights from the specified origin country to the specified destination country |
| /flight/<span style="color:darkred;">{flightId}</span>/airplane | Retrieves the airplane associated with the specified flight ID  |
| /flight/<span style="color:darkred;">{flightId}</span>/bookings | Retrieves a list of bookings for the specified flight ID  |
| /flight/<span style="color:darkred;">{flightId}</span>/seats-availability| Retrieves a list of available seats for the specified flight ID |
| /flight/<span style="color:darkred;">{flightId}</span>/check-seat-availability/<span style="color:darkred;">{seatId}</span> | Checks the availability of a specific seat on the specified flight |
| /flight-changes| Retrieves a list of recent changes made to flights |
| /flight-cancellations| Retrieves a list of recently canceled flights |
| /cancel/flight/<span style="color:darkred;">{flightId}</span>| Cancels the specified flight |
| /seats| Retrieves a list of all seats across all flights |
| /loyality-programs| Retrieves a list of all loyalty programs |
| /flight-providers| Retrieves a list of all flight providers that our agency works with |
| /countries| Retrieves a list of all countries that our agency works with |
| /airports| Retrieves a list of all airports that our agency works with |
| /airports/<span style="color:darkred;">{countryName}</span>| Retrieves a list of airports from the specified country |
| /airport-type| Retrieves a list of all airport types that our agency works with |
| /airplane-models| Retrieves a list of all airplane models that our agency works with |
| /airplanes| Retrieves a list of all airplanes that we currently have |
|/airplane/<span style="color:darkred;">{id}</span>| Retrieves an airplane by its ID |


## Authors

- [@rossiko22](https://github.com/rossiko22)
