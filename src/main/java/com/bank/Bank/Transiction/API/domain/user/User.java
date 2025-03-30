package com.bank.Bank.Transiction.API.domain.user;

import java.util.List;

import com.bank.Bank.Transiction.API.domain.account.Account;
import com.bank.Bank.Transiction.API.domain.card.Card;
import com.bank.Bank.Transiction.API.domain.feature.Feature;
import com.bank.Bank.Transiction.API.domain.news.News;
import com.bank.Bank.Transiction.API.dto.UserDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="users")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String firstname;
    private String lastName;

    @Column(unique = true)
    private String document;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    private Card card;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Feature> feature;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<News> news;

    public User(UserDTO data) {
        this.firstname = data.firstname();
        this.lastName = data.lastName();
        this.document = data.document();
        this.userType = data.userType();
        this.email = data.email();
        this.password = data.password();

        if(data.account() != null) {
            Account newAccount = new Account();
            newAccount.setNumber(data.account().number());
            newAccount.setBalance(data.account().balance());
            newAccount.setLimit(data.account().limit());
            newAccount.setAgency(data.account().agency());
            this.account = newAccount;
        }

        if(data.card() != null) {
            Card newCard = new Card();
            newCard.setLimit(data.card().limit());
            newCard.setNumber(data.card().number());
            this.card = newCard;
        }
    }

}
