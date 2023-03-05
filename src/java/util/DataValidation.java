/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.ArrayList;
import dao.AccountsDAO;
import java.util.List;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import model.Accounts;
import model.Categories;
import model.Informations;
import model.Products;
import model.InformationCategories;
/**
 *
 * @author Admin
 */
public class DataValidation {

    public boolean checkAccountExist(List<Accounts> ls, String email, String phone) {
        
        for (Accounts accounts : ls) {
            if (email.equalsIgnoreCase(accounts.getEmail())
                    || phone.equalsIgnoreCase(accounts.getPhone())) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkCategoryExist(List<Categories> ct, String name) {
        
        for (Categories category : ct) {
            if (name.equalsIgnoreCase(category.getCateName())) {
                return true;
            }
        }
        return false; 
    }
    
    public boolean checkCategoryExist2(List<Categories> ct, String cateCode) {
        
        for (Categories category : ct) {
            if (cateCode.equalsIgnoreCase(category.getCateCode())  ) {
                return true;
            }
        }
        return false; 
    }
    
        public boolean checkProductExist(List<Products> ct, String name) {
        
        for (Products product : ct) {
            if (name.equalsIgnoreCase(product.getpName())) {
                return true;
            }
        }
        return false; 
    }
        public boolean checkInformationExist(List<Informations> listInfor, String title) {
        
        for (Informations infor : listInfor) {
            if (title.equalsIgnoreCase(infor.getTitle())) {
                return true;
            }
        }
        return false; 
    }
        public boolean checkInformationCateExist(List<InformationCategories> inforCate, String name) {
        
        for (InformationCategories cate : inforCate) {
            if (name.equalsIgnoreCase(cate.getName())) {
                return true;
            }
        }
        return false; 
    }
    


    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

//    public static boolean isValiddEmailAddress(String email) {
//        boolean result = true;
//        try {
//            InternetAddress emailAddr = new InternetAddress(email);
//            emailAddr.validate();
//        } catch (AddressException ex) {
//            result = false;
//        }
//        return result;
//    }
    
     public boolean isValidVietNamesePhoneNumber(String phone) {
        String ePattern = "((^(\\+84|84|0|0084){1})(1|3|5|7|8|9))+([0-9]{8})$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(phone);
        return m.matches();
    }

    public boolean  checkInputName(String name) {
        boolean result = false;
            
          if (name.matches("^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ0-9]+(([ ][a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ0-9 ])?[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ0-9]*){7}$")) {
               // if (name.matches("^[A-Za-z ]+$")) {
                result = true;
            }
            return result;
            
    }
    
    public boolean  checkLimitCharactor(String code) {
        boolean result = false;
            
          if (code.length() >= 6 && code.length() < 50) {
               // if (name.matches("^[A-Za-z ]+$")) {
                result = true;
            }
            return result;
            
    }
    
    
    
    public boolean checkOldPassword(String email, String oldPassword, String newPassword) {
        boolean result = false;      
        if(oldPassword.equals(newPassword)){
            result =  true;
        }
        return result;
    }
    
    public boolean checkRepeatPassword(String newPassword, String rePassword){
        boolean result  = false;
        if(newPassword.equals(rePassword)){
            result = true;
        }
        return result;
    }
    
    public static void main (String[] args){
        DataValidation test = new DataValidation();
        
        boolean a = test.checkInputName("hòn hon hon hon hon hon hon hon");
        System.out.println(a);
    }
    

}
