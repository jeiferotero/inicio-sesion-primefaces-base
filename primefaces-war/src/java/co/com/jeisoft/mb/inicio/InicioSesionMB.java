/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jeisoft.mb.inicio;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.context.RequestContext;

/**
 *
 * @author jeiferotero
 */
@ManagedBean
@SessionScoped
public class InicioSesionMB {

    /**
     * Creates a new instance of InicioSesionMB
     */
    private InputText txtUsuario;
    private InputText txtContrasena;
    private InputText txtCorreo;
    private boolean blnLogeado;

    @PostConstruct
    public void inicio() {

    }

    public void iniciarSesion() {
        System.out.println("Usuario ::: " + txtUsuario.getValue().toString());

        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;
        if (txtUsuario.getValue() != null && txtUsuario.getValue().toString().equals("admin") && txtContrasena.getValue() != null && txtContrasena.getValue().toString().equals("admin")) {
            blnLogeado = true;
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", txtUsuario.getValue().toString());
        } else {
            blnLogeado = false;
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error",
                    "Credenciales no válidas");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("estaLogeado", blnLogeado);
    }

    public void logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        session.invalidate();
        blnLogeado = false;
    }

    //Getters y Setters
    
    public boolean isBlnLogeado() {
        return blnLogeado;
    }

    public void setBlnLogeado(boolean blnLogeado) {
        this.blnLogeado = blnLogeado;
    }

    public InputText getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(InputText txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    public InputText getTxtContrasena() {
        return txtContrasena;
    }

    public void setTxtContrasena(InputText txtContrasena) {
        this.txtContrasena = txtContrasena;
    }

    public InputText getTxtCorreo() {
        return txtCorreo;
    }

    public void setTxtCorreo(InputText txtCorreo) {
        this.txtCorreo = txtCorreo;
    }

}
