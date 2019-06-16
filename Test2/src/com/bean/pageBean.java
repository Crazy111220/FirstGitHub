package com.bean;

public class pageBean {
    //1.四大参数
    private int size = 3;
    private int currPage = 1;
    private int count;
    private int totalPage;
    //2.查询参数
    private String cards_id;
    private String name;

    public String getCards_id() {
        return cards_id;
    }

    public void setCards_id(String cards_id) {
        this.cards_id = cards_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
