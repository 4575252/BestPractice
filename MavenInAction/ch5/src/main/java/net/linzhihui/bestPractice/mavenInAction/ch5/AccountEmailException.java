package net.linzhihui.bestPractice.mavenInAction.ch5;

public class AccountEmailException
    extends Exception
{
    private static final long serialVersionUID = -4817386460334501672L;

    public AccountEmailException( String message )
    {
        super( message );
    }

    public AccountEmailException( String message, Throwable throwable )
    {
        super( message, throwable );
    }
}
