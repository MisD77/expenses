package com.example.expenses.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Builder
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long orderId;
    private String userName;
    private String orderName;
    private String description;
    private Float cost;
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
