package com.koko.java8.design.strategy;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * strategy pattern using lambda
 */
public class AssetUtilRefactored {
	public static void main(String[] args) {
		final List<Asset> assets = Arrays.asList(
				new Asset(Asset.AssetType.BOND, 1000),
				new Asset(Asset.AssetType.BOND, 2000),
				new Asset(Asset.AssetType.STOCK, 3000),
				new Asset(Asset.AssetType.STOCK, 4000)
		);

		System.out.println("Total of all assets: " + totalAssetValues(assets, asset -> true));
		System.out.println("Total of bonds: " + totalAssetValues(assets, asset -> asset.getType() == Asset.AssetType.BOND));
		System.out.println("Total of stocks: " + totalAssetValues(assets, asset -> asset.getType() == Asset.AssetType.STOCK));
	}

	public static int totalAssetValues(final List<Asset> assets,
									   final Predicate<Asset> assetSelector) {
		return assets.stream()
				.filter(assetSelector)
				.mapToInt(Asset::getValue)
				.sum();
	}
}
