drop table if exists question;
drop table if exists category;
drop table if exists catGroup;

create table catGroup(
	id_catGroup int auto_increment,
	name varchar(20),
	constraint pk_cg primary key(id_catGroup)
); 

create table category(
	id_cat int auto_increment,
	name varchar(20),
	catGroup int,
	constraint pk_c primary key(id_cat),
	constraint fk_c foreign key(catGroup) 
		references catGroup(id_catGroup) on delete cascade on update cascade
); 

create table question(
	id_q int auto_increment,
    img varchar(500),
	stmnt varchar(500),
	o0 varchar(500),
	o1 varchar(500),
	o2 varchar(500),
	correctAnswer int,
    difficulty int,
    category int,
	constraint pk_q primary key(id_q),
	constraint fk_q foreign key(category) 
		references category(id_cat) on delete cascade on update cascade
);

insert into catGroup values (1,'unset');
insert into category values (1,'unset',1);

delete from question;

insert into question values (
    1,
    null,
    '¿Las vías para automóviles puden tener acceso a las propiedades colindantes?',
    'Sí.',
    'No.',
    'Solo algunos días.',
    1,
    1,1
);

insert into question values (
    2,
    null,
    '¿Por qué tipo de vías no pueden circular los ciclomotores?',
    'Por las autovías unicamente.',
    'Por las vías que no tengan arcén.',
    'Por las autopistas y autovías.',
    2,
    1,1
);

insert into question values (
    3,
    'q3.jpg',
    'Circula a 80 kilómetros por hora, ¿por qué carril debe hacerlo?',
    'Por el central, utilizando el derecho para facilitar los adelantamientos.',
    'Por el derecho, utilizando el resto cuando las circustancias del tráfico o de la vía los aconsejen.',
    'Por cualquiera de ellos, ya que mi velocidad es superior a 70 km/h.',
    1,
    1,1
);

insert into question values (
    4,
    'q4.jpg',
    'El conductor del turismo amarillo...',
    'Debe llevar al menos dos ocupantes.',
    'No puede utilizar este carril.',
    'Circula por un carril reversible.',
    2,
    1,1
);

insert into question values (
    5,
    null,
    'La circulación de peatones está prohibida...',
    'En autopistas, pero no en autovías.',
    'En autovías, pero no en autopistas.',
    'En autopistas y en autovías.',
    2,
    1,1
);

insert into question values (
    6,
    null,
    'Si los panales de mensaje variable indican que los turismos conn distintivo ambiental B pueden circular por un carril VAO, ¿qué ocupación minima debe tener el vehículo?',
    'Dos ocupantes, incluido el conductor.',
    'Un ocupante.',
    'Dos ocupantes, sin incluir al conductor.',
    1,
    1,1
);

insert into question values (
    7,
    null,
    '¿Quién es el responsable de pasar la itv a un turismo?',
    'El titular del vehículo.',
    'El tomador del seguro.',
    'El conductor habitual.',
    0,
    1,1
);

insert into question values (
    8,
    null,
    '¿Puede un vehículo de tres ruedas arrastrar un remolque?',
    'Sí.',
    'Sí, cualquier remolque.',
    'No, nunca.',
    0,
    1,1
);

insert into question values (
    9,
    null,
    'El titular de un permiso de la clase B, ¿puede conducir motocicletas con sidecar?',
    'No.',
    'Sí, pero sólo en territorio nacional.',
    'Sím siempre que el permiso de la clase B tenga una antigüedad superior a 3 años.',
    0,
    1,1
);

insert into question values (
    10,
    null,
    '¿Cuántos puntos puede perder por superar en un 10% la velocidad máxima permitida en las vías públicas?',
    '3 puntos.',
    'Ninguno.',
    '3 puntos.',
    1,
    1,1
);

insert into question values (
    11,
    null,
    'El seguro obligatorio, ¿cubre los daños ocasionados en el vehículo asegurado?',
    'Sí, cuando su conductor no sea culpable del accidente.',
    'Sí.',
    'No.',
    2,
    1,1
);

insert into question values (
    12,
    null,
    '¿Qué vehículos deben tener concertado el Seguro Obligatorio?',
    'Todos los vehículos que circulen por vías públicas.',
    'Todos los vehículos a motor excepto los ciclomotores.',
    'Los vehículos a motor y ciclomotores.',
    2,
    1,1
);

insert into question values (
    13,
    null,
    'Las luces de los semáforos con la silueta de un ciclo afectan...',
    'exclusivamente a los ciclos y ciclomotores.',
    'a ciclos solamente.',
    'a ciclomotores solamente.',
    0,
    1,1
);


insert into question values (
    14,
    'sign_procamiones5.png',
    'Circula con un turismo, ¿le prohibe esta señal ejecutar un adelantamiento?',
    'No, la señal solo prohíbe que se adelante a los camiones por la derecha.',
    'No.',
    'Sí, la señal prohíbe adelantar a todos los vehículos en general y especialmente a los camiones.',
    1,
    1,1
);

insert into question values (
    15,
    'q15.jpg',
    'Esta marca transversal continua, ¿está permitido franquearla sin detenerse antes?',
    'Sí, cuando no sea obligatoria la detención.',
    'Sí, cuando no represente peligro a la circulación.',
    'No, nunca.',
    0,
    1,1
);

insert into question values (
    16,
    null,
    'Como norma general las señales se aplican...',
    'A toda la anchura de la calzada.',
    'A toda la vía.',
    'Solo al carril derecho.',
    0,
    1,1
);

insert into question values (
    17,
    'q17.jpg',
    '¿A qué vehículo afecta la señal horizontal de velocidad?',
    'Al verde.',
    'Al blanco.',
    'A los dos.',
    1,
    1,1
);

insert into question values (
    18,
    null,
    '¿Todos los usuarios de la vía están obligados a obedecer las señales de circulaación?',
    'No.',
    'Los conductires sí, los peatones no.',
    'Sí, siempre.',
    2,
    1,1
);






insert into question values (
    aaaaaaaaaa,
    'img1.jpg',
    'asdasdasd',
    'asdasdasd',
    'assdasdasd',
    'asdasdsad',
    1,
    1,1
);


