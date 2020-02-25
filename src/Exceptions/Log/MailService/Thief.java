package Exceptions.Log.MailService;


public class Thief implements MailService {
    private int minPrice;
    private static int stolenValue = 0;

    public Thief(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getStolenValue(int price) {
        return stolenValue;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        MailPackage pack;
        if (mail instanceof MailPackage) {
            pack = (MailPackage) mail;
            if (pack.getContent().getPrice() >= minPrice) {
                stolenValue += pack.getContent().getPrice();
                return new MailPackage(pack.getFrom(), pack.getTo(), new Package("stones instead of " +
                        pack.getContent().getContent(), 0));
            }

        }
        return mail;
    }
}
