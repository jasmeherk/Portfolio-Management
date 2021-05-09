--AGGREGATION

--Find the derivative with the highest asset value for each asset type with at least 2 instruments
SELECT underlyingAssetType, ROUND(MAX(underlyingAssetValue), 2)
FROM Derivatives
GROUP BY underlyingAssetType
HAVING COUNT(*) > 1;
