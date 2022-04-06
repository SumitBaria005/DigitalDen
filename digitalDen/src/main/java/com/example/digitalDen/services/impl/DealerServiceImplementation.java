package com.example.digitalDen.services.impl;

import com.example.digitalDen.DTO.response.DealerData;
import com.example.digitalDen.DTO.response.DealerShops;
import com.example.digitalDen.entities.dealer.Dealer;
import com.example.digitalDen.entities.dealer.DealerAccountDetails;
import com.example.digitalDen.entities.dealer.ShopDetails;
import com.example.digitalDen.repository.DealerRepository;
import com.example.digitalDen.services.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DealerServiceImplementation implements DealerService {

    @Autowired
    DealerRepository dealerRepository;
    @Override
    public ResponseEntity<String> addDealer(Dealer dealer) {
        return dealerRepository.addDealer(dealer);
    }

    @Override
    public DealerAccountDetails addDealerAccount(DealerAccountDetails dealerAccountDetails) {
        return dealerRepository.addDealerAccount(dealerAccountDetails);
    }

    @Override
    public ShopDetails addDealerShop(ShopDetails shopDetails) {
        return dealerRepository.addDealerShop(shopDetails);
    }

    @Override
    public List<DealerShops> getDealerShops(Integer dealerId) {
        return dealerRepository.getDealerShops(dealerId);
    }

    @Override
    public DealerData getDealer(Integer dealerId) {
        return dealerRepository.getDealer(dealerId);
    }
}
