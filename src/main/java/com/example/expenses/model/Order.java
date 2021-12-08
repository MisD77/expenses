package com.example.expenses.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Builder
public class Order {

    @Id
    private Long orderId;
    private String user;
    private String orderName;
    private String description;
    private float cost;
    private String reasonForPurchase;

    /*
    * 1. RESTful endpoint for a new purchase order request
    1. Fields:
        1. User
        2. Item Name
        3. Item Description
        4. Item Cost
        5. Reason For Purchase (list of values can be "Required for job performance",
        *  "Job performance improvement", and "Other". When "Other",
        * then provide a text area to provide additional information)
    * */

}
