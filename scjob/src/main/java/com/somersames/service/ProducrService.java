package com.somersames.service;

import com.netflix.discovery.converters.Auto;
import com.somersames.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author szh
 * @create 2018-06-13 16:32
 **/
@Service
public class ProducrService {
    @Autowired
    ProductDao productDao;
}
