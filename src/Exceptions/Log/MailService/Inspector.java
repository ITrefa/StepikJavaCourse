package Exceptions.Log.MailService;

public class Inspector implements MailService{
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";


    @Override
    public Sendable processMail(Sendable mail) {
        MailPackage pack;
        if (mail instanceof MailPackage) {
            pack = (MailPackage) mail;
            if ((pack.getContent().getContent().contains(WEAPONS) || pack.getContent().getContent().contains(BANNED_SUBSTANCE)))
                throw new IllegalPackageException();
            else if (pack.getContent().getContent().contains("stones")) {
                throw new StolenPackageException();
            }

        }
        return mail;
    }
}
