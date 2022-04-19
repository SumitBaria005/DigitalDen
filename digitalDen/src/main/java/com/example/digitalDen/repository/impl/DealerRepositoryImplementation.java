package com.example.digitalDen.repository.impl;

import com.example.digitalDen.DTO.response.DealerAccount;
import com.example.digitalDen.DTO.response.DealerData;
import com.example.digitalDen.DTO.response.DealerShops;
import com.example.digitalDen.db.util.JDBCAccess;
import com.example.digitalDen.db.util.JPAAccess;
import com.example.digitalDen.entities.dealer.Dealer;
import com.example.digitalDen.entities.dealer.DealerAccountDetails;
import com.example.digitalDen.entities.dealer.ShopDetails;
import com.example.digitalDen.repository.DealerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DealerRepositoryImplementation implements DealerRepository {
    @Inject
    JPAAccess jpaAccess;

    @Inject
    JDBCAccess jdbcAccess;

    private String GET_SHOPS="SELECT * FROM digitalden.shopdetails WHERE dealer_id=?";

    private String GET_DEALER="SELECT * FROM digitalden.dealer WHERE id=?";

    private String GET_DEALER_ACCOUNT="SELECT * FROM digitalden.dealeraccountdetails WHERE dealer_id=?";

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

    @Override
    public List<DealerShops> getDealerShops(Integer dealerId) {
         List<DealerShops> dealerShops=jdbcAccess.find(GET_SHOPS, new RowMapper<DealerShops>() {
             @Override
             public DealerShops mapRow(ResultSet rs, int rowNum) throws SQLException {
                 DealerShops dealerShops1=new DealerShops();
                 dealerShops1.setAddress(rs.getString("address"));
                 dealerShops1.setBusinessEmail(rs.getString("business_email"));
                 dealerShops1.setCountry(rs.getString("country"));
                 dealerShops1.setShopContact(rs.getString("shop_contact"));
                 dealerShops1.setCreatedDate(rs.getString("created_date"));
                 dealerShops1.setState(rs.getString("state"));
                 dealerShops1.setPinCode(rs.getString("pin_code"));
                 return dealerShops1;
             }
         },dealerId);
        return dealerShops;
    }

    public DealerAccount getDealerAccount(Integer dealerId) {
        DealerAccount dealerAccount=jdbcAccess.findOne(GET_DEALER_ACCOUNT, new RowMapper<DealerAccount>() {
            @Override
            public DealerAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
                DealerAccount dealerAccount1=new DealerAccount();
                dealerAccount1.setAccountNo(rs.getString("account_no"));
                dealerAccount1.setIFSCcode(rs.getString("ifsc_code"));
                dealerAccount1.setBankName(rs.getString("bank_name"));
                dealerAccount1.setCreatedDate(rs.getString("created_date"));
                return dealerAccount1;
            }
        },dealerId);
        return dealerAccount;
    }

    @Override
    public DealerData getDealer(Integer dealerId) {
        DealerData dealerData=jdbcAccess.findOne(GET_DEALER, new RowMapper<DealerData>() {
            @Override
            public DealerData mapRow(ResultSet rs, int rowNum) throws SQLException {
                DealerData dealerData1=new DealerData();
                dealerData1.setDealerShops(getDealerShops(dealerId));
                dealerData1.setDealerAccount(getDealerAccount(dealerId));
                dealerData1.setAddress(rs.getString("address"));
                dealerData1.setContactNo(rs.getString("contact"));
                dealerData1.setDateOfBirth(rs.getString("date_of_birth"));
                dealerData1.setEmail(rs.getString("email"));
                dealerData1.setName(rs.getString("name"));
                return dealerData1;
            }
        },dealerId);
        return dealerData;
    }
}
