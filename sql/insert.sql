INSERT INTO `periodicals`.`roles` (`id`, `name`) VALUES ('1', 'User');
INSERT INTO `periodicals`.`roles` (`id`, `name`) VALUES ('2', 'Admin');

INSERT INTO `periodicals`.`users` (`login`, `password`, `first_name`, `last_name`, `email`, `role_id`) VALUES ('VladSV', '12345', 'Vladislav', 'Sevashko', 'vlad@gmail.com', '2');
INSERT INTO `periodicals`.`users` (`login`, `password`, `first_name`, `last_name`, `email`, `role_id`) VALUES ('user', 'user', 'user', 'user', 'user@email.com', '1');

INSERT INTO `periodicals`.`themes` (`id`, `name`) VALUES ('1', 'Автомобили. Транспорт');
INSERT INTO `periodicals`.`themes` (`id`, `name`) VALUES ('2', 'Здравоохранение. Медицина');

INSERT INTO `periodicals`.`publications` (`name`, `theme_id`, `type_id`, `periodicity`, `price`) VALUES ('Автодайджест	', '1', '1', '12', '3.79');
INSERT INTO `periodicals`.`publications` (`name`, `theme_id`, `type_id`, `periodicity`, `price`) VALUES ('Мир тяжелых моторов', '1', '1', '12', '4.17');
INSERT INTO `periodicals`.`publications` (`name`, `theme_id`, `type_id`, `periodicity`, `price`) VALUES ('Транспортная безопасность', '1', '1', '24', '14.98');

INSERT INTO `periodicals`.`publications` (`name`, `theme_id`, `type_id`, `periodicity`, `price`) VALUES ('Здоровье плюс', '2', '1', '6', '4.44');
INSERT INTO `periodicals`.`publications` (`name`, `theme_id`, `type_id`, `periodicity`, `price`) VALUES ('Ваше здоровье', '2', '1', '12', '4.19');
INSERT INTO `periodicals`.`publications` (`name`, `theme_id`, `type_id`, `periodicity`, `price`) VALUES ('Доживем до ста', '2', '1', '6', '0.26');
