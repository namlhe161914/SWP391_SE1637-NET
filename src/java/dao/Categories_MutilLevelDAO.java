/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import util.DBContext;

/**
 *
 * @author Admin
 */
public class Categories_MutilLevelDAO {
    private static final String GET_CATEGORIES = "SELECT cateId, cateName FROM swp_gr01.categories_mutillevel;";
    private static final String UPDATE_CATEGORY_INFO = "UPDATE swp_gr01.categories_mutillevel SET cateName = ? WHERE cateId = ?";
    private static final String INSERT_NEW_CATEGORY = "INSERT INTO swp_gr01.categories_mutillevel (cateName) VALUES (?)";
    private static final String DELETE_AN_CATEGORY = "DELETE FROM swp_gr01.categories_mutillevel WHERE cateId = ?";
    
    private static final String GET_CATEGORIES_MUTIL_LEVEL = "SELECT cateId, cateName, parentId FROM swp_gr01.categories_mutillevel;";
    
//    // Tham số truyền vào là parentID hiện tại
//public void  CreateChildMenu(String parentId, javax.servlet.jsp.JspWriter out){
////Khai báo đối tượng out javax.servlet.jsp.JspWriter
//// để sử dụng được phương thức println().
////Đối tượng out mặc định cung cấp trong JSP 
////không sử dụng được trong cặp <%! %>
// 
//        try{
//            List<String> idChildMenu=new ArrayList();
//            List<String> nameChildMenu=new ArrayList();
// 
//            try
//            {
//                while(rsl.next())
//                {
//                    //Tìm tất cả id và name củaa các dòng nếuu có parent_id là tham số parentId truyền vào.
//                    if(rsl.getString("parent_id").equals(parentId))
//                    {
//                        //Add dữ liệu vào 2 List, các id và name của cùng parent_id
//                        // sẽ được lưu tương ứng trong 2 List (có cùng index)
//                        idChildMenu.add(rsl.getString("id"));
//                        nameChildMenu.add(rsl.getString("name"));
//                    }
//                }
//                if(idChildMenu.size()>0)//Nếu tồn tại menu con với parent_id=parentId
//                {
//                    out.println("<ul>"); //Bắt đầu một phân cấp với thẻ <ul>
//                    for(int i=0;i<idChildMenu.size();i++)
//                    {
//                        out.println("<li>"); //Bắt đầu một dòng menu con với thẻ <li>
//                        out.println("<a href='index.jsp?menu_id="+
//                          idChildMenu.get(i)+"'>"+nameChildMenu.get(i)+"</a>");
//                        //Đệ quy, gọi lại chính hàm CreateChildMenu với tham số là idChildMenu hiện tại.
//                        CreateChildMenu(idChildMenu.get(i),out);
//                    }
//                    out.println("</ul>"); //Kết thúc một phân cấp với thẻ </ul>
//                }
//                else //Ngược lại, nếu không tồn tại menu con thì dùng thẻ đóng </li>  
//                     //để hoàn thành một cấp menu hiện tại.
//                {
//                    out.println("</li>");
//                }
//            }
//            catch(IOException ex){}
//        }
//        catch (SQLException e)
//        {
//                
//    
//    public void  CreateMenu(javax.servlet.jsp.JspWriter out){
//    try{
//        ResultSet rs= cnn.getResultSet(cmd); 
//        try
//        {
//            //Bắt đầu tạo menu với thẻ điều hướng <nav>
//            out.println("<nav>");
//            out.println("<ul>");
// 
//            //Phương thức next() kiểm tra dòng dữ liệu tiếp theo có tồn tại hay không
//            while(rs.next()) //Sử dụng tương đương như vòng lặp for duyệt qua hết các bộ giá trị trong ResultSet
//            {
//                // Nếu parent_id=0, tức là tất cả menu cha (cấp 0)
//                if(rs.getString("parent_id").equals("0")) 
//                {
//                    out.println("<li>");
// 
//                    //In tất cả menu cha cấp 0 (parent_id=0)
//                    out.println("<a href='index.jsp?menu_id="+
//                    rs.getString("id")+"'>"+rs.getString("name")+"</a>");
// 
//                     //Với mỗi menu cha, kiểm tra sự tồn tại của menu con và tạo ra chúng
//                     bằng hàm CreateChildMenu với tham số là id menu hiện tại.
//                    CreateChildMenu(rs.getString("id"),out);
//                }                  
//            }
//            out.println("</ul>");
//            out.println("</nav>");
//        } catch(IOException ex){}
//    }
//    catch (SQLException e)
//    {
//    }
//}
//    
//    
//    
//    
//    
//    public void getCategories_Mutil_Level(String parentId) throws SQLException {
//        
//        List<String> idChild=new ArrayList();
//        List<String> nameChild=new ArrayList();
//        Connection conn = null;
//        PreparedStatement psm = null;
//        ResultSet rs = null;
//        try {
//            conn = DBContext.getJDBCConnection();
//            if (conn != null) {
//                psm = conn.prepareStatement(GET_CATEGORIES_MUTIL_LEVEL);
//                rs = psm.executeQuery();
//                if (rs != null) {
//                    while (rs.next()) {
//                        //Tìm tất cả id và name củaa các dòng nếuu có parent_id là tham số parentId truyền vào.
//                    if(rs.getString("parent_id").equals(parentId))
//                    {
//                        //Add dữ liệu vào 2 List, các id và name của cùng parent_id
//                        // sẽ được lưu tương ứng trong 2 List (có cùng index)
//                        idChild.add(rs.getString("cateId"));
//                        nameChild.add(rs.getString("cateName"));
//                    }
//                    }
//                    
//                    for(int i=0;i<idChild.size();i++)
//                    {
//                        out.println("<li>"); //Bắt đầu một dòng menu con với thẻ <li>
//                        out.println("<a href='index.jsp?menu_id="+
//                          idChild.get(i)+"'>"+nameChild.get(i)+"</a>");
//                        //Đệ quy, gọi lại chính hàm CreateChildMenu với tham số là idChildMenu hiện tại.
//                        CreateChildMenu(idChild.get(i),out);
//                    }
//                }
//            }
//        } catch (Exception e) {
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (psm != null) {
//                psm.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        }
//      
//    }
//    
    
    
    
    
    
    
    
    public boolean deleteCategory(int cateId) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(DELETE_AN_CATEGORY);
                stm.setInt(1, cateId);      
                check = stm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
    
    
    public Map<Integer, String> getCategories() throws SQLException {
        Map<Integer, String> list = new LinkedHashMap<>();
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                psm = conn.prepareStatement(GET_CATEGORIES);
                rs = psm.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int cateId = rs.getInt("cateId");
                        String cateName = rs.getString("cateName");
                        list.put(cateId, cateName);
                    }
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (psm != null) {
                psm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
    
    public boolean insertNewCategory(String cateName) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement psm = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                psm = conn.prepareStatement(INSERT_NEW_CATEGORY);
                psm.setString(1, cateName);
                check = psm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
        } finally {
            if (psm != null) {
                psm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean updateCategoryInfo(int cateId, String cateName) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement psm = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                psm = conn.prepareStatement(UPDATE_CATEGORY_INFO);
                psm.setString(1, cateName);
                psm.setInt(2, cateId);
                check = psm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
        } finally {
            if (psm != null) {
                psm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
    
}
