--JOIN

--JOIN UserAccount and TradingAccount tables to get names, emails and
--phone numbers of people who have a balance of greater than 1000

SELECT name, email, phone
FROM UserAccount U, TradingAccount T, Owns O
WHERE O.customerID = U.customerID AND O.accountNum = T.accountNum AND T.balance > 1000;