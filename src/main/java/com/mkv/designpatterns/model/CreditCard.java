package com.mkv.designpatterns.model;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public abstract class CreditCard {
    private String cardNumber;
    private String creditCardHolderName;
    private Date expirationDate;
    private CreditCardTypes type;
}
