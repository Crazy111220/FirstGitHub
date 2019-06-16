package com.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.SqlDateConverter;

import javax.sql.DataSource;
import java.util.Map;

public class JdbcUtil {
    private static DataSource ds = new ComboPooledDataSource();

    public static DataSource getDs() {
        return ds;
    }

    static {
        //1,处理java.sql.Date日期为null的情况
        ConvertUtils.register(new SqlDateConverter(null), java.sql.Date.class);
        //2、解决java.util.Date日期为null的情况
        ConvertUtils.register(new SqlDateConverter(null), java.util.Date.class);

    }

    public static <T> T mapToBean(Class<T> c, Map map) {
        try {
            T t = c.newInstance();
            BeanUtils.populate(t, map);
            return t;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}