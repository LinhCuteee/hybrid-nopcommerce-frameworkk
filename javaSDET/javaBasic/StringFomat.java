package javaBasic;

public class StringFomat {
    public static void main(String[] args) {
        String locator ="//td[@data-key='females'and text()= '%s']/preceding-sibling::td/button[@class='qgrd-edit-row-btn']";
        String locator1 = "//td[@data-key='country'and text()='%s']/preceding-sibling::td[@data-key='females'and text()='%s']/preceding-sibling::td/button[@class='qgrd-edit-row-btn']";

        Scanner(locator,"384187");
        System.out.println(String.format("Linh '%s'","Nguyen"));

    }

    public static void Scanner(String locator,String females){
        System.out.println(String.format(locator,females));
    }

    public static void Scanner(String locator,String females,String contruy){
        System.out.println(String.format(locator,contruy,females));
    }

    // 1 mảng String parametor mà format nhận tham số thứ 2 kiểm object nên phải ép từ mảng String lên mảng Object
    public static void Scanner(String locator,String... restParametor){
        System.out.println(String.format(locator, (Object[]) restParametor));
    }

}
