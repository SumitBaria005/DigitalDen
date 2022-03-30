package com.example.digitalDen.repository.impl;

import com.example.digitalDen.db.util.JPAAccess;
import com.example.digitalDen.entities.dealer.Dealer;
import com.example.digitalDen.entities.dealer.DealerAccountDetails;
import com.example.digitalDen.entities.dealer.ShopDetails;
import com.example.digitalDen.repository.DealerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository
public class DealerRepositoryImplementation implements DealerRepository {
    @Inject
    JPAAccess jpaAccess;
    @Override
    public ResponseEntity<String> addDealer(Dealer dealer) {
        jpaAccess.save(dealer);
        return ResponseEntity.status(HttpStatus.OK).body("Dealer is Successfully Added! Thank you");
    }

    @Override
    public DealerAccountDetails addDealerAccount(DealerAccountDetails dealerAccountDetails) {
        jpaAccess.save(dealerAccountDetails);
        return dealerAccountDetails;
    }

    @Override
    public ShopDetails addDealerShop(ShopDetails shopDetails) {
        jpaAccess.save(shopDetails);
        return shopDetails;
    }
}
