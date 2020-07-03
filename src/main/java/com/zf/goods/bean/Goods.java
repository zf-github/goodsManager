package com.zf.goods.bean;

public class Goods {
    int id;                         //商品id
    String name;                    //商品名称
    String size;                    //商品规格
    String produce_date;            //商品生产日期
    long barcode;                   //条码
    String batch;                   //生产批次
    int nums;                       //商品数量
    String note;                    //商品备注
    String thumbnail;               //商品缩略图

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setProduce_date(String produce_date) {
        this.produce_date = produce_date;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public String getProduce_date() {
        return produce_date;
    }

    public long getBarcode() {
        return barcode;
    }

    public String getBatch() {
        return batch;
    }

    public int getNums() {
        return nums;
    }

    public String getNote() {
        return note;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
