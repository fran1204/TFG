/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email.actions;

import DAO.InterlocutorOrderDAO;
import DAO.UserDAO;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import modelo.InterlocutorOrder;
import modelo.User;

/**
 *
 * @author fmrodriguez
 */
public class Emailer extends ActionSupport {

    private String from = "franciscomiguel.rodalv@gmail.com";
    private String password = "franmi12";
    private String to;
    private String subject;
    private String body;
    private int idInterOrder;
    private String emailUser;
    private int op;
    private int id;

    static Properties properties = new Properties();

    static {
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "587");
        properties.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.tls", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", "587");
    }

    public String execute() {
        String ret = SUCCESS;
        UserDAO udao = new UserDAO();
        User u = udao.get(emailUser);
        InterlocutorOrderDAO iodao = new InterlocutorOrderDAO();
        InterlocutorOrder io = iodao.get(idInterOrder);
        switch (op) {
            case 1:
                to = emailUser;
                //to = "franshesco12@gmail.com";
                subject = "CommunityShopping: Recordatorio de pago";
                body = "Buenas " + u.getName() + " le recordamos que tienes aún pendiente"
                        + " el pago del pedido " + io.getOrder().getLot().getTitle()
                        + ", caracteristicas: " + io.getLotDetail().getColor() + ", "
                        + io.getLotDetail().getSize();

                id = iodao.get(idInterOrder).getOrder().getId();
                break;
            case 2:
                to = emailUser;
                //to = "franshesco12@gmail.com";
                subject = "CommunityShopping: Nuevo Cliente Lider!";
                body = "Buenas " + u.getName() + " te informamos que ahora eres"
                        + " el nuevo Cliente lider del pedido: "+io.getOrder().getLot().getTitle();
                ret = "succesElimi";
                break; 
        }

        try {
            Session session = Session.getInstance(properties,
                    new javax.mail.Authenticator() {
                protected PasswordAuthentication
                        getPasswordAuthentication() {
                    return new PasswordAuthentication(from, password);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);
            Transport.send(message);
        } catch (Exception e) {
            ret = ERROR;
            e.printStackTrace();
        }
        return ret;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public static Properties getProperties() {
        return properties;
    }

    public static void setProperties(Properties properties) {
        Emailer.properties = properties;
    }

    public int getOp() {
        return op;
    }

    public void setOp(int op) {
        this.op = op;
    }

    public int getIdInterOrder() {
        return idInterOrder;
    }

    public void setIdInterOrder(int idInterOrder) {
        this.idInterOrder = idInterOrder;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
