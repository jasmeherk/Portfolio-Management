INSERT INTO UserAccount VALUES(100001, 111111, 'Passport', '123456', 'Michael Yin', '2366 Main Mall, Vancouver, BC', '123-1234', 'myin@ubc.ca', 'pass1');
INSERT INTO UserAccount VALUES(100002, 222222, 'Passport', '444444', 'Kendrick Yap', '2335 Engineering Rd, Vancouver, BC', '234-2345', 'kyap@ubc.ca', 'pass2');
INSERT INTO UserAccount VALUES(100003, 333333, 'Passport', '232323', 'Terry Zhang', '6245 Argonomy Rd, Vancouver, BC', '345-3456', 'tzhang@ubc.ca', 'pass3');
INSERT INTO UserAccount VALUES(100004, 444444, 'Passport', '123123', 'Vera Fan', '2053 Main Mall, Vancouver, BC', '456-4567', 'vfan@ubc.ca', 'pass4');
INSERT INTO UserAccount VALUES(100005, 555555, 'Passport', '987654', 'Irena Zhang', '2275 E Mall, Vancouver, BC', '567-5678', 'izhang@ubc.ca', 'pass5');

INSERT INTO TradingAccount VALUES(9456,3685.12);
INSERT INTO TradingAccount VALUES(9457,4231.67);
INSERT INTO TradingAccount VALUES(9458,1000.00);
INSERT INTO TradingAccount VALUES(9459,3213.12);
INSERT INTO TradingAccount VALUES(9460,919.12);
INSERT INTO TradingAccount VALUES(9461,10.0);
INSERT INTO TradingAccount VALUES(9462,0);

INSERT INTO Owns VALUES(100001,9456);
INSERT INTO Owns VALUES(100002,9457);
INSERT INTO Owns VALUES(100002,9458);
INSERT INTO Owns VALUES(100003,9459);
INSERT INTO Owns VALUES(100004,9460);
INSERT INTO Owns VALUES(100005,9461);
INSERT INTO Owns VALUES(100001,9462);

INSERT INTO CreatesTransaction VALUES(212112, 'Sell', 18.90, 9456, 'Stop Loss', 'confirmed', 'United States', 'NYSE', 18.00);
INSERT INTO CreatesTransaction VALUES(212113, 'Buy', 200, 9460, 'Complete', 'confirmed', 'United States', 'NYSE', 20.00);
INSERT INTO CreatesTransaction VALUES(212114, 'Buy', 400, 9460, 'Complete', 'confirmed', 'United States', 'NASDAQ', 19.00);
INSERT INTO CreatesTransaction VALUES(212115, 'Sell', 500, 9460, 'Complete', 'confirmed', 'United States', 'NYSE', 10.00);
INSERT INTO CreatesTransaction VALUES(212116, 'Buy', 200, 9458, 'Complete', 'confirmed', 'United States', 'NYSE', 219.00);
INSERT INTO CreatesTransaction VALUES(212117, 'Sell', 200, 9460, 'Complete', 'confirmed', 'United States', 'NASDAQ', 145.00);
INSERT INTO CreatesTransaction VALUES(212118, 'Sell', 500, 9459, 'Complete', 'confirmed', 'United States', 'NASDAQ', 120.00);
INSERT INTO CreatesTransaction VALUES(212119, 'Buy', 100, 9460, 'Complete', 'confirmed', 'United States', 'NYSE', 140.00);

INSERT INTO HasAPortfolio VALUES(2345,'AB12C',21.00, 9456,'Active'); 
INSERT INTO HasAPortfolio VALUES(2346,'AB12D',29.00, 9457,'Dormant');
INSERT INTO HasAPortfolio VALUES(2347,'AB12E',9.00, 9458,'Active');
INSERT INTO HasAPortfolio VALUES(2348,'AB12F',500.00, 9459,'Active');
INSERT INTO HasAPortfolio VALUES(2349,'AB12G',40.00, 9460,'Active');
INSERT INTO HasAPortfolio VALUES(2350,'AB12F',500.00, 9459,'Dormant');
INSERT INTO HasAPortfolio VALUES(2351,'AB12G',40.00, 9460,'Dormant');

