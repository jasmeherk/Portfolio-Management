--UPDATE

--Update User Address
--UPDATE UserAccount SET address = ? WHERE customerID = ?;

UPDATE UserAccount 
SET address = '565 Commonwealth Ave, Boston, MA 02215' 
WHERE customerID = 100003;