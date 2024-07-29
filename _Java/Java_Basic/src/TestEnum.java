import Enum.ResultCode;


/**
 * @Create 06/27/2024 - 22:25
 * @Author xiao
 * @Description TODO
 */


public class TestEnum {
    public static void main(String[] args) {
        for (ResultCode s: ResultCode.values())
            System.out.println("code: "+s.getValue()+", message: "+s.getMessage());
    }

}
