package com.zf.goods.service;

import com.zf.goods.bean.Goods;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface GoodsService {
    List<Goods> getGoodsList();         //查询商品列表

    Goods getOneGoods(int id);          //根据id查询商品

    int addGoods(String name, String size, Date produce_date,long barcode,String batch,int nums,String note,String thumbnail);    //添加商品

    int updateGoods(String name, String size, Date produce_date,long barcode,String batch,int nums,String note,String thumbnail,int goods_id);   //更新商品

    int deleteGoods(int id);            //根据id删除商品

    List<Goods> searchGoodsList(String q);      //查询商品
}
