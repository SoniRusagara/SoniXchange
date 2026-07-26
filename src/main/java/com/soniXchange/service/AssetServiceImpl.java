package com.soniXchange.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soniXchange.model.Asset;
import com.soniXchange.model.Coin;
import com.soniXchange.model.User;
import com.soniXchange.repository.AssetRepository;

@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    private AssetRepository assetRepository;

    @Override
    public Asset createAsset(User user, Coin coin, double quantity) {
        // TODO Continue off here
        return null;
    }

    @Override
    public Asset getAssetById(Long assetId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAssetById'");
    }

    @Override
    public Asset getAssetByUserIdAndId(Long userId, Long assetId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAssetByUserIdAndId'");
    }

    @Override
    public List<Asset> getUsersAssets(Long userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsersAssets'");
    }

    @Override
    public Asset updateAsset(Long assetId, double quantity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateAsset'");
    }

    @Override
    public Asset findAssetByUserIdAndCoinId(Long userId, String coinId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAssetByUserIdAndCoinId'");
    }

    @Override
    public void deleteAsset(Long assetId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAsset'");
    }
    
}