INSERT INTO TransactionModifiesPortfolio VALUES(2345, 'AB12C', 9456, 21.00, 212112, 9456, 'Sell', 18.00);
INSERT INTO TransactionModifiesPortfolio VALUES(2349, 'AB12G', 9460, 40.00, 212113, 9460, 'Buy', 20.00);
INSERT INTO TransactionModifiesPortfolio VALUES(2349, 'AB12G', 9460, 40.00, 212114, 9460, 'Buy', 19.00);
INSERT INTO TransactionModifiesPortfolio VALUES(2349, 'AB12G', 9460, 40.00, 212115, 9460, 'Sell', 10.00);
INSERT INTO TransactionModifiesPortfolio VALUES(2347, 'AB12E', 9458, 9.00, 212116, 9458, 'Buy', 219.00);
INSERT INTO TransactionModifiesPortfolio VALUES(2349, 'AB12G', 9460, 40.00, 212117, 9460, 'Sell', 145.00);
INSERT INTO TransactionModifiesPortfolio VALUES(2348, 'AB12F', 9459, 500.00, 212118, 9459, 'Sell', 120.00);
INSERT INTO TransactionModifiesPortfolio VALUES(2349, 'AB12G', 9460, 40.00, 212119, 9460, 'Buy', 140.00);

INSERT INTO Crypto VALUES('US2345667891', 'BTC', 'Bitcoin',22300000000.00, TO_DATE('13/3/2021 9:22:00 AM', 'DD/MM/YYYY HH:MI:SS AM'),59060.60);
INSERT INTO Crypto VALUES('US2345667892', 'BCH', 'Bitcoin Cash',12300000000.00, TO_DATE('13/3/2021 9:56:00 AM', 'DD/MM/YYYY HH:MI:SS AM'),560.40);
INSERT INTO Crypto VALUES('US2345667893', 'LTC', 'Litecoin',15300000000.00, TO_DATE('13/3/2021 2:22:00 PM', 'DD/MM/YYYY HH:MI:SS PM'),200.87);

INSERT INTO Forex VALUES('F1232','United States Dollar','USD','Canadian Dollar','CAD',TO_DATE('13/3/2021 9:22:00 AM', 'DD/MM/YYYY HH:MI:SS AM'), 2300.12);
INSERT INTO Forex VALUES('F1233','United States Dollar','USD','Japanese Yen','JPY',TO_DATE('23/3/2021 3:15:00 PM', 'DD/MM/YYYY HH:MI:SS PM'), 2300.12);
INSERT INTO Forex VALUES('F1234','Canadian Dollar','CAD','Japanese Yen','JPY',TO_DATE('15/2/2021 10:26:00 AM', 'DD/MM/YYYY HH:MI:SS AM'), 2300.12);
INSERT INTO Forex VALUES('F1235','United States Dollar','USD','Australian Dollar', 'AUD', TO_DATE('3/4/2021 2:06:26 PM', 'DD/MM/YYYY HH:MI:SS PM'), 2300.12);
INSERT INTO Forex VALUES('F1236','Canadian Dollar','CAD','Australian Dollar','AUD',TO_DATE('16/1/2021 1:22:50 PM', 'DD/MM/YYYY HH:MI:SS PM'), 2300.12);

