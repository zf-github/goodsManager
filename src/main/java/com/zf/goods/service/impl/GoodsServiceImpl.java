package com.zf.goods.service.impl;

import com.zf.goods.bean.Goods;
import com.zf.goods.dao.GoodsMapper;
import com.zf.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> getGoodsList() {
        return goodsMapper.select();
    }

    @Override
    public Goods getOneGoods(int id) {
        return goodsMapper.selectOne(id);
    }

    @Override
    public int addGoods(String name, String size, Date produce_date, long barcode, String batch, int nums, String note, String thumbnail) {
        return goodsMapper.insert(name,size,produce_date,barcode,batch,nums,note,thumbnail);
    }

    @Override
    public int updateGoods(String name, String size, Date produce_date, long barcode, String batch, int nums, String note, String thumbnail,int goods_id) {
        System.out.println("service:"+goods_id);
        return goodsMapper.updateGoods(name,size,produce_date,barcode,batch,nums,note,thumbnail,goods_id);
    }

    @Override
    public int deleteGoods(int id) {
        return goodsMapper.deleteGoods(id);
    }

    @Override
    public List<Goods> searchGoodsList(String q) {
        return goodsMapper.search(q);
    }
}
