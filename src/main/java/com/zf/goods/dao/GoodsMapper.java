package com.zf.goods.dao;

import com.zf.goods.bean.Goods;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface GoodsMapper {
    @Select("select * from goods")
    List<Goods> select();

    @Select("select * from goods where id=#{id}")
    Goods selectOne(@Param("id") int id);

    @Select("SELECT * FROM goods where name LIKE CONCAT('%',#{q},'%') or barcode like CONCAT('%',#{q},'%')")
    List<Goods> search(@Param("q")String q);


    @Insert("insert into goods(name,size,produce_date,barcode,batch,nums,note,thumbnail) values(#{name},#{size,jdbcType=VARCHAR,javaType=String},#{produce_date},#{barcode},#{batch},#{nums},#{note},#{thumbnail})")
    int insert(@Param("name") String name,
               @Param("size") String size,
               @Param("produce_date")Date produce_date,
               @Param("barcode") long barcode,
               @Param("batch") String batch,
               @Param("nums") int nums,
               @Param("note") String note,
               @Param("thumbnail") String thumbnail);

    @Update("update goods set name=#{name},size=#{size,jdbcType=VARCHAR,javaType=String},produce_date=#{produce_date},barcode=#{barcode},batch=#{batch},nums=#{nums},note=#{note},thumbnail=#{thumbnail} where id=#{goods_id}")
    int updateGoods(@Param("name") String name,
                    @Param("size") String size,
                    @Param("produce_date")Date produce_date,
                    @Param("barcode") long barcode,
                    @Param("batch") String batch,
                    @Param("nums") int nums,
                    @Param("note") String note,
                    @Param("thumbnail") String thumbnail,
                    @Param("goods_id") int goods_id);

    @Delete("delete from goods where id=#{id}")
    int deleteGoods(@Param("id")int id);

}
