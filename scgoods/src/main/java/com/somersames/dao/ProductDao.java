package com.somersames.dao;

import com.somersames.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.omg.CORBA.OBJ_ADAPTER;

import java.util.List;
import java.util.Map;
@Mapper
public interface ProductDao {
    /**
     * 根据Type查询出所有的物品
     * @param type
     * @return
     */
    List<Goods> queryProduct(@Param("type") String type);

    /**
     * 根据用户名查询该用户的所有物品
     * @param userName
     * @return
     */
    List<Map<Object,Object>> queryProductByUserName(@Param("userName") String userName);

    /**
     * 新增物品
     * @param goods
     * @return
     */
    int insertNewProduct(Goods goods);

    /**
     * 删除物品，只在Controller进行校验
     * @param goodsId
     * @return
     */
    int deleteProoduct(@Param("goodsId") int goodsId);

    /**
     * 更新物品
     * @param goods
     * @return
     */
    int updateProduct(@Param(("goods")) Goods goods);
}
