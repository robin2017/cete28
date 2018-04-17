DROP TABLE IF EXISTS `messages`;
CREATE TABLE `messages` (
  `id` int(11) NOT NULL auto_increment,
  `user` varchar(250) NOT NULL ,
  `msg` text NOT NULL,
  `time` int(11) NOT NULL,
  PRIMARY KEY (`id`)
);