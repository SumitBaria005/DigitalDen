package com.example.digitalDen.repository;

import com.example.digitalDen.entities.dealer.Dealer;
import com.example.digitalDen.entities.dealer.DealerAccountDetails;
import com.example.digitalDen.entities.dealer.ShopDetails;
import org.springframework.http.ResponseEntity;

public interface DealerRepository {
    ResponseEntity<String> addDealer(Dealer dealer);

    DealerAccountDetails addDealerAccount(DealerAccountDetails dealerAccountDetails);

    ShopDetails addDealerShop(ShopDetails shopDetails);
}
