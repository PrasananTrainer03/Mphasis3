package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OrdersDAO {
	
	@Autowired
    JdbcTemplate jdbcTemplate;

	public Wallet searchByWalletId(int walletId) {
		String cmd = "select * from wallet where walletid=?";
		List<Wallet> walletList = jdbcTemplate.query(cmd, 
				new Object[] {walletId}, new RowMapper(){
					@Override
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						Wallet wallet = new Wallet();
						wallet.setWalletId(rs.getInt("walletid"));
						wallet.setCustomerId(rs.getInt("customerid"));
						wallet.setWallettype(rs.getString("wallettype"));
						wallet.setAmount(rs.getInt("amount"));
						return wallet;
					}
		});
		return walletList.get(0);
		
	}

	public Menu searchMenu(int menuId)  {
		String cmd = "select * from menu where menuid=?";
		List<Menu> menuList = jdbcTemplate.query(cmd, 
				new Object[] {menuId}, new RowMapper(){
					@Override
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						Menu menu = new Menu();
						menu.setMenuId(rs.getInt("menuid"));
						menu.setRestaurantId(rs.getInt("restaurantid"));
						menu.setItemName(rs.getString("itemname"));
						menu.setMenutype(rs.getString("menutype"));
						menu.setCalories(rs.getInt("calories"));
						menu.setPrice(rs.getInt("Price"));
						return menu;
					}
		});
		return menuList.get(0);
	}

	public Orders searchOrder(int orderId) {
		String cmd = "select * from orders where ORDERID=?";
		List<Orders> ordersList = jdbcTemplate.query(cmd, 
				new Object[] {orderId},
				new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			 Orders	orderFound = new Orders();
				orderFound.setOrderId(rs.getInt("ORDERID"));
				orderFound.setMenuId(rs.getInt("MENUID"));
				orderFound.setVendorId(rs.getInt("VendorID"));
				orderFound.setCustomerId(rs.getInt("CustomerID"));
				orderFound.setWalletId(rs.getInt("WALLETID"));
				orderFound.setBillAmount(rs.getInt("BILLAMOUNT"));
				orderFound.setOrderComments(rs.getString("COMMENTS"));
				orderFound.setOrderDate(rs.getDate("ORDERDATE"));
				orderFound.setOrderStatus(rs.getString("ORDERSTATUS"));
				orderFound.setQuantityOrdered(rs.getInt("QUANTITYORDERED"));
				return orderFound;
			}
		});
		return ordersList.get(0);
		
	}
	public String acceptOrRejectOrder(int orderId, int vendorId, String status) {
		Orders order = searchOrder(orderId);
		if (order.getVendorId()==vendorId) {
			if (status.toUpperCase().equals("YES")) {
				String cmd = "Update orders set OrderStatus='ACCEPTED' "
						+ " WHERE OrderID=?";
				jdbcTemplate.update(cmd, new Object[] {orderId});
				return "Order Approved Successfully...";
			} else {
				String cmd = "Update orders set OrderStatus='REJECTED' "
						+ " WHERE OrderID=?";
				jdbcTemplate.update(cmd,new Object[] {orderId});
				cmd = "Update Wallet set Amount=Amount+? where walletId=?";
				jdbcTemplate.update(cmd, new Object[] {order.getBillAmount(), order.getWalletId()});
				return "Order Rejected Amount Refunded...";
			}
		} 
		return "You are unauthorized vendor...";
	}
	public String deductBalance(int walletId, int billAmount) {
		String cmd = "update wallet set amount=amount-? where walletId=?";
		jdbcTemplate.update(cmd, new Object[] {billAmount,walletId});
		return "Amount Deducted...";
	}

	public String placeOrder(Orders order)  {
		int oid = generateOrderId();
		order.setOrderStatus("PENDING");
		java.util.Date today = new Date();
		java.sql.Date dbDate = new java.sql.Date(today.getTime());
		order.setOrderDate(dbDate);
		Menu menu = searchMenu(order.getMenuId());
		int price = menu.getPrice();
		int  billAmount = order.getQuantityOrdered() * price;
		Wallet wallet = searchByWalletId(order.getWalletId());
		int amount = wallet.getAmount();
		if (amount - billAmount > 0) {
			order.setBillAmount(billAmount);
			order.setOrderId(oid);
			String cmd = "insert into Orders(orderId,VendorId,CustomerId,MenuID,"
					+ "WalletId,OrderDate,QuantityOrdered,OrderStatus,BillAmount,Comments) "
					+ "values(?,?,?,?,?,?,?,?,?,?)";
			jdbcTemplate.update(cmd, new Object[] {
				order.getOrderId(), order.getVendorId(),
				order.getCustomerId(),order.getMenuId(),
				order.getWalletId(), order.getOrderDate(),
				order.getQuantityOrdered(),order.getOrderStatus(),
				order.getBillAmount(),order.getOrderComments()
			});
			deductBalance(order.getWalletId(), billAmount);
			return "Order Placed Successfully...Wallet Balance Deducted...";
		}
		return "Insufficient Funds...";
		//order.setBillAmount(billAmount);
	}
	
	public int generateOrderId()  {
		String cmd = "select case when max(ORDERID) is NULL THEN 1"
				+ " else max(ORDERID)+1 end oid from orders";
		List<Object> oid = jdbcTemplate.query(cmd, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Object ob = rs.getInt("oid");
				return ob;
			}
		});
		return (Integer)oid.get(0);
	}
}
