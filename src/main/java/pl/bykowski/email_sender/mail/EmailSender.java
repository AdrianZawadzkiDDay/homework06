package pl.bykowski.email_sender.mail;


public interface EmailSender {
    void sendEmail(String to, String subject, String content);
}
