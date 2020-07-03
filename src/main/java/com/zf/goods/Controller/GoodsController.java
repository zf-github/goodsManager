package com.zf.goods.Controller;

import com.zf.goods.bean.Goods;
import com.zf.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private int page_numbers = 3;

    @GetMapping("")
    @ResponseBody
    public Map getGoodsList(@RequestParam(name="page",required = false)Integer page){                          //获取商品列表的映射
        Map<String,Object> map = new HashMap<>();

        List<Goods> list = null;
        int total = goodsService.getGoodsList().size();
        if(page == null){
            list = goodsService.getGoodsList().subList(0,page_numbers);
        }else{
            List newList = goodsService.getGoodsList();
            if(page >= newList.size()/page_numbers + 1){            //如果超过当前页，则获取最后一页的商品
                list = newList.subList((newList.size()/page_numbers)*page_numbers,newList.size());     //除以乘以就获取到开始的位置，一直到结束
            }else{
                //如果是第二页，则需要从列表中截取5-10即（page_numbers*(page-1)到page_numbers*page）
                list = goodsService.getGoodsList().subList(page_numbers*(page-1),page_numbers*page);
            }
        }
        map.put("total",total);
        map.put("data",list);
        map.put("page_size",page_numbers);
        return map;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Goods getGoods(@PathVariable(name="id",required = true)int id){          //获取某个商品的映射
        Goods goods = goodsService.getOneGoods(id);
        return goods;
    }

    @PostMapping("")
    @ResponseBody
    public int addGoods(@RequestParam(name="name",required = true)String name,
                          @RequestParam(name="size",required = true)String size,
                          @RequestParam(name="produce_date",required = true)String produce_date,
                          @RequestParam(name="barcode",required = true)String barcode,
                          @RequestParam(name="batch",required = true)String batch,
                          @RequestParam(name="nums",required = true)String nums,
                          @RequestParam(name="note",required = true)String note,
                          @RequestParam(name="thumbnail",required = true)String thumbnail){         //添加商品的映射

        Date date = null;
        try {
            date = sdf.parse(produce_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int code = goodsService.addGoods(name,size,date,Long.parseLong(barcode),batch,Integer.parseInt(nums),note,thumbnail);
        return code;
    }


    @PutMapping("/{goods_id}")
    @ResponseBody
    public int updateGoods(@PathVariable(name="goods_id",required = true)int goods_id,
                            @RequestParam(name="name",required = true)String name,
                           @RequestParam(name="size",required = true)String size,
                           @RequestParam(name="produce_date",required = true)String produce_date,
                           @RequestParam(name="barcode",required = true)long barcode,
                           @RequestParam(name="batch",required = true)String batch,
                           @RequestParam(name="nums",required = true)int nums,
                           @RequestParam(name="note",required = true)String note,
                           @RequestParam(name="thumbnail",required = true)String thumbnail){            //更新商品的映射
        System.out.println("goods_id:"+goods_id);
        System.out.println("name:"+name);
        Date date = null;
        try {
            date = sdf.parse(produce_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int code = goodsService.updateGoods(name,size,date,barcode,batch,nums,note,thumbnail,goods_id);
        return code;
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public int deleteGoods(@PathVariable(name="id",required = true)int id){                             //删除商品的映射
        int code = goodsService.deleteGoods(id);
        return code;
    }

    @RequestMapping("/search")
    @ResponseBody
    public Map searchGoods(String q){                                                           //搜索商品的映射
        Map<String, Object> map = new HashMap<>();

        List<Goods> list = goodsService.searchGoodsList(q);
        int size = list.size();
        map.put("data",list);
        map.put("total",size);
        map.put("page_size",page_numbers);
        return map;
    }

    @PostMapping("/delete")
    @ResponseBody
    public int batchDeleteGoods(@RequestParam(name="dList",required = true)String dList){
        List<Integer> list = new ArrayList<>();
        String[] sList = dList.replace("[","").replace("]","").split(",");
        for (String s:sList) {
            list.add(Integer.valueOf(s));
        }
        int code = 0;
        for (int i:list) {
            code = goodsService.deleteGoods(i);
        }
        return code;
    }

    @PostMapping("/upload")
    @ResponseBody
    public Map<String,String> uploadImage(@RequestParam(value = "file") MultipartFile file, Model model, HttpServletRequest request){
        Map<String,String> imageMap = new HashMap();

        if (file.isEmpty()) {
            System.out.println("文件为空空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名

        String filePath = System.getProperty("user.dir");
        filePath = filePath + "\\src\\main\\resources\\static\\images\\";

        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String url = "/images/" + fileName;
        imageMap.put("path",url);
        return imageMap;
    }

}
