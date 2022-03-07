#create database airportManagement;


create table users
(
    user_id         int auto_increment not null,
    first_name varchar(64)                 not null,
    last_name  varchar(64)                 not null,
    is_minor   boolean,
    age        int,
    balance    int,
    user_pin   int,
    primary key (user_id)
);



create table airline
(
    airline_id         int auto_increment not null,
    airline_name varchar(64)                 not null,
    primary key (airline_id)
);

create table plane
(
    plane_id          int auto_increment not null,
    plane_name  varchar(64)                 not null,
    snacks      boolean                     not null,
    total_seats int                         not null,
    primary key (plane_id)
);


create table flight_passengers
(
    id        int auto_increment not null,
    flight_id int,
    user_id   int,
    primary key (id),
    CONSTRAINT fk_flights
        foreign key (flight_id) references flights (flight_id),
    CONSTRAINT fk_users
        foreign key (user_id) references users (user_id)
);



create table flights
(
    flight_id          int auto_increment not null,
    flight_name        varchar(64)        not null,
    location_departure varchar(64)        not null,
    location_arrival   varchar(64)        not null,
    duration           varchar(64)        not null,
    price              int                not null,
    total_seats        int                not null,
    plane_id           int                not null,
    airline_id         int                not null,
    primary key (flight_id),
    CONSTRAINT fk_planes FOREIGN KEY (plane_id)
        references plane (plane_id),
    CONSTRAINT fk_airlines
        FOREIGN KEY (airline_id) references airline (airline_id)
);

insert into flights(flight_name, location_departure, location_arrival, duration, price, total_seats, plane_id, airline_id)  VALUES (?, ?, ?, ?, ?, ?, ?, ?);
