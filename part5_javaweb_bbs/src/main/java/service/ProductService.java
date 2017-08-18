package service;

import entity.Product;
import jdbc.DaoSupport;
import jdbc.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductService {
	private DaoSupport<Product> ds = new DaoSupport<Product>();

	public List<Product> getAll() {
		return ds.find("select * from product", new ProductRowMapper());
	}

	public Product findById(int id) {
		return ds.findById(id, "select * from product where id= ?",
				new ProductRowMapper());

	}

	public int update(Product product) {
		return ds.saveOrUpOrDel(
				"update product set proname=?,prodes=?,proCount=? where id=?",
				product.getProname(), product.getProdes(),
				product.getProCount(), product.getId());

	}
	public int delProd(int id){
		return ds.saveOrUpOrDel("delete from product where id = ?",id);
		
	}
}

class ProductRowMapper implements RowMapper<Product> {

	@Override
	public Product getRow(ResultSet rs) throws SQLException {
		Product p = new Product(rs.getInt("id"), rs.getString("proname"),
				rs.getString("prodes"), rs.getInt("procount"));
		return p;
	}

}
