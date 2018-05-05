INSERT INTO cities (id,name_of_city) VALUES (1,'Łódź');
INSERT INTO cities (id,name_of_city) VALUES (2,'Poznań');

INSERT INTO cinemas (id,address,cities_id_cities) VALUES (1,'Drewnowska 58',1);
INSERT INTO cinemas (id,address,cities_id_cities) VALUES (2,'Dróżbieckiego 2',2);

INSERT INTO movies(id,actors,director,duration,premiere_date,title) VALUES (1,'Alden Ehrenreich, Donald Glover, Emilia Clarke, Woody Harrelson, Paul Bettany, Warwick Davis','Ron Howard',135,'2018-05-22','Han Solo: A Star Wars Story');
INSERT INTO movies(id,actors,director,duration,premiere_date,title) VALUES (2,'Chris Pratt, Bryce Dallas Howard, Jeff Goldblum, BD Wong, James Cromwell','J.A. Bayona',128,'2018-06-08','Jurassic World 2');

INSERT INTO users(id,email,first_name,last_name,password,phone_number) VALUES (1,'adres1@test.pl','Adam','Mickiewicz','slowacki123','123456789');
INSERT INTO users(id,email,first_name,last_name,password,phone_number) VALUES (2,'adres2@test.pl','Juliusz','Słowacki','mickiewicz123','987654321');

INSERT INTO screening_rooms(id,number_of_room,sponsor_name,cinemas_id_cinemas) VALUES (1,32,'mcdonald',1);
INSERT INTO screening_rooms(id,number_of_room,sponsor_name,cinemas_id_cinemas) VALUES (2,23,'kfc',2);

INSERT INTO tickets(id,users_id_users) values (1,1);
INSERT INTO tickets(id,users_id_users) values (2,2);

INSERT INTO reservations (id,tickets_id_tickets) VALUES (1,1);
INSERT INTO reservations (id,tickets_id_tickets) VALUES (2,2);

INSERT INTO seances(id,data_of_seance,movies_id_movies,screening_rooms_id_screening_rooms) VALUES (1,'2017-05-04',1,1);
INSERT INTO seances(id,data_of_seance,movies_id_movies,screening_rooms_id_screening_rooms) VALUES (2,'2018-03-14',2,2);

INSERT INTO seats(id,number_of_seat,row_in_theater,reservations_id_reservations,screening_rooms_id_screening_rooms) VALUES (1,14,9,1,1);
INSERT INTO seats(id,number_of_seat,row_in_theater,reservations_id_reservations,screening_rooms_id_screening_rooms) VALUES (2,16,11,2,2);


