# gilfoylego_master
*** ROUTES ***

localhost:8080			<--- Root route

-----------------------------------------------
*HOTEL* 			<--- SQL-tabellnamn
/rest/hotel			<--- Hotel root

#GET#
/		 		<--- find all hotels
/*      			<--- find one hotel with id equal to *
/name/* 			<--- find all with name containing * (ignoreCase)
/cityId/*			<--- find all with cityId equal to *
/hasRestaurant			<--- find all with restaurant
/hasPool			<--- find all with pool
/hasEveningEntertainment	<--- find all with evening entertainment
/beachCloserThan/*		<--- find all closer than (or equal to) * meters 
/cityCenterCloserThan/*		<--- find all closer than (or equal to) * meters
/rating/greaterEqual/*		<--- find all with rating above (or equal to) *
/rating/lessEqual/*		<--- find all with rating below (or equal to) *
/description/*			<--- find all with description containing * (ignoreCase)

-------------------------------------------------
*USERS*
/rest/user			<--- User root

#GET#
/				<--- find all users
/*				<--- find one user with id equal to *

#POST#
/				<--- create one user

#PUT#
/update				<--- update one user

#DELETE#
/delete/*			<--- delete one user with id equal to *
-------------------------------------------------
*COUNTRY*
/rest/country			<--- Country root

#GET#
/				<--- find all countries
/*				<--- find one country with id equals *
/name/*				<--- find all countries containing * (ignoreCase)-------------------------------------------------

-------------------------------------------------
*CITY*
/rest/city			<--- City root

#GET#
/				<--- find all cities
/*				<--- find one city with id equal to *
/country/*			<--- find all cities with countryId equal to *

-------------------------------------------------
*ROOM*
/rest/room			<--- Room root

#GET#
/				<--- find all rooms
/*				<--- find one room with id equal to *
/hotelrooms/*			<--- find all rooms with hotelId equal to *
/size/greaterEqual/*		<--- find all with size above (or equal to) *
/size/lessEqual/*		<--- find all with size below (or equal to) *
/price/equals/*			<--- find all with price equals * 
/price/greaterEqual/*		<--- find all with price above (or equal to) *
/price/lessEqual/*		<--- find all with price below (or equal to) *

-------------------------------------------------
*ROOMTYPE*
/rest/roomtype			<--- Roomtype root

#GET#
/				<--- find all roomtypes
/*				<--- find one roomtype with id equal to *

-------------------------------------------------
*BOOKING*
/rest/booking			<--- Booking root

#GET#
/				<--- find all bookings
/*				<--- find one booking with id equal to *
/user/*				<--- find all bookings with userId equal to *



#POST#
/				<--- create one booking

#PUT#
/update				<--- update one booking

#DELETE#
/delete/*			<--- delete one booking with id equal to *

-------------------------------------------------
*ROOMBOOKING*
/rest/roombooking		<--- RoomBooking root

#GET#
/				<--- find all roombookings
/*				<--- find one roombooking with id equal to *
/room/*				<--- find all roombooking with roomId equal to *
/booking/*			<--- find all with bookingId 

#POST#
/				<--- create one roombooking

#PUT#
/update				<--- update one roombooking

#DELETE#
/delete/*			<--- delete one roombooking with id equal to *






