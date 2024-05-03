package justforpractice.db;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class PracticeSQL {


    public static void main(String[] args) {

        DBUtils.establishSQLConnection();

//        List<Map<String,Object>> finaList = DBUtils.runSQLSelectQuery("select * from account where id = 256 limit 10;");
//        for (Map<String,Object> map: finaList) {
//            System.out.println(map.toString());
//        }
//        System.out.println();
//        List<Map<String,Object>> finaList = DBUtils.getFirstRowData("select * from account where id = 256 limit 10;");
//        for (Map<String,Object> map: finaList) {
//            System.out.println(map.toString());
//        }
//        System.out.println();
//        List<Map<String,Object>> finaList2 = DBUtils.getLastRowData("select * from account where id = 256 limit 10;");
//        for (Map<String,Object> map: finaList2) {
//            System.out.println(map.toString());
//        }
        System.out.println();
        List<Map<String,Object>> finaList3 = DBUtils.getNthRowData("select * from account limit 10;",10);
        for (Map<String,Object> map: finaList3) {
            System.out.println(map.toString());
        }




//        DBUtils.getFirstRowData("select * from account;");
//        DBUtils.getLastRowData("select * from account;");
//        DBUtils.getNthRowData("select * from account;", 5);


//         int id = 0;
//         int owner_id = 0;
//         long account_number = 0;
//
//        while (resultSet.next()) {
//            id = resultSet.getInt("id");
//            owner_id = resultSet.getInt("owner_id");
//            account_number = resultSet.getLong("account_number");
//        }
//    //            statement.execute("INSERT INTO account VALUES (" + id+1 + ", 10000, null, null ,1.85, 'Account 1 SVG', 10000, 0, null, 0, "
//    //                    + account_number+1 + ",19,10, null, " + owner_id + ", 17)");
//
//        resultSetFinal = statement.executeQuery("select * from account WHERE id = " + id+1);
//



    }
}
