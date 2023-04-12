SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS ruoka;
DROP TABLE IF EXISTS unenlaatu;
DROP TABLE IF EXISTS uni;
DROP TABLE IF EXISTS appUser;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE ruoka(
id BIGINT NOT NULL AUTO_INCREMENT,
nimi VARCHAR(100) NOT NULL,
lisatietoja VARCHAR(100),
pvm VARCHAR(15),
kellonaika VARCHAR(10),
PRIMARY KEY (id)
);

INSERT INTO ruoka(nimi, lisatietoja, pvm, kellonaika)
VALUES	('Ruoka1', 'ei ole', '2023-03-20', '21:00'),
		('Ruoka2', 'ei ole', '2023-03-21', '22:00'),
		('Ruoka3', 'ei ole', '2023-03-22', '23:00'),
		('Ruoka4', 'ei ole', '2023-03-23', '20:00'),
		('Ruoka5', 'ei ole', '2023-03-24', '16:00'),
		('Ruoka6', 'ei ole', '2023-03-25', '20:00'),
		('Ruoka7', 'ei ole', '2023-03-27', '16:00'),
		('Ruoka8', 'ei ole', '2023-03-27', '20:00'),
		('Ruoka9', 'ei ole', '2023-03-28', '16:00'),
		('Ruoka10', 'ei ole', '2023-03-29', '16:00'),
		('Ruoka11', 'ei ole', '2023-03-30', '16:00'),
		('Ruoka12', 'ei ole', '2023-03-31', '16:00'),
		('Ruoka13', 'ei ole', '2023-04-01', '16:00'),
		('Ruoka14', 'ei ole', '2023-04-02', '16:00'),
		('Ruoka15', 'ei ole', '2023-04-03', '16:00'),
		('Ruoka16', 'ei ole', '2023-04-04', '16:00');

		
CREATE TABLE unenlaatu(
id BIGINT NOT NULL AUTO_INCREMENT,
laatu VARCHAR(100),
PRIMARY KEY (id)
);

INSERT INTO unenlaatu (laatu)
VALUES ('0'),
		('1'),
		('2'),
		('3'),
		('4'),
		('5');

		
CREATE TABLE uni(
id BIGINT NOT NULL AUTO_INCREMENT,
maara VARCHAR(10) NOT NULL,
lisatietoja VARCHAR(50),
pvm VARCHAR(50),
unenlaatuid BIGINT,
PRIMARY KEY (id),
FOREIGN KEY (unenlaatuid) REFERENCES unenlaatu(id)
);

INSERT INTO uni(maara, lisatietoja, pvm, unenlaatuid)
VALUES	('05:00', 'ei ole', '2023-03-20', 1),
		('06:00', 'ei ole', '2023-03-21', 2),
		('07:00', 'ei ole', '2023-03-22', 3),
		('08:00', 'ei ole', '2023-03-23', 4),
		('09:00', 'ei ole', '2023-03-24', 5),
		('05:00', 'ei ole', '2023-03-25', 6),
		('03:15', 'ei ole', '2023-03-26', 3),
		('09:00', 'ei ole', '2023-03-27', 4),
		('08:00', 'ei ole', '2023-03-28', 5),
		('07:00', 'ei ole', '2023-03-29', 5),
		('07:30', 'ei ole', '2023-03-30', 4),
		('07:00', 'ei ole', '2023-03-31', 3),
		('09:00', 'ei ole', '2023-04-01', 2),
		('07:00', 'ei ole', '2023-04-02', 4),
		('08:00', 'ei ole', '2023-04-03', 1),
		('07:00', 'ei ole', '2023-04-04', 1);

CREATE TABLE appUser (
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY
,rooli VARCHAR(100) NOT NULL
,tunnus VARCHAR(250) NOT NULL
,password_hash VARCHAR(250) NOT NULL);
INSERT INTO appUser (tunnus, password_hash, rooli)
VALUES ('admin',
'$2a$10$4aCWvPlxaDMi31ClImeS7efooaO9Afe4rwxvoB2cmpHGJc8ZgKFvm', 'ADMIN'),
('user',
'$2a$10$6kx54VgcI7vSZPRPpSQ9Mua7TQHeCqpsnTpG2D9ur7dfbFIz4kSg6', 'USER');
		
SELECT * FROM ruoka;
SELECT * FROM unenlaatu;
SELECT * FROM uni;
SELECT * FROM appUser;