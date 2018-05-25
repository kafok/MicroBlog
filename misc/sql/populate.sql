

USE `MicroBlog`;

INSERT INTO `user` (`id_u`, `Email`, `Password`, `Name`, `Profile`) VALUES
(1, 'marcos@gmail.com', '123456789', 'Marcos', ''),
(2, 'cristina@gmail.com', '123456789', 'Cristina ', ''),
(3, 'joseantonio@gmail.com', '123456789', 'Joseantonio', '');

INSERT INTO `news` (`id_n`, `Fecha`, `titulo`, `descripcion`,`userId`) VALUES
(1, '2018-05-25 13:00:00', 'Final de la UEFA Champions League 2018', 'El próximo sábado 26 de Mayo se celebra la final de la UEFA Champions Leaque entre el Real Madrid y el Liverpool en la Ciudad de Kiev.',3),
(2, '2018-05-25 14:00:00', 'PSOE presenta Moción de Censura', 'El secretario general del PSOE Pedro Sánchez quiere presentar una moción de censura al partido político del PP.',3);
