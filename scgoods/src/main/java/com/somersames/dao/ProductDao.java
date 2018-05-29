package com.somersames.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductDao {
    List<Map<Object,Object>> queryProduct(@Param("type") String type);
}
