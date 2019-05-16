package com.welfare.service;

import java.util.List;

import com.welfare.model.Goods;
import com.welfare.model.GoodsSKU;

public interface GoodsService {
	
	public List<Goods> selectList();
	public List<GoodsSKU> selectSKUById(int idGoods);
	

}
