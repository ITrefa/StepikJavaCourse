package Exceptions.Log.MailService;

public class UntrustworthyMailWorker implements MailService {
    private RealMailService realMailService;
    private MailService[] mailServices;

    public UntrustworthyMailWorker(MailService[] mailServices) {
        this.mailServices = mailServices;
        for (MailService ms : this.mailServices) {
            if (ms instanceof RealMailService)
                this.realMailService = (RealMailService) ms;
        }
        if (this.realMailService == null) {
            this.realMailService = new RealMailService();
        }

    }

    public RealMailService getRealMailService() {
        return realMailService;
    }


    @Override
    public Sendable processMail(Sendable mail) {
        Sendable sendable = mail;
        for (MailService service : this.mailServices) {
            if (service instanceof RealMailService)
                continue;
            sendable = service.processMail(sendable);
        }
        if (getRealMailService() != null) {
            sendable = this.realMailService.processMail(sendable);
        }
        return sendable;
    }

}