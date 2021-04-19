DROP TABLE IF EXISTS BestChoiceCars;

CREATE TABLE BestChoiceCars(
	id INT AUTO_INCREMENT PRIMARY KEY,
	brand VARCHAR(50),
	model VARCHAR(50),
	year INT,
	kilometer INT,
	price INT,
	fuel VARCHAR(50)
);