package net.linzhihui.bestPractice.mavenInAction.ch5;

public interface AccountEmailService
{
    void sendMail( String to, String subject, String htmlText )
        throws AccountEmailException;
}
