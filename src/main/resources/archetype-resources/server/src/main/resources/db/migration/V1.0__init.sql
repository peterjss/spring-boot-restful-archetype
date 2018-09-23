-- Table: t_user
CREATE TABLE t_user (
  id            BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  code          VARCHAR(255),
  loginName     VARCHAR(255),
  name          VARCHAR(255),
  password      VARCHAR(255),
  email         VARCHAR(255),
  phone         VARCHAR(255),
  createTime    VARCHAR(255),
  lastestLogin  VARCHAR(255)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8;

INSERT INTO t_user (id,code,loginName, name, password, email,phone,createTime,lastestLogin) VALUES (1, 'sdfsdf','admin', 'Administrator', '123456', 'admin@admin.com','15678977877','915120000000','915120000000');
INSERT INTO t_user (id,code,loginName, name, password, email,phone,createTime,lastestLogin) VALUES (2, 'sfdsfsdf','user', 'User',  '123456', 'user@user.com','153564789561','915120000000','915120000000');