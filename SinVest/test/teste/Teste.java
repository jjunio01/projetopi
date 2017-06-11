package teste;

import br.com.simuladorinvestimentos.controller.ControllerInvestimento;
import java.text.DecimalFormat;

public class Teste {
    
    
    // ai é só jogar o atributo na sessão e recuperá-lo quando quiser. //métodos auxiliares que podem te ajudar: public FacesContext getFacesContext() { return FacesContext.getCurrentInstance(); } public HttpSession getSession() { return (HttpSession) getFacesContext().getExternalContext().getSession(false); } public HttpServletRequest getRequestSession() { return (HttpServletRequest) getFacesContext().getExternalContext().getRequest(); } 
    
    
    public static void main(String[] args){
        
        ControllerInvestimento invest = new ControllerInvestimento();
        
        
        DecimalFormat df = new DecimalFormat();
        
       double r = 8;
       df.format(1010101.01001000);
        
        
        System.out.println();
        
        
   
        
        
        
        
    }
    
}
