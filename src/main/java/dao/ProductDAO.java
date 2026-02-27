package dao;

import util.DBConnect;
import model.Product;

import java.sql.*;
import java.util.*;

public class ProductDAO {

	public List<Product> getAll() {

		List<Product> list = new ArrayList<>();

		try (Connection con = DBConnect.getConnection()) {

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM products");

			while (rs.next()) {

				Product p = new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"),
						rs.getInt("quantity"));

				list.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public void insert(Product p) {

		String sql = "INSERT INTO products(name,price,installment,quantity,category,description) VALUES(?,?,?,?,?,?)";

		try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, p.getName());
			ps.setDouble(2, p.getPrice());
			ps.setDouble(3, p.getInstallment());
			ps.setInt(4, p.getQuantity());
			ps.setInt(5, p.getCategory());
			ps.setString(6, p.getDescription());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {

		String sql = "DELETE FROM products WHERE id=?";

		try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Product getById(int id) {

		String sql = "SELECT * FROM products WHERE id=?";

		try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				return new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getInt("quantity"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void update(Product p) {

		String sql = "UPDATE products SET name=?, price=?, quantity=? WHERE id=?";

		try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, p.getName());
			ps.setDouble(2, p.getPrice());
			ps.setInt(3, p.getQuantity());
			ps.setInt(4, p.getId());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}