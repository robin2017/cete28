package org.robin.jdbc.sql;

import java.lang.reflect.Field;

/**
 * Created by robin on 2017/8/19.
 */
public class BeanSQL {
    public static String insertBeanSQL(Object obj) {
        Class c = obj.getClass();
        StringBuffer s = new StringBuffer();
        s.append("insert into ");
        String tablename = c.getSimpleName();
        DBTable entity = (DBTable) c.getAnnotation(DBTable.class);
        if (entity != null)
            tablename = entity.value();
        s.append(tablename);
        s.append("(");
        Field[] fs = c.getDeclaredFields();
        for (int i = 0; i < fs.length; i++) {
            String columnName = fs[i].getName();
            DBAttr column = fs[i].getAnnotation(DBAttr.class);
            if (column != null)
                columnName = column.value();
            s = i == 0 ? s.append(columnName) : s.append(",").append(columnName);
        }
        s.append(")values").append(getString(fs.length));
        System.out.println("BeanSQL----->" + s.toString());
        return s.toString();
    }

    //这个方法注意，不然就删掉所有记录
    public static String deleteBeanByConditionSQL(Object obj, String... conditions) {
        Class c = obj.getClass();
        StringBuffer sb = new StringBuffer();
        sb.append("delete from ");
        String tableName = c.getSimpleName();
        DBTable entity = (DBTable) c.getAnnotation(DBTable.class);
        if (entity != null)
            tableName = entity.value();
        sb.append(tableName);
        for (int i = 0; i < conditions.length; i++)
            sb = i == 0 ? sb.append(" where ").append(conditions[i] + " = ? ") : sb.append("and ").append(conditions[i] + " = ? ");
        System.out.println("BeanSQL----->" + sb.toString());
        return sb.toString();
    }

    //这个方法注意，不然就更新所有数据
    public static String updateBeanByConditionSQL(Object obj, String... conditions) {
        Class c = obj.getClass();
        StringBuffer sb = new StringBuffer();
        sb.append("update ");
        String tableName = c.getSimpleName();
        DBTable entity = (DBTable) c.getAnnotation(DBTable.class);
        if (entity != null)
            tableName = entity.value();
        sb.append(tableName).append(" set ");
        Field[] fs = c.getDeclaredFields();
        for (int i = 0; i < fs.length; i++) {
            String attrName = fs[i].getName();
            DBAttr column = fs[i].getAnnotation(DBAttr.class);
            if (column != null)
                attrName = column.value();
            sb = i == 0 ? sb.append(attrName).append(" = ?") : sb.append(",").append(attrName).append(" = ?");
        }
        for (int i = 0; i < conditions.length; i++)
            sb = i == 0 ? sb.append(" where ").append(conditions[i] + " = ? ") : sb.append("and ").append(conditions[i] + " = ? ");
        System.out.println("BeanSQL----->" + sb.toString());
        return sb.toString();
    }

    public static String getBeanByConditionSQL(Object obj, String... conditions) {
        Class c = obj.getClass();
        StringBuffer sb = new StringBuffer();
        sb.append("select * from ");
        String tableName = c.getSimpleName();
        DBTable entity = (DBTable) c.getAnnotation(DBTable.class);
        if (entity != null)
            tableName = entity.value();
        sb.append(tableName);
        for (int i = 0; i < conditions.length; i++)
            sb = i == 0 ? sb.append(" where ").append(conditions[i] + " = ? ") : sb.append("and ").append(conditions[i] + " = ? ");
        System.out.println("BeanSQL----->" + sb.toString());
        return sb.toString();
    }

    private static String getString(int length) {
        StringBuffer s = new StringBuffer();
        s.append("(");
        for (int i = 0; i < length; i++) {
            s = i == 0 ? s.append("?") : s.append(",?");
        }
        return s.append(")").toString();
    }
}
