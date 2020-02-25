package Exceptions.Log.MailService;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Spy implements MailService {
    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final Logger LOGGER = Logger.getLogger(Spy.class.getName());
    private Logger logger;

    public Spy(Logger logger) {
        this.logger = logger;
    }


    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            if (mail.getTo().equals(AUSTIN_POWERS) || mail.getFrom().equals(AUSTIN_POWERS)) {
                logger.log(Level.WARNING, "Detected target mail correspondence: from " + mail.getFrom() + "to " + mail.getTo() +
                        " " + ((MailPackage) mail).getContent().getContent());
            } else {
                logger.log(Level.INFO, "Usual correspondence: from " + mail.getFrom() + "to " + mail.getTo());
            }
        }
        return mail;
    }
}
