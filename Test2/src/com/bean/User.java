package com.bean;

import java.util.Date;

public class User {
    private int id;
    private String num;
    private String name;
    private String addr;
    private Date create_date;
    private int cards_id;
    private Card card;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public int getCards_id() {
        return cards_id;
    }

    public void setCards_id(int cards_id) {
        this.cards_id = cards_id;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
