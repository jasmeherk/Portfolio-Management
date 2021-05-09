--AGGREGATION

--Find the derivative with the highest asset value for each asset type
SELECT underlyingAssetType, ROUND(MAX(underlyingAssetValue), 2)
FROM Derivatives
GROUP BY underlyingAssetType;