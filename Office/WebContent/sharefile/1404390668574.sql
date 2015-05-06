delimiter $$

CREATE TABLE `supplier` (
  `s_id` varchar(20) NOT NULL,
  `s_name` varchar(45) DEFAULT NULL,
  `s_city` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$
delimiter $$

CREATE TABLE `project` (
  `p_id` varchar(20) NOT NULL,
  `p_name` varchar(45) DEFAULT NULL,
  `p_city` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `component` (
  `c_id` varchar(20) NOT NULL,
  `c_name` varchar(45) DEFAULT NULL,
  `c_color` varchar(45) DEFAULT NULL,
  `c_weight` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `mid` (
  `s_id` varchar(20) NOT NULL,
  `c_id` varchar(45) NOT NULL,
  `p_id` varchar(45) NOT NULL,
  `quantity` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`s_id`,`c_id`,`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$





