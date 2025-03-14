package com.eazybytes.accounts.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounts")
public class Accounts extends BaseEntity {

    @Id
    @Column(name = "account_number", nullable = false, unique = true)
    private Long accountNumber;

    @Column(name = "account_type", nullable = false)
    private String accountType;

    @Column(name = "branch_address", nullable = false)
    private String branchAddress;

    @Column(name = "balance", nullable = false)
    private Double balance;

    @Column(name = "ifsc_code", nullable = false, length = 11)
    private String ifscCode;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

}
