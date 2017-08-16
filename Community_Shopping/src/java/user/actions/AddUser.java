/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.actions;

import DAO.SectorDAO;
import DAO.SessionDAO;
import DAO.UserDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import modelo.Sector;
import modelo.User;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author fmrodriguez
 */
public class AddUser extends ActionSupport {

    private Boolean provider;
    private String email;
    private String sector;
    private String name;
    private String company_name;
    private List<Sector> sectores;
    private Integer bank;
    private String password;
    private User u;
    private File fileUpload;
    private String fileUploadContentType;
    private String fileUploadFileName;

    private String existeUsuario;

    public AddUser() {
    }

    public String execute() throws Exception {
        UserDAO dao = new UserDAO();
        SessionDAO sdao = new SessionDAO();
        SectorDAO sectordao = new SectorDAO();

        if (dao.existeUsuario(email)) {
            existeUsuario = "El usuario ya existe.";
            return ERROR;
        } else {
            Date ahora = new Date();
            SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
            formateador.format(ahora);
            if (provider) {
                //Sector sector, String name, String email, String password, Integer bank, String company_name, Boolean provider, Date created_date
                u = new User(sectordao.getSectorById(sector), name, email, password, bank, company_name, provider, ahora);
            } else {
                //String name,String email, String password, boolean provider, String photo,Date createDate
                u = new User(name, email, password, provider, ahora);
            }
            if (fileUpload != null && (fileUploadContentType.equals("image/png") || fileUploadContentType.equals("image/jpg") || fileUploadContentType.equals("image/jpeg"))) {
                String extension = (fileUploadFileName.split("\\."))[1];
                fileUploadFileName = System.currentTimeMillis() + "." + extension;
                String url = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/");
                url = url.split("build")[0] + "web/";
                dao.resize(fileUpload.getAbsolutePath(), url + "img/perfil/" + fileUploadFileName, 480, 480);
                u.setPhoto(fileUploadFileName);
            } else {
                u.setPhoto("defecto.jpeg");
            }
            dao.add(u);
            sdao.getSession().put("email", email);
            return SUCCESS;
        }
    }

    @Override
    public void validate() {
        if (email == null || email.equals("")) {
            addFieldError("email", "Se requiere un email.");
        } else if (email.length() > 45) {
            addFieldError("email", "El tamaño del email es de máximo 45 caracteres");
        } else if (!email.matches("^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$")) {
            addFieldError("email", "Formato del email incorrecto");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    @RequiredStringValidator(message = "Se requiere una contraseña.")
    @StringLengthFieldValidator(
            minLength = "5",
            maxLength = "45",
            message = "La contraseña debe tener entre ${minLength} y ${maxLength} caracteres"
    )
    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public List<Sector> getSectores() {
        sectores = new SectorDAO().getAll();
        return sectores;
    }

    public void setSectores(List<Sector> sectores) {
        this.sectores = sectores;
    }

    public Integer getBank() {
        return bank;
    }

    public void setBank(Integer bank) {
        this.bank = bank;
    }

    public Boolean getProvider() {
        return provider;
    }

    public void setProvider(Boolean provider) {
        this.provider = provider;
    }

    public String isExisteUsuario() {
        return existeUsuario;
    }

    public void setExisteUsuario(String existeUsuario) {
        this.existeUsuario = existeUsuario;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    public File getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(File fileUpload) {
        this.fileUpload = fileUpload;
    }

    public String getFileUploadContentType() {
        return fileUploadContentType;
    }

    public void setFileUploadContentType(String fileUploadContentType) {
        this.fileUploadContentType = fileUploadContentType;
    }

    public String getFileUploadFileName() {
        return fileUploadFileName;
    }

    public void setFileUploadFileName(String fileUploadFileName) {
        this.fileUploadFileName = fileUploadFileName;
    }

}