INSERT INTO Bonds VALUES('US1234231211',TO_DATE('10/10/2017', 'DD/MM/YYYY'),TO_DATE('13/12/2021', 'DD/MM/YYYY'),1000.00, 5.00, 6.00, 4, 980.00, 'Texa Motors, Inc.', TO_DATE('13/3/2021 9:22:00 AM', 'DD/MM/YYYY HH:MI:SS AM'));
INSERT INTO Bonds VALUES('US1234231212',TO_DATE('10/10/2017', 'DD/MM/YYYY'),TO_DATE('13/12/2021', 'DD/MM/YYYY'),10000.00, 3.00, 2.00, 2, 12890.23, 'Van Klo and Company', TO_DATE('23/3/2021 3:15:00 PM', 'DD/MM/YYYY HH:MI:SS PM'));
INSERT INTO Bonds VALUES('US1234231213',TO_DATE('12/12/2017', 'DD/MM/YYYY'),TO_DATE('15/1/2023', 'DD/MM/YYYY'),5000.00, 10.00, 7.00, 10, 6598.45, 'Link M and G', TO_DATE('3/4/2021 2:06:26 PM', 'DD/MM/YYYY HH:MI:SS PM'));
INSERT INTO Bonds VALUES('US1234231214',TO_DATE('12/12/2017', 'DD/MM/YYYY'),TO_DATE('15/1/2023', 'DD/MM/YYYY'),2000.00, 2.00, 6.00, 5, 1408.98, 'Van Cleef and Arples', TO_DATE('16/1/2021 1:22:50 PM', 'DD/MM/YYYY HH:MI:SS PM'));

INSERT INTO Derivatives VALUES('US8234291221','Google','Option','American','short','call','Stock',2270.90,TO_DATE('10/10/2022', 'DD/MM/YYYY'),27.20);
INSERT INTO Derivatives VALUES('US8234291224','Microsoft','Future','Asian','long','call','Bond',377.24,TO_DATE('10/08/2023', 'DD/MM/YYYY'),27.90);
INSERT INTO Derivatives VALUES('US8234291228','Apple','Option','European','short','pull','Stock',970.50,TO_DATE('10/10/2021', 'DD/MM/YYYY'),28.20);
INSERT INTO Derivatives VALUES('US8234291229','Tesla','Option','European','short','pull','Crypto',1970.50,TO_DATE('10/10/2021', 'DD/MM/YYYY'),28.20);
INSERT INTO Derivatives VALUES('US8234291230','Facebook','Future','European','short','pull','Stock',370.00,TO_DATE('10/10/2021', 'DD/MM/YYYY'),28.20);
INSERT INTO Derivatives VALUES('US8234291231','Snapchat','Option','European','short','pull','Stock',70.50,TO_DATE('10/10/2021', 'DD/MM/YYYY'),28.20);

INSERT INTO Equity VALUES('US0230290221',320.95,'TESLA');
INSERT INTO Equity VALUES('US0230290222',120.05,'APPLE');
INSERT INTO Equity VALUES('US0230290223',60.53,'GAMESTOP');
INSERT INTO Equity VALUES('US0230290224',30.43,'Fund1');
INSERT INTO Equity VALUES('US0230290225',200.21,'Fund2');

INSERT INTO Stock VALUES('US0230290221',10000,3209500,0.17);
INSERT INTO Stock VALUES('US0230290222',10000,1200500,0.05);
INSERT INTO Stock VALUES('US0230290223',10000,605300,3.14);

INSERT INTO Fund VALUES('US0230290224',200.06,'Mutual Fund','openEnd','AAA');
INSERT INTO Fund VALUES('US0230290225',260.06,'Mutual Fund','openEnd','BBB');

INSERT INTO InvolvesCrypto VALUES('US2345667891',212112, 1450000.00);
INSERT INTO InvolvesCrypto VALUES('US2345667893',212117, 1450000.00);

INSERT INTO InvolvesForex VALUES('F1232',212113,20.00);
INSERT INTO InvolvesForex VALUES('F1235',212118,120.00);

INSERT INTO InvolvesDerivatives VALUES('US8234291221',212114, 19.00);

INSERT INTO InvolvesBonds VALUES('US1234231211',212115, 10.00);

INSERT INTO InvolvesEquity VALUES('US0230290221',212116, 219.00);
INSERT INTO InvolvesEquity VALUES('US0230290224',212119, 140.00);
