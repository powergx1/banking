//package com.jaqg.banking.entities;
//
//import com.jaqg.banking.enums.TransactionType;
//import jakarta.persistence.*;
//import org.hibernate.annotations.CreationTimestamp;
//import org.springframework.data.annotation.CreatedDate;
//
//import java.io.Serial;
//import java.io.Serializable;
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//
//@Entity
//public class TransactionToDelete implements Serializable {
//
//    @Serial
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // This helps auto-generate primary keys
//    private long id;
//
//    @CreatedDate
//    @CreationTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(nullable = false, updatable = false)
//    private LocalDateTime dateTime;
//
//    @Column(precision = 16, scale = 2, nullable = false)
//    private BigDecimal value;
//
//    @Enumerated(EnumType.STRING)
//    @Column(length = 10, nullable = false)
//    private TransactionType type;
//
//    @ManyToOne
//    @JoinColumn(name = "recipient_id", updatable = false)
//    private Account recipient; // to account
//
//    private Long recipientSourceCode;
//
//    @ManyToOne
//    @JoinColumn(name = "sender_id", updatable = false)
//    private Account sender;
//
//    private Long senderSourceCode;
//
//    public TransactionToDelete(LocalDateTime dateTime, BigDecimal value, TransactionType type, Account recipient, Account sender) {
//        this.dateTime = dateTime;
//        this.value = value;
//        this.type = type;
//        setRecipient(recipient);
//        setSender(sender);
//    }
//
//    public TransactionToDelete() {
//    }
//
//    public Account getSender() {
//        return sender;
//    }
//
//    public void setSender(Account sender) {
//        if (recipient != null) {
//            recipient.addDebitTransaction(this);
//        }
//        this.sender = sender;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public LocalDateTime getDateTime() {
//        return dateTime;
//    }
//
//    public void setDateTime(LocalDateTime dateTime) {
//        this.dateTime = dateTime;
//    }
//
//    public BigDecimal getValue() {
//        return value;
//    }
//
//    public void setValue(BigDecimal transVal) {
//        this.value = transVal;
//    }
//
//    public TransactionType getType() {
//        return type;
//    }
//
//    public void setType(TransactionType transType) {
//        this.type = transType;
//    }
//
//    public Account getRecipient() {
//        return recipient;
//    }
//
//    public void setRecipient(Account recipient) {
//        if (recipient != null) {
//            recipient.addCreditTransaction(this);
//        }
//        this.recipient = recipient;
//    }
//
//    public Long getFromAccountNumber() {
//        return sender == null ? null : sender.getNumber();
//    }
//
//    public Integer getFromAccountSourceCode() {
//        return sender == null ? null : sender.getSortCode();
//    }
//
//    public Long getToAccountNumber() {
//        return recipient == null ? null : recipient.getNumber();
//    }
//
//    public Integer getToAccountSourceCode() {
//        return recipient == null ? null : recipient.getSortCode();
//    }
//}