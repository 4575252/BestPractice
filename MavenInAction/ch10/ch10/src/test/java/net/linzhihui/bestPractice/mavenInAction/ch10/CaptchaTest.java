package net.linzhihui.bestPractice.mavenInAction.ch10;

public class CaptchaTest {

    private static final long serialVersionUID = 1339439433313285858L;
    
	public static void main(String[] args) {
		AccountCaptchaService cap = new AccountCaptchaServiceImpl();
		try {
			String key = cap.generateCaptchaKey();
//			System.out.println(key);
			cap.generateCaptchaImage(key);
		} catch (AccountCaptchaException e) {
			e.printStackTrace();
		}
	}

}
