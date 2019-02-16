package MyMain;

import com.lanou.utills.MailValidate;

public class MyTest {
	public static void main(String[] args) {
		String num = MailValidate.createnNum(6);
		MailValidate.sendEmail("401864150@qq.com", num);
	}
}
