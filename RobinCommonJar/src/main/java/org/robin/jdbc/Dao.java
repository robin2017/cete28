package org.robin.jdbc;

import java.io.Serializable;

public interface Dao<T> {
	//�г�һЩͨ�õķ���������������ѯ
	T findById(Serializable id, String sql, RowMapper<T> rm);
	//����������ѯ
	//List<T> find(String sql, RowMapper<T> rm, Object... obj);
	//��ɾ��
	int saveOrUpOrDel(String sql, Object... obj);
}
