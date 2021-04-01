-- https://www.hackerrank.com/challenges/print-prime-numbers/problem
-- hackerrank

DELIMITER $$
DROP PROCEDURE IF EXISTS PRINT_PRIME_NUMS$$
CREATE PROCEDURE PRINT_PRIME_NUMS()
BEGIN
	DECLARE i INT;
	DECLARE j INT;
	DECLARE prime INT;
	DECLARE result VARCHAR(1000);

	SET i := 2;
	SET prime := 0;
	SET result := '';

	WHILE i <= 10 DO
		SET j := 2;
		WHILE j < i DO
			IF i % j = 0 THEN
				SET prime := 1;
			END IF;
			set j = j + 1;
		END WHILE;
		
		IF prime = 0 THEN
			SET result := CONCAT(result,CAST(i AS CHAR(10)), '&');

		END IF;
		SET prime := 0;
		SET i = i+1;
	END WHILE;

	SELECT LEFT(result, LENGTH(result)-1);
END $$

call PRINT_PRIME_NUMS();
