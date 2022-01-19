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
	public String placeOrder(Orders order)  {
		int oid = generateOrderId();
		order.setOrderStatus("PENDING");
		java.util.Date today = new Date();
		java.sql.Date dbDate = new java.sql.Date(today.getTime());
		order.setOrderDate(dbDate);
		Menu menu = new MenuDAO().searchMenu(order.getMenuId());
		int price = menu.getPrice();
		int  billAmount = order.getQuantityOrdered() * price;
		Wallet wallet = new WalletDAO().searchByWalletId(order.getWalletId());
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
			new WalletDAO().deductBalance(order.getWalletId(), billAmount);
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
