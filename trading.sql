CREATE TABLE UserAccount
	(customerID int NOT NULL,
 	 sin int NOT NULL,
	 IDType varchar(20) NOT NULL,
	 IDNum varchar(20) NOT NULL,
 	 name varchar(20) NOT NULL,
  	 address varchar(50) NULL,
 	 phone varchar(13) NOT NULL,
  	 email varchar(20) NOT NULL,
 	 password varchar(16) NOT NULL,
 	 PRIMARY KEY (customerID),
  	 UNIQUE (sin, IDNum));

grant select on UserAccount to public;

CREATE TABLE TradingAccount
	(accountNum int NOT NULL,
	 balance FLOAT(2),
	 PRIMARY KEY (accountNum));

grant select on TradingAccount to public;

CREATE TABLE Owns
	(customerID int NOT NULL,
	 accountNum int NOT NULL,
	 PRIMARY KEY (customerID, accountNum),
	 UNIQUE (accountNum),
	 FOREIGN KEY (customerID) REFERENCES UserAccount ON DELETE CASCADE,
	 FOREIGN KEY (accountNum) REFERENCES TradingAccount ON DELETE CASCADE);

grant select on Owns to public;

CREATE TABLE CreatesTransaction
	(id int NOT NULL,
	 type varchar(4) NULL,
	 amount FLOAT(2) NULL,
	 accountNum int NOT NULL,
	 transactionType varchar(15) NOT NULL, 
	 status varchar(15) NOT NULL,
	 country varchar(20) NULL,
	 exchange varchar(20) NULL,
	 units FLOAT(2) NULL,
	 PRIMARY KEY (accountNum, id),
	 FOREIGN KEY (accountNum) REFERENCES TradingAccount);

grant select on CreatesTransaction to public;

CREATE TABLE HasAPortfolio
	(portfolioID int NOT NULL,
	 instrumentID varchar(12) NOT NULL,
 	 units FLOAT(2) NULL,		    
	 accountNum int NOT NULL,
	 status	varchar(10) NOT NULL,
	 PRIMARY KEY (accountNum, portfolioID, instrumentID),
 	 FOREIGN KEY (accountNum) REFERENCES TradingAccount);

grant select on HasAPortfolio to public;

CREATE TABLE TransactionModifiesPortfolio
	(portfolioID int NOT NULL,
	 instrumentID varchar(12) NOT NULL,
	 portAccountNum int NOT NULL,
	 portUnits FLOAT(2) NULL,
	 transactionID int NOT NULL,
	 transAccountNum int NOT NULL,
	 type varchar(4) NULL,
	 transUnits FLOAT(2) NULL,
	 PRIMARY KEY (transactionID),
	 FOREIGN KEY (transactionID, transAccountNum) REFERENCES CreatesTransaction (id, accountNum));

grant select on TransactionModifiesPortfolio to public;

CREATE TABLE Crypto
	(isin CHAR(12) NOT NULL,
	 symbol varchar(9) NOT NULL,
	 name varchar(20) NULL,
	 volume FLOAT(2) NULL,
	 timestamp TIMESTAMP NULL,
	 price FLOAT(2) NULL,
	 PRIMARY KEY (isin),
 	 UNIQUE (symbol));

grant select on Crypto to public;

CREATE TABLE Forex
	(id varchar(12) NOT NULL,
 	 fromCurrency varchar(20) NULL,
     fromCurrCode varchar(5) NOT NULL,
	 toCurrency varchar(20) NULL,
	 toCurrCode varchar(5) NOT NULL,
	 timestamp TIMESTAMP NULL,
	 price FLOAT(2) NULL,
	 PRIMARY KEY (id));

grant select on Forex to public;

CREATE TABLE Bonds
	(isin CHAR(12) NOT NULL,
	 issueDate DATE NOT NULL, 
	 purchaseDate DATE NOT NULL,
 	 faceValue FLOAT(2) NOT NULL,
 	 couponRate FLOAT(2) NULL,
 	 interestRate FLOAT(2) NOT NULL,
	 timeToMaturity	int NOT NULL,
	 tradePrice FLOAT(2) NULL,
	 issuingEntityName varchar(20) NULL,
	 timestamp TIMESTAMP NULL,
	 PRIMARY KEY (isin));

grant select on Bonds to public;

CREATE TABLE Derivatives
	(isin CHAR(12) NOT NULL,
	 name varchar(20) NULL,
	 instrumentName	varchar(20) NOT NULL,
	 instrumentType	varchar(20) NOT NULL,
	 longOrShort varchar(5) NOT NULL,
	 putOrCall varchar(4) NOT NULL,
	 underlyingAssetType varchar(20) NOT NULL,
	 underlyingAssetValue FLOAT(2) NULL,
	 exciseDate DATE NOT NULL,
	 strikePrice FLOAT(2) NOT NULL,
	 PRIMARY KEY(isin));	

grant select on Derivatives to public;	

CREATE TABLE Equity
	(isin CHAR(12) NOT NULL,
	 price FLOAT(2) NULL,
	 name varchar(20) NULL,
	 PRIMARY KEY(isin));

grant select on Equity to public;

CREATE TABLE Stock
	(isin CHAR(12) NOT NULL,
	 volume int NULL,
	 marketCap FLOAT(2) NULL,
	 delta24 FLOAT(2) NULL,
	 PRIMARY KEY (isin));

grant select on Stock to public;

CREATE TABLE Fund
	(isin CHAR(12),
	 nav FLOAT(2),
	 type varchar(20),
	 openEndOrCloseEnd varchar(10),
	 analystRatings	varchar(10),
	 PRIMARY KEY(isin));

grant select on Fund to public;

CREATE TABLE InvolvesCrypto
	(isin CHAR(12),
	 transactionID int,
	 units FLOAT(2),
	 PRIMARY KEY (isin, transactionID),
	 FOREIGN KEY (isin) REFERENCES Crypto,
	 FOREIGN KEY (transactionID) REFERENCES TransactionModifiesPortfolio);

grant select on InvolvesCrypto to public;

CREATE TABLE InvolvesForex
	(forexID varchar(12),
	 transactionID int,
	 units FLOAT(2),
	 PRIMARY KEY (forexID, transactionID),
	 FOREIGN KEY (forexID) REFERENCES Forex,
	 FOREIGN KEY (transactionID) REFERENCES TransactionModifiesPortfolio);

grant select on InvolvesForex to public;

CREATE TABLE InvolvesDerivatives
	(isin CHAR(12),
	 transactionID int,
	 units int,
	 PRIMARY KEY (isin, transactionID),
	 FOREIGN KEY (isin) REFERENCES Derivatives,
	 FOREIGN KEY (transactionID) REFERENCES TransactionModifiesPortfolio);

grant select on InvolvesDerivatives to public;

CREATE TABLE InvolvesBonds
	(isin CHAR(12),
	 transactionID int,
	 units int,
	 PRIMARY KEY (isin, transactionID),
	 FOREIGN KEY (isin) REFERENCES Bonds,
	 FOREIGN KEY (transactionID) REFERENCES TransactionModifiesPortfolio);

grant select on InvolvesBonds to public;

CREATE TABLE InvolvesEquity
	(isin CHAR(12),
	 transactionID int,
	 units int,
	 PRIMARY KEY (isin, transactionID),
	 FOREIGN KEY (isin) REFERENCES Equity,
	 FOREIGN KEY (transactionID) REFERENCES TransactionModifiesPortfolio);

grant select on InvolvesEquity to public;
