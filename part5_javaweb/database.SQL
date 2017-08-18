DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `userpass` varchar(255) DEFAULT NULL
) ;


DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) DEFAULT NULL,
  `proname` varchar(255) DEFAULT NULL,
  `prodes` varchar(255) DEFAULT NULL,
  `procount` int(11) DEFAULT NULL
) ;