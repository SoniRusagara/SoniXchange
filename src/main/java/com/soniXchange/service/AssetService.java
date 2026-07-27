package com.soniXchange.service;

import java.util.List;

import com.soniXchange.model.Asset;
import com.soniXchange.model.Coin;
import com.soniXchange.model.User;

public interface AssetService {

    Asset createAsset(User user, Coin coin, double quantity);

    Asset getAssetById(Long assetId) throws Exception;

    Asset getAssetByUserIdAndId(Long userId, Long assetId);

    List<Asset> getUsersAssets(Long userId);

    Asset updateAsset(Long assetId, double quantity) throws Exception;

    Asset findAssetByUserIdAndCoinId(Long userId, String coinId);

    void 